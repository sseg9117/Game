package dev.sheradon.game.tile;

import dev.sheradon.game.gfx.Assets;

public class LavaTile extends Tile
{

	public LavaTile(int id)
	{
		super(Assets.lava, id);
	}

	@Override
	public boolean isSolid()
	{
		return true;
	}
	
	public boolean hurt()
	{
		return true;
	}
}