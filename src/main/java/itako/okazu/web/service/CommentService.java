package itako.okazu.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import itako.okazu.web.dao.CommentDao;
import itako.okazu.web.entity.Comment;

@Service
public class CommentService {

	@Autowired
	CommentDao commentDao;

	public List<Comment> findAll() {
		String orderBy = "order by 1 desc";
		return commentDao.selectAll(orderBy);
	}

	public Optional<Comment> findById(Integer id) {
		return commentDao.selectById(id);
	}

	public int create(Comment comment) {
		return commentDao.insert(comment);
	}

}
