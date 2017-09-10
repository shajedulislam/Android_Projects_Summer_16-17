package com.example.dx;
import java.util.ArrayList;

import android.content.Context;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.MotionEvent;
import android.view.View;

public class GamePlay extends View 
{
	
	ArrayList<Brick>bricks =new ArrayList<Brick>();

	Paint paint,paint2,paint3,paint4,paint5;
	
	float wid, x=0,xl=0,xr=0,xh=0, y=0, z=0, Bottom=0, Top=0, Left=0, Right=0, xx=0,yy=0, xxx=0,yyy=0, xxx2=0, yyy2=0, newPos=0;
	
	float xleft1=0, xtop2=0, xright3=0, xbottom4=0, xwid=0;
	
	float tX,tY;
	
	int xc=0;

	boolean start=true;
	
	boolean height=true;
	
	boolean rect=true;
	
	boolean rect2=true;
	
	boolean rect3=true;
	
	boolean first = true;
	boolean first2 = true;
	
	boolean left=false;
	boolean right=false;
	boolean middle=false;
	
	boolean painter1=true;
	boolean painter2=true;
	
	boolean gameover=false;

	
	boolean leftPos,rightPos;
	
	int min_distance = 50;
	
    int Colorx,Colory;	
    
    boolean drawn = true;
    
    
    
	
	void DrawBrick(Canvas canvas,ArrayList<Brick>bricks)
	{
		xleft1=0;
		xtop2=0;
		xwid=canvas.getWidth()/5;
		xright3=xwid;
		xbottom4=50;
		
		Colorx=Color.BLACK;
		Colory=Color.BLUE;
		
		//int k=0;
		
	    for (int i = 0; i < 5; i++) 
	    {
	           for (int j = 0; j <5; j++) 
	           {
	           		
		        	if(painter1==true)
		        	{
		        		bricks.add(new Brick(xleft1,xtop2,xright3,xbottom4,Colorx));
		        		painter1=false;
		        	}
		        	else if(painter1==false)
		        	{
		        		bricks.add(new Brick(xleft1,xtop2,xright3,xbottom4,Colory));
		        		painter1=true;
		        	}
		        	xleft1=xright3;
		        	xright3=xright3+xwid;		        	
	           
	           }
	           
	           xtop2=xbottom4;
	           xbottom4=xbottom4+50;
	           xleft1=0;
	           xright3=xwid;
	           
	   } 
	    
	    drawn=false;
	}
	
	
	
	protected  void moveBall()
	{
		
//**********************************YYYYY----Upper*******************************************	
		if(height==true)
		
		{
			if(first==true)
			{
				if(left==true)
				{
																							
					y=y-4;
					x=x-4;
					
					if(x<=10)
					{
						left=false;
						right=true;
					}
					
					
				}
				else if(left==false)
				{
					y=y-4;
					x=x+4;
					
					
				}
				
				
			}
			//************************first
			else
			{
				if(left==true)
				{
					y=y-4;
					
					x=x-4;
					
					if(x<=10)
					{
						left=false;
						right=true;
					}
					else if(x>=wid-10)
					{
						y=y-4;
						x=x+4;
						
					}
					else if(y<=10)
					{
						height=false;
					}
				
					
				}
				else if(left==false)
				{
					y=y-4;
					x=x+4;
					
					if(x>=wid-10)
					{
						left=true;
						right=false;
					}
					else if(y<=10)
					{
						height=false;
					}
									
				}
				
				
			}
		}
//**********************************Y++++Lower********************************************
		else if(height==false)
		{
			if(first==true)
			{
				if(left==false && right==true)
				{
					y=y+4;
					x=x+4;
					
					if(x>=wid-10)
					{
						right=false;
						left=true;
					}
				}
				else if(left==true)
				{
					
					y=y+4;
					
					x=x-4;
					

					
					if(x>=tX-50 && x< tX+50 && y>= z-210 )
					{
						height=true;
						first=false;
						
					}
					if( y> z-100)
					{
						gameover=true;
					}
					
					
				}
			
			}
			//***************first
			else
			{
				if(left==false)
				{
					y=y+4;
					x=x+4;
					
					if(x>=wid-10)
					{
						right=false;
						left=true;
					}
					if(x>=tX-50 && x< tX+50 && y>= z-210 )
					{
						height=true;
						left=false;
						
					}
					if( y> z-100)
					{
						gameover=true;
					}
				}
				else if(left==true)
				{
					
					y=y+4;
					
					x=x-4;
					
					if(x<=10)
					{
						left=false;
						//right=true;
					}
					
					if(x>=tX-50 && x< tX+50 && y>= z-210 )
					{
						height=true;
						left=true;
						
					}
					if(y> z-100)
					{
						gameover=true;
					}
					
					
				}
				
				
				
			}
		}

	}
	
