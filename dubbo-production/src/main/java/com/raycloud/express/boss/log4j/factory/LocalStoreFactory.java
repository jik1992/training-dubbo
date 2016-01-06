package com.raycloud.express.boss.log4j.factory;

import org.iq80.leveldb.impl.LogMonitor;
import org.iq80.leveldb.impl.LogReader;
import org.iq80.leveldb.impl.LogWriter;
import org.iq80.leveldb.impl.Logs;
import org.iq80.leveldb.util.Closeables;
import org.iq80.leveldb.util.Slice;
import org.iq80.leveldb.util.SliceOutput;
import org.iq80.leveldb.util.Slices;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.channels.FileChannel;

import static java.io.File.createTempFile;

/**
 * Created by ZuoYun on 12/12/15. Time: 10:47 AM Information:
 */
public class LocalStoreFactory {

  static LogWriter writer = null;

  static {
    if (writer == null) {
      try {
        writer = Logs.createLogWriter(createTempFile("trace", ".log"), 10000);
        System.out.println("绑定一个临时文件" + writer.getFile().getAbsolutePath());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public static void write(String data) {
    try {
      writer.addRecord(toSlice(data), false);
    } catch (IOException e) {
      System.out.println("异常");
    }
  }

  public static LogWriter getWriter() {
    return writer;
  }

  public static LogReader getReader() {
    FileChannel fileChannel = null;
    LogReader reader = null;
    try {
      try {
        fileChannel = new FileInputStream(writer.getFile()).getChannel();
        System.out.println("读取一个临时文件\t" + writer.getFile().getAbsolutePath());
      } catch (FileNotFoundException e) {
        System.out.println("文件读取失败");
      }

      reader = new LogReader(fileChannel, new LogMonitor() {
        public void corruption(long l, String s) {

        }

        public void corruption(long l, Throwable throwable) {

        }
      }, true, 0);
    } catch (Exception e) {
      Closeables.closeQuietly(fileChannel);
    }
    return reader;
  }


  private static Slice toSlice(String value) throws UnsupportedEncodingException {
    byte[] bytes = value.getBytes("UTF-8");
    Slice slice = Slices.allocate(bytes.length);
    SliceOutput sliceOutput = slice.output();
    for (int i = 0; i < 1; i++) {
      sliceOutput.writeBytes(bytes);
    }
    return slice;
  }

}
