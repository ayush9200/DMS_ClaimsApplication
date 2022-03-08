/**
 * 
 */
package com.dynamic.medical.claimsapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dynamic.medical.claimsapplication.entity.PatientDemographics;

/**
 * @author Ayush Kumar Singh
 *
 */
public interface PatientDemographicsRepo extends JpaRepository<PatientDemographics, Integer> {
	
}
