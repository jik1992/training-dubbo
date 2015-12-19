package com.quicloud;


import com.raycloud.express.monitor.logback.helper.QuicloudMonitorFormatter;
import com.raycloud.express.monitor.logback.helper.QuicloudMonitorTracer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by ZuoYun on 12/10/15. Time: 6:51 PM Information:
 */
@Component
public class DubboSerivceImpl implements DubboService {


  Logger logger = LoggerFactory.getLogger(this.getClass());

  public String hello() {
    QuicloudMonitorTracer.send("生产者测试");
    QuicloudMonitorTracer.send(QuicloudMonitorFormatter
                                   .setMessage("yyy")
                                   .setSpendTime(222L)
                                   .setEvent("生产者事件")
                                   .setEvent("索引1")
                                   .setEvent("索引2")
                                   .setEvent("索引3")
                                   .setEvent("索引4")
                                   .setKeyValue("a", "b")
                                   .setEvent("额外事件2")
                                   .format());

    return "finish";
  }
}
