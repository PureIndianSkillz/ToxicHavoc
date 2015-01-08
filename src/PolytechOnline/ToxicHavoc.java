package PolytechOnline;

import java.util.logging.Logger;





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
		PluginDescriptionFile pdfFile = this.getDescription();
		ToxicHavoc.logger.info(pdfFile.getName() + " Version" + pdfFile.getVersion() + " Toxic Havoc Development Build Has Been Enabled");
	}
	public static void start() {
		
		
		
		
	}
	public static void stop(){
		
		
		
	}
}
