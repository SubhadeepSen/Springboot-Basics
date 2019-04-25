package com.app;

import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.google.gson.Gson;
import com.model.Student;
import com.mongo.MongoDBCRUD;
import com.mongo.MongoDBUtil;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.util.StudentBuilder;

public class CRUDOperator {

	public static void main(String[] args) {
		MongoDBCRUD mongodb = new MongoDBCRUD();
		mongodb.mongoConfiguration("localhost", 27017, "StudentDB");
		//mongodb.dropCollection();
		
		mongodb.createCollection("StudentInfo");
		
		List<Student> students = StudentBuilder.buildStudents();
		Gson gson = new Gson();
		for (Student student : students) {
			mongodb.addToCollection(Document.parse(gson.toJson(student)));
		}

		System.out.println("After Insertion:");
		MongoDBUtil.printDocuments(mongodb.readAllFromCollection());

		Bson filter = Filters.eq("firstName", "Subhadeep");
		System.out.println("Filtered Find:");
		MongoDBUtil.printDocuments(mongodb.readDocumentFromCollection(filter));
		
		Bson update = Updates.set("age", "25");
		mongodb.updateDocumentInCollection(filter, update);
		System.out.println("After Update:");
		MongoDBUtil.printDocuments(mongodb.readDocumentFromCollection(filter));
		
		mongodb.deleteDocumentInCollection(filter);
		System.out.println("After Deletion:");
		MongoDBUtil.printDocuments(mongodb.readAllFromCollection());
	}

}
