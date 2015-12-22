package com.vedic.astro.util;

import java.io.IOException;
import java.io.StringWriter;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.vedic.astro.exception.SystemException;

/**
 * A utility class for converting json to object and vice versa.
 * 
 * @author Saxena_s
 * 
 */
public class JsonUtil {


	/**
	 * Private constructor so that nobody can instantiate class.
	 */
	private JsonUtil() {
		
	}

	/**
	 * Converts the Object format to JSON format.
	 * 
	 * @param objectToConvert
	 *            Object to convert

	 * @return JSON in String format.
	 */
	public static String toJson(Object objectToConvert) {
		
		String json = null;

		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.setVisibilityChecker(mapper.getSerializationConfig().getDefaultVisibilityChecker()
	                .withIsGetterVisibility(JsonAutoDetect.Visibility.NONE));
			
			StringWriter writer = new StringWriter();
			mapper.writeValue(writer, objectToConvert);
			json = writer.toString();
			
		} catch (JsonMappingException ex) {
			throw new SystemException(ex.getMessage(), ex);
		}
		catch (JsonGenerationException ex) {
			throw new SystemException(ex.getMessage(), ex);
		}
		catch (IOException ex) {
			throw new SystemException(ex.getMessage(), ex);
		}
		
		return json;
	}

	/**
	 * Converts the JSON format to Object format .
	 * 
	 * @param objectToConvert
	 *            Object to convert

	 * @return Object .
	 */
	public static Object fromJson(String jsonToConvert, Object object) {
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			object = mapper.readValue(jsonToConvert, object.getClass());
			
		} catch (JsonMappingException ex) {
			throw new SystemException(ex.getMessage(), ex);
		}
		catch (JsonGenerationException ex) {
			throw new SystemException(ex.getMessage(), ex);
		}
		catch (IOException ex) {
			throw new SystemException(ex.getMessage(), ex);
		}
		
		return object;
	}

}
