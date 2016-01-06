package com.raycloud.express.boss;

import org.apache.log4j.Logger;
import org.iq80.leveldb.impl.LogConstants;
import org.iq80.leveldb.impl.LogMonitor;
import org.iq80.leveldb.impl.LogReader;
import org.iq80.leveldb.impl.LogWriter;
import org.iq80.leveldb.impl.MMapLogWriter;
import org.iq80.leveldb.util.Slice;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by ZuoYun on 12/10/15. Time: 6:59 PM Information:
 */
public class DubboSerivceImplTest {

  final static Logger logger = Logger.getLogger(DubboSerivceImplTest.class);


  static ApplicationContext ctx;
  static DubboService       dubboService;

  @org.junit.Test
  public void testHello() throws Exception {
    //装载log4j.xml
    try {
      Log4jConfigurer.initLogging("classpath:_log4j.xml");
    } catch (FileNotFoundException e) {
      logger.error("日志异常");
    }
    //Spring装载扫描
    ctx = new ClassPathXmlApplicationContext("classpath:spring/spring-dubbo-produce.xml");
    dubboService = (DubboService) ctx.getBean("dubboServiceImpl", DubboSerivceImpl.class);
    System.out.println(dubboService.hello());
    while (true) {

    }
  }

  @Test
  public void testHello2() throws IOException {
    File file = File.createTempFile("test", ".log");
    try {
      int recordSize = LogConstants.BLOCK_SIZE - LogConstants.HEADER_SIZE;
      Slice record = new Slice(recordSize);

      LogWriter writer = new MMapLogWriter(file, 10);
      writer.addRecord(record, false);
      writer.close();

      LogMonitor logMonitor = new AssertNoCorruptionLogMonitor();

      FileChannel channel = new FileInputStream(file).getChannel();

      LogReader logReader = new LogReader(channel, logMonitor, true, 0);

      int count = 0;
      for (Slice slice = logReader.readRecord(); slice != null; slice = logReader.readRecord()) {
        assertEquals(slice.length(), recordSize);
        count++;
      }
      assertEquals(count, 1);
    } finally {
      file.delete();
    }
  }

  private static class AssertNoCorruptionLogMonitor
      implements LogMonitor {

    public void corruption(long bytes, String reason) {
      fail("corruption at " + bytes + " reason: " + reason);
    }

    public void corruption(long bytes, Throwable reason) {
      fail("corruption at " + bytes + " reason: " + reason);
    }
  }
}