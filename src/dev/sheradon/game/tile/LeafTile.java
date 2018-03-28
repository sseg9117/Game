package dev.sheradon.game.tile;

import dev.sheradon.game.gfx.Assets;

public class LeafTile extends Tile
{

	public LeafTile(int id)
	{
		super(Assets.leaves, id);
	}

	@Override
	public boolean isSolid()
	{
		return true;
	}
}