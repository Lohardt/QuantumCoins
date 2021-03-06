package com.mint.quantumcoins.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.mint.quantumcoins.lib.QuantumRef;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class QuantumItems extends Item
{
    public String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
 
    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s%s", QuantumRef.RESOURCES_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }
 
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        this.itemIcon = iconRegister.registerIcon(QuantumRef.RESOURCES_PREFIX + getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }
    
    public int getIntColorFromHex(String hexColor)
    {
		return Integer.parseInt(hexColor, 16);
    }
}
