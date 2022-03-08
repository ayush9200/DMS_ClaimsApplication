/**
 * 
 */
package com.dynamic.medical.claimsapplication.service;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dynamic.medical.claimsapplication.entity.FileLog;
import com.dynamic.medical.claimsapplication.entity.RawData;
import com.dynamic.medical.claimsapplication.modal.RawDataDto;
import com.dynamic.medical.claimsapplication.repository.RawDataRepo;


/**
 * @author Ayush Kumar Singh
 *
 */

@Service
public class ProcessDataService {
	
	//@Autowired
	//private FileLog fileLogRepository;
	
	@Autowired
	private RawDataRepo rawDataRepository;
	@Autowired
	private com.dynamic.medical.claimsapplication.repository.FileLog fileDataRepository;
	
public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	
	public boolean checkIfExcel(MultipartFile file) {

	    if (!TYPE.equals(file.getContentType())) {
	      return false;
	    }

	    return true;
	  }
	
	public List<RawDataDto> excelUpload(InputStream is, String fileName, long size, String fileType) throws ParseException {
		 List<RawDataDto> dataList = new LinkedList<RawDataDto>();
	    try {
	      Workbook workbook = new XSSFWorkbook(is);
	      Sheet sheet = workbook.getSheetAt(0);
	      Iterator<Row> excelRow = sheet.iterator();
	      int rowNumber = 0;
	      while (excelRow.hasNext()) {
	        Row currentRow = excelRow.next();
	        // skip header
	        if (rowNumber < 1) {
	          rowNumber++;
	          continue;
	        }
	        RawDataDto excelRowData = new RawDataDto();
	        Iterator<Cell> cellsInRow = currentRow.iterator();
	        String value = "";
	        int cellIdx = 0;
	       // System.out.println("============= > "+ rowNumber);
	        while (cellsInRow.hasNext()) {
	        	Cell currentCell = cellsInRow.next();
	        	CellType type = currentCell.getCellType();
                if (type == CellType.STRING) {
                    value = currentCell.getStringCellValue();
                } else{
                	CellType cellType = currentCell.getCellType();
                	currentCell.setCellType(CellType.STRING);
                	value = currentCell.getStringCellValue();
                 	currentCell.setCellType(cellType);
                 	/*
					 * if (type == CellType.NUMERIC) {
					 * 
					 * // value = String.valueOf(currentCell.getNumericCellValue());
					 * 
					 * } else if (type == CellType.BOOLEAN) { value =
					 * String.valueOf(currentCell.getBooleanCellValue());
					 * 
					 * } else if (type == CellType.BLANK) { value = ""; }
					 */
                }
               // System.out.println("============== > "+cellIdx);
             	//System.out.println("============== > "+value);
	        	switch (cellIdx) {
	        	 case 0:
		          excelRowData.setUclId(Double.valueOf(value));
		          break;
		              
	            case 1:
	            	excelRowData.setMrn(value);
	              break;

	            case 2:
	              excelRowData.setPtName(value);
	              break;

	            case 3:
	            	excelRowData.setDeptName(value);
	              break;

	            case 4:
	            	excelRowData.setProvName(value);
	              break;
	              
	            case 5:
	            	excelRowData.setRefName(value);
	              break;

	            case 6:
	            	excelRowData.setRefNum(value);
	              break;

	            case 7:
	            	excelRowData.setAdmitDate(value);
	              break;

	            case 8:
	            	excelRowData.setDxName(value);
	              break;

	            case 9:
	            	excelRowData.setDxCode(value);
	              break;
	              
	            case 10:
	            	excelRowData.setQty(value);
	              break;
	              
	            case 11:
	            	Date date=new SimpleDateFormat("dd/MM/yyyy").parse(value);
	            	excelRowData.setDob(date);
	              break;
	              
	            case 12:
	            	excelRowData.setCoverage(value);
	              break;
	              
	            case 13:
	            	excelRowData.setSex(value);
	              break;

	            case 14:
	            	excelRowData.setStartTime(value);
	              break;
	              
	           case 15:
	            	excelRowData.setStopTime(value);
	              break;
	              
	            case 16:
	            	excelRowData.setIcd10Code(value);
	              break;
	              
	            case 17:
	            	Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(value);
	            	excelRowData.setExpiry(date2);
	              break;
	              
	            case 18:
	            	excelRowData.setAddress(value);
	              break;
	              
	            case 19:
	            	excelRowData.setCity(value);
	              break;
	              
	            case 20:
	            	excelRowData.setProvince(value);
	              break;
	              
	            case 21:
	            	excelRowData.setPostCode(value);
	              break;
	              
	            case 22:
	            	excelRowData.setParentName(value);
	              break;

	            default:
	              break;
	            }
	        	
	        	cellIdx++;
	        }	
	        dataList.add(excelRowData);
	      }
	      workbook.close();
	      
	      //saving
	     for (RawDataDto excelRows : dataList) {
			RawData datadtoObject = excelRows._toConvertRawDataEntity();
			rawDataRepository.save(datadtoObject);
		}
	     
	     //saving file details
	     FileLog fileLogEntity = new FileLog();
	     fileLogEntity.setFileName(fileName);
	     fileLogEntity.setFilePath("C:/File/Excel");
	     fileLogEntity.setFileSize(String.valueOf(size));
	     
	     long now = System.currentTimeMillis();
        java.sql.Date sqlDate = new java.sql.Date(now);
	     fileLogEntity.setImportDate(sqlDate);
	     fileLogEntity.setRowCount(rowNumber);
	     fileLogEntity.setXlsx_cols(22);
	     fileLogEntity.setXlsx_rows(rowNumber);
	     fileDataRepository.save(fileLogEntity);
	      
	    } catch (IOException e) {
	    	e.printStackTrace();
	      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
	    }
	    return dataList;
	  }

