package com.lgd.ssh.spider.Dao.Spi;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

public class RedisBaseDaoSpi {
	
	protected Jedis jedis;

	public Jedis getRedis() {
		return jedis;
	}

	public void setRedis(Jedis jedis) {
		this.jedis = jedis;
	}
	
	public Pipeline getPipeline(){
		return jedis.pipelined();
	}
	
}
