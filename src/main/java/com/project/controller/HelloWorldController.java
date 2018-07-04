package com.project.controller;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.exception.CustomGenericException;

@Controller
public class HelloWorldController {

	static final Logger logger = Logger.getLogger(HelloWorldController.class);

	@RequestMapping(value = "/{type:.+}", method = RequestMethod.GET)
	public ModelAndView getPages(@PathVariable("type") String type)
			throws Exception {

		if ("error".equals(type)) {
			// go handleCustomException
			logger.error("CustomGenericException");
			throw new CustomGenericException("E888", "This is custom message");
		} else if ("io-error".equals(type)) {
			// go handleAllException
			logger.error("IOException");
			throw new IOException();
		} else {
			logger.error("Check-Point");	
			return new ModelAndView("index").addObject("msg", type);
		}

	}

}