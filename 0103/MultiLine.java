import java.io.*;
public class MultiLine{
    public static void main(String[]args)throws Exception{
        BufferedReader keyIn =new BufferedReader(new InputStreamReader(System.in));
        String data="";
        PrintStream out =new PrintStream(System.out );
        PrintStream out2 =new PrintStream("MultiLine.txt");
        while(!(data=keyIn.readLine()).equals("quit")){
            out.println(data);
            out2.println(data);

        }
        BufferedReader Out = new BufferedReader((new FileReader("MultiLine.txt")));
        while((data=Out.readLine())!=null){
            out.println(data);

        }

    }
}