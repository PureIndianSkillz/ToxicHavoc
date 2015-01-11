package PolytechOnline;



import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import PolytechOnline.threads.StartCountdown;


public class ToxicHavoc extends JavaPlugin{ 
	public static  Logger logger = Logger.getLogger("Minecraft");
	public static ToxicHavoc plugin;
	
	
	
	public void onEnable() {
		new PolytechOnline.handlers.SignListener(this);
		new PolytechOnline.handlers.PlayerListener(this);
		new PolytechOnline.handlers.DropListener(this);
		new PolytechOnline.handlers.ProxyCard(this);
	
		PluginDescriptionFile pdfFile = this.getDescription();
		ToxicHavoc.logger.info(pdfFile.getName() + " Version" + pdfFile.getVersion() + " Toxic Havoc Development Build Has Been Enabled");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
	    Player player = (Player) sender;
	    //start a game//
	   if (commandLabel.equalsIgnoreCase("start")){
		   player.sendMessage(ChatColor.RED + "This command has not been added yet!"); }
			
	   if(commandLabel.equalsIgnoreCase("setteamspawn")){
		   player.sendMessage(ChatColor.RED + "This command has not been added yet!");
	   }
	   if(commandLabel.equalsIgnoreCase("spawn")){
		   World world = player.getWorld();
			Location loc = new Location(world,571, 49, -734, 89, 0);
			player.teleport(loc);}
			
	
			
			
			
			
			
			
			
			
			
			
			
			
			return true;}
	    
	
	
	
	
	public static void start() {
		
		
		
		
	}
	public static void stop(){
		
		
		
	}
}
