/**
 * 
 */
package com.dynamic.medical.claimsapplication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Ayush Kumar Singh
 *
 */

@Entity
public class LoginDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer loginId;
	private String fullName;
	private String username;
	private String password;
	private String provnum;
	private String role;
	
	public Integer getLoginId() {
		return loginId;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getRole() {
		return role;
	}
	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getProvnum() {
		return provnum;
	}
	public void setProvnum(String provnum) {
		this.provnum = provnum;
	}
	
}
