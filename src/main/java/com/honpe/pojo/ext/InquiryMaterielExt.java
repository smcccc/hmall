package com.honpe.pojo.ext;

import com.honpe.po.FileInfo;
import com.honpe.po.InquiryMateriel;

public class InquiryMaterielExt extends InquiryMateriel {
	
	private FileInfo attachment;

	public final FileInfo getAttachment() {
		return attachment;
	}

	public final void setAttachment(FileInfo attachment) {
		this.attachment = attachment;
	}
}
