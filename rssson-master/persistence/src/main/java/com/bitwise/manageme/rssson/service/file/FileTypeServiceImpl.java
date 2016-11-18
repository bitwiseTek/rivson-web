package com.bitwise.manageme.rssson.service.file;
/**
 *  
 * @author Sika Kay
 * @date 28/06/16
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.manageme.rssson.domain.file.FileType;
import com.bitwise.manageme.rssson.repository.file.FileTypeRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("fileTypeService")
public class FileTypeServiceImpl implements FileTypeService {

	@Autowired
	private FileTypeRepository fileTypeRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<FileType> findAll() {
		return Lists.newArrayList(this.fileTypeRepo.findAll());
	}

	@Override
	@Transactional(readOnly=false)
	public FileType save(FileType fileType) {
		return this.fileTypeRepo.save(fileType);
	}

}
