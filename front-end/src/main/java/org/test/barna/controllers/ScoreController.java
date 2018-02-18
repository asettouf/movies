package org.test.barna.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.test.Entities.Score;
import org.test.back.dao.ScoreDao;

@Controller
public class ScoreController {

	@Autowired
	ScoreDao scoreDao;



	@RequestMapping("/score")
	public String getScore(
			@RequestParam(value = "id", required = false) Integer id,
			Map<String, Object> model) {
		if (id == null) {
			return "score";
		}

		// we don't need the `intValue` call, it is just to explicit the
		// autounboxing
		Score score = scoreDao.getById(id.intValue());
		model.put("getMessage",
				"Score " + score == null ? "not found" : score + "found");
		System.out.println(score);
		return "score";

	}

	@RequestMapping(value="/score", method=RequestMethod.DELETE)
	public String delScore(
			@RequestParam(value = "id", required = false) Integer id,
			Map<String, Object> model) {
		if (id == null) {
			return "score";
		}
		Score scoreToDelete = scoreDao.getById(id);
		String message = "Score not found cannot delete";
		if (scoreToDelete != null) {
			scoreDao.delete(scoreToDelete);
			System.out.println("Delete score");
			message = "Score " + scoreToDelete + " deleted";

		}
		model.put("delMessage", message);
		return "score";

	}

	@RequestMapping(value = "/score", method = RequestMethod.PUT)
	public String createScore(@RequestParam(value = "value") Integer value,
			Map<String, Object> model) {
		if (value == null) {
			return "score";
		}
		System.out.println("Create score with value" + value);
		Score score = new Score(value);
		scoreDao.save(score);
		model.put("createMessage", "Score " + score + " created");
		return "score";

	}

	@RequestMapping(value = "/score", method = RequestMethod.POST)
	public String updateScore(@RequestParam(value = "id") Integer id,
			@RequestParam(value = "value") Integer value, Map<String, Object> model) {
		if (value == null || id == null) {
			model.put("updMessage", "We need a value and an id!");
			return "score";
		}
		Score scoreToUpdate = scoreDao.getById(id);
		String message = "Score not found. Cannot update";
		if (scoreToUpdate != null) {
			scoreToUpdate.setScore(value);
			scoreDao.update(scoreToUpdate);
			message = "Score " + scoreToUpdate + " updated";
		}
		model.put("updMessage", message);
		return "score";

	}

}
