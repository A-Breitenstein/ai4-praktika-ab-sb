package rn.praktikum3.file_copy_client;

/* FileCopyClient.java
 Version 0.1 - Muss erg�nzt werden!!
 Praktikum 3 Rechnernetze BAI4 HAW Hamburg
 Autoren:
 */

import java.io.*;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class FileCopyClient extends Thread implements ACKReceiver.ACKListener {

  // -------- Constants
  public final static boolean TEST_OUTPUT_MODE = false;

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
  private WindowBuffer windowBuffer;
  public FileReader fileReader;
  public Sender sender;
  public ACKReceiver ackReceiver;
    // zaehlt wie viele messungen wir schon haben
    public long RTT_sample = 0;
    // allee RTT_Updater messungen wird timeout neu berechnet
    public long RTT_Updater = 2;      // 150
    public double RTT_X = 0.1;           //0.1
    public double RTT_estimated = timeoutValue;
    public double RTT_deviation = 0;

    public static long lostPackets = 0;
    public static long startTime = 0;
    public static long endTime = 0;
    public static long timeoutCount = 0;
    public Thread mainThread;
    private long calculatedTimeoutValue;


    // Constructor
  public FileCopyClient(String serverArg, String sourcePathArg,
    String destPathArg, String windowSizeArg, String errorRateArg) {
    servername = serverArg;
    sourcePath = sourcePathArg;
    destPath = destPathArg;
    windowSize = Integer.parseInt(windowSizeArg);
    serverErrorRate = Long.parseLong(errorRateArg);
    windowBuffer = new WindowBuffer(this,windowSize);

  }

  public long runFileCopyClient() {

      mainThread = Thread.currentThread();
      // ToDo!!
      fileReader = new FileReader(UDP_PACKET_SIZE-8,sourcePath, windowBuffer);
      sender = new Sender(servername,SERVER_PORT,UDP_PACKET_SIZE, windowBuffer,this);
      startTime = System.currentTimeMillis();
      sender.send(makeControlPacket());
      ackReceiver = new ACKReceiver(sender.getSocket(),UDP_PACKET_SIZE,this);
      ackReceiver.start();
      try {
          ackReceiver.join();
      } catch (InterruptedException e) {
        endTime = System.currentTimeMillis();
      }
      ackReceiver.closeSocket();
      sender.interrupt();


      System.out.println(TimeUnit.MILLISECONDS.toSeconds(endTime - startTime) +"s   ("+(endTime - startTime)+" ms)");
      System.out.println("windowsize: "+windowSize+"  errorRate: "+serverErrorRate);
      System.out.println("lostpackets: "+lostPackets+"  timeouts: "+timeoutCount+" sampleRTT: "+(timeoutValue)+" ns");
      return (endTime - startTime);
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
      testOut("perfoming timeoutTask for Packet: " + seqNum);
      timeoutCount++;
      windowBuffer.timeOut(seqNum);
  }


  /**
   *
   * Computes the current timeout value (in nanoseconds)
   */
  public void computeTimeoutValue(long sampleRTT) {
      // ToDo

      RTT_estimated = (1 - RTT_X) * RTT_estimated + RTT_X * sampleRTT;
      RTT_deviation = (1 - RTT_X) * RTT_deviation + RTT_X * Math.abs(sampleRTT - RTT_estimated);
      calculatedTimeoutValue = (long) (RTT_estimated + 4 * RTT_deviation);
      timeoutValue = (calculatedTimeoutValue>0?calculatedTimeoutValue:timeoutValue);


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
    public void receivedACK(FCpacket fCpacket) {
        testOut("Received ACK for: "+fCpacket.getSeqNum());
        windowBuffer.ackPacketReceived(fCpacket);
        if (windowBuffer.isEmpty()) {
            mainThread.interrupt();
        }
    }


    @Override
    public void ACK_0_received() {
        fileReader.start();
        sender.start();
    }


    public static void main(String argv[]) throws Exception {
//    FileCopyClient myClient = new FileCopyClient(argv[0], argv[1], argv[2],
//        argv[3], argv[4]);

        FileCopyClient myClient = new FileCopyClient("LAB21","RN_SoSe13_Kap2.pdf","copy/RN_SoSe13_Kap2.pdf","8","10000");
        myClient.runFileCopyClient();

//        for (Integer windowSize : Arrays.asList(128)) {
//            long timeVal = 0;
//            for (Integer errorRate : Arrays.asList(10000)) {
//
//                for (int i = 0; i < 1; i++) {
//
//                    FileCopyClient myClient = new FileCopyClient("LAB21","RN_SoSe13_Kap2.pdf","copy/RN_SoSe13_Kap2.pdf",String.valueOf(windowSize),String.valueOf(errorRate));
//                    timeVal += myClient.runFileCopyClient();
//                }
////                System.out.println("---###---windowS,errorR,time: " + windowSize + "," + errorRate +","+timeVal/3+ "---###---");
//            }
//        }
        
        
  }
}