	public List<RawDataDto> getAllRawData(String userRole, String providerNumber) {
		List<RawDataDto> listOfData = new LinkedList<RawDataDto>();
		try {
			List<RawData> rawDataList = rawDataRepository.findAll();
			RawDataDto dtoObject = null;
			Boolean restrictData = (userRole.equalsIgnoreCase("client"))?true:false;
			for (RawData rawDataEntity : rawDataList) {
				if(restrictData) {
					if(!providerNumber.equals(rawDataEntity.getProvNum())) {
						continue;
					}
				}
					
				dtoObject = new RawDataDto();
				java.util.Date dobDate = rawDataEntity.getDob();
				//java.util sqlDateDob = new java.sql.Date(dob.getTime());
				java.util.Date expDate = rawDataEntity.getExpiry();
			    dtoObject.setPkId(rawDataEntity.getPkId());
			    dtoObject.setMrn(rawDataEntity.getMrn());
			    dtoObject.setPtName(rawDataEntity.getPtName());
			    dtoObject.setDeptName(rawDataEntity.getDeptName());
			    dtoObject.setProvName(rawDataEntity.getProvName());
			    dtoObject.setRefName(rawDataEntity.getRefName());
			    dtoObject.setAdmitDate(rawDataEntity.getAdmitDate());
			    dtoObject.setDxName(rawDataEntity.getDxName());
			    dtoObject.setDxCode(rawDataEntity.getDxCode());
			    dtoObject.setQty(rawDataEntity.getQty());
			    dtoObject.setDob(dobDate);
			    dtoObject.setSex(rawDataEntity.getSex());
			    dtoObject.setHlthNum(rawDataEntity.getHlthNum());
			    dtoObject.setVerCode(rawDataEntity.getVerCode());
			    dtoObject.setExpiry(expDate);
			    dtoObject.setCoverage(rawDataEntity.getCoverage());
			    dtoObject.setStartTime(rawDataEntity.getStartTime());
			    dtoObject.setStopTime(rawDataEntity.getStopTime());
			    dtoObject.setBillProv(rawDataEntity.getBillProv());
			    dtoObject.setAddress(rawDataEntity.getAddress());
			    dtoObject.setCity(rawDataEntity.getCity());
			    dtoObject.setProvince(rawDataEntity.getProvince());
			    dtoObject.setPostCode(rawDataEntity.getPostCode());
			    dtoObject.setParentName(rawDataEntity.getParentName());
			    dtoObject.setPostCode(rawDataEntity.getPostCode());
			    dtoObject.setPhone(rawDataEntity.getPhone());
			    dtoObject.setNotes(rawDataEntity.getNotes());
			    dtoObject.setUclId(rawDataEntity.getUclId());
			    
			    listOfData.add(dtoObject);
			}
		} catch (Exception e) {
			e.printStackTrace();
		      throw new RuntimeException("Not able to get data: " + e.getMessage());
		}
		return listOfData;
	}
}
