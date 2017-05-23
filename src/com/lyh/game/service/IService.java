
package com.lyh.game.service;

/** 
 * ClassName:IService <br/> 
 * Function: TODO (数据库接口). <br/> 
 * Reason:   TODO (). <br/> 
 * Date:     2017年5月23日 下午2:37:45 <br/> 
 * @author   lyh 
 * @version   
 * @see       
 */
public interface IService<T> {
	    /** 
	 * deleteByPrimaryKey:(). <br/> 
	 * TODO().<br/> 
	 * 用主键删除对象
	 * @author lyh 
	 * @param id
	 * @return 
	 */  
	int deleteByPrimaryKey(Long id);

	    /** 
	 * insert:(). <br/> 
	 * TODO().<br/> 
	 * 插入数据
	 * @author lyh 
	 * @param record
	 * @return 
	 */  
	int insert(T record);

	    /** 
	 * insertSelective:(). <br/> 
	 * TODO().<br/> 
	 * 只插入不为空的字段
	 * @author lyh 
	 * @param record
	 * @return 
	 */  
	int insertSelective(T record);

	    /** 
	 * selectByPrimaryKey:(). <br/> 
	 * TODO().<br/> 
	 * 主键查找出相应的对象
	 * @author lyh 
	 * @param id
	 * @return 
	 */  
	T selectByPrimaryKey(Long id);

	    /** 
	 * updateByPrimaryKeySelective:(). <br/> 
	 * TODO().<br/> 
	 * 更新不为空的字段
	 * @author lyh 
	 * @param record
	 * @return 
	 */  
	int updateByPrimaryKeySelective(T record);

	/** 
	 * updateByPrimaryKey:(). <br/> 
	 * TODO().<br/> 
	 * 更新对象
	 * @author lyh 
	 * @param record
	 * @return 
	 */  
	int updateByPrimaryKey(T record);
	
	
}
  