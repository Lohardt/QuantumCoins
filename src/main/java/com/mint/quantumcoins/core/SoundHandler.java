package com.mint.quantumcoins.core;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

import com.mint.quantumcoins.lib.QuantumRef;

public class SoundHandler
{
	public static void playSoundAtEntity(World world, Entity entity, String name, float volume, float pitch)
	{
		world.playSoundAtEntity(entity, QuantumRef.MOD_ID + ":" + name, volume, pitch);
	}
}
