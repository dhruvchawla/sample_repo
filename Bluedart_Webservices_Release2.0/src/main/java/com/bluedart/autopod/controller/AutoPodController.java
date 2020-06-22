package com.bluedart.autopod.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bluedart.autopod.dto.AutoPodDto;
import com.bluedart.autopod.service.AutoPodService;
import com.bluedart.autopod.serviceImpl.AutoPodServiceImpl;
import com.bluedart.exception.PodMailServiceException;

@RestController
public class AutoPodController {
 
	private static final Logger logger = Logger.getLogger(AutoPodController.class);
	 
	@Autowired
	private AutoPodService autoPodService;
	
	// private static final Logger logger = Logger.getLogger(AutoPodController.class);
	@RequestMapping(value = "autopod/autoPodCreation", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<AutoPodDto> createPod(@RequestBody AutoPodDto autoPodDto) {
		logger.debug(" AutoPodController : createPod");
		System.out.println("createAutoPod from Java side is  called");
		AutoPodDto autoPodDtoRes=autoPodService.createPod(autoPodDto);
		return new ResponseEntity(autoPodDtoRes, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "autopod/autoPodSearch/autoPodDto", method = RequestMethod.POST)
	public ResponseEntity<AutoPodDto> searchPod(@RequestBody AutoPodDto autoPodDto) {
		logger.debug(" AutoPodController : searchPod");
		System.out.println("searchPod in controller is  called in BD Service");
		AutoPodDto autoPodDtoRes=autoPodService.searchPod(autoPodDto);
		System.out.println("searchPod in controller is  called in BD Service size is "+autoPodDtoRes.getAutoPodList().size());
		return new ResponseEntity(autoPodDtoRes, HttpStatus.OK);
	}
	
	@RequestMapping(value = "autopod/autoPodEdit", method = RequestMethod.POST)
	public ResponseEntity<AutoPodDto> editPod(@RequestBody AutoPodDto autoPodDto) {
		logger.debug(" AutoPodController : editPod");
		System.out.println("searchAutoPodEntry called");
		AutoPodDto autoPodDtoRes=autoPodService.editPod(autoPodDto);
		return new ResponseEntity(autoPodDtoRes, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "autopod/autoPodDelete", method = RequestMethod.POST)
	public ResponseEntity<AutoPodDto> softDeletePod(@RequestBody AutoPodDto autoPodDto) {
		logger.debug(" AutoPodController : softDeletePod");
		System.out.println("deleteAutoPodToEntry called");
		AutoPodDto autoPodDtoRes=autoPodService.softDeletePod(autoPodDto);
		return new ResponseEntity(autoPodDtoRes, HttpStatus.OK);
	}
	
	@ExceptionHandler(PodMailServiceException.class)
    private AutoPodDto myError(PodMailServiceException serviceException) {
		 logger.debug(" AutoPodController : myError");
          System.out.println("exception");
          AutoPodDto trackDto = new AutoPodDto();
          trackDto.setErrorcode(serviceException.getErrorCode());
          trackDto.setErrorMessage(serviceException.getErrorMessage());
        return trackDto;
    }
}
