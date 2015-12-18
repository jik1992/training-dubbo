package com.quicloud;


import com.raycloyud.express.monitor.logback.helper.QuicloudMonitorHelper;

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
    logger.info("生产者测试");
    logger.info(
        QuicloudMonitorHelper
            .setMessage("yyy")
            .setSpendTime(222L)
            .setEvent("生产者事件")
            .setEventExtra("索引1")
            .setEventExtra("索引2")
            .setEventExtra("索引3")
            .setEventExtra("索引4")
            .setKeyValue("a", "b")
            .setEventExtra("额外事件2").build());
    return "finish";
  }
}
