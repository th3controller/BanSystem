package us.th3controller.bansystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.th3controller.bansystem.FileSystem;

public class CmdTempBan implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			if(sender.hasPermission("bansystem.tempban")) {
				if(args.length >= 2) {
					Player target = Bukkit.getServer().getPlayer(args[0]);
					String reason = new String();
					for (int i = 1; i < args.length; i++) {
						reason = reason + " " + args[i];
					}
					FileSystem.banlist.set("banned."+args[0].toLowerCase()+".reason", reason);
					FileSystem.banlist.set("banned."+args[0].toLowerCase()+".issuer", sender.getName());
					FileSystem.saveBan();
					sender.sendMessage(args[0]+" has been banned. Reason:"+reason);
					if(target != null) {
						target.kickPlayer("You have been banned, reason:"+reason);
					}
				}
				else if(args.length == 1) {
					Player target = Bukkit.getServer().getPlayer(args[0]);
					FileSystem.banlist.set("banned."+args[0].toLowerCase()+".reason", "Undefined");
					FileSystem.banlist.set("banned."+args[0].toLowerCase()+".issuer", sender.getName());
					FileSystem.saveBan();
					sender.sendMessage(args[0]+" has been banned. Reason: Undefined");
					if(target != null) {
						target.kickPlayer("You have been banned, reason: Undefined");
					}
				}
				else if(args.length == 0) {
					return false;
				}
			}
		} else {
			
		}
		return true;
	}
}
