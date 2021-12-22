package com.javahelps.persistance;

public class PersistanceFactory {

	public PersistanceHandler getPersistance(String type) {
		if (type == null) {
			return null;
		}
		if (type.equalsIgnoreCase("MYSQL")) {
			return new MySQLHandler();

		}
		return null;
	}
}
