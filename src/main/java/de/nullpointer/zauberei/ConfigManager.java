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
	
	

}
