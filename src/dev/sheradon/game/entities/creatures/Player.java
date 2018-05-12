package dev.sheradon.game.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dev.sheradon.game.Handler;
import dev.sheradon.game.gfx.Animation;
import dev.sheradon.game.gfx.Assets;
import dev.sheradon.game.inventory.Inventory;
//USED  CodeNMore YoutubeChannle as a refernce for the code in here he has a youtube tutorial video 
public class Player extends Creature
{
	//Animations
	private Animation animleft;
	private Animation animright;
	private Animation animup;
	private Animation animdown;
	private Animation animstill;
	private Animation animjump;
	private Inventory inventory;
	

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
		
		for(dev.sheradon.game.entities.Entity e : handler.getWorld().getEntityManager().getEntities())
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
	//startComplexity
	//used some stackoverflow for help and a little of CodNMore's youtube tutorial video
	public Player(Handler handler,float x, float y)
	{
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
//
//		bounds.x = 20;
//		bounds.y = 30;
//		bounds.width = 65;
//		bounds.height = 70;

		bounds.x = 10;
		bounds.y = 15;
		bounds.width = 33;
		bounds.height = 35;
		
		//Animations
		animleft = new Animation(100, Assets.player2_left);
		animright = new Animation(100, Assets.player2_right);
		animup = new Animation(100, Assets.player2_up);
		animdown = new Animation(100, Assets.player2_down);
		animstill = new Animation(500, Assets.player2_still);
		animjump = new Animation(100, Assets.player2_jump);
		
		inventory = new Inventory(handler);
	}
	


	@Override
	public void tick()
	{
		//Animations
		animleft.tick();
		animright.tick();
		animup.tick();
		animdown.tick();
		animstill.tick();
		animjump.tick();
		//Movement
		move();
		getInput();
		handler.getGameCamera().centerOnEntity(this);
		inventory.tick();
	
		//Attack method if i need it
		checkAttacks();
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
		inventory.render(g);
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
			return animleft.getCurrentFrame();
		}
		else if(xMove > 0)
		{
			return animright.getCurrentFrame();
		}
		else if(yMove < 0)
		{
			return animup.getCurrentFrame();
		}
		else if(yMove > 0)
		{
			return animdown.getCurrentFrame();
		}
		else if(yMove < 0)
		{
			return animjump.getCurrentFrame();
		}
		else
		{
			return animstill.getCurrentFrame();
		}
	//endComplexity
	}

	public Inventory getInventory()
	{
		return inventory;
	}

	public void setInventory(Inventory inventory)
	{
		this.inventory = inventory;
	}

}
