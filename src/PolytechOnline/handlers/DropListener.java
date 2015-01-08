package PolytechOnline.handlers;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.plugin.java.JavaPlugin;

import PolytechOnline.ToxicHavoc;

public class DropListener implements Listener{
	public DropListener (JavaPlugin plugin){
		plugin.getServer().getPluginManager().registerEvents(this, plugin);}
		
	
	@EventHandler	
	
	public void onPlayerDropItem(PlayerDropItemEvent event){
		if(event.getItemDrop().getItemStack().getType() == Material.BOWL){
		event.setCancelled(true);
			
		}}}

	