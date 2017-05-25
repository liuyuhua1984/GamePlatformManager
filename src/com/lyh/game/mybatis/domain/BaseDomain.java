
package com.lyh.game.mybatis.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * ClassName:EntityDb <br/>
 * Function: TODO (数据库对象基类). <br/>
 * Reason: TODO (). <br/>
 * Date: 2017年5月23日 下午3:33:43 <br/>
 * 
 * @author lyh
 * @version
 * @see
 */
public class BaseDomain {
	
	/** id **/
	private Long id;
	/** 创建时间 **/
	private Date createTime = new Date();
	
	/** 版本号 **/
	private Integer version = 0;
	
	public Integer getVersion() {
		return version;
	}
	
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
