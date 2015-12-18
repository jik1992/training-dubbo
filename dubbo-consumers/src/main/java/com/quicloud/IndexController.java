package com.quicloud;


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

  @Resource
  DubboService service;


  Logger log = LoggerFactory.getLogger(this.getClass());

  @RequestMapping("/index")
  @ResponseBody
  public Object index() throws SocketException, UnknownHostException {
    log.info("消费者测试");

//    throw new IllegalArgumentException("xxxx");
    return service.hello();
  }

}
