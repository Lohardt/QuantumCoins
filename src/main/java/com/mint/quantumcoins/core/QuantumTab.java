package com.mint.quantumcoins.core;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.mint.quantumcoins.items.ItemHelper;

public class QuantumTab extends CreativeTabs
{
	public QuantumTab(int id, String mod_id)
	{
		super(id, mod_id);
	}
	
    @Override
    public Item getTabIconItem()
    {
        return ItemHelper.coin;
    }
}
