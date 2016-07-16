package main.java.de.nullpointer.zauberei.team;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class QuidditchTeam {
	
	private String teamname;
	
	private ArrayList<QuidditchPlayer> players = new ArrayList<>();
	
	public QuidditchTeam(String name, ArrayList<Player> players) {
		
		teamname = name;
		for (Player p : players) {
			this.players.add(new QuidditchPlayer(p, this));
		}
		
	}
	
	public String getName() {
		return teamname;
	}
	
	public ArrayList<Player> getPlayers() {
		ArrayList<Player> out = new ArrayList<>();
		for (QuidditchPlayer qp : players) {
			out.add(qp.getPlayer());
		}
		return out;
	}

}
