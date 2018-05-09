package com.beicai.util

import redis.clients.jedis.{JedisPool, JedisPoolConfig}

/**
  * Created by Administrator on 2018/5/9.
  */
object JedisUtils {
  val config = new JedisPoolConfig
   val jedisPool = new JedisPool(config,"z1",6379,0)

  def getConnection() ={
    jedisPool.getResource
  }

  /**
    * 向redis中写入hash数据类型的数据
    * @param key
    * @param field
    * @param value
    */
  def hset(key:String,field:String,value: String)={
    val client = getConnection()
    client.hset(key,field,value)
    client.close()
  }
}
