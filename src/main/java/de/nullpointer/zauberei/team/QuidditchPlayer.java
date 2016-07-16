package main.java.de.nullpointer.zauberei.team;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class QuidditchPlayer {
	
	protected static Material[] items = new Material[]{
			Material.COMPASS,
			Material.STICK
	};
	
	private Player player;
	private QuidditchTeam team;
	
	public QuidditchPlayer(Player player, QuidditchTeam team) {
		this.player = player;
		this.team = team;
		fillInventory();
	}
	
	public void fillInventory() {
		Inventory inv = player.getInventory();
		inv.clear();
		for (Material m : items) {
			inv.addItem(new ItemStack(m));
		}
		player.updateInventory();
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public QuidditchTeam getTeam() {
		return team;
	}

	public void giveQuaffle() {
		ItemStack item = new ItemStack(Material.REDSTONE_BLOCK);
		item.getItemMeta().setDisplayName("Quaffel");
		player.getInventory().addItem(item);
		player.updateInventory();
	}

}
