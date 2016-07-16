package main.java.de.nullpointer.zauberei.team;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.entity.Player;

public class QuidditchTeam {
	
	private String teamname;
	private int points = 0;
	
	private ArrayList<QuidditchPlayer> players = new ArrayList<>();
	
	public static Random random = new Random();
	
	public QuidditchTeam(String name, ArrayList<Player> players) {
		
		teamname = name;
		for (Player p : players) {
			this.players.add(new QuidditchPlayer(p, this));
		}
		
	}
	
	public String getName() {
		return teamname;
	}
	
	public void addGoalPoints() {
		points = points + 10;
	}
	
	public int getPoints() {
		return points;
	}
	
	public ArrayList<QuidditchPlayer> getPlayers() {
		return players;
	}
	
	public QuidditchPlayer getRandomPlayer() {
		if (players.size() < 2) return players.get(0);
		return players.get(random.nextInt(players.size()));
	}

}
