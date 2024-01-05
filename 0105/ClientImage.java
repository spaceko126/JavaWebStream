import java.net.*;
import java.io.*;

public class ClientImage {
    public static void main(String[]args)throws Exception{

        Socket socket =new Socket("192.168.54.74",1000);

        DataInputStream fileIn = new DataInputStream(socket.getInputStream());
        FileOutputStream out =new FileOutputStream("2.png");  //  ./폴더이름/2.png   -> 폴더안에  저장 
    
        byte[] data=new byte[1024*8];
        int size;

        while((size=fileIn.read(data))!=-1){
            out.write(data,0,size);
            out.flush();
        }
        fileIn.close();
        socket.close();
    }
}