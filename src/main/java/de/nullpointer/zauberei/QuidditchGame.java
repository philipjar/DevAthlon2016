package main.java.de.nullpointer.zauberei;

import java.util.ArrayList;
import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import main.java.de.nullpointer.zauberei.ball.QuidditchBall;
import main.java.de.nullpointer.zauberei.team.QuidditchPlayer;
import main.java.de.nullpointer.zauberei.team.QuidditchTeam;

public class QuidditchGame {
	
	public enum Gamestate {
		READY, 
		STARTED,
		STOPPED
	}
	
	private Gamestate gamestate = Gamestate.READY;
	
	private JavaPlugin plugin;
	
	protected QuidditchTeam teamA;
	protected QuidditchTeam teamB;
	
	protected QuidditchBall ball;

	private Location middle;
	
	private QuidditchThread thread;
	
	public QuidditchGame(JavaPlugin plugin) {
		
		this.middle = ConfigManager.getMiddleLocation();
		this.plugin = plugin;
		this.middle = middle;
		
	}
	
	public Gamestate getGamestate() {
		return this.gamestate;
	}
	
	public void setGamestate(Gamestate state) {
		this.gamestate = state;
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
		
		// Teleport
		for (QuidditchPlayer qp : getAllPlayers()) {
			qp.getPlayer().teleport(middle);
		}
		

		thread = new QuidditchThread(this);
		plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, thread, 0L, 2L);
		
		setGamestate(Gamestate.STARTED);
	}
	
	public void stop(String name, ChatColor c) {
		thread.halt();
 			Bukkit.broadcastMessage("Team " + c + " gewinnt dieses Quidditch-Match" + ChatColor.RESET);
		for (QuidditchPlayer p : getAllPlayers()) {
			p.removeBroom();
		}
		setGamestate(Gamestate.STOPPED);
	}
	
	public ArrayList<QuidditchPlayer> getAllPlayers() {
		ArrayList<QuidditchPlayer> out = teamA.getPlayers();
		out.addAll(teamB.getPlayers());
		return out;
	}

}
