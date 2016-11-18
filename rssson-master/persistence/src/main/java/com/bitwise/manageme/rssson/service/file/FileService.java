package com.bitwise.manageme.rssson.service.file;
/**
 *  
 * @author Sika Kay
 * @date 28/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.file.File;

public interface FileService {

	public List<File> findAll();
	
	public File save(File file);
	
}
