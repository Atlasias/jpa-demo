package com.demo.spring.jpa.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.jpa.repository.BillionairesRepository;

@RestController
public class BillionairesController {

	Logger logger = LoggerFactory.getLogger(BillionairesController.class);
	
	@Autowired
	private BillionairesRepository billionairesRepository;
	
	@GetMapping("/getBillionaires")
	public ResponseEntity<?> getBillionaires(){
		logger.info("reached getBillionaires");
		MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
		Object data = null;
		HttpStatus httpStatus;
		if(billionairesRepository.count()<=0) {
			logger.error("list is empty");
			httpStatus = HttpStatus.NOT_FOUND;
			
			Map<String,Object> resultMap = new LinkedHashMap<>();
			resultMap.put("status", httpStatus);
			resultMap.put("cause", "no data to show");
			
			
		}else {
			logger.error("list is not empty");
			data = billionairesRepository.findAll();
			httpStatus = HttpStatus.OK;
		}
		return new ResponseEntity<>(data,header,httpStatus);
		
	}
	
	
}
