package com.mint.quantumcoins.core;

import java.util.Random;

import com.mint.quantumcoins.items.ItemHelper;
import com.mint.quantumcoins.lib.QuantumSettings;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class QuantumEvents
{

	@SubscribeEvent
	public void mobDrop(LivingDropsEvent event)
	{
<<<<<<< HEAD
		if (event.entityLiving instanceof EntityLiving)
		{
			if(event.recentlyHit == false) return;
		
			EntityLiving entity = (EntityLiving)event.entityLiving;
			String entityName = (String) EntityList.classToStringMapping.get(entity.getClass());
			
			if(DropHelper.dropPerm.containsKey(entityName) && DropHelper.dropPerm.get(entityName) && getDropChance(DropHelper.dropChance.get(entityName)))
			{
				Random numberDropped = new Random();
				ItemStack droppedCoin = new ItemStack(ItemHelper.coin, numberDropped.nextInt(DropHelper.dropMax.get(entityName)+1), DropHelper.droppedMeta.get(entityName));
				
				event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, event.entity.posZ, droppedCoin));
			}
		}
	}
	
	public boolean getDropChance(int percent)
=======
		ItemStack droppedCoin = new ItemStack(ItemHelper.coin, 1, 0);
		
		if(event.recentlyHit == false) return;
		
		EntityLiving entity = (EntityLiving)event.entityLiving;
		String entityName = (String) EntityList.classToStringMapping.get(entity.getClass());
		
		if(event.entityLiving instanceof EntityZombie)
		{
			if(QuantumSettings.settings.zombieDrop == true)
			{
				if(dropChance(QuantumSettings.settings.zombieChance) == true)
				{
					event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, event.entity.posZ));
				}
			}
		}
		
		
	}
	
	public boolean dropChance(int percent)
>>>>>>> origin/master
	{
		Random chance = new Random();
		if(percent <= chance.nextInt(101)) return true;
		
		else return false;
	}
}
