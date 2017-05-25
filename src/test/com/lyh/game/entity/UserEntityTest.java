
package test.com.lyh.game.entity;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
 * ClassName:UserEntityTest <br/> 
 * Function: TODO (). <br/> 
 * Reason:   TODO (). <br/> 
 * Date:     2017年5月24日 下午4:28:23 <br/> 
 * @author   lyh 
 * @version   
 * @see       
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:${user.dir}/spring-db.xml"})
public class UserEntityTest {
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
}
  