import java.net.*;
import java.io.*;

public class FileReceiverThread extends Thread {
    private Socket socket;

    public FileReceiverThread() throws Exception {
        socket = new Socket("192.168.54.74", 2000);
        System.out.println("파일 수신 스레드가 실행됨");
    }

    public void run() {
        try {
            InputStream in = socket.getInputStream();
            FileOutputStream out = new FileOutputStream("from.html");

            byte[] data = new byte[1024*8];
            int size;

            while((size=in.read(data))!=-1) {
                out.write(data,0,size);
                out.flush();
            }
            System.out.println("파일 수신 완료");
            in.close();
            socket.close();
        }catch(Exception e){}
    }
}