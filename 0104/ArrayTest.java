import java.util.*;

public class ArrayTest{
    public static void main(String[]args)throws Exception{
        HashMap<String,Object> person = new HashMap<>();
        ArrayList<HashMap<String,Object>> persons=new ArrayList<>();
        person.put("name","이순신");
        person.put("address","여수시");
        person.put("age",20);
        persons.add(person);

        person =new HashMap<>();
        person.put("name","이방원");
        person.put("address","한양시");
        person.put("age",30);
        persons.add(person);

        person =new HashMap<>();
        person.put("name","이도");
        person.put("address","서울시");
        person.put("age",42);
        persons.add(person);

        // HashMap<String,Object> person2 = new HashMap<>();
        // person2.put("name","이방원");
        // person2.put("address","한양시");
        // person2.put("age",30);

        // HashMap<String,Object> person3 = new HashMap<>();
        // person3.put("name","이도");
        // person3.put("address","서울시");
        // person3.put("age",42);

        // persons.add(person);
        // persons.add(person2);
        // persons.add(person3);

        int av=0;
        for(int i=0;i<persons.size(); i++){
            System.out.println(persons.get(i)); // .toString 이 생략되어있음
            av +=  (int)persons.get(i).get("age");
            // (integer)persons.get(1).get("age")).intValue();
            
        }
        
        System.out.println((double)av/person.size()); // 실수를 계산할려면 둘중하나를 실수로 만들어줘야한다
            

        
        
    }
}