package main.java.de.nullpointer.zauberei.team;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_10_R1.CraftServer;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class QuidditchPlayer extends CraftPlayer {
	
	public enum Playertype {
		BEATER, CHASER, SEEKER, KEEPER
	};
	
	protected static Material[] items = new Material[]{
			Material.COMPASS,
			Material.STICK
	};
	
	private Playertype type;
	private QuidditchTeam team;
	
	public QuidditchPlayer(Player player, Playertype type, QuidditchTeam team) {
		super((CraftServer) Bukkit.getServer(), ((CraftPlayer) player).getHandle());
		this.type = type;
		this.team = team;
	}
	
	public void fillInventory() {
		Inventory inv = getInventory();
		inv.clear();
		for (Material m : items) {
			inv.addItem(new ItemStack(m));
		}
	}
	
	public Playertype getQuidditchType() {
		return type;
	}
	
	public QuidditchTeam getTeam() {
		return team;
	}

}
