package main.java.de.nullpointer.zauberei.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import main.java.de.nullpointer.zauberei.Main;
import main.java.de.nullpointer.zauberei.ball.ThrownQuaffle;

public class BallEvents implements Listener {
	
	public BallEvents(Main plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerThrow(PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_AIR | e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			Player p = e.getPlayer();
			Material itemInHand = p.getItemInHand().getType();

			if (itemInHand == Material.REDSTONE_BLOCK) { // Quaffle

				p.getInventory().remove(p.getItemInHand());

				ThrownQuaffle quaffle = new ThrownQuaffle(p);

			}
		}
	}

}
