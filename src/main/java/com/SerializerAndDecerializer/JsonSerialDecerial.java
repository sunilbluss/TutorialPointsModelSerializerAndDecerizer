package com.SerializerAndDecerializer;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonSerialDecerial{
	public static final ObjectMapper JOSN_MAPPER = new ObjectMapper();
	
	public static Object readObject(String loc,Class<?> clazz) {
		try {
			return JOSN_MAPPER.readValue(new File(loc),clazz);
			
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static  boolean writeObject(Object obj, String loc) {
		try {
			String writeString = JOSN_MAPPER.writerWithDefaultPrettyPrinter()
					.writeValueAsString(obj);
			FileUtils.write(new File(loc), writeString);
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
	
	public static Object readObjectViaFile(File file,Class<?> clazz) {
		try {
			return JOSN_MAPPER.readValue(file,clazz);
			
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
