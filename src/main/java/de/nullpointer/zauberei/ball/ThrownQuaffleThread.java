package main.java.de.nullpointer.zauberei.ball;

import java.util.ArrayList;

import org.bukkit.Location;

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
		
		Location a0 = ConfigManager.getGate('a', 1);
		Location a1 = ConfigManager.getGate('a', 2);
		Location a2 = ConfigManager.getGate('a', 3);
		Location b0 = ConfigManager.getGate('b', 1);
		Location b1 = ConfigManager.getGate('b', 2);
		Location b2 = ConfigManager.getGate('b', 3);
		
		ArrayList<Location> goalLocs = new ArrayList<>();
		goalLocs.add(a0);
		goalLocs.add(a1);
		goalLocs.add(a2);
		goalLocs.add(b0);
		goalLocs.add(b1);
		goalLocs.add(b2);
		
		while(!quaffle.isOnGround()) {
			
			for (QuidditchPlayer qp: Main.game.getAllPlayers()) {
				if (Util.isNearTo(qp.getPlayer().getEyeLocation(), quaffle.getLocation(), 2)) {
					quaffle.remove();
					qp.giveQuaffle();
					break;
				}
			}
			
			for (Location l : goalLocs) {
				if (Util.isNearTo(l, quaffle.getLocation(), 2));
			}
			
			try { Thread.sleep(1); } catch (InterruptedException e) { e.getMessage(); } 
			
		}
		quaffle.remove();

	}

}
