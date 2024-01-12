import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("192.168.54.74", 1000);
        System.out.println("채팅을 시작함");


        // FileReceiverThread fileThread = new FileReceiverThread();
        // fileThread.start();
        
        ChatReceiverThread chatTread =new ChatReceiverThread(socket);
        chatTread.start();

        BufferedReader keyIn = new BufferedReader(new InputStreamReader(System.in));
        PrintStream out = new PrintStream(socket.getOutputStream());

        String message = "";
        while(!(message = keyIn.readLine()).equals("quit")) {
            out.println(message);   //소켓에 보내기만함
        }
        out.println(message);
        socket.close();
    }
}