package com.bitwise.manageme.rssson.util.search;
/**
 *  
 * @author Sika Kay
 * @date 17/06/16
 *
 */
import java.util.Collection;

import org.apache.lucene.document.Document;
import org.hibernate.search.bridge.FieldBridge;
import org.hibernate.search.bridge.LuceneOptions;

public class CollectionBridge implements FieldBridge {

	public CollectionBridge() {
		
	}
	
	@Override
	public void set(String name, Object value, Document document, LuceneOptions luceneOptions) {
		if (value == null) {
			return;
		}
		
		if (!(value instanceof Collection)) {
			throw new IllegalArgumentException("This FieldBridge only supports Collection<String>");
		}
		
		Collection<String> objects = (Collection<String>) value;
		
		for (String object : objects) {
			luceneOptions.addFieldToDocument(name, object, document);
		}
	}
}
