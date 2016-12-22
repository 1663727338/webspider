package com.lgd.ssh.spider.Dao;

import java.util.List;
import java.util.Map;

public interface RedisDao {

	/**
	 * 向redis添加数据
	 * 
	 * @param addMap<key,
	 *            value>
	 */
	public void add(Map<String, String> addMap);

	/**
	 * 删除redis数据
	 * 
	 * @param deleteList<key>
	 */
	public void delete(List<String> deleteList);

	/**
	 * 更新redis数据
	 * 
	 * @param updateMap<key,
	 *            value>
	 */
	public void update(Map<String, String> updateMap);

	/**
	 * 查询
	 * 
	 * @param queryList
	 */
	public Map<String, String> query(List<String> queryList);
}
