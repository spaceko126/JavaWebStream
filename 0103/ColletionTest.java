import java.util.*;

public class ColletionTest{
    public static void main(String[]args) throws Exception{
        HashMap<String,Object> map = new HashMap<>();
        map.put("name","kim");
        map.put("address","gimhae");
        map.put("age",20);

        map.put("name","lee");

        System.out.println(map.get("name"));
        System.out.println(map.get("age"));

        ArrayList<Object>array=new ArrayList<>();
        ArrayList<HashMap<String,String>> array2=new ArrayList<>();
        array2.get(3).get("name");
        array.add("kim");
        array.add(20);
        // array.add(map);
        // map.put("array",array);
        // // System.out.println(array.get(0));

        // // HashMap map2=(HashMap)array.get(2);
        // System.out.println(map2.get("name"));
    }
}