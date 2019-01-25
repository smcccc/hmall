package com.honpe.system.service;

import java.util.List;

import com.honpe.po.SystemSet;


public interface SystemService {
	
	 List<SystemSet> findSystemSetting();
	 
	 void saveSystemSetting(List<SystemSet> systemSets);
}
