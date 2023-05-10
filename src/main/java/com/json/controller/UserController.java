package com.json.controller;

import java.io.File;


import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import org.json.simple.*;
import org.json.simple.JSONArray;

//only for test imported 

//import org.json.JSONArray;
//import org.json.JSONObject;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;




@Controller
//@RestController
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/get")
	public String getJsonData(Model model) throws IOException, ParseException{
		
		/* Here We Convert The NDJSON File NORMAL JSON File To Read That File */
			File ndJsonFile = new File("src/main/resources/test2.json");
			File JsonFile = new File("src/main/resources/test1.json");
			
			ObjectMapper mapper = new ObjectMapper();
			
			String [] lines = org.apache.commons.io.FileUtils.readFileToString(ndJsonFile,"UTF-8").split("\\r?\\n");
			
			ArrayNode arrayNode =mapper.createArrayNode();
			for (String line: lines) {
				JsonNode jsonNode = mapper.readTree(line);
				arrayNode.add(jsonNode);
			}
			
			/* Here Will Add The File All Converted Data */
			mapper.writerWithDefaultPrettyPrinter().writeValue(JsonFile, arrayNode);
			
	/* ------------------------------------------------------------------------------------------- */
			/* Hear We Read Data of That NDJSON Converted file*/
			JSONParser jsonParser = new JSONParser();
		
			FileReader reader = new FileReader("src/main/resources/test1.json");
			/* Passed The Object Of File Reader */
			Object object =jsonParser.parse(reader);
			JSONArray array = (JSONArray)object;

			/* ITRATE The length Of array  */
			int SignUp=0;
			int KYC=0;
			int Loan=0;
			int Transaction=0;
			for (int i = 0; i < array.size(); i++) {
				
				JSONObject jsonObject= (JSONObject) array.get(i);
				/* Here We Check The Key value of JSON Data And Count The Value Of key */
				if(jsonObject.containsValue("SignUP")){
					SignUp = SignUp+1;
				}
				else if(jsonObject.containsValue("KYC")){
					KYC=KYC+1;
				}
				else if(jsonObject.containsValue("saveImageToFinnone")){
					Loan=Loan+1;
				}
				else if(jsonObject.containsValue("Transaction")){
					Transaction=Transaction+1;
				}
				System.out.println(" ");
				System.out.println(jsonObject);
				System.out.println(" ");
			}
			/* All Collected Data Print Here */
			System.out.println("Total SignUp := ["+SignUp+"] || KYC ["+KYC+"] || "+"Loan ["+Loan+"] || Transaction ["+Transaction+"]");
			
			/*
			  array.forEach(emp -> parseEmpObj((JSONObject)emp));
			  
			  return new ResponseEntity<>(array,HttpStatus.OK);
			 */
			
			/* Here Will Pass The Counted Data Of each Parameter And Send To the Front End  */
			model.addAttribute("SignUp",SignUp);
			model.addAttribute("KYC",KYC);
			model.addAttribute("Loan",Loan);
			model.addAttribute("Transaction",Transaction); 
			return "home"; 
	}

	/*
	 * private static void parseEmpObj(JSONObject emp) {
	 * 
	 * JSONObject jsonObject = (JSONObject)emp.get(""); String Type=(String)
	 * emp.get("Type"); String DeviceId=(String) emp.get("deviceid"); String
	 * timestamp=(String) emp.get("timestamp"); String LoanNumber=(String)
	 * emp.get("LoanNumber"); String Transaction=(String) emp.get("Transaction");
	 * 
	 * 
	 * System.out.println("Type:= "+ Type +" DeviceId:= "+DeviceId+" timestamp:= "
	 * +timestamp+" Transaction:= "+Transaction);
	 * 
	 * }
	 */
	

}
