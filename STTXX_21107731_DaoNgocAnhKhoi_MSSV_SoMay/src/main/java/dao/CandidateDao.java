package dao;

import java.util.List;
import java.util.Map;

import entity.Candidate;
import entity.Position;

public interface CandidateDao {
	public List<Position> listPositions(String name, Double salaryTo, Double salaryFrom) throws Exception;
	public Map<Candidate, Position> listCandidatesWithLongestWorking() throws Exception;
}
