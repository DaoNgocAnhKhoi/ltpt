package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.CandidateDao;
import entity.Candidate;
import entity.Position;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class CandidateServices implements CandidateDao {
	private EntityManager entityManager;

	public CandidateServices(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Position> listPositions(String name, Double salaryTo, Double salaryFrom) throws Exception {

		return null;
	}

	@Override
	public Map<Candidate, Position> listCandidatesWithLongestWorking() {
	    String sql = "SELECT c.candidate_id, p.name\r\n"
	    		+ "FROM candidates c\r\n"
	    		+ "JOIN positions p ON c.position_id = p.position_id\r\n"
	    		+ "JOIN (\r\n"
	    		+ "    SELECT position_id, MAX(DATEDIFF(to_date, from_date)) AS max_duration\r\n"
	    		+ "    FROM experiences\r\n"
	    		+ "    GROUP BY position_id\r\n"
	    		+ ") ex ON ex.position_id = p.position_id\r\n"
	    		+ "JOIN experiences e ON e.position_id = p.position_id \r\n"
	    		+ "    AND DATEDIFF(e.to_date, e.from_date) = ex.max_duration;\r\n"
	    		+ "";

	    Query query = entityManager.createNativeQuery(sql);
	    List<Object[]> results = query.getResultList();

	    Map<Candidate, Position> result = new HashMap<>();
	    for (Object[] row : results) {
	    	
	        Candidate candidate = new Candidate(); 
	        candidate.set_id((String) row[0]); 
	        System.out.println(candidate.toString());
	        Position position = new Position();
	        position.setName((String) row[1]); 
	        System.out.println(position.toString());
	        result.put(candidate, position);
	    }
	    return result;
	}

}
