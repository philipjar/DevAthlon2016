package main.java.de.nullpointer.zauberei;

import org.bukkit.plugin.java.JavaPlugin;

import main.java.de.nullpointer.zauberei.events.BallEvents;
import main.java.de.nullpointer.zauberei.events.FlyEvents;
import main.java.de.nullpointer.zauberei.events.InteractEvents;

public class Main extends JavaPlugin {

	CommandListener cListener;
	QuidditchGame game;

	@Override
	public void onEnable() {
		
		new BallEvents(this);
		new FlyEvents(this);
		new InteractEvents(this);

		cListener = new CommandListener(this);
		getCommand("quiddich").setExecutor(cListener);

	}

}
