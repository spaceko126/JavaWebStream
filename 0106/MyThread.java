public class MyThread extends Thread {

    private String name;
    private int start;
    private MyEvent listener;

    public MyThread(MyEvent listener) {
        this.name="default";
        this.start=100;
        this.listener=listener;
    }

    public MyThread(String name,MyEvent listener) {
        this.name=name;
        this.start=100;
        this.listener=listener;
    }

    public MyThread(int start,MyEvent listener) {
        this.name="default";
        this.start=start;
        this.listener=listener;
    }

    public MyThread(String name, int start, MyEvent listener) {
        this.name=name;
        this.start=start;
        this.listener=listener;
    }

    public void run() {
        try{
            for(int i=this.start;i<this.start+10;i++) {
                System.out.println(this.name+" 에서 출력합니다=>"+i);
                sleep(300);
                if(i==this.start+4){
                    this.listener.Half(this.name);    //this.name을 추가하면 MyEvent와 Test 의 listen()메소드안에 추가해야한다
                }
                if(i==this.start+9){
                    this.listener.Complete(this.name);
                }
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}