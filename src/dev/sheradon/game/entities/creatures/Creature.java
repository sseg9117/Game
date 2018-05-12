package dev.sheradon.game.entities.creatures;

import dev.sheradon.game.Handler;
import dev.sheradon.game.entities.Entity;
import dev.sheradon.game.tile.Tile;
//USED  CodeNMore YoutubeChannle as a refernce for the code in here he has a youtube tutorial video 
public abstract class Creature extends Entity
{

	public static final float DEFAULT_SPEED = 5.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 64,
			DEFAULT_CREATURE_HEIGHT = 64;
	protected float gravity;
	protected float jump;
    protected boolean falling;
    protected boolean jumping;
    protected boolean moving;
	protected float speed;
	protected float xMove, yMove;
	
	public Creature(Handler handler, float x, float y, int width, int height)
	{
		super(handler, x, y, width, height);
		speed = DEFAULT_SPEED;
		jump = -speed -8;
		gravity = speed;
		jumping = false;
		falling = true;
		xMove = 0;
		yMove = 0;
	}
	public void jumping()
	{
		if(jumping)
			yMove = -speed;
	}
	public void move()
	{
		if (!checkEntityCollision(xMove, 0f))
			moveX();
		if (!checkEntityCollision(0f, yMove))
			moveY();
	}
	public void moveX()
	{
		if (xMove > 0)// Moving right
		{
			int tx = (int) (x + xMove + bounds.x + bounds.width)
					/ Tile.TILEWIDTH;

			if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT)
					&& !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT))
			{
				x += xMove;
			} 
			else
			{
				x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
			}

		}

		else if (xMove < 0)// Moving left
		{
			int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;

			if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT)
					&& !collisionWithTile(tx,(int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT))
			{
				x += xMove;
			}
			else
			{
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
			}
		}
	}

	public void moveY()
	{
		if (yMove < 0)// Up
		{
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;

			if (!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty)
					&& !collisionWithTile((int) (x + bounds.x + bounds.width)
							/ Tile.TILEWIDTH, ty))
			{
				y += yMove;
				
			
			} 
			else
			{
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
			}
		} 
		else if (yMove > 0)
		{
			int ty = (int) (y + yMove + bounds.y + bounds.height)
					/ Tile.TILEHEIGHT;

			if (!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty)
					&& !collisionWithTile((int) (x + bounds.x + bounds.width)
							/ Tile.TILEWIDTH, ty))
			{
				y += yMove;
			} 
			else
			{
				y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
			}
		}

	}
	protected boolean collisionWithTile(int x, int y)
	{
		return handler.getWorld().getTile(x, y).isSolid();

	}
	// GETTERS SETTERS
	public boolean isJumping()
	{
		return jumping;
	}

	public void setJumping(boolean jumping)
	{
		this.jumping = jumping;
	}

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
	public float getGravity()
	{
		return gravity;
	}

	public void setGravity(float gravity)
	{
		this.gravity = gravity;
	}

	public boolean isMoving()
	{
		return moving;
	}

	public void setMoving(boolean moving)
	{
		this.moving = moving;
	}
	public static float getDefaultSpeed()
	{
		return DEFAULT_SPEED;
	}
	public static int getDefaultCreatureWidth()
	{
		return DEFAULT_CREATURE_WIDTH;
	}
	public static int getDefaultCreatureHeight()
	{
		return DEFAULT_CREATURE_HEIGHT;
	}
	
}
