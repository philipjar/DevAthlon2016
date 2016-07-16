package main.java.de.nullpointer.zauberei;

import org.bukkit.Bukkit;

import main.java.de.nullpointer.zauberei.team.QuidditchTeam;

public class QuidditchThread implements Runnable {
	
	private QuidditchGame game;
	private int countdown = 5;
	
	public QuidditchThread(QuidditchGame game) {
		this.game = game;
	}

	@Override
	public void run() {
		
		while (countdown > 0) {
			Bukkit.broadcastMessage(String.valueOf(countdown));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		// LOS
		
		// Random ball geben
		if (QuidditchTeam.random.nextBoolean()) {
			game.teamA.getRandomPlayer().giveQuaffle();
		} else {
			game.teamB.getRandomPlayer().giveQuaffle();
		}
	}

}
