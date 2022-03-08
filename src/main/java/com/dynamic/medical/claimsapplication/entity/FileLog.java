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
 * @author Ayush Kumar Singh
 *
 */


@Entity
public class FileLog {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer fileId;
	private String filePath;
	private String fileName;
	private String fileData;
	private String fileSize;
	private String fileType;
	private String ptName;
	private String status;
	private Date importDate;
	private Integer xlsx_rows;
	private Integer xlsx_cols;
	private String xlsx_hdrs;
	private String xlsx_color;
	private Integer rowCount;
	private Integer billCount;
	private Date billDate;
	private String notes;
	
	public Integer getFileId() {
		return fileId;
	}
	public String getFilePath() {
		return filePath;
	}
	public String getFileName() {
		return fileName;
	}
	public String getFileData() {
		return fileData;
	}
	public String getFileSize() {
		return fileSize;
	}
	public String getFileType() {
		return fileType;
	}
	public String getPtName() {
		return ptName;
	}
	public String getStatus() {
		return status;
	}
	public Date getImportDate() {
		return importDate;
	}
	public Integer getXlsx_rows() {
		return xlsx_rows;
	}
	public Integer getXlsx_cols() {
		return xlsx_cols;
	}
	public String getXlsx_hdrs() {
		return xlsx_hdrs;
	}
	public String getXlsx_color() {
		return xlsx_color;
	}
	public Integer getRowCount() {
		return rowCount;
	}
	public Integer getBillCount() {
		return billCount;
	}
	public Date getBillDate() {
		return billDate;
	}
	public String getNotes() {
		return notes;
	}
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public void setFileData(String fileData) {
		this.fileData = fileData;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public void setPtName(String ptName) {
		this.ptName = ptName;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setImportDate(Date importDate) {
		this.importDate = importDate;
	}
	public void setXlsx_rows(Integer xlsx_rows) {
		this.xlsx_rows = xlsx_rows;
	}
	public void setXlsx_cols(Integer xlsx_cols) {
		this.xlsx_cols = xlsx_cols;
	}
	public void setXlsx_hdrs(String xlsx_hdrs) {
		this.xlsx_hdrs = xlsx_hdrs;
	}
	public void setXlsx_color(String xlsx_color) {
		this.xlsx_color = xlsx_color;
	}
	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}
	public void setBillCount(Integer billCount) {
		this.billCount = billCount;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
}
