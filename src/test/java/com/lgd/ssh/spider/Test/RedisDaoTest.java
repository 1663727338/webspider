package com.lgd.ssh.spider.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lgd.ssh.spider.Dao.RedisDao;

public class RedisDaoTest {

	private static RedisDao redisDao;

	public RedisDao getRedisDao() {
		return redisDao;
	}

	public void setRedisDao(RedisDao redisDao) {
		this.redisDao = redisDao;
	}

	public static void main(String[] args) {

		ContextLoad.loadContext();

		System.out.println("testAdd");
		List<String> addList = add();
		query(addList);
		
		List<String> updateList = update();
		query(updateList);
		
		delete();
		updateList.addAll(addList);
		query(updateList);
	}

	private static void delete() {
		 List<String> deleteList = new ArrayList<String>();
		 deleteList.add("100");
		 deleteList.add("101");
		 deleteList.add("103");
		 redisDao.delete(deleteList);
	}

	private static List<String> update() {
		
		Map<String, String> addMap = new HashMap<String, String>();
		addMap.put("100", "100:1");
		addMap.put("105", "105:2");
		addMap.put("101", "101:3");
		addMap.put("101", "101:3");
		addMap.put("103", "103:1");
		addMap.put("104", "104:1");
		redisDao.add(addMap);
		List<String> addList = new ArrayList<String>();
		addList.addAll(addMap.keySet());
		return addList;
	}

	private static void query(List<String> queryList) {
		Map<String, String> queryMap = redisDao.query(queryList);
		System.out.println("queryAll");
		for (Map.Entry<String, String>entry : queryMap.entrySet()){
			System.out.println("key=" + entry.getKey() + ",value=" + entry.getValue());
		}
		System.out.println("queryAll Done");
	}

	private static List<String> add() {

		Map<String, String> addMap = new HashMap<String, String>();
		addMap.put("100", "100:1");
		addMap.put("100", "100:2");
		addMap.put("101", "101:1");
		addMap.put("102", "102:1");
		addMap.put("103", "103:1");
		addMap.put("104", "104:1");
		redisDao.add(addMap);

		List<String> addList = new ArrayList<String>();
		addList.addAll(addMap.keySet());
		return addList;
	}
}
