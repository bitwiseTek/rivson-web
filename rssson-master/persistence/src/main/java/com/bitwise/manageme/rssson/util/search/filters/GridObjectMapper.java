package com.bitwise.manageme.rssson.util.search.filters;
/**
 *  
 * @author Sika Kay
 * @date 10/09/16
 *
 */
import org.codehaus.jackson.map.ObjectMapper;

public class GridObjectMapper {

	public static GridFilter map(String jsonString) {
		if (jsonString != null) {
			ObjectMapper mapper = new ObjectMapper();
			
			try {
				return mapper.readValue(jsonString, GridFilter.class);
			} catch(Exception e) {
				throw new RuntimeException(e);
			}
		}
		return null;
	}
}
