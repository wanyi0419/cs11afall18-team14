import java.util.*;

public class BattleShip1 
{
	
	private int posx;
	private int posy;
		
	public BattleShip1()
	{
		posx=0;
		posy=0;
	}	
		
	public BattleShip1 (int a, int b)
	{
		posx = a;
		posy = b; 
	}
		
	public int getPosx()
	{
		return posx;
	}
		
	public int getPosy()
	{
		return posy;
	}
		
	public void setPosx(int newPosx)
	{
		posx = newPosx;
	}
		
	public void setPosy(int newPosy)
	{
		posy = newPosy;
	}
	
	
}	
		


