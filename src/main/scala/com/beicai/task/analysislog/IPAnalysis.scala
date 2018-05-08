package com.beicai.task.analysislog

import com.beicai.caseclass.{IPRule, RegionInfo}
import com.beicai.util.Utils
import scala.util.control.Breaks._
/**
  * Created by Administrator on 2018/5/7.
  */
object IPAnalysis {



  def analysisIP(ip:String, ipRules:Array[IPRule])={
  val regionInfo = RegionInfo()
  if(Utils.validateIP(ip)){
    //将ip解析成完整的十进制数字
    val numIp = ip2Long(ip)
    //获取numIP的地域信息
    val index = binarySearch(numIp,ipRules)
    if(index != -1){
      val iPRule = ipRules(index)
      regionInfo.country = iPRule.country
      regionInfo.province = iPRule.province
      regionInfo.city = iPRule.city
    }
  }
    regionInfo
}
  def binarySearch(numIp: Long, ipRules: Array[IPRule]) = {
    //最小角标
    var min:Int = 0
    //最大角标\
    var max:Int = ipRules.length -1
    //目标角标
    var index:Int = -1
    breakable({
      while(min<=max){
      //中间角标
        var middle = (min + max) /2
        // 取出中间角标对应的规则
        val iPRule = ipRules(middle)
        //判断numIp是否在规则起始ip内
        if(numIp >= iPRule.startIP && numIp <= iPRule.endIP){
          index = middle
          break()
        }else if (numIp < iPRule.startIP){
          max = middle -1
        }else if(numIp > iPRule.endIP){
          min = middle +1
        }

      }
    })
    index
  }
  def ip2Long(ip:String)={
    val fields = ip.split("[.]")
    var numIP : Long = 0L
    for(i<- 0 until(fields.length)){
      numIP = numIP << 8 |fields(i).toLong
    }
    numIP
  }
}
