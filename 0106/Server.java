import java.net.*;

public class Server{
    public static void main(String[]args)throws Exception{
        ServerSocket seversocket =new ServerSocket(2000);
        ServerSocket seversocket2 =new ServerSocket(1000);

        while (true){
            Socket socket =seversocket.accept();
            FileTransferThread thread=new FileTransferThread(socket);
            thread.start();
            Socket socket2 =seversocket2.accept();
            FileTransferThread thread2=new FileTransferThread2(socket2);
            thread2.start();
        }
        
    }
}