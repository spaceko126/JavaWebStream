import java.io.*;

public class HelloWorld {
    public static void main (String[] args)throws Exception {
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader in = new BufferedReader(new InputStreamReader (new FileInputStream("test.txt")));
        String data=in.readLine();
        byte [] byteData=data.getBytes("utf-8");

        PrintStream out =new PrintStream(System.out );
        // PrintStream out2 =new PrintStream("test2.txt");
        out.write(byteData);
        // out2.println(data);
        // System.out.println("자바수업시간입니다.");
    }
}

// javac -encoding utf-8 StreamTest.java
// java StreamTest