package com.quicloud;


import com.raycloud.express.monitor.logback.helper.QuicloudMonitorFormatter;
import com.raycloud.express.monitor.trace.QuicloudMonitorContext;

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
    logger.info("你好");
    QuicloudMonitorContext.INSTALL.init();
    logger
        .info(QuicloudMonitorFormatter.setMessage("测试").setEvent("事件一").setEvent("消费时间").setSpendTime(1000L).format());
    logger.error("xxxx");
    logger.trace("xxxx");

    return "finish";
  }
}
