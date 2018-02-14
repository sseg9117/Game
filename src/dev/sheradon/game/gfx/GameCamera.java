package dev.sheradon.game.gfx;

import dev.sheradon.game.Game;
import dev.sheradon.game.entities.Entity;

public class GameCamera
{
	private Game game;
	private float xoffset, yoffset;
	public GameCamera(Game game, float xoffset, float yoffset)
	{
		this.game = game;
		this.xoffset = xoffset;
		this.yoffset = yoffset;
	}
	public void centerOnEntity(Entity e)
	{
		xoffset = e.getX() - game.getWidth() / 2 + e.getWidth() / 2;
		yoffset = e.getY() - game.getHeight() / 2  + e.getHeight() / 2;
	}
	public void move(float xAmt, float yAmt)
	{
		xoffset += xAmt;
		yoffset += yAmt;
	}
	public float getXoffset()
	{
		return xoffset;
	}
	public void setXoffset(float xoffset)
	{
		this.xoffset = xoffset;
	}
	public float getYoffset()
	{
		return yoffset;
	}
	public void setYoffset(float yoffset)
	{
		this.yoffset = yoffset;
	}
}
