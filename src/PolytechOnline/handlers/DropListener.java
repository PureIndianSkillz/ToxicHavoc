package PolytechOnline.handlers;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.plugin.java.JavaPlugin;

import PolytechOnline.ToxicHavoc;

public class DropListener implements Listener{
	public DropListener (JavaPlugin plugin){
		plugin.getServer().getPluginManager().registerEvents(this, plugin);}
		
	
	@EventHandler	
	
	
	//Prevents player from throwing weapons//
	public void onPlayerDropItem(PlayerDropItemEvent event){
		if(event.getItemDrop().getItemStack().getType() == Material.BOWL);
		if(event.getItemDrop().getItemStack().getType() == Material.STONE_SWORD);
		if(event.getItemDrop().getItemStack().getType() == Material.WOOD_SWORD);
		if(event.getItemDrop().getItemStack().getType() == Material.BOW);
		if(event.getItemDrop().getItemStack().getType() == Material.ARROW);
		if(event.getItemDrop().getItemStack().getType() == Material.STICK);//test//
		{
		event.setCancelled(true);}}
	
	//Prevents player from taking off armor//
	public  void onClick(InventoryClickEvent event){
	        if(event.getSlotType() == InventoryType.SlotType.ARMOR){
	         event.setCancelled(true);}}
	  
	//Prevents player from dropping items on death//
	public void onPlayerDeath(PlayerDeathEvent event){
	        	event.getDrops().clear();}
	        
	        
		{
			
			
			
			
		}}

	