import java.net.*;
import java.io.*;

public class FileTransferThread extends Thread {
    private Socket socket;

    public FileTransferThread(Socket socket) {
        this.socket = socket;
        System.out.println("파일 전송 스레드가 실행됨"+socket.getInetAddress().toString());

    }

    public void run() {
        try {
            FileInputStream in = new FileInputStream("1.exe");
            OutputStream out = socket.getOutputStream();

            byte[] data = new byte[1024*8];
            int size;

            while((size=in.read(data))!=-1) {
                out.write(data,0,size);
                out.flush();
            }
            System.out.println("파일 전송 완료");
            in.close();
            socket.close();
        }catch(Exception e){}

    }
}