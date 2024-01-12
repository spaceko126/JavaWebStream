import java.net.*;
import java.io.*;
import java.util.*;
import java.lang.reflect.*;

public class WebClient{
    public static void main(String[]args)throws Exception{
        Socket socket =new Socket("192.168.54.74",80);

        PrintStream out= new PrintStream (socket.getOutputStream());
        // out.println("GET / HTTP/1.1"); 
        out.println("GET /hello/HelloWorld HTTP/1.1");     // Root 파일에 name.html 파일을 열고 싶을때   특정 파일을 열고싶을때
        out.println("Host: 192.168.54.74");     //구글할때는 호스트 빼야함   웹서버마다 다름 
        out.println("Connection: close");
        out.println();
        
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));       //받는 타입그대로 사용
        String jsonString ="";
        while((jsonString = in.readLine())!=null){
            System.out.println(jsonString);
        }   

        // FileOutputStream fileout = new FileOutputStream("HelloWorld.html");   //html파일로 저장

        // byte[] data=new byte[1024*8];
        // int size;

        // while((size=in.read(data))!=-1){
        //     System.out.println(new String(data,0,size,"utf-8"));
        //     fileout.write(data,0,size);
        //     fileout.flush();
        // }
        // fileout.close();


    }
} 
//  header에 뭘 요구하는지 적어야함 
//  클라이언트에 "GET / HTTP/1.1" 적어서  서버에 보내줘야함
//  톰캣파일 - webapps - ROOT - 안에 index.html 생성  기본주소 80포트로 연결시 사이트에 뜸

