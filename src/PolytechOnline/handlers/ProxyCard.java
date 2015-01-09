package PolytechOnline.handlers;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ProxyCard implements Listener{
	public ProxyCard (JavaPlugin plugin){
		plugin.getServer().getPluginManager().registerEvents(this, plugin);}
		
	@EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction().equals(Action.PHYSICAL)) {
            if (event.getClickedBlock().getType().equals(Material.STONE_PLATE)){
            	Player player = event.getPlayer();
            	Set<Integer> set = new HashSet<Integer>();
            	if(player.getInventory().contains(Material.SLIME_BALL)){
            		event.setCancelled(false);}
            	else {
            	  
            		
            		event.setCancelled(true);
            		
            	
            	}	
            	
                  
            	
            }
            
       



}}}













                
