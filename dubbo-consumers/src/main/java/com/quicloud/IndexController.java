package com.quicloud;


import com.raycloud.express.monitor.logback.helper.QuicloudMonitorHelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Created by ZuoYun on 12/10/15. Time: 6:42 PM Information:
 */
@RestController("/")
public class IndexController {

  Logger log = LoggerFactory.getLogger(this.getClass());

  //  @Resource
//  NameDao dao;
//
  @RequestMapping("/index")
  @ResponseBody
  public Object index() throws SocketException, UnknownHostException {
    return null;
  }

  @RequestMapping("/dubbo")
  @ResponseBody
  public Object dubbo() throws SocketException, UnknownHostException {
    QuicloudMonitorHelper.setMessage("xxxxx").send();
    return "finish";
  }

}
