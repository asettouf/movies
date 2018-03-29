import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.test.Connectors.MySQLManager;
import org.test.Entities.Actor;
import org.test.Entities.Movie;
import org.test.Entities.Score;
import org.test.back.dao.ScoreDao;
import org.test.back.dao.ScoreDaoImpl;

public class Test {

	public static void main(String[] args) {
		ApplicationContext appContext =
    	  new ClassPathXmlApplicationContext("spring.xml");
		ScoreDao scoreDao = (ScoreDao) appContext.getBean("ScoreDao");
		Score score = new Score(3);
		scoreDao.save(score);
		System.out.println("Score is " + scoreDao.getById(2).getScore());
//		score.setScore(5);
//		scoreDao.update(score);
//		System.out.println("Score is now " + scoreDao.getById(1).getScore());
//		scoreDao.delete(score);
//		System.out.println("Score is now " + scoreDao.getById(1));
//		Actor actor = new Actor("Catherine Schell", 72, "cschell@something.com");
//		Actor actorClone = new Actor("Catherine Schell Clone", 22, "cschell-clone@something.com");
//		Set<Actor> actors = new HashSet<Actor>();
//		actors.add(actor);
//		actors.add(actorClone);
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
////		MySQLManager.createModelHibernate(actor);
//		try {
//			Movie movie = new Movie("ZZ", sdf.parse("17/06/1991") , score);
//			movie.setActors(actors);
//			mysqlManager.createModelHibernate(movie);
//		} catch (ParseException e) {
//			e.printStackTrace();
//			System.out.println("Could not create date");
//}
	}

}
