package main.java.de.nullpointer.zauberei.events;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class BallEvents implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerThrow(PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_AIR | e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			Player p = e.getPlayer();
			Material itemInHand = p.getItemInHand().getType();

			if (itemInHand == Material.REDSTONE_BLOCK) { // Quaffle

				p.getInventory().remove(p.getItemInHand());

				Item quaffle = p.getWorld().dropItem(p.getEyeLocation(), new ItemStack(Material.REDSTONE_BLOCK));

				quaffle.setVelocity(p.getLocation().getDirection().multiply(2.0D));

			}
		}
	}

}
