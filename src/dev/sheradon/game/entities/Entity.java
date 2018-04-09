package dev.sheradon.game.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.sheradon.game.Handler;
//USED  CodeNMore YoutubeChannle as a refernce for the code in here he has a youtube tutorial video 
public abstract class Entity
{
	public static final int DEFAULT_HEALTH = 10;
	
	protected Handler handler;
	
	protected double x;
	protected double y;
	protected int width, height;
	protected int health;
	protected boolean active = true;
	
	protected Rectangle bounds;

	public Entity(Handler handler, double x, double y, int width, int height)
	{
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		health = DEFAULT_HEALTH;

		bounds = new Rectangle(0, 0, width, height);
	}
	public abstract void tick();

	public abstract void render(Graphics g);
	
	public abstract void die();
	
	public void hurt(int amt)
	{
		health -= amt;
		if(health <=0)
		{
			active = false;
			die();
		}
	}

	public boolean checkEntityCollision(float xOffset, float yOffset)
	{
		for (Entity e : handler.getWorld().getEntityManager().getEntities())
		{
			if (e.equals(this))
				continue;
			if (e.getCollisionBounds(0f, 0f)
					.intersects(getCollisionBounds(xOffset, yOffset)))
				return true;
		}
		return false;
	}
	public Rectangle getCollisionBounds(float xOffset, float yOffset)
	{
		return new Rectangle((int) (x + bounds.x + xOffset),
				(int) (y + bounds.y + yOffset), bounds.width, bounds.height);
	}

	public double getX()
	{
		return x;
	}

	public void setX(double x)
	{
		this.x = x;
	}

	public double getY()
	{
		return y;
	}

	public void setY(double y)
	{
		this.y = y;
	}

	public int getWidth()
	{
		return width;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}

	public int getHeight()
	{
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}
	public int getHealth()
	{
		return health;
	}
	public void setHealth(int health)
	{
		this.health = health;
	}
	public boolean isActive()
	{
		return active;
	}
	public void setActive(boolean active)
	{
		this.active = active;
	}

}
