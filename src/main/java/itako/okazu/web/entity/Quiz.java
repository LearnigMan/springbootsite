package itako.okazu.web.entity;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(listener = BaseEntityListener.class)
@Table(name = "quizzes") // テーブル名指定
public class Quiz extends BaseEntity {

	@Id
	public String id;

	@JsonIgnore
	public String contents;

	@JsonIgnore
	public String encodedPassword;

}
