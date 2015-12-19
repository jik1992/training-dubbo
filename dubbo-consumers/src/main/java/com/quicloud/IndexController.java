package com.quicloud;


import com.quicloud.dao.Name;
import com.quicloud.dao.NameDao;
import com.raycloud.express.monitor.logback.helper.QuicloudMonitorFormatter;
import com.raycloud.express.monitor.logback.helper.QuicloudMonitorTracer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
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

  Logger log = LoggerFactory.getLogger(this.getClass());

  @Resource
  NameDao dao;

  @Resource
  DubboService service;

  @RequestMapping("/index")
  @ResponseBody
  public Object index() throws SocketException, UnknownHostException {
    dao.save(new Name().setName("左韵"));
    return dao.findByName("左韵"
        , new Sort(new Sort.Order(Sort.Direction.ASC, "id"))
    );
  }

  @RequestMapping("/dubbo")
  @ResponseBody
  public Object dubbo() throws SocketException, UnknownHostException {

    QuicloudMonitorTracer.send(QuicloudMonitorFormatter.setMessage("消费者事件").setEvent("消费者").format());
    return service.hello();
  }

}
