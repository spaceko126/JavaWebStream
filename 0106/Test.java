public class Test {
	public static void main(String[] args) throws Exception {

		MyEvent eventListener =new MyEventListener(); 		//new를 4개 각각 만들어주는것보다
		Thread thread1 = new MyThread("Thread1",1, eventListener());
		MyThread thread2 = new MyThread(11, eventListener());
		MyThread thread3 = new MyThread("Thread3", eventListener());
		MyThread thread4 = new MyThread(eventListener());

		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();	
	}
}
// 새로운 클래스 선언 MyEventListener
class MyEventListener implements MyEvent{	//MyEvent.java를  import 함 
	public synchronized void Half(String name) {			//synchronized 지금 half를 실행하고있을때 다른 thread를 멈춰라
		System.out.println("********************");
		System.out.println(name+"이(가)절반이 실행되었습니다");
		System.out.println("********************");
	}
	public void Complete(String name) {
		System.out.println("********************");
		System.out.println(name+"이(가) 실행 완료 되었습니다");
		System.out.println("********************");
	}
}