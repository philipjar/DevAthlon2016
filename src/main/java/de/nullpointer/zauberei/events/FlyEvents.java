package main.java.de.nullpointer.zauberei.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleMoveEvent;

import main.java.de.nullpointer.zauberei.Main;

public class FlyEvents implements Listener {
	
	public FlyEvents(Main plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onVehicleDrive(VehicleMoveEvent e) {
		if (e.getVehicle().getPassenger() instanceof Player) {
			Player p = (Player) e.getVehicle().getPassenger();
			if (p.getInventory().contains(Material.BLAZE_ROD)) {
				e.getVehicle().setGravity(false); // Perfomence!!!
				e.getVehicle().setVelocity(p.getLocation().getDirection().multiply(1.0D));
			}
		}
	}

}
