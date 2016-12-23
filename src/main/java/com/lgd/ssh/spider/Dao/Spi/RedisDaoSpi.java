package com.lgd.ssh.spider.Dao.Spi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lgd.ssh.spider.Dao.RedisDao;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

public class RedisDaoSpi extends RedisBaseDao implements RedisDao {

	private Jedis getJedisClient() {
		return super.getJedis();
	}

	private Pipeline getPipeline() {
		Jedis jedis = getJedisClient();
		return jedis.pipelined();
	}

	public void add(Map<String, String> addMap) {

		Pipeline pipeline = getPipeline();

		pipeline.multi();
		for (Map.Entry<String, String> entry : addMap.entrySet()) {
			pipeline.setnx(entry.getKey(), entry.getKey());
		}
		pipeline.exec();
		pipeline.syncAndReturnAll();
	}

	public void delete(List<String> deleteList) {
		Pipeline pipeline = getPipeline();

		pipeline.multi();
		for (String key : deleteList) {
			pipeline.del(key);
		}

		pipeline.exec();
		pipeline.syncAndReturnAll();
	}

	public void update(Map<String, String> updateMap) {
		Pipeline pipeline = getPipeline();

		pipeline.multi();
		for (Map.Entry<String, String> entry : updateMap.entrySet()) {
			pipeline.set(entry.getKey(), entry.getKey());
		}

		pipeline.exec();
		pipeline.syncAndReturnAll();

	}

	public Map<String, String> query(List<String> queryList) {
		Pipeline pipeline = getPipeline();

		pipeline.multi();

		for (String key : queryList) {
			pipeline.get(key);
		}
		pipeline.exec();

		List<Object> getAll = pipeline.syncAndReturnAll();

		Map<String, String> getMap = new HashMap<String, String>();
		for (Object obj : getAll) {
			String[] param = ( obj.toString()).split(":");
			getMap.put(param[0], obj.toString());
		}
		return getMap;
	}

}
