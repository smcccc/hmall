package com.honpe.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class IpHelper {

	private String token;
	private String url;
	private String dataType;
	

	public IpHelper(String token, String url, String dataType) {
		this.token = token;
		this.url = url;
		this.dataType = dataType;
	}

	private String get(String urlString, String token) {
		try {
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5 * 1000);
			conn.setReadTimeout(5 * 1000);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setInstanceFollowRedirects(false);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("token", token);
			int responseCode = conn.getResponseCode();
			if (responseCode == 200) {
				StringBuilder builder = new StringBuilder();
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
				for (String s = br.readLine(); s != null; s = br.readLine()) {
					builder.append(s);
				}
				br.close();
				return builder.toString();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String queryIP(String ip) {
		String postUrl = url + "/?ip=" + ip + "&datatype=" + dataType;
		return get(postUrl, token);
	}
	
}
