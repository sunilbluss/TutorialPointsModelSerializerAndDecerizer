package com.SerializerAndDecerializer.service.fileService.impl;

import com.SerializerAndDecerializer.service.fileService.ObjectRWservice;
import com.SerializerAndDecerializer.util.model.DummyPerson;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

public class XmlObjectRWserviceServiceImpl implements ObjectRWservice {
	public Object readObject(String loc) {
		File file = new File(loc);
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Object.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Object obj = jaxbUnmarshaller.unmarshal(file);
			return obj;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean writeObject(Object obj, String loc) {
		try {
			File file = new File(loc);
			JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(obj, file);
		} catch (PropertyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	 
	
}
