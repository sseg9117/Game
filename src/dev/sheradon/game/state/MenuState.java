package dev.sheradon.game.state;

import java.awt.Color;
import java.awt.Graphics;

import dev.sheradon.game.Handler;

public class MenuState extends State
{
	public MenuState(Handler handler)
	{
		super(handler);
	}

	@Override
	public void tick()
	{
	}

	@Override
	public void render(Graphics g)
	{
		g.setColor(Color.red);
		g.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 8, 8);
	}

}
