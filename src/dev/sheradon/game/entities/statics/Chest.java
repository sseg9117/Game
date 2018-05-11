package dev.sheradon.game.entities.statics;

import java.awt.Graphics;

import dev.sheradon.game.Handler;
import dev.sheradon.game.tile.Tile;
//Might have used something fron stackoverflow but dont remember
public class Chest extends StaticEntity
{

	public Chest(Handler handler, float x, float y)
	{
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT * 1);

		bounds.x = (int) (20.55f);
		bounds.y = (int) (height / 2.3f);
		bounds.width = width - 40;
		bounds.height = (int) (height - height / 2.1f);
	}

	@Override
	public void tick()
	{

	}
	@Override
	public void die()
	{
	}
	@Override
	public void render(Graphics g)
	{

	}

}
