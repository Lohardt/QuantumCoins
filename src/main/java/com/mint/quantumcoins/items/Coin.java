package quantumcoins.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import quantumcoins.QuantumCoins;
import quantumcoins.core.SoundHandler;
import quantumcoins.lib.QuantumRef;
import quantumcoins.lib.QuantumSettings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Coin extends QuantumItems
{
	public Coin()
	{
		this.setUnlocalizedName("coin");
		setHasSubtypes(true);
		setMaxStackSize(64);
		setMaxDamage(0);
		setCreativeTab(QuantumCoins.getCreativeTab());
		ItemHelper.registerItems(this);
	}

	public int getMaxItemUseDuration(ItemStack par1ItemStack)
	{
		return QuantumSettings.settings.convertTime * 20;
	}

	public EnumAction getItemUseAction(ItemStack itemstack)
	{
		return EnumAction.bow;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
	{
		if(player.isSneaking() == true)
		{
			downConvert(itemstack, world, player);
		}
		
		else upConvert(itemstack, world, player);

		return itemstack;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon(QuantumRef.RESOURCES_PREFIX + getUnwrappedUnlocalizedName(super.getUnlocalizedName()) + "_" + QuantumSettings.settings.coinLetter);
	}

	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack itemstack, int par2)
	{
		return getIntColorFromHex(QuantumSettings.settings.coinColor[itemstack.getItemDamage()]);
	}

	@Override
	public String getItemStackDisplayName(ItemStack itemstack)
	{
		return "\u00A7" + QuantumSettings.settings.coinNameColor[itemstack.getItemDamage()] + QuantumSettings.settings.coinTypeName[itemstack.getItemDamage()] + " " + QuantumSettings.settings.coinName;
	}

	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
	{
		if (QuantumSettings.settings.coinTypeInfo[itemstack.getItemDamage()].equals("none") == false)
		{
			list.add(QuantumSettings.settings.coinTypeInfo[itemstack.getItemDamage()]);
		}
	}
	
	public void upConvert(ItemStack itemstack, World world, EntityPlayer player)
	{
		if ((itemstack.stackSize >= QuantumSettings.settings.convertAmount) && (itemstack.getItemDamage() != QuantumSettings.settings.coinNum - 1))
		{
			itemstack.stackSize -= QuantumSettings.settings.convertAmount;
			
			SoundHandler.playSoundAtEntity(world, player, "conversion", 1F, 1F);
			
			if (player.inventory.addItemStackToInventory(new ItemStack(ItemHelper.coin, 1, itemstack.getItemDamage() + 1)) == false)
			{
				player.dropPlayerItemWithRandomChoice(new ItemStack(ItemHelper.coin, 1, itemstack.getItemDamage() + 1), false);
			}
		}
	}
	
	public void downConvert(ItemStack itemstack, World world, EntityPlayer player)
	{
		if (itemstack.getItemDamage() != 0)
		{
			if((itemstack.stackSize - 1) == 0) itemstack.stackSize = 0;
			
			else itemstack.stackSize--;
			
			SoundHandler.playSoundAtEntity(world, player, "conversion", 1F, 0.5F);
			
			if (player.inventory.addItemStackToInventory(new ItemStack(ItemHelper.coin, QuantumSettings.settings.convertAmount, itemstack.getItemDamage() - 1)) == false)
			{
				player.dropPlayerItemWithRandomChoice(new ItemStack(ItemHelper.coin, QuantumSettings.settings.convertAmount, itemstack.getItemDamage() - 1), false);
			}
		}
	}

	@SuppressWarnings(
	{ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list)
	{
		for (int count = 0; count < QuantumSettings.settings.coinNum; count++)
		{
			list.add(new ItemStack(item, 1, count));
		}
	}
}
