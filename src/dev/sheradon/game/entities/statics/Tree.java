package dev.sheradon.game.entities.statics;

import java.awt.Graphics;

import dev.sheradon.game.Handler;
import dev.sheradon.game.gfx.Assets;
import dev.sheradon.game.tile.Tile;

public class Tree extends StaticEntity
{

	public Tree(Handler handler, float x, float y)
	{
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT * 2);
		
		bounds.x = 10;
		bounds.y = (int) (height / 1.5f);
		bounds.width = width - 20;
		bounds.height = (int) (height - height / 1.5f);
	}

	@Override
	public void tick()
	{
		
	}

	@Override
	public void render(Graphics g)
	{
		g.drawImage(Assets.tree, (int) (x - handler.getGameCamera().getXoffset()), (int) (y - handler.getGameCamera().getYoffset()), width, height, null);

		
	}

}
