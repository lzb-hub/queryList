package com.example.query.service;


import lombok.Data;

 
@Data
public class SqueryEntity {

 private int id;
   
 private String name;

 private String org;
 
 private int level;
 
 private String address;

public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getOrg() {
	return org;
}


public void setOrg(String org) {
	this.org = org;
}


public int getLevel() {
	return level;
}


public void setLevel(int level) {
	this.level = level;
}


public String getAddress() {
	return address;
}


public void setAddress(String address) {
	this.address = address;
}


 
}
