package com.SerializerAndDecerializer.util.model;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="DummyPerson")
public class DummyPerson implements Serializable{
	int id;
	String name;
	List msg;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	Date date;
	public int getId() {
		return id;
	}
	@XmlElement
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	public List getMsg() {
		return msg;
	}
	@XmlElement
	public void setMsg(List msg) {
		this.msg = msg;
	}
	public static DummyPerson getDummyPerson(){
		DummyPerson dummyPerson = new DummyPerson();
		dummyPerson.setId(1);
		dummyPerson.setName("sunil");
		dummyPerson.date = new Date();
		System.out.println(new Date());
		List<String> msgList = new LinkedList<String>();
		msgList.add("Email");
		msgList.add("Phone");
		msgList.add("Hit");
		dummyPerson.setMsg(msgList);
		return dummyPerson;
	}
}
