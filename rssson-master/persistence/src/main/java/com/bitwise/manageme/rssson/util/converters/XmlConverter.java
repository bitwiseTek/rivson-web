package com.bitwise.manageme.rssson.util.converters;
/**
 *  
 * @author Sika Kay
 * @date 06/02/16
 *
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;

public class XmlConverter {
	
	private Marshaller marshaller;
	
	private Unmarshaller unmarshaller;

	public void setMarshaller(Marshaller marshaller) {
		this.marshaller = marshaller;
	}

	public void setUnmarshaller(Unmarshaller unmarshaller) {
		this.unmarshaller = unmarshaller;
	}
	
	public void doMarshalling(String fileName, Object graph) throws IOException {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(fileName);
			marshaller.marshal(graph, new StreamResult(fos));
		} finally {
			fos.close();
		}
	}
	
	public Object doUnMarshalling(String fileName) throws IOException {
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(fileName);
			return unmarshaller.unmarshal(new StreamSource(fis));
		} finally {
			fis.close();
		}
	}
}
