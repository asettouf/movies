package org.test.back.dao;

import org.test.Entities.Score;

public interface ScoreDao {
	
	void save(Score score);
	Score getById(int id);
	void update(Score score);
	void delete(Score score);
	

}
