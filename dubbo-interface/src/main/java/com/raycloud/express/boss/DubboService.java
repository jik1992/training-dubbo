package com.raycloud.express.boss;


import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Created by ZuoYun on 12/10/15. Time: 6:48 PM Information:
 */

public interface DubboService {

  String hello() throws SocketException, UnknownHostException;

}
