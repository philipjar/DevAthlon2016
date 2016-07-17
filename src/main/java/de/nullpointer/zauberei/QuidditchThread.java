package main.java.de.nullpointer.zauberei;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import main.java.de.nullpointer.zauberei.team.QuidditchPlayer;
import main.java.de.nullpointer.zauberei.team.QuidditchTeam;

public class QuidditchThread implements Runnable {
	
	private QuidditchGame game;
	private int countdown = 5;
	
	public QuidditchThread(QuidditchGame game) {
		this.game = game;
	}

	@Override
	public void run() {
		
		Bukkit.broadcastMessage(ChatColor.GREEN + "Willkommen bei Quidditch!");
		Bukkit.broadcastMessage(ChatColor.YELLOW + "Versucht, den Ball (Quaffel) in die gegnerischen Tore zu werfen!");
		Bukkit.broadcastMessage("Wie in Hogwarts fliegt ihr dabei auf verzauberten Besen.");
		Bukkit.broadcastMessage("Das Team, das zuerst " + String.valueOf(ConfigManager.getWinningPoints()) +
				" Punkte hat, gewinnt!" + ChatColor.RESET);
		
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
		
		for (QuidditchPlayer p : game.teamA.getPlayers()) {
			p.getPlayer().sendMessage("Du bist in Team " + ChatColor.RED + "A" + ChatColor.RESET);
		}
		
		for (QuidditchPlayer p : game.teamB.getPlayers()) {
			p.getPlayer().sendMessage("Du bist in Team " + ChatColor.BLUE + "A" + ChatColor.RESET);
		}
	}

}
