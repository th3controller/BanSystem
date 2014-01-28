package us.th3controller.bansystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.th3controller.bansystem.BanSystem;
import us.th3controller.bansystem.Messages;

public class CmdBan implements CommandExecutor {
	
	BanSystem plugin;

	public CmdBan(BanSystem plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			if(sender.hasPermission("bansystem.ban")) {
				if(args.length >= 2) {
					Player target = Bukkit.getServer().getPlayer(args[0]);
					String reason = new String();
					for (int i = 1; i < args.length; i++) {
						reason = reason + " " + args[i];
					}
					BanSystem.banlist.set("banned."+args[0].toLowerCase()+".reason", reason);
					BanSystem.banlist.set("banned."+args[0].toLowerCase()+".issuer", sender.getName());
					BanSystem.saveBan();
					if(target != null) {
						target.kickPlayer("You have been banned, reason:"+reason);
					}
				}
				if(args.length == 1) {
					Player target = Bukkit.getServer().getPlayer(args[0]);
					BanSystem.banlist.set("banned."+args[0].toLowerCase()+".reason", "Undefined");
					BanSystem.banlist.set("banned."+args[0].toLowerCase()+".issuer", sender.getName());
					BanSystem.saveBan();
					if(target != null) {
						target.kickPlayer("You have been banned, reason: Undefined");
					}
				}
				if(args.length == 0) {
					return false;
				}
			} else {
				Messages.noPerm((Player)sender);
			}
		} else {
			if(args.length >= 2) {
				Player target = Bukkit.getServer().getPlayer(args[0]);
				String reason = new String();
				for (int i = 1; i < args.length; i++) {
					reason = reason + " " + args[i];
				}
				BanSystem.banlist.set("banned."+args[0].toLowerCase()+".reason", reason);
				BanSystem.banlist.set("banned."+args[0].toLowerCase()+".issuer", sender.getName());
				BanSystem.saveBan();
				if(target != null) {
					target.kickPlayer("You have been banned, reason:"+reason);
				}
			}
			if(args.length == 1) {
				Player target = Bukkit.getServer().getPlayer(args[0]);
				BanSystem.banlist.set("banned."+args[0].toLowerCase()+".reason", "Undefined");
				BanSystem.banlist.set("banned."+args[0].toLowerCase()+".issuer", sender.getName());
				BanSystem.saveBan();
				if(target != null) {
					target.kickPlayer("You have been banned, reason: Undefined");
				}
			}
			if(args.length == 0) {
				return false;
			}
		}
		return true;
	}
}
