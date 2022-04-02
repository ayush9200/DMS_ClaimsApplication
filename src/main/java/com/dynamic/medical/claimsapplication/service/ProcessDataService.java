/**
 * 
 */
package com.dynamic.medical.claimsapplication.service;

import java.io.IOException;
import com.monitorjbl.xlsx.StreamingReader;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
import com.dynamic.medical.claimsapplication.entity.MedicalData;
import com.dynamic.medical.claimsapplication.modal.RawDataDto;
import com.dynamic.medical.claimsapplication.modal.RawExcelDto;
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
	
	public List<RawExcelDto> excelUpload(InputStream is, String fileName, long size, String fileType) throws ParseException {
		 List<RawExcelDto> dataList = new LinkedList<RawExcelDto>();
	    try {
	    	
	    	
	    	long startTime = System.nanoTime();
	    	//InputStream is = new FileInputStream(new File("/path/to/workbook.xlsx"));
	    	StreamingReader reader = StreamingReader.builder()
	    	        .rowCacheSize(100)    // number of rows to keep in memory (defaults to 10)
	    	        .bufferSize(4096)     // buffer size to use when reading InputStream to file (defaults to 1024)
	    	        .sheetIndex(0)        // index of sheet to use (defaults to 0)
	    	        .read(is);            // InputStream or File for XLSX file (required)

	    	int rowNumber = 0;
	    	System.out.println(" ===============  STARTED AT ========> "+ new Date().getTime());
	    	for (Row r : reader) {
	    		//System.out.println(r.getRowNum());
	    		if (rowNumber < 1) {
	    			rowNumber++;
	    			continue;
	    		}
	    		RawExcelDto rowData = new RawExcelDto();
	    		String value = "";
	    		int cellIdx = 0;
	    	  for (Cell currentCell : r) {
	    	   // System.out.println(c.getStringCellValue());
	   // 	  }
	   // 	}
	     // Workbook workbook = new XSSFWorkbook(is);
	      //Sheet sheet = workbook.getSheetAt(0);
	      //Iterator<Row> excelRow = sheet.iterator();
	     // while (excelRow.hasNext()) {
	      //  Row currentRow = excelRow.next();
	        // skip header
	        //RawDataDto excelRowData = new RawDataDto();
//	        Iterator<Cell> cellsInRow = currentRow.iterator();
	       // System.out.println("============= > "+ rowNumber);
	//        while (cellsInRow.hasNext()) {
	        	//Cell currentCell = cellsInRow.next();
	        	//CellType type = currentCell.getCellType();
                //if (type == CellType.STRING) {
                    value = currentCell.getStringCellValue();
                    if(value == null || value.isEmpty() || value.contains("******")) {
                    	cellIdx++;
                    	continue;
                    }
                //} else{
                	//CellType cellType = currentCell.getCellType();
                	//currentCell.setCellType(CellType.STRING);
                	//value = currentCell.getStringCellValue();
                 	//currentCell.setCellType(cellType);
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
             //   }
               // System.out.println("============== > "+cellIdx);
             	//System.out.println("============== > "+value);
	        	switch (cellIdx) {
	        	 case 0:
	        		 rowData.setPkid(Long.valueOf(value));
		          break;
		              
	            case 1:
	            	rowData.setFileid(Long.valueOf(value));
	              break;

	            case 2:
	            	rowData.setFilerow(Integer.parseInt(value));
	              break;

	            case 3:
	            	rowData.setPatientid(Long.valueOf(value));
	              break;

	            case 4:
	            	rowData.setMrn(Long.valueOf(value));
	              break;
	              
	            case 5:
	            	rowData.setCoverage(value);
	              break;

	            case 6:
	            	rowData.setProvname(value);
	              break;
	              
	            case 7:
	            	rowData.setProvnum(Long.valueOf(value));
	              break;

	            case 8:
	            	rowData.setRefname(value);
	              break;
	              
	            case 9:
	            	rowData.setRefnum(Long.valueOf(value));
	              break;


	            case 10:
	            	rowData.setSvcdate(value);
	              break;

	            case 11:
	            	rowData.setProccode(value);
	              break;
	              
	            case 12:
	            	rowData.setPercent(Integer.parseInt(value));
	              break;
	              
	            case 13:
	            	//Date date=new SimpleDateFormat("dd/MM/yyyy").parse(value);
	            	rowData.setAdmitdate(value);
	              break;
	              
	            case 14:
	            	rowData.setDxcode(Integer.parseInt(value));
	              break;
	              
	            case 15:
	            	rowData.setIcd10code(value);
	              break;

	            case 16:
	            	rowData.setStarttime(value);
	              break;
	              
	           case 17:
	            	rowData.setStoptime(value);
	              break;
	              
	            case 18:
	            	rowData.setBasicunits(Integer.parseInt(value));
	              break;
	              
	            case 19:
	            	//Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(value);
	            	rowData.setTimeunits(Integer.parseInt(value));
	              break;
	              
	            case 20:
	            	rowData.setQty(Integer.parseInt(value));
	              break;
	              
	            case 21:
	            	rowData.setUnitfee(Float.parseFloat(value));
	              break;
	              
	            case 22:
	            	rowData.setTotalfee(Float.parseFloat(value));
	              break;
	              
	            case 23:
	            	rowData.setFacility(Integer.parseInt(value));
	              break;
	              
	            case 24:
	            	rowData.setSlicode(value);
	              break;
	              
	            case 25:
	            	rowData.setManreview(value);
	              break;
	              
	            case 26:
	            	rowData.setClaim(Long.valueOf(value));
	              break;
	              
	            case 27:
	            	rowData.setStatus(value);
	              break;
	              
	            case 28:
	            	rowData.setErrcode(value);
	              break;
	              
	            case 29:
	            	rowData.setPaidamt(Float.parseFloat(value));
	              break;

	            case 30:
	            	rowData.setPaidstatus(value);
	              break;

	            case 31:
	            	rowData.setPaiddate(value);
	              break;

	            default:
	              break;
	            }
	        	
	        	cellIdx++;
	        }	
	        dataList.add(rowData);
	        
	        if(dataList.size() == 100) {
	        	ExecutorService es = Executors.newSingleThreadExecutor();
	        	es.execute(new Runnable() {
					@Override
					public void run() {
						Iterator<RawExcelDto> itr = dataList.iterator(); 
						while (itr.hasNext()) { 
							RawExcelDto dto = itr.next(); 
							MedicalData dataObject = dto._toConvertRawDataEntity();
							rawDataRepository.save(dataObject);
							itr.remove();
							}
						System.out.println("====== ============== 100 ROWS EXECUTED ======================= ======");
					}
				});
	        	es.shutdown(); 
	        }
	      }
	   //   workbook.close();
	      
	      //saving
	     for (RawExcelDto excelRows : dataList) {
			MedicalData dataObject = excelRows._toConvertRawDataEntity();
			rawDataRepository.save(dataObject);
		}
	     System.out.println(" ===============  ENDED AT ========> "+ new Date().getTime());
	     
	     //saving file details
	     FileLog fileLogEntity = new FileLog();
	     fileLogEntity.setFileName(fileName);
	     fileLogEntity.setFilePath("C:/File/Excel");
	     fileLogEntity.setFileSize(String.valueOf(size));
	     
	     long now = System.currentTimeMillis();
        java.sql.Date sqlDate = new java.sql.Date(now);
	     fileLogEntity.setImportDate(sqlDate);
	     fileLogEntity.setRowCount(rowNumber);
	     fileLogEntity.setXlsx_cols(32);
	     fileLogEntity.setXlsx_rows(rowNumber);
	     fileDataRepository.save(fileLogEntity);
	      
	     long endTime   = System.nanoTime();
	     long totalTime = endTime - startTime;
	     System.out.println(" ========================== TOTAL TIME : "+ totalTime + " =============================");
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	System.out.println(e.getMessage());
	      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
	    }
	    return dataList;
	  }

	public List<RawExcelDto> getAllRawData(String userRole, String providerNumber) {
		List<RawExcelDto> listOfData = new LinkedList<RawExcelDto>();
		try {
			List<MedicalData> rawDataList = rawDataRepository.findAll();
			RawExcelDto dtoObject = null;
			Boolean restrictData = (userRole.equalsIgnoreCase("client"))?true:false;
			for (MedicalData rawDataEntity : rawDataList) {
				if(restrictData) {
					if(!rawDataEntity.getProvnum().toString().equals(providerNumber)) {
						continue;
					}
				}
					
				dtoObject = new RawExcelDto();
				//java.util.Date dobDate = rawDataEntity.getDob();
				//java.util sqlDateDob = new java.sql.Date(dob.getTime());
				//java.util.Date expDate = rawDataEntity.getExpiry();
			    dtoObject.setPkid(rawDataEntity.getPkid());
			    dtoObject.setFileid(rawDataEntity.getFileid());
			    dtoObject.setFilerow(rawDataEntity.getFilerow());
			    dtoObject.setPatientid(rawDataEntity.getPatientid());
			    dtoObject.setMrn(rawDataEntity.getMrn());
			    dtoObject.setCoverage(rawDataEntity.getCoverage());
			    dtoObject.setProvname(rawDataEntity.getProvname());
			    dtoObject.setProvnum(rawDataEntity.getProvnum());
			    dtoObject.setRefname(rawDataEntity.getRefname());
			    dtoObject.setRefnum(rawDataEntity.getRefnum());
			    dtoObject.setSvcdate(rawDataEntity.getSvcdate());
			    dtoObject.setProccode(rawDataEntity.getProccode());
			    dtoObject.setPercent(rawDataEntity.getPercent());
			    dtoObject.setAdmitdate(rawDataEntity.getAdmitdate());
			    dtoObject.setDxcode(rawDataEntity.getDxcode());
			    dtoObject.setIcd10code(rawDataEntity.getIcd10code());
			    dtoObject.setStarttime(rawDataEntity.getStarttime());
			    dtoObject.setStoptime(rawDataEntity.getStoptime());
			    dtoObject.setBasicunits(rawDataEntity.getBasicunits());
			    dtoObject.setTimeunits(rawDataEntity.getTimeunits());
			    dtoObject.setQty(rawDataEntity.getQty());
			    dtoObject.setUnitfee(rawDataEntity.getUnitfee());
			    dtoObject.setTotalfee(rawDataEntity.getTotalfee());
			    dtoObject.setFacility(rawDataEntity.getFacility());
			    dtoObject.setSlicode(rawDataEntity.getSlicode());
			    dtoObject.setManreview(rawDataEntity.getManreview());
			    dtoObject.setClaim(rawDataEntity.getClaim());
			    dtoObject.setStatus(rawDataEntity.getStatus());
			    dtoObject.setErrcode(rawDataEntity.getErrcode());
			    dtoObject.setPaidamt(rawDataEntity.getPaidamt());
			    dtoObject.setPaidstatus(rawDataEntity.getPaidstatus());
			    dtoObject.setPaiddate(rawDataEntity.getPaiddate());
			    
			    listOfData.add(dtoObject);
			}
		} catch (Exception e) {
			e.printStackTrace();
		      throw new RuntimeException("Not able to get data: " + e.getMessage());
		}
		return listOfData;
	}
}
