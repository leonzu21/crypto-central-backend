package com.phc.cryptocentral.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;


import com.phc.cryptocentral.dao.WhaleAlertRequestRepository;



@RepositoryRestController
public class WhaleAlertRequestRestController {

	private WhaleAlertRequestRepository whaleAlertRequestRepository;

	@Autowired
	public WhaleAlertRequestRestController(WhaleAlertRequestRepository theWhaleAlertRequestRepository) {
		whaleAlertRequestRepository = theWhaleAlertRequestRepository;
	}

}
