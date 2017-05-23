
package com.lyh.game.control;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String login(HttpServletRequest request, HttpServletResponse response) {
		String validateCode = request.getParameter("captcha");
		String userName = request.getParameter("username");
		String passwd = request.getParameter("passwordhash");
		
		
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
			return "error" ;
		}
		
		if (userName.equals(anObject)){
			
		}
		return "error";
		// 这里我没有进行字母大小模糊的验证处理，感兴趣的你可以去试一下！
	}
	
}
