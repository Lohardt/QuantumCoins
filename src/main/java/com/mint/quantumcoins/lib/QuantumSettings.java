package com.mint.quantumcoins.lib;

public class QuantumSettings
{
	public static class defaults
	{
		public static final int DEFAULT_COIN_NUMBER = 5;
		public static final String DEFAULT_COIN_NAME = "Coin";
		public static final String DEFAULT_COIN_LETTER = "M";
		public static final int DEFAULT_CONVERT_AMOUNT = 5;

		public static final String[] DEFAULT_COIN_TYPE_NAME = { "Stone", "Iron", "Gold", "Diamond", "Special" };
		public static final String[] DEFAULT_COIN_NAME_COLOR = { "7", "F", "E", "9", "D"};
		public static final String[] DEFAULT_COIN_COLOR = { "AAAAAA", "FFFFFF", "FFFF55", "55FFFF", "123456" };
		public static final String[] DEFAULT_COIN_TYPE_INFO = { "none",
													  			"Worth 5 Stone Coins", "Worth 5 Iron Coins",
													  			"Worth 5 Gold Coins", "none", };
		
		//Mobs//
<<<<<<< HEAD
		public static final boolean DEFAULT_ZOMBIE_DROP_PERMISSION = true;
		public static final int DEFAULT_ZOMBIE_DROP_CHANCE = 25;
		public static final int DEFAULT_ZOMBIE_DROP_MAX = 3;
		public static final int DEFAULT_ZOMBIE_DROPPED_META = 0;
		
		public static final boolean DEFAULT_SKELETON_DROP_PERMISSION = true;
		public static final int DEFAULT_SKELETON_DROP_CHANCE = 20;
		public static final int DEFAULT_SKELETON_DROP_MAX = 2;
		public static final int DEFAULT_SKELETON_DROPPED_META = 0;
		
		public static final boolean DEFAULT_SPIDER_DROP_PERMISSION = true;
		public static final int DEFAULT_SPIDER_DROP_CHANCE = 15;
		public static final int DEFAULT_SPIDER_DROP_MAX = 2;
		public static final int DEFAULT_SPIDER_DROPPED_META = 0;
		
		public static final boolean DEFAULT_CAVE_SPIDER_DROP_PERMISSION = true;
		public static final int DEFAULT_CAVE_SPIDER_DROP_CHANCE = 20;
		public static final int DEFAULT_CAVE_SPIDER_DROP_MAX = 3;
		public static final int DEFAULT_CAVE_SPIDER_DROPPED_META = 0;
		
		public static final boolean DEFAULT_ENDERMAN_DROP_PERMISSION = true;
		public static final int DEFAULT_ENDERMAN_DROP_CHANCE = 35;
		public static final int DEFAULT_ENDERMAN_DROP_MAX = 5;
		public static final int DEFAULT_ENDERMAN_DROPPED_META = 0;
=======
		public static final boolean DEFAULT_ZOMBIE_DROP = true;
		public static final int DEFAULT_ZOMBIE_CHANCE = 25;
		
		public static final boolean DEFAULT_SKELETON_DROP = true;
		public static final int DEFAULT_SKELETON_CHANCE = 20;
		
		public static final boolean DEFAULT_SPIDER_DROP = true;
		public static final int DEFAULT_SPIDER_CHANCE = 15;
		
		public static final boolean DEFAULT_CAVE_SPIDER_DROP = true;
		public static final int DEFAULT_CAVE_SPIDER_CHANCE = 20;
		
		public static final boolean DEFAULT_ENDERMAN_DROP = true;
		public static final int DEFAULT_ENDERMAN_CHANCE = 35;
>>>>>>> origin/master
	}
	
	public static class settings
	{
		public static int coinNum;
		public static String coinName;
		public static String coinLetter;
		public static int convertAmount;
		public static int convertTime;

		public static String[] coinTypeName;
		public static String[] coinNameColor;
		public static String[] coinColor;
		public static String[] coinTypeInfo;
		
		//Mobs//
<<<<<<< HEAD
		public static boolean zombieDropPermission;
		public static int zombieDropChance;
		public static int zombieDropMax;
		public static int zombieDroppedMeta;
		
		public static boolean skeletonDropPermission;
		public static int skeletonDropChance;
		public static int skeletonDropMax;
		public static int skeletonDroppedMeta;
		
		public static boolean spiderDropPermission;
		public static int spiderDropChance;
		public static int spiderDropMax;
		public static int spiderDroppedMeta;
		
		public static boolean caveSpiderDropPermission;
		public static int caveSpiderDropChance;
		public static int caveSpiderDropMax;
		public static int caveSpiderDroppedMeta;
		
		public static boolean endermanDropPermission;
		public static int endermanDropChance;
		public static int endermanDropMax;
		public static int endermanDroppedMeta;
=======
		public static boolean zombieDrop;
		public static int zombieChance;
		
		public static boolean skeletonDrop;
		public static int skeletonChance;
		
		public static boolean spiderDrop;
		public static int spiderChance;
		
		public static boolean caveSpiderDrop;
		public static int caveSpiderChance;
		
		public static boolean endermanDrop;
		public static int endermanChance;
>>>>>>> origin/master
	}
}
