import java.util.*;
import java.io.*;

public class Receiver{
    public static void main(String[]args)throws Exception{
        ObjectInputStream in =new ObjectInputStream(new FileInputStream("persons"));
        HashMap persons = (HashMap)in.readObject();
        in.close();

        // Set<String> keySet = persons.keySet();
        Collection<HashMap<String,Object>> value=persons.values();
        int sum =0;
        for(HashMap p : value){
            int age = (int)p.get("age");
            System.out.println(p.get("name")+":"+age);
            sum = sum + age;
        }
        System.out.println("평균나이"+(double)sum/value.size());
    }
}