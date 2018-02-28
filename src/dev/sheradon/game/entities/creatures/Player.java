package dev.sheradon.game.entities.creatures;

import java.awt.Graphics;

import dev.sheradon.game.Handler;
import dev.sheradon.game.gfx.Animation;
import dev.sheradon.game.gfx.Assets;

public class Player extends Creature
{
	//Animations
	private Animation animLeft;
	
	public Player(Handler handler,float x, float y)
	{
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 20;
		bounds.y = 32;
		bounds.width = 16;
		bounds.height = 17;
		
		//Animations
		animLeft = new Animation(500, Assets.player_left);
		
	}

	@Override
	public void tick()
	{
		//Animations
		animLeft.tick();
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
		g.drawImage(animLeft.getCurrentFrame(), (int) (x- handler.getGameCamera().getXoffset()), (int) (y - handler.getGameCamera().getYoffset()), width, height, null);
		
//		g.setColor(Color.RED);
//		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getXoffset()),
//				(int) (y + bounds.y - handler.getGameCamera().getYoffset()),
//				bounds.width, bounds.height);
	}

}
