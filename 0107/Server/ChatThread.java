import java.io.*;
import java.net.*;
import java.util.*;

public class ChatThread extends Thread {
    private Socket socket;
    private String ip;
    private ArrayList<PrintStream> clientList;

    public ChatThread(Socket socket , ArrayList<PrintStream> clientList) {
        this.socket = socket;
        this.clientList =clientList;
        this.ip = socket.getInetAddress().toString();
        System.out.println(this.ip+"가 접속함");
        broadCast(this.ip +"가 접속함");
    }

    public void run() {
    try {
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream out = new PrintStream(socket.getOutputStream());
        clientList.add(out);
        String message = "";

        while(!(message = in.readLine()).equals("quit")){
            broadCast(this.ip+":"+message);
        }
        socket.close();
        System.out.println(this.ip+"가 나감");
        clientList.remove(out);
        broadCast(this.ip+"가 나감");

    }catch(Exception e) {}
    }
    
    private void broadCast(String message){
        for(int i=0;i<this.clientList.size();i++){
            clientList.get(i).println(message);
        }
        }
    
}