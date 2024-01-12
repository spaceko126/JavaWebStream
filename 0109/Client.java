import java.io.*;
import java.net.*;

public class Client{
    public static void main(String[]args)throws Exception{
        //Header
        URL url=new URL("http://192.168.54.71/attach2/form.html");
        HttpURLConnection conn=(HttpURLConnection)url.openConnection();
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        // conn.setRequestProperty("Content-Type","application/json; charset-utf-8");   //Json파일 보낼때 사용      텍스트파일 보낼때 ->  text/html/; charset-utf-8
        conn.setRequestProperty("Content-Type","application/octet-stream");        //바이너리 파일 보낼때 사용      Content-Type 바디에 어떤 타입인지 지정
        //여러개 타입을 보낼때 body 파트를 나누어서 사용   Content-Tpye:multipart/form-data; boundary =abc123             bounday-> 파트 구분자


        //body
        // OutputStream out =conn.getOutputStream();
        // String jsonString ="{\"name\":\"이방원\",\"address\":\"여수시\",\"age\":20}";
        // out.write(jsonString.getBytes("utf-8"));
        // out.flush();

        // InputStream in =conn.getInputStream();
        // byte[] data = new byte[1024*8];
        // int size;
        // while((size=in.read(data))!=-1){
        //     System.out.println(new String(data,0,size,"utf-8"));
        // }


        //이미지 보내기
        // FileInputStream fileIn = new FileInputStream("1.png");
        // OutputStream fileOut = conn.getOutputStream();

        // byte[] data = new byte[1024 * 8];
        // int size;
        // while ((size = fileIn.read(data)) != -1) {
        //     fileOut.write(data, 0, size);
        //     fileOut.flush();
        // }
        // fileIn.close();
        // InputStream in =conn.getInputStream();
        // while((size=in.read(data))!=-1){
        //     System.out.println(new String(data,0,size,"utf-8"));
        // }
        

        //이미지 받기
        InputStream fileIn = conn.getInputStream();
        FileOutputStream fileOut = new FileOutputStream("from.html");
        byte[] data = new byte[1024 * 8];
        int size;
        while ((size = fileIn.read(data)) != -1) {
            fileOut.write(data, 0, size);
            fileOut.flush();
        }
        fileIn.close();
        fileOut.close();
    }
}