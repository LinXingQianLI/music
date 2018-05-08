package com.beicai.util

import java.text.SimpleDateFormat
import java.util.{Base64, Locale}
import java.util.regex.Pattern

/**
  * Created by Administrator on 2018/5/7.
  */
object Utils {
  /**
    * 验证ip是否符合ip格式
    * @param ip
    */
  def validateIP(ip:String)={
  val reg = "((25[0-5]|2[0-4]\\\\d|((1\\\\d{2})|([1-9]?\\\\d)))\\\\.){3}(25[0-5]|2[0-4]\\\\d|((1\\\\d{2})|([1-9]?\\\\d)))"
  val pattern = Pattern.compile(reg)
    pattern.matcher(ip).matches()
  }

  /**
    * 将日志服务器时间转换成时间戳
    * @param accessTime
    * @return
    */
  def parseLogServerTimeToLong(accessTime:String) ={
    val simpleDateFormat = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss +0800",Locale.ENGLISH)
    val date = simpleDateFormat.parse(accessTime)
    date.getTime
  }

  /**
    * base64解码
    * @param base64EndcodeString
    * @return
    */
  def base64Decode(base64EndcodeString:String)={
    Base64.getDecoder.decode(base64EndcodeString)
  }

  /**
    * 验证日期是否是 yyyy-MM-dd
    * @param date
    * @return
    */
  def validateDate(date:String) ={
    val reg = "((((19|20)\\d{2})-(0?(1|[3-9])|1[012])-(0?[1-9]|[12]\\d|30))|(((19|20)\\d{2})-(0?[13578]|1[02])-31)|(((19|20)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|((((19|20)([13579][26]|[2468][048]|0[48]))|(2000))-0?2-29))$"
    val pattern = Pattern.compile(reg)
    pattern.matcher(date).matches()
  }

  /**
    * 将时间戳转换成指定格式的日期
    * @param longTime
    * @param pattern
    * @return
    */
  def formatDate(longTime:Long,pattern:String)={
  val sdf = new SimpleDateFormat(pattern)
  val calendar = sdf.getCalendar
  calendar.setTimeInMillis(longTime)
  sdf.format(calendar.getTime)
}
  def parseDateToLong(strDate:String,pattern: String)={
    val sdf = new SimpleDateFormat(pattern)
    sdf.parse(strDate).getTime
  }
//  def main(args: Array[String]): Unit = {
//    val str = base64Decode("eyJrdGluZ1Rva2VuIjoiQzVRUzZUZUNnb3NZcURkOGVmcnZaZEZoVkpWWmZtNXNLdk" +
//      "tzR3VxQVp5MFpGN242RFhpZXB4XC8wM0prdm1zN2RkeDk2Y2s5aG05N1FKM0h0SmZxOHpRPT0iLCJiZWhhdmlvck" +
//      "tleSI6IkRGU0o0MDAiLCJiZWhhdmlvckRhdGEiOnsiem9uZ0tleSI6IkZNNzAyIiwicHJvZ3JhbUlkIjoiMzEwMT" +
//      "MxIiwiYWxidW1JZCI6IjE2MjQ5IiwiYW5jaG9ySWQiOiIxMTUwNSIsInBsYXlUaW1lIjowLCJvbi1vZmYiOmZhbHNlfX0=")
// println(new String(str))
//  }
}
