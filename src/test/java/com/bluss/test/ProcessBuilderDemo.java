package com.bluss.test;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
public class ProcessBuilderDemo {
	public static void main(String[] args) throws IOException, InterruptedException {
		 ProcessBuilder processBuilder = new ProcessBuilder("C:/Users/Sunilkumar.Meena/Desktop/tomcat7/bin/startup.bat", "ABC", "XYZ");
		 processBuilder.directory(new File("E:/"));
		 File log = new File("E:/log.txt");
		 processBuilder.redirectErrorStream(true);
		 processBuilder.redirectOutput(Redirect.appendTo(log));
		 Process p = processBuilder.start();
		 p.waitFor();
		 System.out.println("Done");
	}
} 