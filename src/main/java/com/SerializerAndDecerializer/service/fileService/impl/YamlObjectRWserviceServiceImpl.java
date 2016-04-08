package com.SerializerAndDecerializer.service.fileService.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.SerializerAndDecerializer.service.fileService.ObjectRWservice;
import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlWriter;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class YamlObjectRWserviceServiceImpl implements ObjectRWservice {
	public Object readObject(String loc) {
		try {
			YamlReader reader = new YamlReader(new FileReader(loc));
			try {
				return reader.read();
			} catch (YamlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean writeObject(Object obj, String loc) {
		try {
			YamlWriter writer = new YamlWriter(new FileWriter(loc));
			writer.write(obj);
		    writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	 
	
}
