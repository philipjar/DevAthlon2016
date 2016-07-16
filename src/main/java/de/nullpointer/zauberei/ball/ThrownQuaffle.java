package main.java.de.nullpointer.zauberei.ball;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ThrownQuaffle {

	Item item;
	Player thrower;

	public ThrownQuaffle(Player thrower) {

		item = thrower.getWorld().dropItem(thrower.getLocation(), new ItemStack(Material.REDSTONE_BLOCK));
		item.setVelocity(thrower.getLocation().getDirection().multiply(2.0D));
		
		new ThrownQuaffleThread(this);

	}

	public Location getLocation() {
		return item.getLocation();
	}
	
	public boolean isOnGround() {
		return item.isOnGround();
	}
	
	public void remove() {
		item.remove();
	}

}
