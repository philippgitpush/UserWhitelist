package me.adeleine1412;

public class Commands {
  private Main plugin;
  
  public void register() {
    this.plugin = Main.getPlugin();
    this.plugin.getCommand("userwhitelist").setExecutor(new WhitelistCommand());
  }
}