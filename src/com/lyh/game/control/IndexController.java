
package com.lyh.game.control;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lyh.game.mybatis.domain.User;
import com.lyh.game.utils.IText;

/**
 * ClassName:IndexController <br/>
 * Function: TODO (). <br/>
 * Reason: TODO (). <br/>
 * Date: 2017年5月10日 下午3:38:23 <br/>
 * 
 * @author lyh
 * @version
 * @see
 */
@Controller
public class IndexController extends BaseController {
	
	/**
	 * index:(). <br/>
	 * TODO().<br/>
	 * 
	 * @author lyh
	 * @return
	 */
	@RequestMapping(value = "/index")
	public String index(HttpSession httpSession, Map<String, String> map) {
		User user = (User) httpSession.getAttribute("pUser");
		if (user == null) {
			map.put("msg", IText.TEXT_2);
			return "error";
		}
		return "index";
	}
}
