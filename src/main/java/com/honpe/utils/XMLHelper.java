package com.honpe.utils;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class XMLHelper {
	public static String parseXml(String xml) {
		String text = null;
		try {
			Document doc = DocumentHelper.parseText(xml);
			Element root = doc.getRootElement();
			text = getText(root);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return text;
	}

	private static String getText(Element root) {
		List<Element> elements = root.elements();
		Element dataElem = elements.get(elements.size() - 1);
		List<Element> dataElems = dataElem.elements();
		StringBuffer buffer = new StringBuffer();
		if (dataElems != null && dataElems.size() > 0) {
			for (int i = 0; i < dataElems.size() - 2; i++) {
				buffer.append(dataElems.get(i).getData());
				buffer.append(" ");
			}
			buffer.deleteCharAt(buffer.length() - 1);
		}
		return buffer.toString();
	}
}
