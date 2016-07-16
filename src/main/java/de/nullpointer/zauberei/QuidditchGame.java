package main.java.de.nullpointer.zauberei;

import java.util.Arrays;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import main.java.de.nullpointer.zauberei.ball.QuidditchBall;
import main.java.de.nullpointer.zauberei.team.QuidditchTeam;

public class QuidditchGame {
	
	private JavaPlugin plugin;
	
	protected QuidditchTeam teamA;
	protected QuidditchTeam teamB;
	
	protected QuidditchBall snitch;
	protected QuidditchBall quaffle;
	protected QuidditchBall bludgerA;
	protected QuidditchBall bludgerB;
	
	public QuidditchGame(JavaPlugin plugin, Location middle, Location[] gatesA,
			Location[] gatesB, Player... players) {
		
		if (players.length != 14) {
			System.out.println("Inkorrekte Spieleranzahl: " + String.valueOf(players.length));
			return;
		}
		
		this.plugin = plugin;
		
		Player[] teamListA = new Player[7];
		Player[] teamListB = new Player[7];
		for (int i = 0; i < 14; i++) {
			if (i < 7)
				teamListA[i] = players[i];
			else
				teamListB[i-7] = players[i];
		}
		teamA = new QuidditchTeam("RED", teamListA);
		teamB = new QuidditchTeam("BLUE", teamListA);
		
	}
	
	public void start() {
		plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new QuidditchThread(this), 0L, 2L);
	}

}
