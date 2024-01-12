import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

// @WebServlet(urlPatterns = {"/SendJSON", "/GetImage"})
@WebServlet(urlPatterns = {"/SendImage", "/GetImage"})
public class ServiceServlet extends HttpServlet {
    //Client 에서 이미지파일 받기
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        InputStream fileIn = request.getInputStream();
        FileOutputStream fileout = new FileOutputStream("3.png");
        byte[] data = new byte[1024 * 8];
        int size;
        while ((size = fileIn.read(data)) != -1) {
            fileout.write(data, 0, size);
            fileout.flush();
        }
        fileout.close();

        PrintWriter out=response.getWriter();
        out.println("성공");
        out.close();
    }


    

    // protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
    //     request.setCharacterEncoding("utf-8");
    //     response.setContentType("text/html;charset=utf-8");

    //     InputStream in = request.getInputStream();
    //     OutputStream out = response.getOutputStream();
    //     byte[] data = new byte[1024 * 8];
    //     int size;
    //     while ((size = in.read(data)) != -1) {
    //         System.out.println(new String(data, 0, size, "utf-8"));
    //     }
    //     out.write("안녕하세요 서블릿에서 보내는 HelloWorld입니다".getBytes("utf-8"));
    //     out.flush();
    //     out.close();
    // }


    //이미지파일 보내기
    // WebClinet에서 값을 받아서 원하는 사진 보내기
    // protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //     response.setContentType("image/jpeg");

    //     String kind = request.getParameter("kind");   //webclient에서 kind=1이라고 주기때문에 값이 입력됨
    //     String level =request.getParameter("level");    //WebCLinet에서 &사용해 더많은 값을 받을수있음 

    //     FileInputStream fileIn = new FileInputStream(kind+".png");  //WebClient에서 kind=1을 받았으니 1.png를 불러옴
    //     OutputStream out = response.getOutputStream();

    //     byte[] data = new byte[1024 * 8];
    //     int size;
    //     while ((size = fileIn.read(data)) != -1) {
    //         out.write(data, 0, size);
    //         out.flush();
    //     }
    //     fileIn.close();
    //     out.close();
    // }
}
//  사진은 톰캣의 bin폴더에 저장