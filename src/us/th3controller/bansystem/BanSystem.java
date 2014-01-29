package us.th3controller.bansystem;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import us.th3controller.bansystem.commands.CmdBan;
import us.th3controller.bansystem.commands.CmdKick;
import us.th3controller.bansystem.commands.CmdTempBan;

public class BanSystem extends JavaPlugin {
	
	Logger log = Logger.getLogger("Minecraft");
	private static File banfile;
	public static FileConfiguration banlist;
	
	public void onEnable() {
		banStart();
		getCommands();
		banlist = YamlConfiguration.loadConfiguration(banfile);
		getServer().getPluginManager().registerEvents(new BanSystemListener(this), this);
		log.info("[BanSystem] Successfully initiated!");
	}
	public void onDisable() {
		
		log.info("[BanSystem] Successfully terminated!");
	}
	public void banStart() {
		banfile = new File("plugins/BanSystem", "banned.yml");
		File bandir = new File("plugins", "BanSystem");
		if(!banfile.exists()) {
			try {
				bandir.mkdir();
				banfile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
		getCommand("tempban", new CmdTempBan());
		getCommand("kick", new CmdKick());
		getCommand("ban", new CmdBan());
	}
	public void getCommand(String command, CommandExecutor commandexecutor) {
		Bukkit.getServer().getPluginCommand(command).setExecutor(commandexecutor);
	}
}
