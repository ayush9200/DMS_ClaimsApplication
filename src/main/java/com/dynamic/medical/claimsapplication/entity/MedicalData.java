package com.dynamic.medical.claimsapplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MedicalData {
	@Id
	@Column(unique=true)
	private Long pkid;
	private Long fileid;
	private int filerow;
	private Long patientid;
	private Long mrn;
	private String coverage;
	private String provname;
	private Long provnum;
	private String refname;
	private Long refnum;
	private String svcdate;
	private String proccode;
	private int percent;
	private String admitdate;
	private int dxcode;
	private String icd10code;
	private String starttime;
	private String stoptime;
	private int basicunits;
	private int timeunits;
	private int qty;
	private float unitfee;
	private float totalfee;
	private int facility;
	private String slicode;
	private String manreview;
	private Long claim;
	private String status;
	private String errcode;
	private float paidamt;
	private String paidstatus;
	private String paiddate;
	public Long getPkid() {
		return pkid;
	}
	public void setPkid(Long pkid) {
		this.pkid = pkid;
	}
	public Long getFileid() {
		return fileid;
	}
	public void setFileid(Long fileid) {
		this.fileid = fileid;
	}
	public int getFilerow() {
		return filerow;
	}
	public void setFilerow(int filerow) {
		this.filerow = filerow;
	}
	public Long getPatientid() {
		return patientid;
	}
	public void setPatientid(Long patientid) {
		this.patientid = patientid;
	}
	public Long getMrn() {
		return mrn;
	}
	public void setMrn(Long mrn) {
		this.mrn = mrn;
	}
	public String getCoverage() {
		return coverage;
	}
	public void setCoverage(String coverage) {
		this.coverage = coverage;
	}
	public String getProvname() {
		return provname;
	}
	public void setProvname(String provname) {
		this.provname = provname;
	}
	public Long getProvnum() {
		return provnum;
	}
	public void setProvnum(Long provnum) {
		this.provnum = provnum;
	}
	public String getRefname() {
		return refname;
	}
	public void setRefname(String refname) {
		this.refname = refname;
	}
	public Long getRefnum() {
		return refnum;
	}
	public void setRefnum(Long refnum) {
		this.refnum = refnum;
	}
	public String getSvcdate() {
		return svcdate;
	}
	public void setSvcdate(String svcdate) {
		this.svcdate = svcdate;
	}
	public String getProccode() {
		return proccode;
	}
	public void setProccode(String proccode) {
		this.proccode = proccode;
	}
	public int getPercent() {
		return percent;
	}
	public void setPercent(int percent) {
		this.percent = percent;
	}
	public String getAdmitdate() {
		return admitdate;
	}
	public void setAdmitdate(String admitdate) {
		this.admitdate = admitdate;
	}
	public int getDxcode() {
		return dxcode;
	}
	public void setDxcode(int dxcode) {
		this.dxcode = dxcode;
	}
	public String getIcd10code() {
		return icd10code;
	}
	public void setIcd10code(String icd10code) {
		this.icd10code = icd10code;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getStoptime() {
		return stoptime;
	}
	public void setStoptime(String stoptime) {
		this.stoptime = stoptime;
	}
	public int getBasicunits() {
		return basicunits;
	}
	public void setBasicunits(int basicunits) {
		this.basicunits = basicunits;
	}
	public int getTimeunits() {
		return timeunits;
	}
	public void setTimeunits(int timeunits) {
		this.timeunits = timeunits;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public float getUnitfee() {
		return unitfee;
	}
	public void setUnitfee(float unitfee) {
		this.unitfee = unitfee;
	}
	public float getTotalfee() {
		return totalfee;
	}
	public void setTotalfee(float totalfee) {
		this.totalfee = totalfee;
	}
	public int getFacility() {
		return facility;
	}
	public void setFacility(int facility) {
		this.facility = facility;
	}
	public String getSlicode() {
		return slicode;
	}
	public void setSlicode(String slicode) {
		this.slicode = slicode;
	}
	public String getManreview() {
		return manreview;
	}
	public void setManreview(String manreview) {
		this.manreview = manreview;
	}
	public Long getClaim() {
		return claim;
	}
	public void setClaim(Long claim) {
		this.claim = claim;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrcode() {
		return errcode;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public float getPaidamt() {
		return paidamt;
	}
	public void setPaidamt(float paidamt) {
		this.paidamt = paidamt;
	}
	public String getPaidstatus() {
		return paidstatus;
	}
	public void setPaidstatus(String paidstatus) {
		this.paidstatus = paidstatus;
	}
	public String getPaiddate() {
		return paiddate;
	}
	public void setPaiddate(String paiddate) {
		this.paiddate = paiddate;
	}
}
