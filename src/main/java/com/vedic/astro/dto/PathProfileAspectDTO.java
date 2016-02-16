package com.vedic.astro.dto;

public class PathProfileAspectDTO {
	
	private String code = null;
	private String path = "";
	
	public PathProfileAspectDTO() {
	}
	
	public PathProfileAspectDTO(String code, String path) {
		this.code = code;
		this.path = path;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	public void addToPath(String name){
		this.path = name + " / " + this.path;
	}
	@Override
	public String toString() {
		return "PathProfileAspectDTO [code=" + code + ", path=" + path + "]";
	}
}
