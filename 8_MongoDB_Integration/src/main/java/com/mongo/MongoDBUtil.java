package com.mongo;

import org.bson.Document;

import com.mongodb.client.FindIterable;

public class MongoDBUtil {

	public static void printDocuments(FindIterable<Document> documents) {
		for (Document document : documents) {
			System.out.println(document.toJson());
		}
	}
}
