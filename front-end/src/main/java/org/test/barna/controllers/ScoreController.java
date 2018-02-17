package org.test.barna.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.test.Connectors.MySQLManager;


@Controller
public class ScoreController {
	
	@Autowired
	MySQLManager mysqlManager;
	
	@Value("${welcome.message:test}")
	private String message = "Hello World";
	
	@RequestMapping("/score")
	public String index(Map<String, Object> model) {
		return "score";
	}
	
	@RequestMapping("/score/{id}")
	public String getScore(@PathVariable("id") int id){
		mysqlManager.getModel(id);
		return "score";
		
	}
	
	

}
