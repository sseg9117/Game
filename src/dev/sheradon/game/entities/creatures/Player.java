package dev.sheradon.game.entities.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.sheradon.game.Handler;
import dev.sheradon.game.gfx.Animation;
import dev.sheradon.game.gfx.Assets;

public class Player extends Creature
{
	//Animations
	private Animation animLeft;
	private Animation animRight;
	private Animation animStill;
	
	public Player(Handler handler,float x, float y)
	{
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 10;
		bounds.y = 20;
		bounds.width = 37;
		bounds.height = 42;
		
		//Animations
		animLeft = new Animation(1000, Assets.player_left);
		animRight = new Animation(1000, Assets.player_right);
		animStill = new Animation(1000, Assets.player_still);
	}

	@Override
	public void tick()
	{
		//Animations
		animLeft.tick();
		animRight.tick();
		animStill.tick();
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
		
//		g.setColor(Color.RED);
//		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getXoffset()),
//				(int) (y + bounds.y - handler.getGameCamera().getYoffset()),
//				bounds.width, bounds.height);
	}
	private BufferedImage getCurrentAnimationFrame()
	{
		if(xMove < 0)
		{
			return animLeft.getCurrentFrame();
		}
		else if(xMove > 0)
		{
			return animRight.getCurrentFrame();
		}
		else if(yMove < 0)
		{
			return animStill.getCurrentFrame();
		}
		else
		{
			return animStill.getCurrentFrame();
		}
	}

}
