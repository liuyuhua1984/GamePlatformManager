
package com.lyh.game.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lyh.game.entity.PageEntity;
import com.lyh.game.iservice.IBaseService;
import com.lyh.game.iservice.IPageHelper;
import com.lyh.game.mybatis.domain.Notice;
import com.lyh.game.mybatis.domain.User;
import com.lyh.game.mybatis.mapper.NoticeMapper;
import com.lyh.game.mybatis.mapper.UserMapper;
import com.lyh.game.utils.log.LogUtils;

/**
 * ClassName:NoticeService <br/>
 * Function: TODO (). <br/>
 * Reason: TODO (). <br/>
 * Date: 2017年5月23日 下午2:46:21 <br/>
 * 
 * @author lyh
 * @version
 * @see
 */
@Service
public class NoticeService implements IBaseService<Notice>, IPageHelper<Notice> {
	
	protected Logger logger = LogUtils.getLog(this.getClass());
	
	@Autowired
	private NoticeMapper mapper;
	
	public long insert(Notice t) {
		
		if (t == null) {
			logger.error("Notice is null");
			return 0;
		}
		
		long result = 0;
		try {
			result = mapper.insert(t);
		} catch (Exception e) {
			logger.error("插入单个Notice异常::", e);
		}
		
		if (t != null && t.getId() != null && result > 0)
			return t.getId();
		
		return result;
	}
	
	public long insert(List<Notice> list) {
		
		if (list == null || list.size() <= 0) {
			logger.error("insertList<Notice>为空或者size为0");
			return 0;
		}
		long result = 0;
		try {
			result = mapper.insert(list);
		} catch (Exception e) {
			// e.printStackTrace();
			logger.error("插入多个Notice异常::", e);
		}
		return result;
	}
	
	public long update(Notice t) {
		if (t == null) {
			logger.error("更新Notice为空");
			return 0;
		}
		long result = 0;
		try {
			result = mapper.update(t);
		} catch (Exception e) {
			// e.printStackTrace();
			logger.error("更新Notice异常::", e);
		}
		
		return result;
	}
	
	public long update(List<Notice> list) {
		
		if (list == null || list.size() <= 0) {
			logger.error("更新多个Notice为空::");
			return 0;
		}
		
		int result = 0;
		
		for (int i = 0; i < list.size(); i++) {
			long ok = update(list.get(i));
			if (ok > 0) {
				result += 1;
			}
		}
		
		return result;
	}
	
	public Notice getById(long id) {
		try {
			return mapper.getById(id);
		} catch (Exception e) {
			// e.printStackTrace();
			logger.error("查找Notice异常::" + id, e);
		}
		return null;
	}
	
	public long deleteById(long id) {
		try {
			return mapper.deleteById(id);
		} catch (Exception e) {
			// e.printStackTrace();
			logger.error("删除Notice异常::" + id, e);
		}
		return 0;
	}
	
	// public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
	//
	// if (paramMap == null)
	// paramMap = new HashMap<String, Object>();
	//
	// // 获取分页数据集 , 注切勿换成 sessionTemplate 对象
	// List<Object> list = getSqlSession().selectList(getStatement(sqlId), paramMap,
	// new RowBounds((pageParam.getPageNum() - 1) * pageParam.getNumPerPage(), pageParam.getNumPerPage()));
	//
	// // 统计总记录数
	// Object countObject = (Object) getSqlSession().selectOne(getStatement(sqlId), new ExecutorInterceptor.CountParameter(paramMap));
	// Long count = Long.valueOf(countObject.toString());
	//
	// return new PageBean(pageParam.getPageNum(), pageParam.getNumPerPage(), count.intValue(), list);
	// }
	//
	// public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
	//
	// if (paramMap == null)
	// paramMap = new HashMap<String, Object>();
	//
	// // 获取分页数据集 , 注切勿换成 sessionTemplate 对象
	// List<Object> list = getSqlSession().selectList(getStatement(SQL_LIST_PAGE), paramMap,
	// new RowBounds((pageParam.getPageNum() - 1) * pageParam.getNumPerPage(), pageParam.getNumPerPage()));
	//
	// // 统计总记录数
	// Object countObject = (Object) getSqlSession().selectOne(getStatement(SQL_LIST_PAGE),
	// new ExecutorInterceptor.CountParameter(paramMap));
	// Long count = Long.valueOf(countObject.toString());
	//
	// // 是否统计当前分页条件下的数据：1:是，其他为否
	// Object isCount = paramMap.get("isCount");
	// if (isCount != null && "1".equals(isCount.toString())) {
	// Map<String, Object> countResultMap = sessionTemplate.selectOne(getStatement(SQL_COUNT_BY_PAGE_PARAM), paramMap);
	// return new PageBean(pageParam.getPageNum(), pageParam.getNumPerPage(), count.intValue(), list, countResultMap);
	// } else {
	// return new PageBean(pageParam.getPageNum(), pageParam.getNumPerPage(), count.intValue(), list);
	// }
	// }
	
