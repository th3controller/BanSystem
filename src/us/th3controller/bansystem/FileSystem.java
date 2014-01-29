package us.th3controller.bansystem;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class FileSystem {
	
	private static File tempbanfile;
	public static FileConfiguration tempbanlist;
	private static File banfile;
	public static FileConfiguration banlist;
	
	public static void tempBanStart() {
		tempbanfile = new File("plugins/BanSystem", "tempbanned.yml");
		File bandir = new File("plugins", "BanSystem");
		if(!bandir.exists()) {
			bandir.mkdir();
		}
		if(!tempbanfile.exists()) {
			try {
				tempbanfile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		tempbanlist = YamlConfiguration.loadConfiguration(tempbanfile);
	}
	public static void saveTempBan() {
		try {
			tempbanlist.save(tempbanfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void banStart() {
		banfile = new File("plugins/BanSystem", "banned.yml");
		File bandir = new File("plugins", "BanSystem");
		if(!bandir.exists()) {
			bandir.mkdir();
		}
		if(!banfile.exists()) {
			try {
				bandir.mkdir();
				banfile.createNewFile();
			} catch (IOException e) {
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
}
