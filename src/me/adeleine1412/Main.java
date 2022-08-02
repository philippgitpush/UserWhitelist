package me.adeleine1412;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	private static Main plugin;
	private Commands cmd;
	
	@Override
	public void onEnable() {
		plugin = this;
		
		this.cmd = new Commands();
		this.cmd.register();
		
		System.out.print("UserWhitelist is running.");
	}
	
	public void onDisable() {
		System.out.print("UserWhitelist stopped.");
	}
	
	public static Main getPlugin() {
	    return plugin;
	}
		
}
