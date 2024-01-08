import java.net.*;
import java.io.*;

public class FileTransferThread extends Thread{
    private Socket socket;
    private Socket socket2;
    public FileTransferThread(Socket socket){
        this.socket=socket;
        System.out.println(socket.getInetAddress().toString()+"다운로드 시작");  
    }
    public FileTransferThread(Socket socket2){
        this.socket2=socket2;
        System.out.println(socket2.getInetAddress().toString()+"채팅 시작");
    }
    public void run(){
        try{
            FileInputStream file = new FileInputStream("1.exe");
            OutputStream out = socket.getOutputStream();
            BufferedReader in =new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream out2 =new PrintStream(socket.getOutputStream());

            byte[] data=new byte[1024*8];
            int size;

            while((size=file.read(data))!=-1){
                out.write(data,0,size);
                out.flush();
            }
            while(!(message=in.readLine()).equals("quit")){
            message2 = message.concat(" from Server");
            out2.println(message2);
            }
            file.close();
            socket.close();
            System.out.println(socket.getInetAddress().toString()+"다운로드 완료");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    
    // public void run(){
    //     try{
    //         BufferedReader in =new BufferedReader(new InputStreamReader(socket.getInputStream()));
    //         PrintStream out2 =new PrintStream(socket.getOutputStream());

    //         while(!(message=in.readLine()).equals("quit")){
    //         message2 = message.concat(" from Server");
    //         out2.println(message2);
    //         }
    //         socket2.close();
    //         System.out.println(socket2.getInetAddress().toString()+"채팅 완료");
    //     }catch(Exception e){
    //         e.printStackTrace();
    //     }
    // }
}