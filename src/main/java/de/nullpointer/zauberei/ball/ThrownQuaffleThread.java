package main.java.de.nullpointer.zauberei.ball;

import main.java.de.nullpointer.zauberei.ConfigManager;
import main.java.de.nullpointer.zauberei.Main;
import main.java.de.nullpointer.zauberei.Util;
import main.java.de.nullpointer.zauberei.team.QuidditchPlayer;

public class ThrownQuaffleThread implements Runnable {

	ThrownQuaffle quaffle;

	public ThrownQuaffleThread(ThrownQuaffle quaffle) {
		this.quaffle = quaffle;
	}

	@Override
	public void run() {
		
		while(!quaffle.isOnGround()) {
			
			for (QuidditchPlayer qp: Main.game.getAllPlayers()) {
				if (Util.isNearTo(qp.getPlayer().getEyeLocation(), quaffle.getLocation(), 2)) {
					quaffle.remove();
					qp.giveQuaffle();
				}
			}
			
			/*
			 * 
			 * Check for goal hit --> Call goal
			 * 
			 */
			
			try { Thread.sleep(1); } catch (InterruptedException e) { e.getMessage(); } 
			
		}
		quaffle.remove();

	}

}
