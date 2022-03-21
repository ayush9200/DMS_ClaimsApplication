/**
 * 
 */
package com.dynamic.medical.claimsapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dynamic.medical.claimsapplication.entity.MedicalData;

/**
 * @author Ayush Kumar Singh
 *
 */

@Repository
public interface RawDataRepo extends JpaRepository<MedicalData, Long> {
	@Query(value = "SELECT rw.provnum FROM MedicalData rw WHERE rw.provname =:name")
	String getProviderNumber(@Param("name") String prov_name);

}
