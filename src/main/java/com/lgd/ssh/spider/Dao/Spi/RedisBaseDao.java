package com.lgd.ssh.spider.Dao.Spi;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisBaseDao {

	private static JedisPool jedisPool;

	public static JedisPool getJedisPool() {
		return jedisPool;
	}

	public static void setJedisPool(JedisPool jedisPool) {
		RedisBaseDao.jedisPool = jedisPool;
	}

	protected Jedis getJedis() {
		return jedisPool.getResource();
	}

}
