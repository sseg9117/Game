package dev.sheradon.game.entities.creatures;

import dev.sheradon.game.Handler;
import dev.sheradon.game.entities.Entity;
import dev.sheradon.game.tile.Tile;

public abstract class Creature extends Entity
{
	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH =  64,
						   DEFAULT_CREATURE_HEIGHT = 64;
	
	protected int health;
	protected float speed;
	protected float xMove, yMove;

	public Creature(Handler handler, float x, float y, int width, int height)
	{
		super(handler, x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove= 0;
		yMove= 0;
	}
	
	public void move()
	{
		moveX();
		moveY();
	}
	
	public void moveX()
	{
		if(xMove >0)//Moving right
		{
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height)/ Tile.TILEHEIGHT));
			{
			x =+ xMove;
			}
		}
		
		else if(xMove <0)//Moving left
		{
			int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height)/ Tile.TILEHEIGHT));
			{
			x =+ xMove;
			}
		}		
	}
	public void moveY()
	{
		if(yMove < 0)//Up
		{
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x)/ Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width)/ Tile.TILEWIDTH, ty)) 
			{
				y += yMove;
			}
		}
		else if(yMove > 0)
		{
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x)/ Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width)/ Tile.TILEWIDTH, ty)) 
			{
				y += yMove;
			}
		}
		
	}
	
	protected boolean collisionWithTile(int x, int y)
	{
		return handler.getWorld().getTile(x, y).isSolid();
		
	}
	//GETTERS SETTERS
	public float getxMove()
	{
		return xMove;
	}

	public void setxMove(float xMove)
	{
		this.xMove = xMove;
	}

	public float getyMove()
	{
		return yMove;
	}

	public void setyMove(float yMove)
	{
		this.yMove = yMove;
	}

	public int getHealth()
	{
		return health;
	}

	public void setHealth(int health)
	{
		this.health = health;
	}

	public float getSpeed()
	{
		return speed;
	}

	public void setSpeed(float speed)
	{
		this.speed = speed;
	}
	
}
