package itako.okazu.web.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import itako.okazu.web.dao.QuizDao;
import itako.okazu.web.entity.Quiz;

@Service
public class LoginUserDetailSerivce implements UserDetailsService {

	@Autowired
	QuizDao quizDao;

	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		Optional<Quiz> quiz = quizDao.selectById(Integer.parseInt(id));
		if (!quiz.isPresent()) {
			throw new UsernameNotFoundException("The requested user is no found");
		}
		return new LoginUserDetail(quiz.get());
	}
}
