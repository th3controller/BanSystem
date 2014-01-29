package us.th3controller.bansystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdKick implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			if(sender.hasPermission("bansystem.kick")) {
				if(args.length >= 2){
					Player other = Bukkit.getServer().getPlayer(args[0]);
					if(other == null){
						sender.sendMessage(args[0] + " is not online!");
					}else{
						String reason = new String();
						for (int i = 1; i < args.length; i++) {
							reason = reason + " " + args[i];
						}
						other.kickPlayer("You have been kicked, reason:" + reason);
						Bukkit.getServer().broadcastMessage(sender.getName()+" kicked: "+args[0]);
						Bukkit.getServer().broadcastMessage("Reason:"+reason);
					}
				}
				else if(args.length == 1){
					Player other = Bukkit.getServer().getPlayer(args[0]);
					if(other == null){
						sender.sendMessage(args[0] + " is not online!");
					}else{
						other.kickPlayer("You have been kicked, reason: Undefined");
						Bukkit.getServer().broadcastMessage(sender.getName()+" kicked: "+args[0]);
						Bukkit.getServer().broadcastMessage("Reason:" +"Undefined");
					}
				}
				else if(args.length < 1){
					sender.sendMessage("Incorrect arguments!");
					sender.sendMessage("Usage: /kick <Player> [reason]");
				}
			}
		} else {
			if(args.length >= 2){
				Player other = Bukkit.getServer().getPlayer(args[0]);
				if(other == null){
					sender.sendMessage(args[0] + " is not online!");
				}else{
					String reason = new String();
					for (int i = 1; i < args.length; i++) {
						reason = reason + " " + args[i];
					}
					other.kickPlayer("You have been kicked, reason:" + reason);
					Bukkit.getServer().broadcastMessage(sender.getName()+" kicked: "+args[0]);
					Bukkit.getServer().broadcastMessage("Reason:"+reason);
				}
			}
			else if(args.length == 1){
				Player other = Bukkit.getServer().getPlayer(args[0]);
				if(other == null){
					sender.sendMessage(args[0] + " is not online!");
				}else{
					other.kickPlayer("You have been kicked, reason: Undefined");
					Bukkit.getServer().broadcastMessage(sender.getName()+" kicked: "+args[0]);
					Bukkit.getServer().broadcastMessage("Reason:" +"Undefined");
				}
			}
			else if(args.length < 1){
				sender.sendMessage("Incorrect arguments!");
				sender.sendMessage("Usage: /kick <Player> [reason]");
			}
		}
		return true;
	}
}
