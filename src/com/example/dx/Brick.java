package com.example.dx;

import android.graphics.Paint;


public class Brick
{
	float bricktop;
	float brickbottom;
	float brickleft;
	float brickright;
	Paint paintx;
	int brickcolor;
	
	
	Brick(float left,float top,float right ,float bottom,int color)
	{
		this.brickleft=left;
		this.bricktop=top;		
		this.brickright=right;
		this.brickbottom=bottom;		
		this.brickcolor= color;
		paintx=new Paint();
		paintx.setColor(color);
		
		
	}
	public void setLeft(float left)
	{
		this.brickleft=left;
		
	}
	public void setTop(float Top)
	{
		this.bricktop=Top;
		
	}
	public void setRight(float right)
	{
		this.brickright=right;
	}
	public void setBottom(float Bottom)
	{
		this.brickbottom=Bottom;
		
	}	
	public float getLeft() 
	{
		return this.brickleft;
	}
	
	public float getTop()
	{
		return this.bricktop;
	}

	public float getRight()
	{
	    return this.brickright;
	}
	
	public float getBottom()
	{
		return this.brickbottom;
	}
	public Paint getColor()
	{
		return this.paintx;
	}

}