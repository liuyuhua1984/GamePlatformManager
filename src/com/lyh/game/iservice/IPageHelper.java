
package com.lyh.game.iservice;

import java.util.List;
import java.util.Map;

import com.lyh.game.entity.PageEntity;

/** 
 * ClassName:IPageHelper <br/> 
 * Function: TODO (分页接口). <br/> 
 * Reason:   TODO (). <br/> 
 * Date:     2017年5月25日 下午3:31:20 <br/> 
 * @author   lyh 
 * @version   
 * @see       
 */
public interface IPageHelper<T> {
	/**
	 * 分页查询 .
	 * 
	 * @param pageParam
	 *            分页参数.
	 * @param paramMap
	 *            业务条件查询参数.
	 * @return
	 */
	PageEntity<T> listByPage(Map<String, Object> paramMap,int startPage,int numPerPage) throws Exception;
}
  