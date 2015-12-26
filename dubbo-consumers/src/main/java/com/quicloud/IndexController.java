package com.quicloud;


import com.quicloud.dao.Name;
import com.quicloud.dao.NameDao;
import com.quicloud.dao.NamePageDao;
import com.raycloud.express.monitor.logback.helper.QuicloudMonitorFormatter;
import com.raycloud.express.monitor.logback.helper.QuicloudMonitorTracer;
import com.raycloud.express.monitor.reporter.QuicloudMonitorMetrics;
import com.raycloud.express.monitor.trace.QuicloudMonitorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.SocketException;
import java.net.UnknownHostException;

import javax.annotation.Resource;

/**
 * Created by ZuoYun on 12/10/15. Time: 6:42 PM Information:
 */
@RestController("/")
public class IndexController {

  Logger logger = LoggerFactory.getLogger(this.getClass());

  @Resource
  NameDao      dao;
  @Resource
  NamePageDao  dao2;
  @Resource
  DubboService service;

  @RequestMapping("/index")
  @ResponseBody
  public Object index() throws SocketException, UnknownHostException {
    dao.save(new Name().setName("左韵"));
    QuicloudMonitorContext.INSTALL.put("测试上下文","xxx");
    logger.info("xxxx {}", new Long(111));
    return dao.findByName("左韵");
  }

  @RequestMapping("/index2")
  @ResponseBody
  public Object index2() throws SocketException, UnknownHostException {
    logger.trace("xxxxx");
    return "";
  }

  @RequestMapping("/dubbo")
  @ResponseBody
  public Object dubbo() throws SocketException, UnknownHostException {

    QuicloudMonitorContext.INSTALL.init();
    QuicloudMonitorContext.INSTALL.put("测试上下文","xxx");



    QuicloudMonitorTracer.send(QuicloudMonitorFormatter
                                   .setMessage("标题")
                                   .setEvent("第一个维度")
                                   .setEvent("第二个维度")
                                   .setKeyValue("第一个指标",111L)
                                   .setKeyValue("第二个指标",111L)
                                   .setSpendTime(222L)
                                   .format());

    QuicloudMonitorMetrics.counter("第一指标","第二指标");

    logger.error("xxxx");
    logger.trace("xxxx");
    return service.hello();
  }

}
