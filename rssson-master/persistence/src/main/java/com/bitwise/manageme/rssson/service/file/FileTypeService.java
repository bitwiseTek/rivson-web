package com.bitwise.manageme.rssson.service.file;
/**
 *  
 * @author Sika Kay
 * @date 28/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.file.FileType;

public interface FileTypeService {

	public List<FileType> findAll();
	
	public FileType save(FileType fileType);
	
}
