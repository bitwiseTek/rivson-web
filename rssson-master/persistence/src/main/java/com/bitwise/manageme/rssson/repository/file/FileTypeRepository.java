package com.bitwise.manageme.rssson.repository.file;
/**
 *  
 * @author Sika Kay
 * @date 22/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.file.FileType;

public interface FileTypeRepository extends CrudRepository<FileType, Long> {

	public List<FileType> findAll();
	
}
