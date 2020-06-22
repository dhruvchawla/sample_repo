package com.bluedart.camanagecorpusers.controller;

import java.util.ArrayList;
import java.util.List;

import com.bluedart.common.dto.PermissionDto;

public class Test {
public static void main(String[] args) {
	
	List<PermissionDto> l1 = new ArrayList<>();
	List<PermissionDto> l2 = new ArrayList<>();
	
	List<PermissionDto> compareLlist = new ArrayList<>();
	List<String> finalLlist = new ArrayList<>();
	
	PermissionDto per = new PermissionDto();
	per.setPermissionName("A");
	per.setPermissionValue("Y");
	l1.add(per);
	per = new PermissionDto();
	per.setPermissionName("B");
	per.setPermissionValue("Y");
	l1.add(per);
	
	PermissionDto per2 = new PermissionDto();
	per2.setPermissionName("A");
	per2.setPermissionValue("Y");
	l2.add(per);
	per2 = new PermissionDto();
	per2.setPermissionName("B");
	per2.setPermissionValue("Y");
	l2.add(per);
	
	compareLlist.addAll(l1);
	
	compareLlist.retainAll(l2);
	for (PermissionDto string : compareLlist) {
		System.out.println(string.getPermissionName());
		System.out.println(string.getPermissionValue());
	}
}
}
