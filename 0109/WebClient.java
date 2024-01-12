import java.net.*;
import java.io.*;

public class WebClient{
    public static void main(String[]args)throws Exception{
        URL url=new URL("http://192.168.54.74/attach/GetImage?kind=3"); 
        //get으로 body없이 보내는방법 ?원하는값=... 추가
        //여러개를 보낼때는 &사용 예시(?kind=1&level=1)   더 많은 값을 보낼때는 POST이용  
        //kind=1 을 Parameter로받으면 .문자열임
        InputStream in =url.openStream();

        byte[] data=new byte[1024*8];
        int size;
        while((size=in.read(data))!=-1){
            System.out.println(new String(data,0,size,"utf-8"));
        }
    }
}