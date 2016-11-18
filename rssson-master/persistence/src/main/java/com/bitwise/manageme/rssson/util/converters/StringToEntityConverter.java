package com.bitwise.manageme.rssson.util.converters;
/**
 *  
 * @author Sika Kay
 * @date 05/01/16
 *
 */
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

public class StringToEntityConverter implements GenericConverter {
	
	private static final String ID_FIELD = "id";
	
	private final Class<?> clazz;
	
	@PersistenceContext
	private EntityManager em;
	
	public StringToEntityConverter(Class<?> clazz) {
		super();
		this.clazz = clazz;
	}
	
	public Set<ConvertiblePair> getConvertibleTypes() {
		Set<ConvertiblePair> types = new HashSet<GenericConverter.ConvertiblePair>();
		types.add(new ConvertiblePair(String.class, this.clazz));
		types.add(new ConvertiblePair(this.clazz, String.class));
		return types;
	}
	
	public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor TargetType) {
		if (String.class.equals(sourceType.getType())) {
			if (StringUtils.isBlank((String) source)) {
				return null;
			}
			Long id = Long.parseLong((String) source);
			return this.em.find(this.clazz, id);
		} else if (this.clazz.equals(sourceType.getType())) {
			try {
				if (source == null) {
					return "";
				} else {
					FieldUtils.readField(source, ID_FIELD, true);
				}
			} catch(IllegalAccessException e) {
				
			}
		} throw new IllegalArgumentException("Cannot convert the " + source + "into a suitable type");
	}
}
