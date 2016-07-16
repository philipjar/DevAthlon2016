package main.java.de.nullpointer.zauberei.ball;

public class ThrownQuaffleThread implements Runnable {

	ThrownQuaffle quaffle;

	public ThrownQuaffleThread(ThrownQuaffle quaffle) {
		this.quaffle = quaffle;
	}

	@Override
	public void run() {
		
		while(!quaffle.isOnGround()) {
			
			
			try { Thread.sleep(1); } catch (InterruptedException e) { e.getMessage(); } 
			
		}
		quaffle.remove();

	}

}
