package service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class EntityManagerFactoryUtil {
	private EntityManagerFactory entityManageFactory;
	private EntityManager entityManager;
	
	public EntityManagerFactoryUtil() {
		entityManageFactory = jakarta.persistence.Persistence.createEntityManagerFactory("test_server");
		entityManager = entityManageFactory.createEntityManager();
	}
	
	public EntityManager getEnManager() {
		return entityManager;
	}
	
	public void closeEnManager() {
		entityManager.close();
	}
	
	public void closeEnManagerFactory() {
		entityManageFactory.close();
	}
}
