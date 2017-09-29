package itako.okazu.web.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import itako.okazu.web.AbstractTestCase;
import itako.okazu.web.dao.CommentDao;
import itako.okazu.web.entity.Comment;

public class CommentServiceTest extends AbstractTestCase {

	@Autowired
	private CommentDao commentDao;

	@Test
	public void test() throws Exception {
		// 登録確認
		Comment entity = new Comment();
		entity.id = 1;
		entity.comment = "コメント";
		commentDao.insert(entity);

		Comment comment = commentDao.selectById(1).orElseThrow(() -> new Exception());
		assertThat(comment.id).isEqualTo(2);

	}

}
