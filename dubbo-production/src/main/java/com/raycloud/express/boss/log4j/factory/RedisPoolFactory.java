package com.raycloud.express.boss.log4j.factory;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by ZuoYun on 12/12/15. Time: 3:20 PM Information:
 */
public class RedisPoolFactory {

  static        String host     = "192.168.31.202";
  static        int    port     = 9979;
  public static String key      = "db5";
  static        int    timeout  = 1000;
  static        String password = "T90ZFoEYrjffuPFDBWhrkD4ZHfXQydch";
  static        int    database = 0;


  static JedisPool pool;


  static {
    pool = new JedisPool(new JedisPoolConfig(), host, port, timeout, password, database);
  }



  public static Jedis buildJedis() {
    return pool.getResource();
  }

  public static void main(String[] args) {
  }

}
