package com.bitwise.manageme.rssson.service.projects;
/**
 *  
 * @author Sika Kay
 * @date 29/06/16
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.manageme.rssson.domain.projects.Project;
import com.bitwise.manageme.rssson.domain.projects.StudentProject;
import com.bitwise.manageme.rssson.domain.students.Student;
import com.bitwise.manageme.rssson.repository.projects.StudentProjectRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("studentProjectService")
public class StudentProjectServiceImpl implements StudentProjectService {

	@Autowired
	private StudentProjectRepository studentProjectRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<StudentProject> findAll() {
		return Lists.newArrayList(this.studentProjectRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public List<StudentProject> findByStudents(Student student) {
		return this.studentProjectRepo.findByStudents(student);
	}

	@Override
	@Transactional(readOnly=true)
	public List<StudentProject> findByProjects(Project project) {
		return this.studentProjectRepo.findByProjects(project);
	}

	@Override
	@Transactional(readOnly=false)
	public StudentProject save(StudentProject studentProject) {
		return this.studentProjectRepo.save(studentProject);
	}

}
