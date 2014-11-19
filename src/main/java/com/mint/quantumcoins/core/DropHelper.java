package com.mint.quantumcoins.core;

import java.util.HashMap;

import com.mint.quantumcoins.lib.QuantumSettings;

public class DropHelper
{
	public static HashMap<String, Boolean> dropPerm = new HashMap<String, Boolean>();
	
	public static HashMap<String, Integer> dropChance = new HashMap<String, Integer>();
	
	public static HashMap<String, Integer> dropMax = new HashMap<String, Integer>();
	
	public static HashMap<String, Integer> droppedMeta = new HashMap<String, Integer>();
	
	public static void populateDropPermissions()
	{
		dropPerm.put("Zombie", QuantumSettings.settings.zombieDropPermission);
		dropPerm.put("Skeleton", QuantumSettings.settings.skeletonDropPermission);
		dropPerm.put("Spider", QuantumSettings.settings.spiderDropPermission);
		dropPerm.put("CaveSpider", QuantumSettings.settings.caveSpiderDropPermission);
		dropPerm.put("Enderman", QuantumSettings.settings.endermanDropPermission);
	}
	
	public static void populateDropChance()
	{
		dropChance.put("Zombie", QuantumSettings.settings.zombieDropChance);
		dropChance.put("Skeleton", QuantumSettings.settings.skeletonDropChance);
		dropChance.put("Spider", QuantumSettings.settings.spiderDropChance);
		dropChance.put("CaveSpider", QuantumSettings.settings.caveSpiderDropChance);
		dropChance.put("Enderman", QuantumSettings.settings.endermanDropChance);
	}
	
	public static void populateDropMax()
	{
		dropMax.put("Zombie", QuantumSettings.settings.zombieDropMax);
		dropMax.put("Skeleton", QuantumSettings.settings.skeletonDropMax);
		dropMax.put("Spider", QuantumSettings.settings.spiderDropMax);
		dropMax.put("CaveSpider", QuantumSettings.settings.caveSpiderDropMax);
		dropMax.put("Enderman", QuantumSettings.settings.endermanDropMax);
	}
	
	public static void populateDroppedMeta()
	{
		droppedMeta.put("Zombie", QuantumSettings.settings.zombieDroppedMeta);
		droppedMeta.put("Skeleton", QuantumSettings.settings.skeletonDroppedMeta);
		droppedMeta.put("Spider", QuantumSettings.settings.spiderDroppedMeta);
		droppedMeta.put("CaveSpider", QuantumSettings.settings.caveSpiderDroppedMeta);
		droppedMeta.put("Enderman", QuantumSettings.settings.endermanDroppedMeta);
	}
}
