package dev.sheradon.game.tile;

import dev.sheradon.game.gfx.Assets;

public class CloudTile extends Tile
{
	public CloudTile(int id)
	{
		super(Assets.cloud, id);
	}
	@Override
	public boolean isSolid()
	{
		return true;	
	}
}
