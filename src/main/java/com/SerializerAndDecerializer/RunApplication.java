package com.SerializerAndDecerializer;

import com.SerializerAndDecerializer.JsonSerialDecerial;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.SerializerAndDecerializer.service.fileService.impl.JsonObjectRWserviceServiceImpl;
import com.SerializerAndDecerializer.service.fileService.impl.PropertiesObjectRWserviceServiceImpl;
import com.SerializerAndDecerializer.service.fileService.impl.XmlObjectRWserviceServiceImpl;
import com.SerializerAndDecerializer.service.fileService.impl.YamlObjectRWserviceServiceImpl;
import com.SerializerAndDecerializer.util.model.DummyPerson;


public class RunApplication {
	public static void main(String[] args) {
		File profileOutFile = new File(
				"E:\\\\Test.json");
		final String LOC = "E:\\\\";
		DummyPerson dummyPerson = DummyPerson.getDummyPerson();
		YamlObjectRWserviceServiceImpl yImp = new YamlObjectRWserviceServiceImpl();
		PropertiesObjectRWserviceServiceImpl pImp = new PropertiesObjectRWserviceServiceImpl();
		/*XmlObjectRWserviceServiceImpl xImp = new XmlObjectRWserviceServiceImpl();
		xImp.writeObject(dummyPerson, LOC+"XmlText.xml");
		DummyPerson per = (DummyPerson) xImp.readObject(LOC+"XmlText.xml");*/
		ObjectMapper MAPPER = new ObjectMapper();
		JsonSerialDecerial.writeObject(dummyPerson, LOC+"Test.json");
		
		ClassLoader classLoader = RunApplication.class.getClassLoader();
		//Enumeration<URL> roots = classLoader.getResources("");
		File file = new File(classLoader.getResource("Test.json").getFile());
		//File file = new File("C:\\Users\\Sunilkumar.Meena\\Desktop\\Working%20Directory\\Eclipse\\delete%20it\\ObjectSerializerDeserializer\\target\\classes\\Test.json");
		DummyPerson per2 = (DummyPerson)JsonSerialDecerial.readObjectViaFile(file, DummyPerson.class);
		DummyPerson per = (DummyPerson)JsonSerialDecerial.readObject(LOC+"Test.json",DummyPerson.class);
		try {
			DummyPerson dummyReadPerson = MAPPER.readValue(new File(LOC+"Test.json"),DummyPerson.class);
		} catch (JsonParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String dummyProfileJson;
		try {
			dummyProfileJson = MAPPER.writerWithDefaultPrettyPrinter()
					.writeValueAsString(dummyPerson);
			FileUtils.write(profileOutFile, dummyProfileJson);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		yImp.writeObject(dummyPerson, LOC+"YMLTest.yml");
		/*Properties prop = (Properties) pImp.readObject(LOC+"Prop.properties");
		pImp.writeObject(prop, LOC+"CpProp.properties");
		InputStream input = RunApplication.class.getClassLoader().getResourceAsStream("application.properties");
		Properties prop2 = new Properties();
		try {
			prop2.load(input);
			System.out.println(prop2.getProperty("APP_NAME"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			DummyPerson yamlDummyPerson = (DummyPerson)yImp.readObject(LOC+"YMLTest.yml");
			System.out.println(yamlDummyPerson);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
