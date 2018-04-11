package dev.sheradon.game.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dev.sheradon.game.Handler;
import dev.sheradon.game.entities.Entity;
import dev.sheradon.game.gfx.Animation;
import dev.sheradon.game.gfx.Assets;
import dev.sheradon.game.inventory.Inventory;
//USED  CodeNMore YoutubeChannle as a refernce for the code in here he has a youtube tutorial video 
public class Player2 extends Creature
{
	//Animations
	private Animation animleft2;
	private Animation animright2;
	private Animation animup2;
	private Animation animdown2;
	private Animation animstill2;
	private Animation animjump2;
	private Inventory inventory2;
	

	
	public Player2(Handler handler,float x, float y)
	{
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

		bounds.x = 12;
		bounds.y = 17;
		bounds.width = 35;
		bounds.height = 42;
		
		//Animations
		animleft2 = new Animation(500, Assets.player2_left);
		animright2 = new Animation(500, Assets.player2_right);
		animup2 = new Animation(500, Assets.player2_up);
		animdown2 = new Animation(500, Assets.player2_down);
		animstill2 = new Animation(500, Assets.player2_still);
		animjump2 = new Animation(500, Assets.player2_jump);
		
		inventory2 = new Inventory(handler);
	}

	@Override
	public void tick()
	{
		//Animations
		animleft2.tick();
		animright2.tick();
		animup2.tick();
		animdown2.tick();
		animstill2.tick();
		animjump2.tick();
		//Movement
		move();
		getInput();
		handler.getGameCamera().centerOnEntity(this);
		inventory2.tick();
	
		//Attack method if i need it
		checkAttacks();
	}
	
	private void checkAttacks()
	{
		Rectangle cb = getCollisionBounds(0,0);
		Rectangle ar = new Rectangle();
		int arSize = 30;
		ar.width = arSize;
		ar.height = arSize;
		
		if(handler.getKeyManager().attackLeft)
		{
			ar.x = cb.x - arSize;
			ar.y = cb.y + cb.height /2 - arSize /2;
		}
		else if(handler.getKeyManager().attackRight)
		{
			ar.x = cb.x + cb.width;
			ar.y = cb.y + cb.height /2 - arSize /2;
		}
		else
		{
			return;
		}
		
		for(Entity e : handler.getWorld().getEntityManager().getEntities())
			{	
				if(e.equals(this))
					continue;
			
				if(e.getCollisionBounds(0,0).intersects(ar))
				{
					e.hurt(1);
					return;
				}
			}
		
	}

	private void getInput()
	{
		xMove = 0;
		yMove = 0;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed; 
		if(falling || jumping)
			yMove += gravity;
		if(handler.getKeyManager().space&& jumping)
			yMove = jump;
			jumping = true;		
		
				
	}
	@Override
	public void render(Graphics g)
	{
		g.drawImage(getCurrentAnimationFrame(), (int) (x- handler.getGameCamera().getXoffset()), (int) (y - handler.getGameCamera().getYoffset()), width, height, null);
		inventory2.render(g);
//		
//		g.setColor(Color.RED);
//		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getXoffset()),
//				(int) (y + bounds.y - handler.getGameCamera().getYoffset()),
//				bounds.width, bounds.height);
	}
	
	@Override
	public void die()
	{
		System.out.println("Game Over");
	}
	
	private BufferedImage getCurrentAnimationFrame()
	{
		if(xMove < 0)
		{
			return animleft2.getCurrentFrame();
		}
		else if(xMove > 0)
		{
			return animright2.getCurrentFrame();
		}
		else if(yMove < 0)
		{
			return animup2.getCurrentFrame();
		}
		else if(yMove > 0)
		{
			return animdown2.getCurrentFrame();
		}
		else if(yMove < 0)
		{
			return animjump2.getCurrentFrame();
		}
		else
		{
			return animstill2.getCurrentFrame();
		}

	
	}

	public Inventory getInventory2()
	{
		return inventory2;
	}

	public void setInventory(Inventory inventory2)
	{
		this.inventory2 = inventory2;
	}

}
