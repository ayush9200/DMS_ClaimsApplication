/**
 * 
 */
package com.dynamic.medical.claimsapplication.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dynamic.medical.claimsapplication.login.LoginService;
import com.dynamic.medical.claimsapplication.modal.RawDataDto;
import com.dynamic.medical.claimsapplication.service.ProcessDataService;

/**
 * @author Ayush Kumar Singh
 *
 */

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@ComponentScan("com.dynamic.medical.claimsapplication")
public class ClaimFile {
	@Autowired
	ProcessDataService processDataService;
	
	@Autowired
	LoginService loginService;
	
	@PostMapping("/upload")
	public List<RawDataDto> getRequest(@RequestParam("excel") MultipartFile file) {
		
		List<RawDataDto> excelDto = new LinkedList<RawDataDto>();
	    if (processDataService.checkIfExcel(file)) {
	      try {
	        excelDto = processDataService.excelUpload(file.getInputStream(),file.getOriginalFilename(), file.getSize(), "excel");

	        System.out.println("Uploaded the file successfully: " + file.getOriginalFilename());
	      } catch (Exception e) {
	    	  e.printStackTrace();
	        System.out.println("Could not upload the file: " + file.getOriginalFilename() + "!");
	      }
	    }else {
	    	System.out.println("Not an excel file.");
	    }

	    return excelDto;
	} 
	
	
	@GetMapping("/rawData")
	public List<RawDataDto> getRawData() {
		List<RawDataDto> listOfRawData = new LinkedList<RawDataDto>();
		try {
			listOfRawData = processDataService.getAllRawData(null, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listOfRawData;
	}
	
	@GetMapping("/")
	public String welcomeMsg() {
		return "Hi! Server is Up and running.";
	}
	
	@GetMapping("/login")
	public ResponseEntity<Map<String,Object>> getLoginVerified(@RequestParam("username") String username, 
			@RequestParam("password") String password) {
		ResponseEntity<Map<String,Object>> response = null;
		Map<String, String> mapToUser = null;
		List<RawDataDto> listOfRawData = new LinkedList<RawDataDto>();
		try {
			mapToUser = loginService.getLoginCredVerified(username, password);
			if(mapToUser == null || mapToUser.isEmpty()) 
				response = new ResponseEntity<Map<String,Object>>(HttpStatus.NOT_FOUND);
			else {
				
				listOfRawData = processDataService.getAllRawData(mapToUser.get("role"), mapToUser.get("provnum"));
				Map<String, Object> mapToReturn = new HashMap<String, Object>();
				mapToReturn.put("user", mapToUser);
				mapToReturn.put("data", listOfRawData);
				response = new ResponseEntity<Map<String,Object>>(mapToReturn, HttpStatus.OK);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	@PostMapping("/createUser")
	public ResponseEntity<String> createUserForLogin(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("role") String role, @RequestParam("fullname") String fullName) {
		ResponseEntity<String> responseBody = null;
		int resCode = 0;
		try {
			resCode = loginService.createUser(username, password, role, fullName);
			if(resCode == 1) 
				responseBody = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			else
				responseBody = new ResponseEntity<String>("FAIL", HttpStatus.NOT_FOUND);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseBody;
	}
}
