/**
 * 
 */
package net.kurse.ts2c.core;

import java.io.IOException;
import java.io.Serializable;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * @author KaynEKH
 *
 */
public class CharSheetSaver {

	public CharSheetSaver() {
		// TODO Auto-generated constructor stub
	}
	
	public static void save(Serializable o) throws JsonGenerationException, JsonMappingException, IOException {
		String serialized = new ObjectMapper().writeValueAsString(o);
		System.out.println(serialized);
	}
	
}
