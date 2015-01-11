package PolytechOnline.handlers;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class SignListener implements Listener{
	public SignListener (JavaPlugin plugin){
		plugin.getServer().getPluginManager().registerEvents(this, plugin);}
		
	
	@EventHandler	
	
	public void onSignCreate(SignChangeEvent sign)
	{
		Player player = sign.getPlayer();
		
		if(sign.getLine(1).equalsIgnoreCase("knight")){
			player.sendMessage(ChatColor.GREEN + "You made a pick class sign:Knight");
			sign.setLine(1, (ChatColor.GREEN+"Knight"));
			sign.setLine(2, (ChatColor.GREEN+"Class"));}
		
		if(sign.getLine(1).equalsIgnoreCase("archer")){
			player.sendMessage(ChatColor.GREEN + "You made a pick class sign:Archer");
			sign.setLine(1, (ChatColor.GREEN+"Archer"));
			sign.setLine(2, (ChatColor.GREEN+"Class"));}
		
		if(sign.getLine(1).equalsIgnoreCase("wizard")){
			player.sendMessage(ChatColor.GREEN + "You made a pick class sign:Wizard");
			sign.setLine(1, (ChatColor.GREEN+"Wizard"));
			sign.setLine(2, (ChatColor.GREEN+"Class"));}
		
		if(sign.getLine(1).equalsIgnoreCase("farmer")){
			player.sendMessage(ChatColor.GREEN + "You made a pick class sign:Farmer");
			sign.setLine(1, (ChatColor.GREEN+"Farmer"));
			sign.setLine(2, (ChatColor.GREEN+"Class"));}
		
		if(sign.getLine(1).equalsIgnoreCase("bowman")){
			player.sendMessage(ChatColor.GREEN + "You made a pick class sign:Bowman");
			sign.setLine(1, (ChatColor.GREEN+"Bowman"));
			sign.setLine(2, (ChatColor.GREEN+"Class"));}
		
		if(sign.getLine(1).equalsIgnoreCase("alchemist")){
			player.sendMessage(ChatColor.GREEN + "You made a pick class sign:Alchemist");
			sign.setLine(1, (ChatColor.GREEN+"Alchemist"));
			sign.setLine(2, (ChatColor.GREEN+"Class"));}
		
		if(sign.getLine(1).equalsIgnoreCase("castle")){
			player.sendMessage(ChatColor.GREEN + "You made a pick side sign: castle");
			sign.setLine(1, (ChatColor.GREEN+"Choose Side:"));
			sign.setLine(2, (ChatColor.RED+"CASTLE"));}
		
		if(sign.getLine(1).equalsIgnoreCase("village")){
			player.sendMessage(ChatColor.GREEN + "You made a pick side sign: village");
			sign.setLine(1, (ChatColor.GREEN+"Choose Side:"));
			sign.setLine(2, (ChatColor.RED+"VILLAGE"));}
		
		if(sign.getLine(1).equalsIgnoreCase("VillageTeam")){
			player.sendMessage(ChatColor.GREEN + "You created a team selecter-village");
			sign.setLine(1, (ChatColor.RED+"Village"));}
		
		if(sign.getLine(1).equalsIgnoreCase("CastleTeam")){
			player.sendMessage(ChatColor.GREEN + "You created a team selecter-castle");
			sign.setLine(1, (ChatColor.RED+"CastleTeam"));}
		
		}	
	
			
		}
