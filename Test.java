package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import entities.Candidate;
import jakarta.persistence.EntityManager;
import services.CandidateService;
import services.EntityManagerFactoryUltil;

class Test {
	private static EntityManagerFactoryUltil entityManagerFactoryUltil;
	private static EntityManager entityManager;
	private static CandidateService candidateService;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		entityManagerFactoryUltil = new EntityManagerFactoryUltil();
		entityManager = entityManagerFactoryUltil.getEntityManager();
		candidateService = new CandidateService(entityManager);
	}

	@org.junit.jupiter.api.Test
	void cau1() {
		//assertTrue(candidateService.addCandidate(new Candidate("asd1", "Luong Thai Go")));
	}
	
	@org.junit.jupiter.api.Test
	void cau2() {
		candidateService.listCadidatesByCompanies().entrySet().forEach(o-> System.out.println(o));
//		List<Object> list = new ArrayList<Object>(candidateService.listCadidatesByCompanies().entrySet());
//		System.out.println(list.get(0));
		//assertNotNull(list.get(0));
	}
	
	@AfterAll
	public static void close() {
		entityManagerFactoryUltil.closeEntityManager();
		entityManagerFactoryUltil.closeEntityManagerFactory();
	}
}
