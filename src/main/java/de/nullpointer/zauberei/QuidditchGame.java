package main.java.de.nullpointer.zauberei;

import java.util.ArrayList;
import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import main.java.de.nullpointer.zauberei.ball.QuidditchBall;
import main.java.de.nullpointer.zauberei.team.QuidditchPlayer;
import main.java.de.nullpointer.zauberei.team.QuidditchTeam;

public class QuidditchGame {
	
	private JavaPlugin plugin;
	
	protected QuidditchTeam teamA;
	protected QuidditchTeam teamB;
	
	protected QuidditchBall ball;

	private Location middle;
	
	public QuidditchGame(JavaPlugin plugin, Location middle, Location[] gatesA,
			Location[] gatesB, Player... players) {
		
		this.plugin = plugin;
		this.middle = middle;
		
	}
	
	public void start() {
		boolean a = true;
		ArrayList<Player> teamListA = new ArrayList<>();
		ArrayList<Player> teamListB = new ArrayList<>();
		Iterator<? extends Player> playerIterator = Bukkit.getServer().getOnlinePlayers().iterator();
		
		for (; playerIterator.hasNext();) {
			if (a) {
				teamListA.add(playerIterator.next());
			} else {
				teamListB.add(playerIterator.next());
			}
			a = !a;
		}
		
		
		teamA = new QuidditchTeam("RED", teamListA);
		teamB = new QuidditchTeam("BLUE", teamListA);
		
		for (QuidditchPlayer qp : getAllPlayers()) {
			qp.getPlayer().teleport(middle);
		}
		
		plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new QuidditchThread(this), 0L, 2L);
	}
	
	public ArrayList<QuidditchPlayer> getAllPlayers() {
		ArrayList<QuidditchPlayer> out = teamA.getPlayers();
		out.addAll(teamB.getPlayers());
		return out;
	}

}
