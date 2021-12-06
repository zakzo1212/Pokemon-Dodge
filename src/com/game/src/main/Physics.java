package com.game.src.main;

import com.game.src.main.classes.EntityA;
import com.game.src.main.classes.EntityB;
import com.game.src.main.classes.EntityC;

public class Physics {
	
	
	

	public static boolean Collision(EntityA enta, EntityB entb){
				
			if(enta.getBounds().intersects(entb.getBounds())){
				
				return true;
			}
			
			
		
		
		return false;
	}
	
	public static boolean Collision(EntityB entb, EntityA enta){
		
		
			
			if(entb.getBounds().intersects(enta.getBounds())){
				return true;
			}
		
		
		return false;
	}
	
	public static boolean Collision(EntityC entc, Player player){
		
		if(entc.getBounds().intersects(player.getBounds())){
			return true;
		}
		
		return false;
		
	}
	
	
}
