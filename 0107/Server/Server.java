import java.net.*;
import java.util.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws Exception {

        // ServerSocket fileServerSocket = new ServerSocket(2000);
        ServerSocket chatServerSocket = new ServerSocket(1000);
        ArrayList<PrintStream> clientList =new ArrayList<>();

        while(true) {
            
            Socket chatSocket = chatServerSocket.accept();
            ChatThread chatThread = new ChatThread(chatSocket,clientList);
            chatThread.start();
            
            // Socket fileSocket = fileServerSocket.accept();
            // FileTransferThread fileThread = new FileTransferThread(fileSocket);
            // fileThread.start();

        }
    }
}