package com.honpe.file.model;

public class UploadInfo {
    private String md5;

    private Integer chunks;

    private Integer chunk;

    private String path;

    private String filename;

    private String ext;

    public UploadInfo(String md5, Integer chunks, Integer chunk, String path, String filename, String ext) {
		super();
		this.md5 = md5;
		this.chunks = chunks;
		this.chunk = chunk;
		this.path = path;
		this.filename = filename;
		this.ext = ext;
	}

	public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5 == null ? null : md5.trim();
    }

    public Integer getChunks() {
        return chunks;
    }

    public void setChunks(Integer chunks) {
        this.chunks = chunks;
    }

    public Integer getChunk() {
        return chunk;
    }

    public void setChunk(Integer chunk) {
        this.chunk = chunk;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext == null ? null : ext.trim();
    }
}