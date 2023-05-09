package com.json;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.gson.JsonObject;




@SpringBootApplication
public class RedingJsonFileDataCountApplication{

	public static void main(String[] args) throws IOException {
		SpringApplication.run(RedingJsonFileDataCountApplication.class, args);
		
		
	}

}
