package quantumcoins.core.proxy;

public interface IProxy
{	
	public abstract void registerRendering();
	
	public abstract void playSound(String soundName, float xCoord, float yCoord, float zCoord, float volume, float pitch);
}
