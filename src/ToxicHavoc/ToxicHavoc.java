package ToxicHavoc;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ToxicHavoc
  extends JavaPlugin
{
  public static ToxicHavoc instance;
  ArrayList<Player> tc = new ArrayList();
  ArrayList<Player> tv = new ArrayList();
  
  public void onDisable()
  {
    Bukkit.getLogger().log(Level.INFO, "[ToxicHavoc] Disabled.");
    instance = null;
  }
  
  public void onEnable()
  {
    instance = this;
    getServer().getPluginManager().registerEvents(new ToxicHavocL(this), this);
    Bukkit.getLogger().log(Level.INFO, "[ToxicHavoc] Enabled.");
    saveDefaultConfig();
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    Player player = (Player)sender;
    if (!(sender instanceof Player))
    {
      sender.sendMessage("You aren't a player");
      return true;
    }
    if (cmd.getName().equalsIgnoreCase("jointeam"))
    {
      if (args.length == 0)
      {
        sender.sendMessage("Specify a team.");
        return true;
      }
      if (args.length == 1)
      {
        if (args[0].equalsIgnoreCase("castle"))
        {
          if ((this.tv.contains(player)) || (this.tc.contains(player)))
          {
            sender.sendMessage("You're already on a team!");
            return true;
          }
          this.tc.add(player);
          reloadConfig();
          String[] loc = getConfig().getString("LobbySpawn").split(",");
          player.teleport(new Location(player.getWorld(), Double.parseDouble(loc[0]), Double.parseDouble(loc[1]), Double.parseDouble(loc[2])));
          sender.sendMessage("You've joined Team Castle");
          return true;
        }
        if (args[0].equalsIgnoreCase("village"))
        {
          if ((this.tc.contains(player)) || (this.tv.contains(player)))
          {
            sender.sendMessage("You're already on a team!");
            return true;
          }
          this.tv.add(player);
          reloadConfig();
          String[] loc = getConfig().getString("LobbySpawn").split(",");
          player.teleport(new Location(player.getWorld(), Double.parseDouble(loc[0]), Double.parseDouble(loc[1]), Double.parseDouble(loc[2])));
          sender.sendMessage("You've joined Team Village");
          return true;
        }
      }
    }
    if (cmd.getName().equalsIgnoreCase("set"))
    {
      if (!player.isOp())
      {
        sender.sendMessage("You are not an Op.");
        return true;
      }
      if (args.length == 0)
      {
        sender.sendMessage("Specify a spawn or target.");
        sender.sendMessage("castle, village, lobby, castlew, villagew");
        return true;
      }
      if (args.length == 1)
      {
        if (args[0].equalsIgnoreCase("castle"))
        {
          getConfig().set("CastleSpawn", player.getEyeLocation().getBlockX() + "," + player.getEyeLocation().getBlockY() + "," + player.getEyeLocation().getBlockZ());
          saveConfig();
          sender.sendMessage("Castle Spawn is set.");
          return true;
        }
        if (args[0].equalsIgnoreCase("village"))
        {
          getConfig().set("VillageSpawn", player.getEyeLocation().getBlockX() + "," + player.getEyeLocation().getBlockY() + "," + player.getEyeLocation().getBlockZ());
          saveConfig();
          sender.sendMessage("Village Spawn is set.");
          return true;
        }
        if (args[0].equalsIgnoreCase("lobby"))
        {
          getConfig().set("LobbySpawn", player.getEyeLocation().getBlockX() + "," + player.getEyeLocation().getBlockY() + "," + player.getEyeLocation().getBlockZ());
          saveConfig();
          sender.sendMessage("Lobby is set.");
          return true;
        }
        if (args[0].equalsIgnoreCase("castlew"))
        {
          getConfig().set("CastleWater", Integer.valueOf(player.getItemInHand().getTypeId()));
          saveConfig();
          sender.sendMessage("Castle Water Source is set.");
          reloadConfig();
          return true;
        }
        if (args[0].equalsIgnoreCase("villagew"))
        {
          getConfig().set("VillageWater", Integer.valueOf(player.getItemInHand().getTypeId()));
          saveConfig();
          sender.sendMessage("Village Water Source is set.");
          reloadConfig();
          return true;
        }
      }
    }
    String[] loc2;
    if ((cmd.getName().equalsIgnoreCase("startgame")) && (args.length == 0))
    {
      if (!player.isOp())
      {
        sender.sendMessage("You are not an Op.");
        return true;
      }
      String[] loc1 = getConfig().getString("CastleSpawn").split(",");
      Location cs = new Location(player.getWorld(), Double.parseDouble(loc1[0]), Double.parseDouble(loc1[1]), Double.parseDouble(loc1[2]));
      loc2 = getConfig().getString("VillageSpawn").split(",");
      Location vs = new Location(player.getWorld(), Double.parseDouble(loc2[0]), Double.parseDouble(loc2[1]), Double.parseDouble(loc2[2]));
      for (Player p : this.tc) {
        p.teleport(cs);
      }
      for (Player p : this.tv) {
        p.teleport(vs);
      }
      sender.getServer().broadcastMessage("The game has begun!");
      return true;
    }
    if ((cmd.getName().equalsIgnoreCase("endgame")) && (args.length == 0))
    {
      if (!player.isOp())
      {
        sender.sendMessage("You are not an Op.");
        return true;
      }
      String[] loc = getConfig().getString("LobbySpawn").split(",");
      Location ls = new Location(player.getWorld(), Double.parseDouble(loc[0]), Double.parseDouble(loc[1]), Double.parseDouble(loc[2]));
      for (Player p : this.tc) {
        p.teleport(ls);
      }
      for (Player p : this.tv) {
        p.teleport(ls);
      }
      getServer().broadcastMessage("The game has been ended early by " + sender.getName());
      endGame();
      return true;
    }
    return true;
  }
  
  public String grabTC()
  {
    String tcl = null;
    for (Player p : this.tc) {
      if (tcl == null) {
        tcl = p.getName();
      } else {
        tcl = tcl + "," + p.getName();
      }
    }
    return tcl;
  }
  
  public String grabTV()
  {
    String tvl = null;
    for (Player p : this.tv) {
      if (tvl == null) {
        tvl = p.getName();
      } else {
        tvl = tvl + "," + p.getName();
      }
    }
    return tvl;
  }
  
  public void endGame()
  {
    this.tc.clear();
    this.tv.clear();
  }
}