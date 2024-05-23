package app;

import service.EntityManagerFactoryUtil;

public class MainServer {

	public static void main(String[] args) {
		EntityManagerFactoryUtil entityManagerFactoryUtil = new EntityManagerFactoryUtil();
		try {
			RequestHandler requestHandler = new RequestHandler(entityManagerFactoryUtil.getEnManager(), 8080);
			requestHandler.start();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManagerFactoryUtil.closeEnManager();
			entityManagerFactoryUtil.closeEnManagerFactory();
		}
	}

}
