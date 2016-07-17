package main.java.de.nullpointer.zauberei.events;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleDamageEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.event.vehicle.VehicleMoveEvent;

import main.java.de.nullpointer.zauberei.Main;
import main.java.de.nullpointer.zauberei.QuidditchGame.Gamestate;
import main.java.de.nullpointer.zauberei.team.QuidditchPlayer;

public class FlyEvents implements Listener {

	public FlyEvents(Main plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onVehicleDrive(VehicleMoveEvent e) {
		if (Main.game.getGamestate() == Gamestate.STARTED) {
			if (e.getVehicle().getPassenger() instanceof Player) {
				Player p = (Player) e.getVehicle().getPassenger();
				if (p.getInventory().contains(Material.BLAZE_ROD)) {
					e.getVehicle().setGravity(false); // Perfomence!!!
					e.getVehicle().setVelocity(p.getLocation().getDirection().multiply(1.0D));
				}
			}
		}
	}

	@EventHandler
	public void onPlayerEject(VehicleExitEvent e) {
		if (Main.game.getGamestate() == Gamestate.STARTED & e.getVehicle().getType() == EntityType.BOAT) {
			if (e.getExited() instanceof Player) {
				Player p = (Player) e.getExited();
				for (QuidditchPlayer qp : Main.game.getAllPlayers()) {
					if (qp.getPlayer().getName().equalsIgnoreCase(p.getName())) {
						p.sendMessage("Du darfst deinen Besen nicht verlassen! ");
						e.setCancelled(true);
					}
				}
			}
		}
	}

	@EventHandler
	public void onDamageBoat(VehicleDamageEvent e) {
		if (Main.game.getGamestate() == Gamestate.STARTED & e.getVehicle().getType() == EntityType.BOAT) {
			if (e.getVehicle().getPassenger() != null) {
				if (e.getVehicle().getPassenger() instanceof Player) {
					Player p = (Player) e.getVehicle().getPassenger();
					for (QuidditchPlayer qp : Main.game.getAllPlayers()) {
						if (qp.getPlayer().getName().equalsIgnoreCase(p.getName())) {
							e.setCancelled(true);
						}
					}
				}
			}
		}
	}
}
