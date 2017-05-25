
package com.lyh.game.entity;

import java.util.List;

/**
 * ClassName:PageEntity <br/>
 * Function: TODO (page实体类). <br/>
 * Reason: TODO (). <br/>
 * Date: 2017年5月25日 下午3:32:37 <br/>
 * 
 * @author lyh
 * @version
 * @see
 */
public class PageEntity<T> {
	/** 总数量 **/
	private long totalNum;
	/****/
	private List<T> list;
	
	/** 开始页 **/
	private int startPage;
	/** 每页数量 **/
	private int numPerPage;
	
	public PageEntity(long totalNum, List<T> list, int startPage, int numPerPage) {
		this.totalNum = totalNum;
		this.list = list;
		this.startPage = startPage;
		this.numPerPage = numPerPage;
	}
	
	public long getTotalNum() {
		return totalNum;
	}
	
	public void setTotalNum(long totalNum) {
		this.totalNum = totalNum;
	}
	
	public List<T> getList() {
		return list;
	}
	
	public void setList(List<T> list) {
		this.list = list;
	}
	
	public int getStartPage() {
		return startPage;
	}
	
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	
	public int getNumPerPage() {
		return numPerPage;
	}
	
	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}
}
