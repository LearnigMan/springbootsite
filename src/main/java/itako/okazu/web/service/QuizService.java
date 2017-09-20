package itako.okazu.web.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import itako.okazu.web.dao.QuizDao;
import itako.okazu.web.entity.Quiz;

@Service
public class QuizService {

	@Autowired
	QuizDao QuizDao;

	public Integer findMax() {
		return QuizDao.selectMax();
	}

	public Optional<Quiz> findById(Integer id) {
		return QuizDao.selectById(id);
	}

}
