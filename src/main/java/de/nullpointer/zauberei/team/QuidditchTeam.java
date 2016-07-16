package main.java.de.nullpointer.zauberei.team;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import main.java.de.nullpointer.zauberei.team.QuidditchPlayer.Playertype;

public class QuidditchTeam {
	
	private String teamname;
	
	private ArrayList<QuidditchPlayer> beaters = new ArrayList<>();
	private ArrayList<QuidditchPlayer> chasers = new ArrayList<>();
	private QuidditchPlayer keeper;
	private QuidditchPlayer seeker;
	
	public QuidditchTeam(String name, Player... players) {
		
		teamname = name;
		
		for (int i = 0; i < players.length; i++) {
			if (i <= 2)
				chasers.add(new QuidditchPlayer(players[i], Playertype.CHASER, this));
			else if (i > 2 && i <= 4)
				beaters.add(new QuidditchPlayer(players[i], Playertype.BEATER, this));
			else if (i == 5)
				keeper = new QuidditchPlayer(players[i], Playertype.KEEPER, this);
			else if (i == 6)
				seeker = new QuidditchPlayer(players[i], Playertype.SEEKER, this);
			
			else System.out.println("[INTERN] Zu viele Spieler im Team!");
						
		}
		
	}
	
	public String getName() {
		return teamname;
	}

}
