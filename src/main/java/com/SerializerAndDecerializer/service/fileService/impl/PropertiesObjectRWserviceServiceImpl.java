package com.SerializerAndDecerializer.service.fileService.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import com.SerializerAndDecerializer.service.fileService.ObjectRWservice;
import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlWriter;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PropertiesObjectRWserviceServiceImpl implements ObjectRWservice {
	public Object readObject(String loc) {
		Properties prop = new Properties();
		try {
			InputStream input  = new FileInputStream(loc);
			prop.load(input);
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return prop;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean writeObject(Object obj, String loc) {
		Properties prop = (Properties) obj;
		OutputStream output = null;
		try {
			output = new FileOutputStream(loc);
			// save properties to project root folder
			prop.store(output, null);
			return true;

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return false;
	}
	 
	
}
