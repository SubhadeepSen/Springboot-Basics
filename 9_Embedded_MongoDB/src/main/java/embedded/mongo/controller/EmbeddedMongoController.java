package embedded.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import embedded.mongo.dao.EmbeddedMongoDao;
import embedded.mongo.model.Student;

@RestController
@CrossOrigin
public class EmbeddedMongoController {

	@Autowired
	private EmbeddedMongoDao embeddedMongoDao;

	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public Student addStudent(@RequestBody Student student) {
		return embeddedMongoDao.addStudent(student);
	}

	@RequestMapping(value = "/students")
	public List<Student> retrieveStudents() {
		return embeddedMongoDao.retrieveStudents();
	}
	
	@RequestMapping(value = "/student", method = RequestMethod.PUT)
	public Student updateStudent(@RequestBody Student student) {
		return embeddedMongoDao.updateDetails(student);
	}
	
	@RequestMapping(value = "/student/{studentId}", method = RequestMethod.DELETE)
	public boolean removeStudent(@PathVariable("studentId") int studentId) {
		return embeddedMongoDao.remove(studentId);
	}
}
