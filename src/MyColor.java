

import java.awt.color.*;

import javafx.scene.paint.Color;


public enum MyColor
{
	RED(255,0,0), BLUE(0,255,0) ,GREEN(255,255,0);
	
	private int red;
	private int blu;
	private int green;

	private MyColor(int red, int blu, int green) 
	{
		
		this.red = red;
		this.blu = blu;
		this.green = green;
		
	}
	
	public Color MixColor(int x, int y, int z)
	{
		return Color.rgb(x,y,z);
	
	}
	
	
	

}

