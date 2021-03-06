package com.lyh.game.control;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lyh.game.lib.utils.RandomValidateCode;

/**
 * ClassName:ImageVerifyController <br/>
 * Function: TODO (). <br/>
 * Reason: TODO (). <br/>
 * Date: 2017年5月17日 下午2:18:16 <br/>
 * 
 * @author lyh
 * @version
 * @see
 */
@Controller
public class ImageVerifyController extends BaseController {
	
	// 登录获取验证码
	@RequestMapping("/code")
	@ResponseBody
	public String getSysManageLoginCode(HttpServletResponse response, HttpServletRequest request) {
		response.setContentType("image/jpeg");// 设置相应类型,告诉浏览器输出的内容为图片
		response.setHeader("Pragma", "No-cache");// 设置响应头信息，告诉浏览器不要缓存此内容
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Set-Cookie", "name=value; HttpOnly");// 设置HttpOnly属性,防止Xss攻击
		response.setDateHeader("Expire", 0);
		RandomValidateCode randomValidateCode = new RandomValidateCode();
		try {
			randomValidateCode.getRandcode(request, response, "imagecode");// 输出图片方法
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	
}
