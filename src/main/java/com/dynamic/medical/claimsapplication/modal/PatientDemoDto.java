/**
 * 
 */
package com.dynamic.medical.claimsapplication.modal;

import java.util.Date;

import com.dynamic.medical.claimsapplication.entity.PatientDemographics;

/**
 * @author Ayush Kumar Singh
 *
 */
public class PatientDemoDto {

	private Integer pkId;
	private String mrn;
	private String ptName;
	private Date dob;
	private String sex;
	private Long hlthNum;
	private Long verCode;
	private Long expiry;
	private String coverage;
	private String billProv;
	private String address;
	private String city;
	private String province;
	private String postCode;
	private String parentName;
	private String phone;
	private String notes;
	public Integer getPkId() {
		return pkId;
	}
	public String getMrn() {
		return mrn;
	}
	public String getPtName() {
		return ptName;
	}
	public Date getDob() {
		return dob;
	}
	public String getSex() {
		return sex;
	}
	public Long getHlthNum() {
		return hlthNum;
	}
	public Long getVerCode() {
		return verCode;
	}
	public Long getExpiry() {
		return expiry;
	}
	public String getCoverage() {
		return coverage;
	}
	public String getBillProv() {
		return billProv;
	}
	public String getAddress() {
		return address;
	}
	public String getCity() {
		return city;
	}
	public String getProvince() {
		return province;
	}
	public String getPostCode() {
		return postCode;
	}
	public String getParentName() {
		return parentName;
	}
	public String getPhone() {
		return phone;
	}
	public String getNotes() {
		return notes;
	}
	public void setPkId(Integer pkId) {
		this.pkId = pkId;
	}
	public void setMrn(String mrn) {
		this.mrn = mrn;
	}
	public void setPtName(String ptName) {
		this.ptName = ptName;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setHlthNum(Long hlthNum) {
		this.hlthNum = hlthNum;
	}
	public void setVerCode(Long verCode) {
		this.verCode = verCode;
	}
	public void setExpiry(Long expiry) {
		this.expiry = expiry;
	}
	public void setCoverage(String coverage) {
		this.coverage = coverage;
	}
	public void setBillProv(String billProv) {
		this.billProv = billProv;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	//convert dto values to entity 
	public PatientDemographics _toConvertPatientEntity(){
	    PatientDemographics entity = new PatientDemographics();
	    java.sql.Date sqlDate = java.sql.Date.valueOf( this.dob.toString() );
	    entity.setPkId(this.pkId);
	    entity.setMrn(this.mrn);
	    entity.setPtName(this.ptName);
	    entity.setDob(sqlDate);
	    entity.setSex(this.sex);
	    entity.setHlthNum(hlthNum);
	    entity.setVerCode(verCode);
	    entity.setExpiry(expiry);
	    entity.setCoverage(coverage);
	    entity.setBillProv(billProv);
	    entity.setAddress(address);
	    entity.setCity(city);
	    entity.setProvince(province);
	    entity.setPostCode(postCode);
	    entity.setParentName(parentName);
	    entity.setPostCode(postCode);
	    entity.setPhone(phone);
	    entity.setNotes(notes);
	    return entity ;
	 }
}
