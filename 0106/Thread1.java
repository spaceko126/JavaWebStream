public class Thread1 extends Thread {
    public void run(){
        try{
            for(int i=1;i<=10;i++){
            System.out.println("Thread1에서 실행되는 코드=>"+i);
            Thread.sleep(500);
        }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}