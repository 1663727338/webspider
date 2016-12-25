package com.lgd.ssh.spider.Dao.Spi;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;

public class RedisBaseDao {

	private static JedisPool jedisPool;

	public static JedisPool getJedisPool() {
		return jedisPool;
	}

	public static void setJedisPool(JedisPool jedisPool) {
		RedisBaseDao.jedisPool = jedisPool;
	}

	private Jedis getJedis() {
		return jedisPool.getResource();
	}
	
	private Jedis getJedisClient() {
		return getJedis();
	}

	private Pipeline getPipeline() {
		Jedis jedis = getJedisClient();
		return jedis.pipelined();
	}
	
	public <T> T RedisExecute(RedisExecute<T> redisExcute){
		
		Pipeline pipeline = getPipeline();
		return redisExcute.Execute(pipeline);		
	}

}
