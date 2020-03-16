package thread;

public class ThreadMinute  implements Runnable {
	
	@Override
	public void run() {
		try {
			//Thread.sleep(180000);
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
}
