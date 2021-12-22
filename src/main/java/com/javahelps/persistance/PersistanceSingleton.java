package com.javahelps.persistance;


public class PersistanceSingleton {
	private static PersistanceSingleton INSTANCE = null;

	public String persistance;

	private PersistanceSingleton() {
		persistance = "";
	}

	public static PersistanceSingleton getInstance() {
		if (INSTANCE == null)
			INSTANCE = new PersistanceSingleton();

		return INSTANCE;
	}

	



	public static void setINSTANCE(PersistanceSingleton iNSTANCE) {
		INSTANCE = iNSTANCE;
	}

	public String getPersistance() {
		return persistance;
	}

	public void setPersistance(String persistance) {
		this.persistance = persistance;
	}
	

}
