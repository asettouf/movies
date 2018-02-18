package org.test.back.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.test.Entities.Score;

@Repository("ScoreDao")
public class ScoreDaoImpl extends HibernateDaoSupport implements ScoreDao {

	public ScoreDaoImpl() {
		super();
	}

	@Autowired
	public void init(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	@Override
	@Transactional(readOnly = false)
	public void save(Score score) {
		getHibernateTemplate().save(score);

	}

	@Override
	public Score getById(int id) {
		// we used named params here as it is compatible Spring orm 5 and 4, and
		// alas Springboot uses v4
		List<Score> scores = (List<Score>) getHibernateTemplate()
				.findByNamedParam("from Score where ID=:id", "id", id);
		if (scores.isEmpty()) {
			return null;
		}
		return scores.get(0);
	}

	@Override
	@Transactional(readOnly = false)
	public void update(Score score) {
		getHibernateTemplate().update(score);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Score score) {
		getHibernateTemplate().delete(score);
	}

}
