package me.adeleine1412;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class WhitelistCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			sender = ((Player) sender).getPlayer();
			
			if (args.length > 0) {
				@SuppressWarnings("deprecation")
				OfflinePlayer newbie = Bukkit.getOfflinePlayer(args[0]);
				
				if (!newbie.isWhitelisted()) {
					
					newbie.setWhitelisted(true);
					Bukkit.getServer().reloadWhitelist();
					
					sender.sendMessage(ChatColor.GRAY + "[UserWhitelist] " + ChatColor.WHITE + args[0] + ChatColor.GRAY + " was added to the whitelist!");
					Bukkit.getServer().broadcastMessage(ChatColor.GRAY + "[UserWhitelist] " + ChatColor.WHITE + sender.getName() + ChatColor.GRAY + " added " + ChatColor.WHITE + args[0] + ChatColor.GRAY + " to the whitelist!");
					
				} else {
					
					sender.sendMessage(ChatColor.GRAY + "[UserWhitelist] " + ChatColor.WHITE + args[0] + ChatColor.GRAY + " is already whitelisted.");
					
				}
				
			} else {
				
				sender.sendMessage(ChatColor.GRAY + "[UserWhitelist] please specify a player. (" + ChatColor.WHITE + "/userwhitelist <username>" + ChatColor.GRAY + ")");
				
			}
			
		}
		return false;
	}
	
}
