package us.th3controller.bansystem;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Messages {
	
	public static void noPerm(Player player) {
		player.sendMessage(ChatColor.RED + "Insufficient permissions to do this command!");
	}
}
