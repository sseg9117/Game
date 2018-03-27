package dev.sheradon.game.entities.creatures;

import java.awt.Graphics2D;
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
	

	
	public Player(Handler handler,float x, float y)
	{
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

		bounds.x = 12;
		bounds.y = 17;
		bounds.width = 35;
		bounds.height = 42;
		
		//Animations
		animleft = new Animation(100, Assets.player_left);
		animright = new Animation(100, Assets.player_right);
		animup = new Animation(100, Assets.player_up);
		animdown = new Animation(100, Assets.player_down);
		animstill = new Animation(500, Assets.player_still);
		animjump = new Animation(100, Assets.player_jump);
		
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
	
	private void checkAttacks()
	{
		Rectangle cb = getCollisionBounds(0,0);
		Rectangle ar = new Rectangle();
		int arSize = 20;
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
		if(handler.getKeyManager().space)
			yMove = jump;
				
	}
	@Override
	public void render(Graphics2D g)
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
