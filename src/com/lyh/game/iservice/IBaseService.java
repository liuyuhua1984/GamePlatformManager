
package com.lyh.game.iservice;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import com.lyh.game.mybatis.domain.BaseDomain;

/**
 * ClassName:IService <br/>
 * Function: TODO (服务基础接口). <br/>
 * Reason: TODO (). <br/>
 * Date: 2017年5月23日 下午2:37:45 <br/>
 * 
 * @author lyh
 * @version
 * @see
 */
public interface IBaseService<T extends BaseDomain> {
	/**
	 * 根据实体对象新增记录.
	 * 
	 * @param entity
	 *            .
	 * @return id .
	 */
	long insert(T entity) throws Exception;

	/**
	 * 批量保存对象.
	 * 
	 * @param entity
	 *            .
	 * @return id .
	 */
	long insertBatch(List<T> list) throws Exception;

	/**
	 * 更新实体对应的记录.
	 * 
	 * @param entity
	 *            .
	 * @return
	 */
	long update(T entity) throws Exception;

	/**
	 * 批量更新对象.
	 * 
	 * @param entity
	 *            .
	 * @return int .
	 */
	long updateBatch(List<T> list) throws Exception;

	/**
	 * 根据ID查找记录.
	 * 
	 * @param id
	 *            .
	 * @return entity .
	 */
	T getById(long id) throws Exception;

	/**
	 * 根据ID删除记录.
	 * 
	 * @param id
	 *            .
	 * @return
	 */
	long deleteById(long id) throws Exception;




	/**
	 * 根据条件查询 listBy: <br/>
	 * 
	 * @param paramMap
	 * @return 返回集合
	 */
	List<T> listBy(Map<String, Object> paramMap) throws Exception;


	/**
	 * 根据条件查询 listBy: <br/>
	 * 
	 * @param paramMap
	 * @return 返回实体
	 */
	T getBy(Map<String, Object> paramMap) throws Exception;


	
//	//获取第1页，10条内容，默认查询总数count
//	PageHelper.startPage(1, 10);
//	//紧跟着的第一个select方法会被分页
//	List<Country> list = countryMapper.selectIf(1);
//	assertEquals(2, list.get(0).getId());
//	assertEquals(10, list.size());
//	//分页时，实际返回的结果list类型是Page<E>，如果想取出分页信息，需要强制转换为Page<E>
//	assertEquals(182, ((Page) list).getTotal());
	
//	/**
//	 * 根据序列名称获取下一个值
//	 * 
//	 * @return
//	 */
//	String getSeqNextValue(String seqName);
//
//	SqlSessionTemplate getSessionTemplate();
//
//	SqlSession getSqlSession();

}
