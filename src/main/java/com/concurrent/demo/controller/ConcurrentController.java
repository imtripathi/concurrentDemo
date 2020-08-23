package com.concurrent.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.concurrent.demo.dataprocessing.DataProccessing;
import com.concurrent.demo.model.Data;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@Api(value = "concurrentController")
@RestController
@RequestMapping("/concurrent")
public class ConcurrentController {
	
	 
	
	
	@ApiOperation(value = "insert the data ", response = String.class)
	@ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	 
	@PutMapping(value = "/insertData",produces = "application/json")
	public String insertData(@RequestBody Data data) {
		DataProccessing dataprocessing= new DataProccessing();
		return dataprocessing.add(data.getKey(), data.getValue());
		 
	}
	
	@ApiOperation(value = "destroy the session ", response = String.class)
	@ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@PostMapping("/destroy")
	public String destroySession(HttpServletRequest request) {
		request.getSession().invalidate();
		return "session destroyed";
	}
	
	
}


