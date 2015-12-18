package com.quicloud.log4j.factory;

import org.iq80.leveldb.impl.LogWriter;
import org.iq80.leveldb.util.Slice;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by ZuoYun on 12/18/15. Time: 1:44 PM Information:
 */
public class QuicloudMonitorLocalListenerTest {

  final static public Executor EXECUTOR = Executors.newSingleThreadExecutor();


  @Test
  public void testRun() throws Exception {

    EXECUTOR.execute(new Runnable() {
      public void run() {
        try {
          //写入数据
          LogWriter writer = LocalStoreFactory.getWriter();
          System.out.println("写入数据\t" + writer.getFile().getAbsolutePath());
          writer.addRecord(new Slice("测试".getBytes()), false);
          System.out.println("写入成功\t" + writer.getFileNumber());
        } catch (IOException e) {
          e.fillInStackTrace();
        }
      }
    });

    Thread.sleep(2000L);

    new QuicloudMonitorLocalListener().run();


  }
}