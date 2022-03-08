/**
 * 
 */
package com.dynamic.medical.claimsapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dynamic.medical.claimsapplication.entity.RawData;

/**
 * @author Ayush Kumar Singh
 *
 */

@Repository
public interface RawDataRepo extends JpaRepository<RawData, Integer> {
	@Query(value = "SELECT rw.provNum FROM RawData rw WHERE rw.provName =:name")
	String getProviderNumber(@Param("name") String prov_name);

}
