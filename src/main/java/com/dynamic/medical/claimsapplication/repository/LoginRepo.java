/**
 * 
 */
package com.dynamic.medical.claimsapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dynamic.medical.claimsapplication.entity.LoginDetails;

/**
 * @author Ayush Kumar Singh
 *
 */
@Repository
public interface LoginRepo extends JpaRepository<LoginDetails, Integer>{

	@Query(value = "SELECT ld FROM LoginDetails ld WHERE ld.username =:username and ld.password =:password")
	LoginDetails getLoginVerified(@Param("username") String username, @Param("password") String password);
	
	@Modifying
	@Query(value = "UPDATE LoginDetails ld SET ld.password =:newPassword WHERE ld.username =:username and ld.password =:oldPassword")
	void updatePassword(@Param("username")String username, @Param("oldPassword") String oldPassword, @Param("newPassword") String newPassword);

	@Query(value = "DELETE LoginDetails ld WHERE ld.username =:username and ld.provnum =:provnum")
	void deleteUser(@Param("username") String username,@Param("provnum") String provnum);
}
