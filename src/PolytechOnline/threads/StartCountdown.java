package PolytechOnline.threads;

import org.bukkit.Bukkit;

import PolytechOnline.ToxicHavoc;
import PolytechOnline.utils.ChatUtilities;

public class StartCountdown implements Runnable{

	private static int timeUntilStart;
	
	public void run() {
		
		while (true) {
			timeUntilStart = 60;
			for (; timeUntilStart >=0; timeUntilStart--) {
				if(timeUntilStart == 0) {
					ToxicHavoc.start();					
					break;
				}
			
				if(timeUntilStart % 10==0 || timeUntilStart < 10) {
					ChatUtilities.broadcast(timeUntilStart + "seconds until game starts");
				}
				try {
					Thread.sleep(1000);
					
				} catch(InterruptedException e) {
					e.printStackTrace();
					Bukkit.shutdown();
					
					
					
				}
			} try {
				Thread.sleep(1000);
				
			} catch(InterruptedException e) {
				e.printStackTrace();
				Bukkit.shutdown();
				
			}
		
	}
		}
	}
	

