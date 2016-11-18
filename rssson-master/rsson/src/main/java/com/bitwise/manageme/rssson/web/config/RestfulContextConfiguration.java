package com.bitwise.manageme.rssson.web.config;
/**
 *  
 * @author Sika Kay
 * @date 07/07/16
 *
 */
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.oxm.castor.CastorMarshaller;

@Configuration
@ComponentScan(basePackages={"com.bitwise.manageme.rssson.web.restful"})
public class RestfulContextConfiguration {
	
	@Bean
	public Map<String, String> castorProperties() {
		Map<String, String> props = new HashMap<String, String>();
		props.put("org.exolab.castor.indent", "true");
		return props;
	}
	
	@Bean
	public CastorMarshaller castorMarshaller() {
		CastorMarshaller castorMarshaller = new CastorMarshaller();
		Resource mappingLocation = new ClassPathResource("classpath:/oxm-mapping.xml");
		castorMarshaller.setCastorProperties(castorProperties());
		castorMarshaller.setMappingLocation(mappingLocation);
		return new CastorMarshaller();
	}

}
