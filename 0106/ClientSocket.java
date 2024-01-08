import java.net.*;
import java.io.*;

public class ClientSocket {
    public static void main(String[]args)throws Exception{

        Socket socket =new Socket("192.168.54.74",2000);
        Socket socket2 =new Socket("192.168.54.74",1000);

        DataInputStream fileIn = new DataInputStream(socket.getInputStream()); //파일 받기
        FileOutputStream fileout =new FileOutputStream("2.exe"); //파일 다운로드
        BufferedReader in =new BufferedReader(new InputStreamReader(System.in)); //키보드 입력
        PrintStream out =new PrintStream(socket2.getOutputStream());  //서버로 입력값 보내기
        BufferedReader in2 =new BufferedReader(new InputStreamReader(socket2.getInputStream())); //서버에서 입력값 받기
        PrintStream out2 =new PrintStream(System.out);  //입력값 출력

        byte[] data=new byte[1024*8];
        int size;
        String message="";
        String message2="";

        while((size=fileIn.read(data))!=-1){
            fileout.write(data,0,size);
            fileout.flush();
        }
        while(!(message=in.readLine()).equals("quit")){
            out.println(message);
            message2=in2.readLine();
            out2.println(message2);
        }
        out.println(message);

        fileIn.close();
        socket.close();
    }
}