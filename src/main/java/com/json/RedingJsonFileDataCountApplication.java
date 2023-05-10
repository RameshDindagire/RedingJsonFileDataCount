package com.json;

import java.io.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.google.gson.JsonObject;




@SpringBootApplication
public class RedingJsonFileDataCountApplication extends SpringBootServletInitializer{

	public static void main(String[] args) throws IOException {
		SpringApplication.run(RedingJsonFileDataCountApplication.class, args);
		
		
	}
	
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	        return builder.sources(RedingJsonFileDataCountApplication.class);
	    }

}
