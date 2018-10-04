/**
 * 
 */
package com.example.demo.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;

/**
 * @author prabhatkumar.mishra
 *
 */
@Service
public class ServicesImpl implements Services {

	static int count = 0;
	static int count1 = 0;

	@Override
	public HashMap<String, Object> simple() {

		System.out.println("Simple API called!");
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("message", "Simple API is working.");
		return result;
	}

	@Override
	public HashMap<String, Object> iooperation() throws IOException {
		int reqNo = count1++;
		long startedAt = System.nanoTime();
		String fileName = "text.txt";
		// ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		File file = new File("D:\\ProcureEdge\\WS3\\java\\demo\\test.txt");
		// System.out.println("FilePath:"+ file.getPath());
		// Read File Content
		String content = new String(Files.readAllBytes(Paths.get(fileName)));
		System.out.println("io-" + reqNo + ": " + (System.nanoTime() - startedAt) / 1000000.0 + "ms");
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("message", "IO operations API is working.");
		return result;
	}

	@Override
	public HashMap<String, Object> cpuoperation() {

		int reqNo = count++;
		long startedAt = System.nanoTime();
		for (int i = 0; i < 10000; i++)
			for (int j = 0; j < 10000; j++)
				;
		System.out.println("cpu-" + reqNo + ": " + (System.nanoTime() - startedAt) / 1000000.0 + "ms");
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("message", "CPU operations API is working.");
		return result;

	}

}
