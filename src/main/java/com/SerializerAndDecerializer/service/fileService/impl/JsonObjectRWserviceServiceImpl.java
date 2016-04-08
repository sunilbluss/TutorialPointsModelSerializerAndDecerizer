package com.SerializerAndDecerializer.service.fileService.impl;

import java.io.File;
import java.io.IOException;

import com.SerializerAndDecerializer.service.fileService.ObjectRWservice;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonObjectRWserviceServiceImpl implements ObjectRWservice {
	ObjectMapper jsonMapper = new ObjectMapper();
	public Object readObject(String loc) {
		try {
			
			return jsonMapper.readValue(new File(loc),Class.class);
			
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean writeObject(Object obj, String loc) {
		try {
			jsonMapper.writeValue(new File(loc), obj);
			return true;
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	 
	
}