	public void brickBreak()
	{
		   for(int i=0;i<bricks.size();i++) 
		   {
	           if (((y - 20) <= bricks.get(i).getBottom()) && ((y + 20) >= bricks.get(i).getTop()) && ((x) >= bricks.get(i).getLeft()) && ((x) <= bricks.get(i).getRight())) 
	           {
	               bricks.remove(i); 
	               height=false;
	               
	              /* if(left==true)
	               {
	            	   left=false;
	               }
	               else
	               {
	            	   left=true;
	               }*/
	               
	           }
	           else if(((y) <= bricks.get(i).getBottom()) && ((y) >= bricks.get(i).getTop()) && ((x + 20) >= bricks.get(i).getLeft()) && ((x - 20) <= bricks.get(i).getRight())) 
	           {
	               bricks.remove(i);
	               //height=true;
	           }
		   }
	   }

	
	protected void onDraw(Canvas canvas)
	{
		//x3=0;
		//x4=50;
		
		if(start==true)
		{
			start=false;
			
			x=canvas.getWidth() / 2;
			y=canvas.getHeight()-200;
			z=canvas.getHeight();
			xl=x-20;
			xr=x+20;
			xh=x/2;
			wid=canvas.getWidth();
			
			xx= canvas.getWidth() / 2;
			yy=canvas.getHeight()-50 ;
			
			xxx= canvas.getWidth()/2;
			yyy=canvas.getHeight()-180;
			
			xxx2=canvas.getWidth()/2;
			yyy2=canvas.getHeight()-500;
			
			
			//x2= canvas.getWidth()/5;
											
			Top=canvas.getHeight()-200;
			Bottom=canvas.getHeight()-180;
			Left=(canvas.getWidth()/2)-50;
			Right=(canvas.getWidth()/2)+50;
						
																	
		}
		
		if(gameover==true)
		{
			
			paint.setColor(Color.rgb(5, 90, 201));
			paint.setStyle(Style.FILL);
			
			paint2.setColor(Color.rgb(111, 186, 0));
			paint2.setStyle(Style.FILL);
			
			canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), paint);
			
			
			paint2.setTextSize(50);
			canvas.drawText("GAME OVER",canvas.getWidth()/2-140,canvas.getHeight()/2,paint2);
			
		}
		/*if(bricks.size()<=0 && drawn == false)
		{
			
			paint.setColor(Color.rgb(5, 90, 201));
			paint.setStyle(Style.FILL);
			
			paint2.setColor(Color.rgb(111, 186, 0));
			paint2.setStyle(Style.FILL);
			
			canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), paint);
			
			
			paint2.setTextSize(50);
			canvas.drawText("Score",canvas.getWidth()/2-110,canvas.getHeight()/2,paint2);
			
		}*/
		else
		{
		
		if(bricks.size()<=0 && drawn == true)
		{
			DrawBrick( canvas,bricks);
		}
		
		//DrawBrick( canvas,bricks);
		
		
		if(rect3==false)
		{
		
		moveBall();
		
		}
				
		 
		canvas.drawRGB(255, 255, 255);
		
		paint.setColor(Color.rgb(5, 90, 201));
		paint.setStyle(Style.FILL);
		
		paint2.setColor(Color.rgb(111, 186, 0));
		paint2.setStyle(Style.FILL);
		
		paint3.setColor(Color.rgb(183, 0, 70));
		paint3.setStyle(Style.FILL);
		
		//paint5.setColor(Color.rgb(111, 186, 0));
		//paint5.setStyle(Style.FILL);
		
		
		canvas.drawCircle(x,y,20, paint3);
		
		canvas.drawCircle(xx,yy,60, paint3);
		
		
		/*for(int i = 0; i<5; i++)
		{
			
			canvas.drawRect(0, x3, x2, x4, paint);  //canvas.drawRect(0, 0, 110, 50, paint); canvas.drawRect(0,50, 110,100, paint2);
			canvas.drawRect(x2, x3, x2*2, x4, paint2); //canvas.drawRect(110, 0, 220, 50, paint2); canvas.drawRect(110, 50, 220, 100, paint);
			canvas.drawRect(x2*2, x3, x2*3, x4, paint);
			canvas.drawRect(x2*3, x3, x2*4, x4, paint2);
			canvas.drawRect(x2*4, x3, x2*5, x4, paint);
			//canvas.drawRect(x2*5, x3, x2*6, x4, paint2);
			
			x3=x3+50;
			x4=x4+50;
			
			if(i%2==0)
			{
				paint4 = paint2;
				paint2=paint;
				paint=paint4;
			}
			else
			{									
				paint4= paint;
				paint = paint2;					
				paint2 = paint4;							
			}								
		}*/
		
		
		if(rect2==true)
		{
			canvas.drawLine(xxx, yyy, xxx2, yyy2, paint3);
		}
		else if(rect2==false)
		{
			if(rect3==true)
			{
				if(tX<xl)
				{
					canvas.drawLine(xxx, yyy, xh, yyy2, paint3);
					left=true;
				
				}
				else if(tX>xr)
				{
					canvas.drawLine(xxx, yyy, x+xh, yyy2, paint3);
					//right=true;
				
				}
				else if(tX>xl && tX<xr)
				{
					canvas.drawLine(xxx, yyy, xxx2, yyy2, paint3);
				}
			
			}
		}
		
		
				
		if(rect==true)
		{
			canvas.drawRect(Left, Top,Right ,Bottom , paint3);
		}
		else if(rect==false)
		{
			
			xx=tX;
			
			canvas.drawRect(Left=tX-50, Top=z-200,Right=tX+50 ,Bottom=z-180 , paint3);
        
		}
		
		brickBreak();
		
		for(int i=0;i<bricks.size();i++)
		 {
	         canvas.drawRect(bricks.get(i).getLeft(), bricks.get(i).getTop(), bricks.get(i).getRight(), bricks.get(i).getBottom(), bricks.get(i).getColor());
		 }
		}
                   
		invalidate();
		
	}
	
	@Override
    public boolean onTouchEvent(MotionEvent event) 
	{
		rect2=false;
				
        switch (event.getAction())
        {
        
            case MotionEvent.ACTION_DOWN:
            {  
            	xc=xc+1;
                tX=event.getX();
                tY=event.getY();   
                
                if(xc==2)
                {
                	rect=false;
                }
                
                return true;
            }
            case MotionEvent.ACTION_UP:
            {         
                tX=event.getX();
                tY=event.getY();
                
                rect3=false;
                return true;                
            }
            case MotionEvent.ACTION_MOVE:
            {
            	
            	tX=event.getX();
            	tY=event.getY();
            	
            	return true;
            }

        }
        
        
        return super.onTouchEvent(event);
    }

	
	public GamePlay(Context context)
	{
		super(context);
		paint = new Paint();
		paint2= new Paint();
		paint3= new Paint();

		
	}

	

	
	
	
}
