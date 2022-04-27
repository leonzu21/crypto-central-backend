package com.phc.cryptocentral.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phc.cryptocentral.entity.WhaleAlertRequest;

public interface WhaleAlertRequestRepository extends JpaRepository<WhaleAlertRequest, Integer> {

}
