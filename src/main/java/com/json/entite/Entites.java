package com.json.entite;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Entites {

	private String KYC;
	private String Signup;
	private String transaction;
	private String Loannumber;
	private String DeviceId;
	Map<String, String> map = new HashMap<String, String>();
	

}
