package org.apache.spark.streaming.http

import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.dstream.ReceiverInputDStream
import org.apache.spark.streaming.receiver.Receiver

private[streaming]
class HttpInputDStream(@transient streamingContext: StreamingContext,
                       storageLevel: StorageLevel) extends ReceiverInputDStream[String](streamingContext) {
  override def getReceiver(): Receiver[String] = {
    new HttpReceiver(storageLevel)
  }
}

private[streaming]
class HttpReceiver(storageLevel: StorageLevel) extends Receiver[String](storageLevel) {
  override def onStart(): Unit = {
    println("Receiver Start")
  }

  override def onStop(): Unit = {
    println("Receiver Stop")
  }
}
