package dev.sheradon.game.tile;

import dev.sheradon.game.gfx.Assets;

public class DirtTile extends Tile
{

	public DirtTile(int id)
	{
		super(Assets.dirt, id);
	}
	@Override
	public boolean isSolid()
	{
		return true;
	}

}
