import java.net.*;
import java.io.*;

public class Client{
    public static void main(String[]args)throws Exception{
        String qureytString =API에 맞게 넣기 "?&..=...."+"&..=...";
        URL url=new URL("API주소"+qureytString);

        InputStream in=url.openStream();
        byte[] data =new byte[1024*8];
        int size;
        while((size=in.read(data))!=-1)
            System.out.println(new String(data,0,size,"utf-8"));
        
        //Post로 받을떄
        HttpURLConnection conn=(HttpURLConnection)url.openConnection();
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type","application/x-ww-form-urlencoded; charset-utf-8");

        OutputStream out=conn.getOutputStream();
        out.write(qureyString.getBytes("utf-8"));
        out.flush();
        out.close();

        InputStream in =

    }
}