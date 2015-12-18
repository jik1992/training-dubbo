package com.quicloud.log4j.factory;


import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import redis.clients.jedis.Jedis;

/**
 * Created by ZuoYun on 12/12/15. Time: 10:43 AM Information:
 */
public class QuicloudMonitorSocketAppender extends AppenderBase<ILoggingEvent> {

  static {
    QuicloudMonitorLocalListener.init();
  }

  static public void write(String sms) {
    Jedis client = RedisPoolFactory.buildJedis();
    try {
      client.rpush(RedisPoolFactory.key, sms);
    } catch (Exception e) {
      LocalStoreFactory.write(sms);
    } finally {
      client.close();
    }
  }


  @Override
  protected void append(ILoggingEvent event) {
    write(new QuicloudMonitorLayout().doLayout(event));
  }


}
