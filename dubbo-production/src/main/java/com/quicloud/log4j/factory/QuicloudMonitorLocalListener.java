package com.quicloud.log4j.factory;


import org.iq80.leveldb.impl.LogReader;
import org.iq80.leveldb.util.Slice;

import java.io.UnsupportedEncodingException;

import redis.clients.jedis.Jedis;

/**
 * Created by ZuoYun on 12/12/15. Time: 10:43 AM Information:
 */
public class QuicloudMonitorLocalListener implements Runnable {


  public static void init() {
  }

  final int DELAY = 3000;

  public void run() {
    LogReader reader = LocalStoreFactory.getReader();
    if (reader == null) {
      return;
    }
    Slice slice = null;
    while (true) {
      slice = reader.readRecord();
      //如果不等于空处理 leveldb 数据
      if (slice != null) {
        //这里提交直到成功为止
        System.out.println("读取到数据:  " + new String(slice.getBytes()));
//        pushRedis(slice);
      }
    }
  }

  private void pushRedis(Slice slice) {
    boolean success = false;
    while (!success) {
      Jedis jedis = RedisPoolFactory.buildJedis();
      if (jedis != null) {
        success = true;
        try {
          jedis.rpush(RedisPoolFactory.key, new String(slice.getBytes(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
          success = false;
          try {
            Thread.sleep(DELAY);
          } catch (InterruptedException e1) {
            Thread.interrupted();
          }
        }
      }
    }
  }

}
