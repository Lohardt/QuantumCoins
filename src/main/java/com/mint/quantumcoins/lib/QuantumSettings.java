package com.mint.quantumcoins.lib;

public class QuantumSettings
{
	public static class defaults
	{
		public static final int DEFAULT_COIN_NUMBER = 5;
		public static final String DEFAULT_COIN_NAME = "Coin";
		public static final String DEFAULT_COIN_LETTER = "M";
		public static final int DEFAULT_CONVERT_AMOUNT = 5;

		public static final String[] DEFAULT_COIN_TYPE_NAME = { "Stone", "Iron", "Gold", "Diamond", "Admin" };
		public static final String[] DEFAULT_COIN_NAME_COLOR = { "7", "F", "E", "9", "D"};
		public static final String[] DEFAULT_COIN_COLOR = { "AAAAAA", "FFFFFF", "FFFF55", "55FFFF", "123456" };
		public static final String[] DEFAULT_COIN_TYPE_INFO = { "none",
													  			"Worth 5 Stone Coins", "Worth 5 Iron Coins",
													  			"Worth 5 Gold Coins", "Special token given out by server admins", };
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
	}
}
