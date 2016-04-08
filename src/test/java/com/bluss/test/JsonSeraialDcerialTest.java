package com.bluss.test;

import com.SerializerAndDecerializer.JsonSerialDecerial;
import com.SerializerAndDecerializer.util.model.DummyPerson;

public class JsonSeraialDcerialTest {
	public static void main(String[] args){
		JsonSerialDecerial jsonSD = new JsonSerialDecerial();
		DummyPerson person = DummyPerson.getDummyPerson();
		String serializedPersonString = jsonSD.writeObjectToSerializedString(person);
		System.out.println(serializedPersonString);
		
	}
}
