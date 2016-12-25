package com.lgd.ssh.spider.Dao.Spi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.lgd.ssh.spider.Dao.RedisDao;

import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

public class RedisDaoSpi extends RedisBaseDao implements RedisDao {

	private Logger logger = Logger.getLogger(RedisDaoSpi.class);

	public void add(final Map<String, String> addMap) {

		if (logger.isDebugEnabled()) {
			logger.debug("start RedisDaoSpi.add");
		}
		RedisExecute(new RedisExecute<Void>() {

			public Void Execute(Pipeline pipeline) {
				pipeline.multi();
				for (Map.Entry<String, String> entry : addMap.entrySet()) {
					pipeline.setnx(entry.getKey(), entry.getValue());
				}
				pipeline.exec();
				pipeline.syncAndReturnAll();
				return null;
			}

		});
		if (logger.isDebugEnabled()) {
			logger.debug("end RedisDaoSpi.add");
		}
	}

	public void delete(final List<String> deleteList) {

		if (logger.isDebugEnabled()) {
			logger.debug("start RedisDaoSpi.delete");
		}
		RedisExecute(new RedisExecute<Void>() {

			public Void Execute(Pipeline pipeline) {
				pipeline.multi();
				for (String key : deleteList) {
					pipeline.del(key);
				}

				pipeline.exec();
				pipeline.syncAndReturnAll();
				return null;
			}

		});
		if (logger.isDebugEnabled()) {
			logger.debug("end RedisDaoSpi.delete");
		}
	}

	public void update(final Map<String, String> updateMap) {

		if (logger.isDebugEnabled()) {
			logger.debug("start RedisDaoSpi.update");
		}
		RedisExecute(new RedisExecute<Void>() {

			public Void Execute(Pipeline pipeline) {
				pipeline.multi();
				for (Map.Entry<String, String> entry : updateMap.entrySet()) {
					pipeline.set(entry.getKey(), entry.getValue());
				}

				pipeline.exec();
				pipeline.syncAndReturnAll();
				return null;
			}

		});
		if (logger.isDebugEnabled()) {
			logger.debug("end RedisDaoSpi.update");
		}
	}

	public Map<String, String> query(final List<String> queryList) {

		if (logger.isDebugEnabled()) {
			logger.debug("start RedisDaoSpi.query");
		}
		Map<String, String> getMap = RedisExecute(new RedisExecute<Map<String, String>>() {

			public Map<String, String> Execute(Pipeline pipeline) {

				Map<String, Response<String>> getMap = new HashMap<String, Response<String>>();
				pipeline.multi();

				for (String key : queryList) {
					getMap.put(key, pipeline.get(key));
				}
				pipeline.exec();

				pipeline.syncAndReturnAll();

				Map<String, String> resultMap = new HashMap<String, String>();
				for (Map.Entry<String, Response<String>> entry : getMap.entrySet()) {
					resultMap.put(entry.getKey(), entry.getValue().get());
				}
				return resultMap;
			}

		});

		if (logger.isDebugEnabled()) {
			logger.debug("end RedisDaoSpi.query");
		}
		return getMap;
	}

}
