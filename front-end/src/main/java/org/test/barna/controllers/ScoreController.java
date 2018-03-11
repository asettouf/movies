package org.test.barna.controllers;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.test.Entities.Score;
import org.test.back.dao.ScoreDao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ScoreController {

	@Autowired
	ScoreDao scoreDao;
	
	@Autowired
	ObjectMapper objectMapper;
	
	//quick JSON formatted message to indicate success or not for POST/PUT/DELETE
	//responses
	String messageStringTemplate = "'{'message: {0}'}'";

	@RequestMapping("/score")
	public String getScore(
			@RequestParam(value = "id", required = false) Integer id) throws JsonProcessingException {
		if (id == null) {
			return "score";
		}

		// we don't need the `intValue` call, it is just to explicit the
		// autounboxing
		Score score = scoreDao.getById(id.intValue());
		return objectMapper.writeValueAsString(score);
//		return MessageFormat.format(this.messageStringTemplate, "Got score " + score);

	}

	@RequestMapping(value = "/score", method = RequestMethod.DELETE)
	public String delScore(@RequestParam(value = "id") Integer id) {
		if (id == null) {
			return MessageFormat.format(this.messageStringTemplate, "Cannot delete score with null id");
		}
		Score scoreToDelete = scoreDao.getById(id);
		String message = "Score not found cannot delete";
		if (scoreToDelete != null) {
			scoreDao.delete(scoreToDelete);
			System.out.println("Delete score");
			message = "Score " + scoreToDelete + " deleted";

		}
		return MessageFormat.format(this.messageStringTemplate, message);

	}

	@RequestMapping(value = "/score", method = RequestMethod.PUT)
	public String createScore(@RequestParam(value = "value") Integer value) {
		if (value == null) {
			return MessageFormat.format(this.messageStringTemplate, "Cannot create score with null values");
		}
		System.out.println("Create score with value" + value);
		Score score = new Score(value);
		scoreDao.save(score);
		return MessageFormat.format(this.messageStringTemplate, score + " Created");

	}

	@RequestMapping(value = "/score", method = RequestMethod.POST)
	public String updateScore(@RequestParam(value = "id") Integer id,
			@RequestParam(value = "value") Integer value) {
		if (value == null || id == null) {
			return MessageFormat.format(this.messageStringTemplate, "Cannot update score with null values");
		}
		Score scoreToUpdate = scoreDao.getById(id);
		String message = "Score not found. Cannot update";
		if (scoreToUpdate != null) {
			scoreToUpdate.setScore(value);
			scoreDao.update(scoreToUpdate);
			message = "Score " + scoreToUpdate + " updated";
		}
		return MessageFormat.format(this.messageStringTemplate, message);

	}

}
