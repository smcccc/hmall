package com.honpe.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class IpHelper {

	private String ipApi;

	public IpHelper(String ipApi) {
		super();
		this.ipApi = ipApi;
	}

	public String queryIp(String ip) {
		String urlString = ipApi + "?ip=" + ip;
		try {
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(100000);
			conn.setReadTimeout(100000);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setInstanceFollowRedirects(false);
			conn.setRequestMethod("GET");
			int responseCode = conn.getResponseCode();
			if (responseCode == 200) {
				StringBuilder builder = new StringBuilder();
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
				for (String s = br.readLine(); s != null; s = br.readLine()) {
					builder.append(s);
				}
				br.close();
				ResponseData responseData = JsonUtils.jsonToPojo(builder.toString(), ResponseData.class);
				if (responseData != null && responseData.getData() != null)
					return responseData.getData().getAddress();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

class ResponseData {

	private int code;
	private IpDate data;

	public final int getCode() {
		return code;
	}

	public final void setCode(int code) {
		this.code = code;
	}

	public final IpDate getData() {
		return data;
	}

	public final void setData(IpDate data) {
		this.data = data;
	}
}

class IpDate {
	private String ip;
	private String country;
	private String area;
	private String region;
	private String city;
	private String county;
	private String isp;
	private String country_id;
	private String area_id;
	private String region_id;
	private String city_id;
	private String county_id;
	private String isp_id;

	public final String getIp() {
		return ip;
	}

	public final void setIp(String ip) {
		this.ip = ip;
	}

	public final String getRegion() {
		return region;
	}

	public final void setRegion(String region) {
		this.region = region;
	}

	public final String getCity() {
		return city;
	}

	public final void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return this.region + " " + this.city;
	}

	public final String getCountry() {
		return country;
	}

	public final void setCountry(String country) {
		this.country = country;
	}

	public final String getArea() {
		return area;
	}

	public final void setArea(String area) {
		this.area = area;
	}

	public final String getCounty() {
		return county;
	}

	public final void setCounty(String county) {
		this.county = county;
	}

	public final String getIsp() {
		return isp;
	}

	public final void setIsp(String isp) {
		this.isp = isp;
	}

	public final String getCountry_id() {
		return country_id;
	}

	public final void setCountry_id(String country_id) {
		this.country_id = country_id;
	}

	public final String getArea_id() {
		return area_id;
	}

	public final void setArea_id(String area_id) {
		this.area_id = area_id;
	}

	public final String getRegion_id() {
		return region_id;
	}

	public final void setRegion_id(String region_id) {
		this.region_id = region_id;
	}

	public final String getCity_id() {
		return city_id;
	}

	public final void setCity_id(String city_id) {
		this.city_id = city_id;
	}

	public final String getCounty_id() {
		return county_id;
	}

	public final void setCounty_id(String county_id) {
		this.county_id = county_id;
	}

	public final String getIsp_id() {
		return isp_id;
	}

	public final void setIsp_id(String isp_id) {
		this.isp_id = isp_id;
	}
}