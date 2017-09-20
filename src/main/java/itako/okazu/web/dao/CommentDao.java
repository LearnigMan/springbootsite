package itako.okazu.web.dao;

import java.util.List;
import java.util.Optional;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import itako.okazu.web.entity.Comment;

@ConfigAutowireable
@Dao
public interface CommentDao {

	@Insert
	int insert(Comment Commnet);

	@Select
	List<Comment> selectAll(String orderBy);

	@Select
	Optional<Comment> selectById(Integer id);

}
