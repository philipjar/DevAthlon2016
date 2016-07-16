package main.java.de.nullpointer.zauberei.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import main.java.de.nullpointer.zauberei.Main;

public class InteractEvents implements Listener {

	public InteractEvents(Main plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerClick(PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_AIR | e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			Player p = e.getPlayer();
			Material itemInHand = p.getItemInHand().getType();
			if (itemInHand == Material.BLAZE_ROD) {
				p.getItemInHand().setType(Material.STICK);
			} else if (itemInHand == Material.STICK) {
				p.getItemInHand().setType(Material.BLAZE_ROD);
			}
		}
	}

}
