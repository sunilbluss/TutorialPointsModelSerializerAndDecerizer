package com.SerializerAndDecerializer.service.fileService;

public interface ObjectRWservice <T> {
	public T readObject(String loc);
	public boolean writeObject(T obj,String loc);
}
