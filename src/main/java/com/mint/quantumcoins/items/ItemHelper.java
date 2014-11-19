package com.mint.quantumcoins.items;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemHelper
{
	public static Item coin;
	
	public static void init()
	{
		coin = new Coin();
	}
	
	public static void registerCrafting()
	{
		
	}
	
	public static void registerItems(QuantumItems item)
	{
		GameRegistry.registerItem(item, item.getUnwrappedUnlocalizedName(item.getUnlocalizedName()));
	}
}
