import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[]args)throws Exception{

        Socket socket =new Socket("192.168.54.75",1000);

        BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
        PrintStream out =new PrintStream(socket.getOutputStream());
        BufferedReader in2 =new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream out2 =new PrintStream(System.out);
        
        String message="";
        String message2="";
        while(!(message=in.readLine()).equals("quit")){
            out.println(message);
            out2.println(message2);
        }

        out.println(message);
        socket.close();
    }
}