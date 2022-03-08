/**
 * 
 */
package com.dynamic.medical.claimsapplication.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author  Ayush  Kumar Singh
 *
 */
@Entity
public class RawData {
	
	@Id
	private Double uclId;
	private String mrn;
	private String ptName;
	private Date dob;
	private String sex;
	private Long hlthNum;
	private Long verCode;
	private Date expiry;
	private String coverage;
	private String billProv;
	private String address;
	private String city;
	private String province;
	private String postCode;
	private String parentName;
	private String phone;
	private String notes;
	private String familyDoc;
	private String refName;
	private String refNum;
	private String provName;
	private String provNum;
	private String deptName;
	private String svcDate;
	private String admitDate;
	private String procName;
	private String procCode;
	private String visitType;
	private String stdUnits;
	private String startTime;
	private String stopTime;
	private String timeUnits;
	private String qty;
	private String dxName;
	private String dxCode;
	private String icd10Code;
	private String fileId;
	private String fileRow;
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String pkId;
	private String manReview;
	
	public Double getUclId() {
		return uclId;
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
	public Date getExpiry() {
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
	public String getFamilyDoc() {
		return familyDoc;
	}
	public String getRefName() {
		return refName;
	}
	public String getRefNum() {
		return refNum;
	}
	public String getProvName() {
		return provName;
	}
	public String getProvNum() {
		return provNum;
	}
	public String getDeptName() {
		return deptName;
	}
	public String getSvcDate() {
		return svcDate;
	}
	public String getAdmitDate() {
		return admitDate;
	}
	public String getProcName() {
		return procName;
	}
	public String getProcCode() {
		return procCode;
	}
	public String getVisitType() {
		return visitType;
	}
	public String getStdUnits() {
		return stdUnits;
	}
	public String getStartTime() {
		return startTime;
	}
	public String getStopTime() {
		return stopTime;
	}
	public String getTimeUnits() {
		return timeUnits;
	}
	public String getQty() {
		return qty;
	}
	public String getDxName() {
		return dxName;
	}
	public String getDxCode() {
		return dxCode;
	}
	public String getIcd10Code() {
		return icd10Code;
	}
	public String getFileId() {
		return fileId;
	}
	public String getFileRow() {
		return fileRow;
	}
	public String getPkId() {
		return pkId;
	}
	public String getManReview() {
		return manReview;
	}
	public void setUclId(Double uclId) {
		this.uclId = uclId;
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
	public void setExpiry(Date expiry) {
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
	public void setFamilyDoc(String familyDoc) {
		this.familyDoc = familyDoc;
	}
	public void setRefName(String refName) {
		this.refName = refName;
	}
	public void setRefNum(String refNum) {
		this.refNum = refNum;
	}
	public void setProvName(String provName) {
		this.provName = provName;
	}
	public void setProvNum(String provNum) {
		this.provNum = provNum;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public void setSvcDate(String svcDate) {
		this.svcDate = svcDate;
	}
	public void setAdmitDate(String admitDate) {
		this.admitDate = admitDate;
	}
	public void setProcName(String procName) {
		this.procName = procName;
	}
	public void setProcCode(String procCode) {
		this.procCode = procCode;
	}
	public void setVisitType(String visitType) {
		this.visitType = visitType;
	}
	public void setStdUnits(String stdUnits) {
		this.stdUnits = stdUnits;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}
	public void setTimeUnits(String timeUnits) {
		this.timeUnits = timeUnits;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public void setDxName(String dxName) {
		this.dxName = dxName;
	}
	public void setDxCode(String dxCode) {
		this.dxCode = dxCode;
	}
	public void setIcd10Code(String icd10Code) {
		this.icd10Code = icd10Code;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public void setFileRow(String fileRow) {
		this.fileRow = fileRow;
	}
	public void setPkId(String pkId) {
		this.pkId = pkId;
	}
	public void setManReview(String manReview) {
		this.manReview = manReview;
	}
	
	
	
	
}
