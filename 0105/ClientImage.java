import java.net.*;
import java.io.*;

public class ClientImage {
    public static void main(String[]args)throws Exception{

        Socket socket =new Socket("192.168.54.71",2000);

        DataInputStream fileIn = new DataInputStream(socket.getInputStream());
        FileOutputStream out =new FileOutputStream("asd.exe");  //  ./폴더이름/2.png   -> 폴더안에  저장 
        BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
        PrintStream out =new PrintStream(socket.getOutputStream());
    
        byte[] data=new byte[1024*8];
        int size;
        String message="";

        while((size=fileIn.read(data))!=-1){
            out.write(data,0,size);
            out.flush();
        }
        while(!(message=in.readLine()).equals("quit")){
            out.println(message);
        }
        fileIn.close();
        socket.close();
    }
}