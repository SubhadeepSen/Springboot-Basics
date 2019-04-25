package embedded.mongo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import embedded.mongo.model.Student;

@Component
public class EmbeddedMongoDao {

	private static final String COLLECTION_NAME = "students";

	@Autowired
	private MongoTemplate mongoTemplate;

	public Student addStudent(Student student) {
		if (!mongoTemplate.getCollectionNames().contains(COLLECTION_NAME)) {
			mongoTemplate.createCollection(COLLECTION_NAME);
		}
		return mongoTemplate.insert(student, COLLECTION_NAME);
	}

	public List<Student> retrieveStudents() {
		/*
		 * System.out.println(mongoTemplate.getDb().getName());
		 * System.out.println(mongoTemplate.getCollectionNames());
		 */
		return mongoTemplate.findAll(Student.class, COLLECTION_NAME);
	}

	public Student updateDetails(Student student) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(student.getId()));
		Update update = new Update();
		update.set("name", student.getName());
		update.set("rollNo", student.getRollNo());
		update.set("address", student.getAddress());
		//return mongoTemplate.updateFirst(query, update, COLLECTION_NAME).wasAcknowledged();
		mongoTemplate.findAndModify(query, update, Student.class, COLLECTION_NAME);
		return student;
	}

	public boolean remove(int studentId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(studentId));
		return mongoTemplate.remove(query, Student.class, COLLECTION_NAME).wasAcknowledged();
	}
}
