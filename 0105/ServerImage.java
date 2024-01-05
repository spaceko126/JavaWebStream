import java.net.*;
import java.io.*;

public class ServerImage{
    public static void main(String[]args)throws Exception{
        ServerSocket seversocket =new ServerSocket(1000); // 소켓 오픈
        Socket socket = seversocket.accept(); //연결 대기중 멈춰있음

        FileInputStream fileIn = new FileInputStream("1.png");
        PrintStream out =new PrintStream(socket.getOutputStream());

        byte[] data=new byte[1024*8];
        int size;

        while((size=fileIn.read(data))!=-1){
            out.write(data,0,size);
            out.flush();
        }

        socket.close();

    }
}