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

import com.bitwise.manageme.rssson.domain.file.File;
import com.bitwise.manageme.rssson.repository.file.FileRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("fileService")
public class FileServiceImpl implements FileService {

	@Autowired
	private FileRepository fileRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<File> findAll() {
		return Lists.newArrayList(this.fileRepo.findAll());
	}

	@Override
	@Transactional(readOnly=false)
	public File save(File file) {
		return this.fileRepo.save(file);
	}

}
