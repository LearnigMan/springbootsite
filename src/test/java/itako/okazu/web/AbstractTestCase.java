package itako.okazu.web;

import org.junit.Rule;
import org.junit.rules.TestName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

public abstract class AbstractTestCase extends AbstractTransactionalJUnit4SpringContextTests {

	@Rule
	public TestName name = new TestName();

	@Autowired
	protected JdbcTemplate jdbcTemplate;

}
