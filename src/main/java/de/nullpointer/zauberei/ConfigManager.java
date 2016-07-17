package main.java.de.nullpointer.zauberei;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

public class ConfigManager {
	
	public static JavaPlugin plugin;
	
	/* No time for serializable
	 * Form: location.middle.[x|y|z]
	 */
	public static Location getMiddleLocation() {
		String name = plugin.getConfig().getString("worldname");
		int x = plugin.getConfig().getInt("location.middle.x");
		int y = plugin.getConfig().getInt("location.middle.y");
		int z = plugin.getConfig().getInt("location.middle.z");
		return new Location(Bukkit.getWorld(name), x, y, z);
	}
	
	/* Form: location.gate.[a|b].[1|2|3].[x|y|z] */
	public static Location getGate(char team, int number) {
		String name = plugin.getConfig().getString("worldname");
		int x = plugin.getConfig().getInt("location.gate." + String.valueOf(team).toLowerCase() 
				+ "." + String.valueOf(number) + ".x");
		int y = plugin.getConfig().getInt("location.gate." + String.valueOf(team).toLowerCase()
				+ "." + String.valueOf(number) + ".y");
		int z = plugin.getConfig().getInt("location.gate." + String.valueOf(team).toLowerCase()
				+ "." + String.valueOf(number) + ".z");
		return new Location(Bukkit.getWorld(name), x, y, z);
	}
	
	public static int getWinningPoints() {
		return plugin.getConfig().getInt("winningpoints");
	}
	
	public static void setQuidditchWorldDefaults() {
		plugin.getConfig().addDefault("worldname", "Quidditch");
		plugin.getConfig().addDefault("winningpoints", 100);
		
		plugin.getConfig().addDefault("location.middle.x", 0);
		plugin.getConfig().addDefault("location.middle.y", 0);
		plugin.getConfig().addDefault("location.middle.z", 70);
		
		// Gate Locations
		plugin.getConfig().addDefault("location.gate.a.1.x", 0);
		plugin.getConfig().addDefault("location.gate.a.1.y", 77);
		plugin.getConfig().addDefault("location.gate.a.1.z", -69);
		
		plugin.getConfig().addDefault("location.gate.a.2.x", 8);
		plugin.getConfig().addDefault("location.gate.a.2.y", 73);
		plugin.getConfig().addDefault("location.gate.a.2.z", -69);
		
		plugin.getConfig().addDefault("location.gate.a.3.x", -7);
		plugin.getConfig().addDefault("location.gate.a.3.y", 69);
		plugin.getConfig().addDefault("location.gate.a.3.z", -69);
		
		
		plugin.getConfig().addDefault("location.gate.b.1.x", 0);
		plugin.getConfig().addDefault("location.gate.b.1.y", 77);
		plugin.getConfig().addDefault("location.gate.b.1.z", 70);
		
		plugin.getConfig().addDefault("location.gate.b.2.x", -7);
		plugin.getConfig().addDefault("location.gate.b.2.y", 73);
		plugin.getConfig().addDefault("location.gate.b.2.z", 70);
		
		plugin.getConfig().addDefault("location.gate.b.3.x", 8);
		plugin.getConfig().addDefault("location.gate.b.3.y", 69);
		plugin.getConfig().addDefault("location.gate.b.3.z", 70);
	}
	
	

}
