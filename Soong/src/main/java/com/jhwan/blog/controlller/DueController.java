package com.jhwan.blog.controlller;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jhwan.blog.dto.DueRequest;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class DueController {
	static final Logger logger = Logger.getLogger(DueController.class);
	
	@RequestMapping(value = "dueInfo", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody Object getMirizum(@RequestBody DueRequest dueRequest, HttpServletResponse response) {
		logger.info(":::: 계비정보 진입 :::: ");
		
		
		return null; 
	}
}
