package com.pingan.pbear.udf

import com.pingan.pbear.udf.common.GeoIp.{ip2city, ip2country}
import com.pingan.pbear.udf.common.SimpleUdf.strLen
import com.pingan.pbear.udf.nlp.AnsjNLP.ansjWordSegToString
import org.apache.spark.internal.Logging
import org.apache.spark.sql.hive.HiveContext


/**
  * Created by lovelife on 17/2/16.
  */
object RegisterUdf extends Logging{
  def registerFunctions(hiveCtx: HiveContext) = {
    try {
      hiveCtx.udf.register("strLen", strLen _)
      hiveCtx.udf.register("ansjWordSegToString", ansjWordSegToString _)
      hiveCtx.udf.register("ip2city", ip2city _)
      hiveCtx.udf.register("ip2country", ip2country _)
    } catch {
      case e: Exception => ()
    }
  }
}
