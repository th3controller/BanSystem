package us.th3controller.bansystem;

import java.util.Set;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

public class BanSystemListener implements Listener {
	
	BanSystem plugin;
	
	public BanSystemListener(BanSystem plugin) {
		this.plugin = plugin;
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void PlayerLogin(PlayerLoginEvent event) {
		String reason = BanSystem.banlist.getString("banned."+event.getPlayer().getName().toLowerCase()+".reason");
		Set<String> players = BanSystem.banlist.getConfigurationSection("banned").getKeys(false);
		if(players.contains(event.getPlayer().getName().toLowerCase())) {
			event.disallow(Result.KICK_BANNED, "You are banned, reason: "+reason);
		}
	}
}
