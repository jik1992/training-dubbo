package com.raycloud.express.boss.log4j.factory;


import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by ZuoYun on 12/12/15. Time: 11:09 AM Information:
 */
public class ThreadPoolFactory {

  final static public Executor EXECUTOR = Executors.newCachedThreadPool();
}
