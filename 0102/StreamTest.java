import java.io.*;
public class StreamTest{
    public static void main(String[]args) throws Exception{
        FileInputStream fileIn = new FileInputStream("1.png");
        PrintStream out = new PrintStream("2.png");
        byte[] data=new byte[1024*8];
        int size;

        while((size=fileIn.read(data))!=-1){
            out.write(data,0,size);
            out.flush();
        }
        fileIn.close();
        out.close();
    }

}