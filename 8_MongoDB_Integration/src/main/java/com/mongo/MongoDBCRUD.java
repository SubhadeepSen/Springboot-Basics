package com.mongo;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.MongoTimeoutException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBCRUD {

	private MongoClient mongoClient;
	private MongoDatabase mdb;
	private MongoCollection<Document> mongoCollection;

	public void mongoConfiguration(String hostname, int portNumber, String databaseName) {
		try {
			// Creates a mongo client for connecting with the mongo server. This constructor
			// takes the hostname and port number.
			// There are other constructors as well. Please go through.
			mongoClient = new MongoClient(hostname, portNumber);
			System.out.println("Connected To: " + mongoClient.getAddress());
			// Once you are connected with the server, you can access a particular database
			// with the following method.
			// If the asked database is not there, then it will create a new database.
			mdb = mongoClient.getDatabase(databaseName);
			System.out.println("Database: " + databaseName);
		} catch (MongoTimeoutException e) {
			System.out.println("Unable to connect to " + hostname + ":" + portNumber + ", make sure server is running!");
			closeConnection();
		}
	}

	public void createCollection(String collectionName) {
		if(!isCollectionExist(collectionName)) {
			mdb.createCollection(collectionName);
		}
		selectCollection(collectionName);
	}

	public void selectCollection(String collectionName) {
		mongoCollection = mdb.getCollection(collectionName);
	}
	
	public void dropCollection() {
		mdb.drop();
	}

	public void addToCollection(Document document) {
		if(!isDocumentExist(document)) {
			mongoCollection.insertOne(document);
		}
	}

	/*public void addBulkToCollection(List<? extends Document> documents) {
		mongoCollection.insertMany(documents);
	}*/

	public FindIterable<Document> readAllFromCollection() {
		return mongoCollection.find();
	}

	public FindIterable<Document> readDocumentFromCollection(Bson filter) {
		return mongoCollection.find(filter);
	}

	public void updateDocumentInCollection(Bson filter, Bson update) {
		mongoCollection.updateOne(filter, update);
	}

	public boolean deleteDocumentInCollection(Bson filter) {
		return mongoCollection.deleteOne(filter).wasAcknowledged();
	}
	
	private boolean isCollectionExist(String collectionName) {
		boolean exist = false;
		for (Document collection : mdb.listCollections()) {
			if(collection.get("name").equals(collectionName)) {
				exist = true;
			}
		}
		return exist;
	}
	
	private boolean isDocumentExist(Document document) {
		boolean exist = false;
		for (Document doc : mongoCollection.find()) {
			if(doc.get("studentId").toString().equals(document.get("studentId").toString()))
				exist = true;
		}
		return exist;
	}

	public void closeConnection() {
		mongoClient.close();
	}
}
