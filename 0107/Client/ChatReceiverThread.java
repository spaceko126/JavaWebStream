import java.net.*;
import java.io.*;


public class ChatReceiverThread extends Thread{
    private Socket socket;  //데이터 없는 소켓 생성
    
    public ChatReceiverThread(Socket socket) throws Exception{  //Client.java 에서 소켓 데이터를 넘겨받음
        this.socket =socket;    //데이터 없는 소켓에 데이터 입력
        System.out.println(socket.getInetAddress().toString()+"가 접속함");
    }
    public void run(){
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while(true){
                System.out.println(in.readLine());     //화면에 출력
            }

        }catch(Exception e){}
        
    }
}