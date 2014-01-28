package us.th3controller.bansystem;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import us.th3controller.bansystem.commands.CmdBan;

public class BanSystem extends JavaPlugin {
	
	Logger log = Logger.getLogger("Minecraft");
	private static File banfile;
	public static FileConfiguration banlist;
	
	public void onEnable() {
		banStart();
		log.info("[BanSystem] Successfully initiated!");
	}
	public void onDisable() {
		
		log.info("[BanSystem] Successfully terminated!");
	}
	public void banStart() {
		banfile = new File("plugins/SimplerThanEssentials", "banned.yml");
		if(!banfile.exists()) {
			try {
				banfile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		banlist = YamlConfiguration.loadConfiguration(banfile);
	}
	public static void saveBan() {
		try {
			banlist.save(banfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void getCommands() {
		getCommand("ban", new CmdBan(this));
	}
	public void getCommand(String command, CommandExecutor commandexecutor) {
		getCommand(command).setExecutor(commandexecutor);
	}
}
