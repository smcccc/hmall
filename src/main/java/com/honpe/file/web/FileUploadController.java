package com.honpe.file.web;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.honpe.account.annotation.RequiredAuth;
import com.honpe.file.service.FileService;
import com.honpe.file.util.UploadUtil;
import com.honpe.po.FileInfo;
import com.honpe.file.util.SaveFile;
import com.honpe.pojo.vo.Result;
import com.honpe.utils.IDUtils;

@Controller
@RequestMapping("upload")
public class FileUploadController {

	@Value("${fileDir}")
	private String fileDir;

	@Value("${tempDir}")
	private String tempDir;

	@Value("${baseSrc}")
	private String baseSrc;

	@Autowired
	private FileService fileService;

	private static String rename(String filename) {
		long currentTimeMillis = System.currentTimeMillis();
		StringBuffer filenameBuffer = new StringBuffer(String.valueOf(currentTimeMillis));
		Random random = new Random();
		filenameBuffer.append(String.valueOf(random.nextInt(10000)));
		String extension = FilenameUtils.getExtension(filename);
		filenameBuffer.append('.');
		filenameBuffer.append(extension);
		return filenameBuffer.toString();
	}

	@PostMapping("/image")
	public @ResponseBody Result imageUpload(MultipartFile file) throws IllegalStateException, IOException {
		String folderName = getFolderName();
		File folder = new File(fileDir, folderName);
		while (!folder.exists()) {
			folder.mkdirs();
		}
		String filename = rename(file.getOriginalFilename());
		file.transferTo(new File(folder, filename));
		StringBuffer srcBuffer = new StringBuffer(baseSrc);
		srcBuffer.append('/');
		srcBuffer.append(folderName);
		srcBuffer.append('/');
		srcBuffer.append(filename);
		return new Result(200, "上传成功", srcBuffer.toString());
	}

	private static String getFolderName() {
		Calendar calendar = Calendar.getInstance();
		StringBuffer folderBuffer = new StringBuffer();
		int year = calendar.get(Calendar.YEAR);
		folderBuffer.append(year);
		folderBuffer.append('-');
		int month = calendar.get(Calendar.MONTH) + 1;
		folderBuffer.append(month);
		return folderBuffer.toString();
	}

	@PostMapping("/file")
	@RequiredAuth
	public @ResponseBody Result fileUpload(String guid, String md5value, Integer chunks, Integer chunk, String id,
			String name, String type, String lastModifiedDate, Integer size, MultipartFile file) {
		FileInfo fileInfo = null;
		try {
			String ext = name.substring(name.lastIndexOf('.'));
			StringBuilder src = new StringBuilder(baseSrc);
			src.append('/');
			if (chunks != null && chunk != null) {
				String tempFileName = chunk + ext;
				String tempFolder = tempDir + '/' + guid;
				SaveFile.saveFile(tempFolder, tempFileName, file);
				Boolean isAllUploaded = UploadUtil.uploaded(md5value, guid, chunk, chunks, tempFolder, fileDir,
						tempFileName, ext);
				if (isAllUploaded) {
					String fileRename = guid + ext;
					src.append(fileRename);
					fileInfo = new FileInfo(name, fileRename, md5value, ext, src.toString(), new Date());
					fileService.saveTempFile(fileInfo);
				}
			} else {
				String fileRename = guid + ext;
				SaveFile.saveFile(fileDir, fileRename, file);
				src.append(fileRename);
				fileInfo = new FileInfo(name, fileRename, md5value, ext, src.toString(), new Date());
				fileService.saveTempFile(fileInfo);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new Result(403, null, null);
		}
		Map<String, String> data = null;
		if (fileInfo != null) {
			data = new HashMap<>();
			data.put("attachId", fileInfo.getFileId());
		}
		return new Result(200, null, data);
	}

	@PostMapping("/isMd5Exist")
	public @ResponseBody Result isMd5Exist(String fileMd5, String filename) {
		boolean md5Exist = fileService.isMd5Exist(fileMd5, filename);
		if (md5Exist) {
			return new Result(403, null, null);
		}
		return new Result(200, null, null);
	}
}
