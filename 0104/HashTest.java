import java.util.*;

public class HashTest{
    public static void main(String[]args)throws Exception{
        HashMap<String,Object> person = new HashMap<>();
        HashMap<String,HashMap<String,Object>> person2 = new HashMap<>();
        person.put("name","이순신");
        person.put("address","여수시");
        person.put("age",20);
        person2.put((String)person.get("name"),person);

        person =new HashMap<>();
        person.put("name","이방원");
        person.put("address","한양시");
        person.put("age",30);
        person2.put((String)person.get("name"),person);

        person =new HashMap<>();
        person.put("name","이도");
        person.put("address","서울시");
        person.put("age",42);
        person2.put((String)person.get("name"),person);

        Set<String> keySet = person2.keySet();
        // System.out.println(keySet.size());
        String[]keys=keySet.toArray(new String[0]);//String[0] 안에들어있는 원소만큼 사이즈 생성
        // System.out.println(keys.length);

        Collection<HashMap<String,Object>> value=person2.values();
        // HashMap[]values=value.toArray(new HashMap[0]);
        int sum =0;
        for(HashMap p : value){
            int age = (int)p.get("age");
            System.out.println(p.get("name")+":"+age);
            sum = sum + age;
        }


        // for(String key : keySet){
        //      HashMap p=person2.get(key);
        //     int age=(int)p.get("age");
        //     System.out.println(p.get("name")+":"+p.get("age"));
        //     sum +=age;
        // }

    //    for(int i=0;i<keys.length; i++){
    //         HashMap p=person2.get(keys[i]);
    //         int age=(int)p.get("age");
    //         System.out.println(p.get("name")+":"+p.get("age"));
    //         sum +=age;
    //     }
        System.out.println("평균나이"+(double)sum/value.size());
    }
}