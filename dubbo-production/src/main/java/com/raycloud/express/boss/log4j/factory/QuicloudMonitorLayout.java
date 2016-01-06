package com.raycloud.express.boss.log4j.factory;


import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.LayoutBase;

/**
 * Created by ZuoYun on 12/10/15. Time: 2:02 AM Information:
 */
public class QuicloudMonitorLayout extends LayoutBase<ILoggingEvent> {

  public String doLayout(ILoggingEvent iLoggingEvent) {
    return iLoggingEvent.toString();
  }
}
