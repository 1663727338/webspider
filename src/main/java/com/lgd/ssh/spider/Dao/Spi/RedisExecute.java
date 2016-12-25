package com.lgd.ssh.spider.Dao.Spi;

import redis.clients.jedis.Pipeline;

public interface RedisExecute<T> {

	public T Execute(Pipeline pipeline);
}
