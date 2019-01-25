package com.honpe.po;

import java.util.Date;

public class FileInfo {
	private String fileId;

	private String fileName;

	private String fileRename;

	private String md5;

	private String ext;

	private String src;

	private Boolean isDownload;

	private Date uploadTime;

	public FileInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileInfo(String fileName, String fileRename, String md5, String ext, String src, Date uploadTime) {
		super();
		this.fileName = fileName;
		this.fileRename = fileRename;
		this.md5 = md5;
		this.ext = ext;
		this.src = src;
		this.uploadTime = uploadTime;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId == null ? null : fileId.trim();
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName == null ? null : fileName.trim();
	}

	public String getFileRename() {
		return fileRename;
	}

	public void setFileRename(String fileRename) {
		this.fileRename = fileRename == null ? null : fileRename.trim();
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5 == null ? null : md5.trim();
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext == null ? null : ext.trim();
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src == null ? null : src.trim();
	}

	public Boolean getIsDownload() {
		return isDownload;
	}

	public void setIsDownload(Boolean isDownload) {
		this.isDownload = isDownload;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}
}