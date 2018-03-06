package dev.sheradon.game.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.sheradon.game.Handler;
import dev.sheradon.game.gfx.Animation;
import dev.sheradon.game.gfx.Assets;

public class Player extends Creature
{
	//Animations
	private Animation animleft;
	private Animation animright;
	private Animation animup;
	private Animation animdown;
	
	public Player(Handler handler,float x, float y)
	{
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

		bounds.x = 5;
		bounds.y = 8;
		bounds.width = 22;
		bounds.height = 23;
		
		//Animations
		animleft = new Animation(500, Assets.player_left);
		animright = new Animation(500, Assets.player_right);
		animup = new Animation(500, Assets.player_up);
		animdown = new Animation(500, Assets.player_down);
	}

	@Override
	public void tick()
	{
		//Animations
		animleft.tick();
		animright.tick();
		animup.tick();
		animdown.tick();
		//Movement
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}

	private void getInput()
	{
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
	}
	@Override
	public void render(Graphics g)
	{
		g.drawImage(getCurrentAnimationFrame(), (int) (x- handler.getGameCamera().getXoffset()), (int) (y - handler.getGameCamera().getYoffset()), width, height, null);
		
		g.setColor(Color.RED);
		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getXoffset()),
				(int) (y + bounds.y - handler.getGameCamera().getYoffset()),
				bounds.width, bounds.height);
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
		else
		{
			return animdown.getCurrentFrame();
		}
	}

}
