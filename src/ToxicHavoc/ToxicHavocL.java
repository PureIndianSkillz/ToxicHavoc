package ToxicHavoc;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ToxicHavocL
  implements Listener
{
  private ToxicHavoc plugin;
  
  public ToxicHavocL(ToxicHavoc instance)
  {
    this.plugin = instance;
  }
  
  int tc = 0;
  int vc = 0;
  
  @EventHandler
  public void onPoisonWaterSupply(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) && (p.getItemInHand().getType() == Material.POISONOUS_POTATO) && (e.getClickedBlock().getTypeId() == this.plugin.getConfig().getInt("CastleWater")))
    {
      this.vc += 1;
      if (this.vc != 3)
      {
        p.getServer().broadcastMessage("Team Village has scored!");
        reset(p);
      }
      else
      {
        p.getServer().broadcastMessage("Team Village has won!");
        this.vc = 0;
        this.tc = 0;
        this.plugin.endGame();
      }
    }
    if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) && (p.getItemInHand().getType() == Material.POISONOUS_POTATO) && (e.getClickedBlock().getTypeId() == this.plugin.getConfig().getInt("VillageWater")))
    {
      this.tc += 1;
      if (this.vc != 3)
      {
        p.getServer().broadcastMessage("Team Castle has scored!");
        reset(p);
      }
      else
      {
        p.getServer().broadcastMessage("Team Castle has won!");
        this.vc = 0;
        this.tc = 0;
        this.plugin.endGame();
      }
    }
  }
  
  public void reset(Player p)
  {
    String[] tcl = this.plugin.grabTC().split(",");
    String[] tvl = this.plugin.grabTV().split(",");
    String[] tcs = this.plugin.getConfig().getString("CastleSpawn").split(",");
    String[] tvs = this.plugin.getConfig().getString("VillageSpawn").split(",");
    if (this.plugin.grabTC() != null) {
      for (String pl : tcl)
      {
        Player player = p.getServer().getPlayer(pl);
        player.teleport(new Location(p.getWorld(), Double.parseDouble(tcs[0]), Double.parseDouble(tcs[1]), Double.parseDouble(tcs[2])));
      }
    }
    if (this.plugin.grabTV() != null) {
      for (String pl : tvl)
      {
        Player player = p.getServer().getPlayer(pl);
        player.teleport(new Location(p.getWorld(), Double.parseDouble(tvs[0]), Double.parseDouble(tvs[1]), Double.parseDouble(tvs[2])));
      }
    }
  }
}
