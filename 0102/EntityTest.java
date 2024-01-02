import java.util.HashMap;
import java.io.*;
public class EntityTest{
    public static void main (String[] args)throws Exception{

        Person person=new Person();

        person.name ="Ko";
        person.tel = "0104195701";
        person.address = "inje";
        person.birth = "011128";

        HashMap<String,String> person3=new HashMap<>(); // HashMap<키,값>
        person3.put("name","lee");
        person3.put("tel","0105566555");
        person3.put("address","Gimhae");
        person3.put("birth","000911");

        // PrintStream out = new PrintStream("object.txt");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("object.txt"));
        out.writeObject(person);
        out.close();

        ObjectInputStream fileIn = new ObjectInputStream(new FileInputStream("object.txt"));
        Person p = (Person)fileIn.readObject();
        System.out.println(p.name);
        fileIn.close();

        // System.out.println(person.name);
        // System.out.println(person3.get("name"));

    }
}