	@Override
	public PageEntity<Notice> listByPage(Map<String, Object> paramMap, int startPage, int numPerPage) throws Exception {
		try {
			if (paramMap == null || paramMap.isEmpty()){
				logger.error("Notice分页参数为空::");
				return null;
			}
			PageHelper.startPage(startPage, numPerPage);
			List<Notice> list = listBy(paramMap);
			long total = ((Page<Notice>) list).getTotal();
			return new PageEntity<Notice>(total, list, startPage, numPerPage);
		} catch (Exception e) {
			logger.error("Notice分页出现异常::", e);
		}
		return null;
	}
	
	public List<Notice> listBy(Map<String, Object> paramMap) {
		try {
			if (paramMap == null || paramMap.isEmpty()) {
				logger.error("查询多个Notice条件为空::");
				return null;
			}
			return mapper.listBy(paramMap);
		} catch (Exception e) {
			// e.printStackTrace();
			logger.error("条件查询多个Notice异常::" + paramMap.toString(), e);
		}
		return null;
	}
	
	public Notice getBy(Map<String, Object> paramMap) {
		try {
			if (paramMap == null || paramMap.isEmpty()) {
				logger.error("查询单个Notice条件为空::");
				return null;
			}
			return mapper.getBy(paramMap);
		} catch (Exception e) {
			logger.error("条件查询单个Notice异常::" + paramMap.toString(), e);
		}
		return null;
	}
	
	//
	// public String getStatement(String sqlId) {
	//
	// String name = this.getClass().getName();
	//
	// StringBuffer sb = new StringBuffer().append(name).append(".").append(sqlId);
	//
	// return sb.toString();
	// }
	//
	// /**
	// * 根据序列名称,获取序列值
	// */
	// public String getSeqNextValue(String seqName) {
	// boolean isClosedConn = false;
	// // 获取当前线程的连接
	// Connection connection = this.sessionTemplate.getConnection();
	// // 获取Mybatis的SQLRunner类
	// SqlRunner sqlRunner = null;
	// try {
	// // 要执行的SQL
	// String sql = "";
	// // 数据库驱动类
	// String driverClass = druidDataSource.getDriver().getClass().getName();
	// // 不同的数据库,拼接SQL语句
	// if (driverClass.equals("com.ibm.db2.jcc.DB2Driver")) {
	// sql = " VALUES " + seqName.toUpperCase() + ".NEXTVAL";
	// }
	// if (driverClass.equals("oracle.jdbc.OracleDriver")) {
	// sql = "SELECT " + seqName.toUpperCase() + ".NEXTVAL FROM DUAL";
	// }
	// if (driverClass.equals("com.mysql.jdbc.Driver")) {
	// sql = "SELECT FUN_SEQ('" + seqName.toUpperCase() + "')";
	// }
	// // 如果状态为关闭,则需要从新打开一个连接
	// if (connection.isClosed()) {
	// connection = sqlSessionFactory.openSession().getConnection();
	// isClosedConn = true;
	// }
	// sqlRunner = new SqlRunner(connection);
	// Object[] args = {};
	// // 执行SQL语句
	// Map<String, Object> params = sqlRunner.selectOne(sql, args);
	// for (Object o : params.values()) {
	// return o.toString();
	// }
	// return null;
	// } catch (Exception e) {
	// throw BizException.DB_GET_SEQ_NEXT_VALUE_ERROR.newInstance("获取序列出现错误!序列名称:{%s}", seqName);
	// } finally {
	// if (isClosedConn) {
	// sqlRunner.closeConnection();
	// }
	// }
	// }
	
}
