package itako.okazu.web.dao;

import java.util.List;
import java.util.Optional;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import itako.okazu.web.entity.Quiz;

@ConfigAutowireable
@Dao
public interface QuizDao {

	@Select
	List<Quiz> selectAll();

	@Select
	Integer selectMax();

	@Select
	Optional<Quiz> selectById(Integer id);

}
