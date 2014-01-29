package us.th3controller.bansystem;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import us.th3controller.bansystem.commands.CmdBan;
import us.th3controller.bansystem.commands.CmdKick;
import us.th3controller.bansystem.commands.CmdTempBan;

public class BanSystem extends JavaPlugin {
	
	Logger log = Logger.getLogger("Minecraft");
	
	//On enable method
	public void onEnable() {
		FileSystem.banStart();
		FileSystem.tempBanStart();
		getCommands();
		getServer().getPluginManager().registerEvents(new BanSystemListener(this), this);
		log.info("[BanSystem] Successfully initiated!");
	}
	//On disable method
	public void onDisable() {
		FileSystem.saveTempBan();
		FileSystem.saveBan();
		log.info("[BanSystem] Successfully terminated!");
	}
	//Initiate commands
	public void getCommands() {
		getCommand("tempban", new CmdTempBan());
		getCommand("kick", new CmdKick());
		getCommand("ban", new CmdBan());
	}
	//getCommand method
	public void getCommand(String command, CommandExecutor commandexecutor) {
		Bukkit.getServer().getPluginCommand(command).setExecutor(commandexecutor);
	}
}
