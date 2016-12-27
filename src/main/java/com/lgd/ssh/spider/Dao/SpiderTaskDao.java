package com.lgd.ssh.spider.Dao;

import java.util.List;

import com.lgd.ssh.spider.bean.SpiderTask;

public interface SpiderTaskDao {

	/**
	 * 添加数据
	 * @param spiderTasks
	 */
	public void Insert(final List<SpiderTask> spiderTasks);
	
	/**
	 * 
	 * @param spiderTasks
	 */
	public void Delete(final List<SpiderTask> spiderTasks);
	
	/**
	 * 
	 * @param spiderTasks
	 */
	public void Update(final List<SpiderTask> spiderTasks);
	
	/**
	 * 根据key获取spidertask对象
	 * @param keys
	 */
	public void Query(final List<String> keys);
}
