package rn.praktikum3.file_copy_client;

/* FileCopyClient.java
 Version 0.1 - Muss erg�nzt werden!!
 Praktikum 3 Rechnernetze BAI4 HAW Hamburg
 Autoren:
 */

import java.io.*;
import java.net.*;

public class FileCopyClient extends Thread implements ACKReceiver.ACKListener {

  // -------- Constants
  public final static boolean TEST_OUTPUT_MODE = true;

  public final int SERVER_PORT = 23000;

  public final int UDP_PACKET_SIZE = 1024;

  // -------- Public parms
  public String servername;

  public String sourcePath;

  public String destPath;

  public int windowSize;

  public long serverErrorRate;

  // -------- Variables
  // current default timeout in nanoseconds
  private long timeoutValue = 100000000L;
//  private long timeoutValue = 9000000000L;
  public static long sequenzStart = 1;

  // ... ToDo
  private SendBuffer sendBuffer;
  public FileReader fileReader;
  public Sender sender;
  public ACKReceiver ackReceiver;

    // Constructor
  public FileCopyClient(String serverArg, String sourcePathArg,
    String destPathArg, String windowSizeArg, String errorRateArg) {
    servername = serverArg;
    sourcePath = sourcePathArg;
    destPath = destPathArg;
    windowSize = Integer.parseInt(windowSizeArg);
    serverErrorRate = Long.parseLong(errorRateArg);
    sendBuffer = new SendBuffer(windowSize,this);

  }

  public void runFileCopyClient() {

      // ToDo!!
      fileReader = new FileReader(UDP_PACKET_SIZE-8,sourcePath,sendBuffer);
      sender = new Sender(servername,SERVER_PORT,UDP_PACKET_SIZE,sendBuffer);
      ackReceiver = new ACKReceiver(SERVER_PORT+1,UDP_PACKET_SIZE,this);
      ackReceiver.start();
      try {
          ackReceiver.join();
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
  }

  /**
  *
  * Timer Operations
  */
  public void startTimer(FCpacket packet) {
    /* Create, save and start timer for the given FCpacket */
    FC_Timer timer = new FC_Timer(timeoutValue, this, packet.getSeqNum());
    packet.setTimer(timer);
    timer.start();
  }

  public void cancelTimer(FCpacket packet) {
    /* Cancel timer for the given FCpacket */
    testOut("Cancel Timer for packet" + packet.getSeqNum());

    if (packet.getTimer() != null) {
      packet.getTimer().interrupt();
    }
  }

  /**
   * Implementation specific task performed at timeout
   */
  public void timeoutTask(long seqNum) {
  // ToDo
      sendBuffer.addSeqNumToTimeOutQueue(seqNum);
  }


  /**
   *
   * Computes the current timeout value (in nanoseconds)
   */
  public void computeTimeoutValue(long sampleRTT) {

  // ToDo
  }


  /**
   *
   * Return value: FCPacket with (0 destPath;windowSize;errorRate)
   */
  public FCpacket makeControlPacket() {
   /* Create first packet with seq num 0. Return value: FCPacket with
     (0 destPath ; windowSize ; errorRate) */
    String sendString = destPath + ";" + windowSize + ";" + serverErrorRate;
    byte[] sendData = null;
    try {
      sendData = sendString.getBytes("UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return new FCpacket(0, sendData, sendData.length);
  }

  public void testOut(String out) {
    if (TEST_OUTPUT_MODE) {
      System.err.printf("%,d %s: %s\n", System.nanoTime(), Thread
          .currentThread().getName(), out);
    }
  }

    @Override
    public void receivedACK(long seqNum) {
        if(TEST_OUTPUT_MODE)
            System.out.println("Received ACK for: "+seqNum);
        sendBuffer.markAsAcked(seqNum);
    }

    @Override
    public void ACK_0_received() {
        fileReader.start();
        sender.start();
    }

    @Override
    public void rdy_for_ack_0() {
        sender.send(makeControlPacket());
    }

    public static void main(String argv[]) throws Exception {
//    FileCopyClient myClient = new FileCopyClient(argv[0], argv[1], argv[2],
//        argv[3], argv[4]);
    FileCopyClient myClient = new FileCopyClient("Sven-LAPTOP","datei.pdf","datei.pdf","10","100");
    myClient.runFileCopyClient();
  }
}
