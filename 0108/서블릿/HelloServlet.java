import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import com.google.gson.Gson;

@WebServlet("/HelloWorld")
public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  //  get은 파일을 보내주기만 post는 받기 주기 둘다가능
        response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter(); //     response =  클라이언트에게 보내기     request는 받기
        // out.println("안녕하세요 서블릿에서 보내는 Hello World입니다");

        HashMap<String,Object> person = new HashMap<>();
        HashMap<String,HashMap<String,Object>> persons = new HashMap<>();
        person.put("name","이순신");
        person.put("address","여수시");
        person.put("age",20);
        persons.put((String)person.get("name"),person);

        person =new HashMap<>();
        person.put("name","이방원");
        person.put("address","한양시");
        person.put("age",30);
        persons.put((String)person.get("name"),person);

        person =new HashMap<>();
        person.put("name","이도");
        person.put("address","서울시");
        person.put("age",42);
        persons.put((String)person.get("name"),person);

        Gson gson=new Gson();
        String jsonString=gson.toJson(persons);
        System.out.println(jsonString);

        out.println(jsonString);
    }
}

//  tomcat 9버전 64bite windows 설치
//  톰캣파일에 servlet api 복서해서 java-jdk-jre-lib-ext 에 저장  
//  톰캣 - webapps - hello - WEB-INF  생성  -classes 생성  - HelloServlet.class 파일 복사 해서 옮기기