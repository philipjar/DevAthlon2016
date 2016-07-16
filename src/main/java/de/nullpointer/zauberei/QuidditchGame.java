package main.java.de.nullpointer.zauberei;

import java.util.Arrays;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import main.java.de.nullpointer.zauberei.team.QuidditchTeam;

public class QuidditchGame {
	
	private QuidditchTeam teamA;
	private QuidditchTeam teamB;
	
	public QuidditchGame(Location middle, Location[] gates, Player... players) {
		
		if (players.length != 14) {
			System.out.println("Inkorrekte Spieleranzahl: " + String.valueOf(players.length));
			return;
		}
		
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
		
	}

}
