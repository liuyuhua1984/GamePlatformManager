
package com.lyh.game.entity;

import java.io.Serializable;

import com.lyh.game.mybatis.domain.User;

/** 
 * ClassName:UserEntity <br/> 
 * Function: TODO (用户实体). <br/> 
 * Reason:   TODO (). <br/> 
 * Date:     2017年5月23日 下午2:33:36 <br/> 
 * @author   lyh 
 * @version   
 * @see       
 */
public class UserEntity implements Serializable{

	/****/  
	private static final long serialVersionUID = 4371339816435156365L;
	
	/**用户数据库实体**/  
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
  