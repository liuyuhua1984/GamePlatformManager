
package com.lyh.game.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
 * ClassName:IndexController <br/> 
 * Function: TODO (). <br/> 
 * Reason:   TODO (). <br/> 
 * Date:     2017年5月10日 下午3:38:23 <br/> 
 * @author   lyh 
 * @version   
 * @see       
 */
@Controller
public class IndexController extends BaseController{
	
	/** 
	 * index:(). <br/> 
	 * TODO().<br/> 
	 * 
	 * @author lyh 
	 * @return 
	 */  
	@RequestMapping(value="/index")
	public  String index(){
		return "index";
	}
}
  