package com.vedic.astro.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.vedic.astro.enums.MemberType;

@Document(collection="profile_heirarchy")
public class ProfileAspect {
	
	@Id
	private String id = null;
	
	private String code = null;
	private String name = null;
	private String parentCode = null;
	private MemberType memberType = null;
	
	public ProfileAspect() {
		
	}
	
	public ProfileAspect(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
	public ProfileAspect(String code, String name, String parentCode) {
		this.code = code;
		this.name = name;
		this.parentCode = parentCode;
	}
	
	public ProfileAspect(String code, String name, String parentCode, MemberType memberType) {
		this.code = code;
		this.name = name;
		this.parentCode = parentCode;
		this.memberType = memberType;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getParentCode() {
		return parentCode;
	}
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MemberType getMemberType() {
		return memberType;
	}
	public void setMemberType(MemberType memberType) {
		this.memberType = memberType;
	}

	@Override
	public String toString() {
		return "ProfileAspect [id=" + id + ", code=" + code + ", name=" + name + ", parentCode=" + parentCode
				+ ", memberType=" + memberType + "]";
	}
}
