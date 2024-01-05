import java.net.*;
import java.io.*;

public class Server{
    public static void main(String[]args)throws Exception{
        ServerSocket seversocket =new ServerSocket(1000); // 소켓 오픈
        Socket socket = seversocket.accept(); //연결 대기중 멈춰있음
        
        BufferedReader in =new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream out =new PrintStream(System.out);
        PrintStream out2 =new PrintStream(socket.getOutputStream());
        
        String message="";
        String message2="";
        while(!(message=in.readLine()).equals("quit")){
            out.println(message);
            message2=message.concat(" from Server");
            out2.println(message2);
        }
        socket.close();

    }
}