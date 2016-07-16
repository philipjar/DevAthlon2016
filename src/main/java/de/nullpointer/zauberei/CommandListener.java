package main.java.de.nullpointer.zauberei;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandListener implements CommandExecutor {

	public Main plugin;

	public CommandListener(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("quiddich")) {
			if (args.length >= 1) {
				
				if(args[0].equalsIgnoreCase("start")) {
					// Start game
					sender.sendMessage("Spiel wurde gestartet! ");
					return true;
				}
				
				if(args[0].equalsIgnoreCase("stop")) {
					// Stop game
					sender.sendMessage("Spiel gestoppt");
					return true;
				}
				
			} else {
				// Help
			}
		}
		return false;
	}

}
