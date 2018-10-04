/**
 * 
 */
package com.example.demo.service;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author prabhatkumar.mishra
 *
 */
public interface Services {
	
	HashMap<String, Object> simple();
	HashMap<String, Object> iooperation() throws IOException;
	HashMap<String, Object> cpuoperation();

}
