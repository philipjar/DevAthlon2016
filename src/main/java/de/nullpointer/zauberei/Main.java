package main.java.de.nullpointer.zauberei;

import org.bukkit.plugin.java.JavaPlugin;

import main.java.de.nullpointer.zauberei.events.BallEvents;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		new BallEvents(this);
	}

}
