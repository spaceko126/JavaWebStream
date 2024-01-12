import java.util.*;
import java.io.*;
import java.net.*;
import java.lang.reflect.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;

public class Receiver{
    public static void main(String[]args)throws Exception{
        Socket socket= new Socket("192.168.54.74",3000);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String jsonString =in.readLine();
        System.out.println(jsonString);
        socket.close();

        Gson gson=new Gson();
        Type type= new TypeToken <HashMap<String,HashMap<String,Object>>>(){}.getType();
        HashMap<String,HashMap<String,Object>> persons =gson.fromJson(jsonString,type);     //fromJson 은 json으로 받을때 사용

        Collection<HashMap<String,Object>> value =persons.values();

        int sum=0;
        for(HashMap<String,Object> p : value){
            int age =(int)((Double)p.get("age")).intValue();    //맵핑할때 double로 받음 숫자계산 할떄 주의!!!
            System.out.println(p.get("name")+":"+age);
            sum=sum+age;
        } 
        System.out.println("평균나이:"+(double)sum/value.size());

}
}
// MVNREPOSITORY 사이트 - gson 검색 - 2.9.0 파일 - json 다운 - gson.json파일을 (java-jdk-jre-lib-ext에 저장)