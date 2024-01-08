public class Thread2 extends Thread {
    public void run(){
        try{
            for(int i=11;i<=20;i++){
            System.out.println("Thread2에서 실행되는 코드=>"+i);
            Thread.sleep(400);
        }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}