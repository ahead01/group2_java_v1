/**
 * 
 */
package com.software.group2.entities;

import javax.persistence.Column;
/**
 * @author Austin
 *
 */
import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Admin implements User {
	
	@Id
	private Integer adminID;
	
	@Column(name="adminpwd")
	private String adminPWD;
	
	
	public boolean isAuthenticated() {
		// TODO Auto-generated method stub
		return true;
	}
	

	/**
	 * @param id the id to set
	 */
	public void setId(Integer adminID) {
		this.adminID = adminID;
	}
	/**
	 * @return the adminPWD
	 */
	public String getPwd() {
		return adminPWD;
	}
	/**
	 * @param pwd the adminPWD to set
	 */
	public void setPwd(String adminPWD) {
		this.adminPWD = adminPWD;
	}

	public Integer getId() {
		return this.adminID;
	}




}
