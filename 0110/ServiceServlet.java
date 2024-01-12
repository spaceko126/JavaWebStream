import java.util.*;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;

@WebServlet("/Multipart")
@MultipartConfig        //multipart를 쓸려면 꼭 필요함 
public class ServiceServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        String path = request.getServletContext().getRealPath("/") + "image/";  
        String path2 = request.getServletContext().getRealPath("/"); 
        String message = "파일전송 실패";
        String name = request.getParameter("name");
        String address=request.getParameter("address");
        String age=request.getParameter("age");
        String Log=name+"/"+address+"/"+age ;
        Collection<Part> parts = request.getParts();    //getParts()를 쓰면 배열로 받음     
        //반복문에서 각각파트에서 inputstream을 가져온다
        for (Part part : parts) {
            System.out.println("part name=" + part.getName() + "=>" + getString(part.getInputStream()));
            if (part.getName().equals("file1")) {
                FileOutputStream fileout = new FileOutputStream(path +UUID.randomUUID().toString()+ ".jpg");    //UUID 랜덤함수 파일이름이 중복되면 덮어씌어지기때문에 파일이름을 랜덤으로 돌릴수있게 해줌
                FileOutputStream fileout2 =new FileOutputStream(path2+"Log.txt");
                InputStream in = part.getInputStream();
                byte[] data = new byte[1024 * 8];
                int size;

                while ((size = in.read(data)) != -1) {
                    fileout.write(data, 0, size);
                    fileout.flush();
                    fileout.write(data,0,size);
                    fileout.flush();
                }
                fileout.close();
                fileout2.close();
                message = "파일전송 성공";
            }
        }

        OutputStream out = response.getOutputStream();
        out.write(message.getBytes("utf-8"));
        out.close();
    }

    private String getString(InputStream in) {      //file1말고 다른 String 타입들을 private String getString 으로 쓰면 기존 추가하는것보다 더빠르게 읽을수있음 
    byte[] data = new byte[1024 * 8];
    int size;
    StringBuilder strBuilder = new StringBuilder();

    try {
        while ((size = in.read(data)) != -1) {
            strBuilder.append(new String(data, 0, size, "utf-8"));
        }
    } catch (Exception e) {}
    return strBuilder.toString();
}
}

//webapps -attach2 파일 생성-image 파일 생성
//attach2 파일안에 WEB-INF파일(서블릿.class)과 form.html 파일을 넣어놔야함
// form.html ->>38줄  fileUpload라는 button이 oneclick 되면 submitContents 함수가 실행 7번줄의함수 실행 http://192.168.54.74/attach2/Multipart  이곳에 저장 
// form.html 파일 이름을 index.html로 바꾸면 주소를 http://192.168.54.74/attach2/ 이렇게만 해도 서버에서받아서함
