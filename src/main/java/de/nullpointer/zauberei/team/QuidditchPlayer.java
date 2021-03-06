package main.java.de.nullpointer.zauberei.team;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Vehicle;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class QuidditchPlayer {
	
	protected static Material[] items = new Material[]{
			Material.COMPASS,
			Material.STICK
	};
	
	private Player player;
	private QuidditchTeam team;
	
	private Vehicle broom;
	
	public QuidditchPlayer(Player player, QuidditchTeam team) {
		this.player = player;
		this.team = team;
		fillInventory();
	}
	
	public void fillInventory() {
		Inventory inv = player.getInventory();
		inv.clear();
		for (Material m : items) {
			ItemStack item = new ItemStack(m);
			if (m == Material.COMPASS)
				item.getItemMeta().setDisplayName("Sucher");
			if (m == Material.STICK)
				item.getItemMeta().setDisplayName("Aktiviere/Deaktiviere Hovermode");
			inv.addItem(item);
		}
		player.updateInventory();
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public QuidditchTeam getTeam() {
		return team;
	}
	
	public void giveBroom() {
		broom = (Vehicle) player.getWorld().spawnEntity(player.getLocation(), EntityType.BOAT);
		broom.setGravity(false);
		broom.setPassenger(player);
	}
	
	public void removeBroom() {
		broom.eject();
		broom.remove();
	}

	public void giveQuaffle() {
		ItemStack item = new ItemStack(Material.REDSTONE_BLOCK);
		item.getItemMeta().setDisplayName("Quaffel");
		player.getInventory().addItem(item);
		player.updateInventory();
	}

}
