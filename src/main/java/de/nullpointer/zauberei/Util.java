package main.java.de.nullpointer.zauberei;

import org.bukkit.Location;

public class Util {
	
	public static boolean isNearTo(Location a, Location b, int range) {
		int xA = a.getBlockX();
		int yA = a.getBlockY();
		int zA = a.getBlockZ();
		
		int xB = b.getBlockX();
		int yB = b.getBlockY();
		int zB = b.getBlockZ();
		
		if ((xA > (xB - (range/2)) && xA < (xB + (range/2))) &&
				((yA > (yB - (range/2)) && yA < (yB + (range/2)))) &&
						((zA > (zB - (range/2)) && zA < (zB + (range/2)))))
		{
			return true;				
		} else {
			return false;
		}
		
	}
	
	public static boolean isNearTo(Location a, Location b) {
		return isNearTo(a, b, 2);
	}

}
