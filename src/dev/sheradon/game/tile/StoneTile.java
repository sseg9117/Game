package dev.sheradon.game.tile;

import java.awt.image.BufferedImage;

import dev.sheradon.game.gfx.Assets;

public class StoneTile extends Tile
{

	public StoneTile( int id)
	{
		super(Assets.stone, id);
	}
	
	@Override
	public boolean isSolid()
	{
		return true;
	}
}
