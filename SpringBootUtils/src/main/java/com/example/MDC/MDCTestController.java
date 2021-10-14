package com.example.MDC;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MDCTestController {
	
	 Logger logger = LoggerFactory.getLogger(MDCTestController.class);

	@GetMapping("/mdc")
	public String mdc() {
		logger.info("Inside mdc  method");
		return "MDC Test";
	}
}
