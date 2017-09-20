package itako.okazu.web.web.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CommnetForm {

	@NotNull
	@Size(min = 1, max = 2500)
	private String comment;

	@NotNull
	@Size(min = 1, max = 2500)
	private String nickName;

}
