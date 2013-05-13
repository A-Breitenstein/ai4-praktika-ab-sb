package rn.praktikum3.file_copy_client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Sven
 * Date: 12.05.13
 * Time: 21:36
 */
public class FileReader extends Thread {

    private int size;
    private String filename;
    private WindowBuffer windowBuffer;
    private long sequenzNumber = FileCopyClient.sequenzStart;

    public FileReader(int size, String filename, WindowBuffer windowBuffer) {
        this.size = size;
        this.filename = filename;
        this.windowBuffer = windowBuffer;
    }

    public void run() {
        FileInputStream f = null;
        try {
            f = new FileInputStream(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] barray = new byte[size];
        int nRead;
        try {
            while ( (nRead=f.read( barray, 0, size )) != -1 ){
                windowBuffer.putPacket(new FCpacket(sequenzNumber++,barray,nRead));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
