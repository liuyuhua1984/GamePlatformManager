
package com.lyh.game.control;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lyh.game.mybatis.domain.User;
import com.lyh.game.service.UserService;
import com.lyh.game.utils.IText;

/**
 * AdminLoginController <br/>
 * Function: TODO (). <br/>
 * Reason: TODO (). <br/>
 * Date: 2017年5月10日 下午3:38:23 <br/>
 * 
 * @author lyh
 * @version
 * @see
 */
@Controller
public class AdminLoginController extends BaseController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * index:(). <br/>
	 * TODO().<br/>
	 * 
	 * @author lyh
	 * @return
	 */
	@RequestMapping(value = "/admin")
	public String login() {
		return "login";
	}
	
	// 验证码验证
	@RequestMapping(value = "/login")
	@ResponseBody
	public Map<String,Object> login(HttpServletRequest request) {
		String validateCode = request.getParameter("captcha");
		String passport = request.getParameter("username");
		String passwd = request.getParameter("passwordhash");
		
		Map<String, Object> returnMap = new ModelMap();
		String code = null;
		// 1:获取cookie里面的验证码信息
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if ("imagecode".equals(cookie.getName())) {
				code = cookie.getValue();
				break;
			}
		}
		// 1:获取session验证码的信息
		// String code1 = (String) request.getSession().getAttribute("");
		// 2:判断验证码是否正确
		if (StringUtils.isEmpty(validateCode) || !validateCode.equals(code)) {
			//验证码错误
			returnMap.put("errorCode","0");
			returnMap.put("msg", IText.TEXT_1);
			return returnMap ;
		}
		
		//
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("passport", passport);
		User user = userService.getBy(map);
		if (user == null){
			returnMap.put("errorCode","2");
			returnMap.put("msg", IText.TEXT_2);
			return returnMap ;
		}
		
		if (!user.getPassword().equals(passwd)){
			returnMap.put("errorCode","3");
			returnMap.put("msg", IText.TEXT_3);
			return returnMap ;
		}
		if (user.getStatus()<= 0){
			returnMap.put("errorCode","4");
			returnMap.put("msg", IText.TEXT_3);
			return returnMap ;
		}
		returnMap.put("errorCode","1");
		return returnMap;
		// 这里我没有进行字母大小模糊的验证处理，感兴趣的你可以去试一下！
	}
	
}
