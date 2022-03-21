/**
 * 
 */
package com.dynamic.medical.claimsapplication.login;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dynamic.medical.claimsapplication.entity.LoginDetails;
import com.dynamic.medical.claimsapplication.modal.RoleType;
import com.dynamic.medical.claimsapplication.repository.LoginRepo;
import com.dynamic.medical.claimsapplication.repository.RawDataRepo;

/**
 * @author ADMIN
 *
 */

@Service
public class LoginService {
	
	@Autowired
	LoginRepo loginRepository;
	@Autowired
	private RawDataRepo rawDataRepository;
	
	public int createUser(String username, String password, String role, String fullName, String provnum) {
		int res = 0;
		try {
			LoginDetails loginEntity = new LoginDetails();
			loginEntity.setUsername(username);
			loginEntity.setPassword(password);
			loginEntity.setFullName(fullName);
			loginEntity.setProvnum(provnum);
			
			if(role.equalsIgnoreCase("admin"))
				role = RoleType.ADMIN.toString();
			else if(role.equalsIgnoreCase("client"))
				role = RoleType.CLIENT.toString();
			else
				role = RoleType.PROVIDER.toString();
			loginEntity.setRole(role);
			loginRepository.save(loginEntity);
			res = 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public Map<String,String> getLoginCredVerified(String username, String password) {
		Map<String, String> mapToReturn = new HashedMap<String, String>();
		try {
			LoginDetails loginEntity = loginRepository.getLoginVerified(username, password);
			if(null != loginEntity && loginEntity.getUsername().equalsIgnoreCase(username)) {
				mapToReturn.put("name", loginEntity.getFullName());
				
				//String providerNumber = rawDataRepository.getProviderNumber(loginEntity.getFullName());
				mapToReturn.put("provnum", loginEntity.getProvnum());
				mapToReturn.put("role", loginEntity.getRole());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapToReturn;
	}

	
}
