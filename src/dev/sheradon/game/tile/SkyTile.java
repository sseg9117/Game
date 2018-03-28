package dev.sheradon.game.tile;

import dev.sheradon.game.gfx.Assets;

public class SkyTile extends Tile
{

	public SkyTile(int id)
	{
		super(Assets.sky, id);
	}

	@Override
	public boolean isSolid()
	{
		return false;
	}
}
