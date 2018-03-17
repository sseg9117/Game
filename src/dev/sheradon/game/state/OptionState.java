package dev.sheradon.game.state;


import java.awt.Graphics2D;

import dev.sheradon.game.Handler;

public class OptionState extends State
{
	private OptionState options;
	public OptionState(Handler handler)
	{
		super(handler);

	}
	@Override
	public void tick()
	{
		options.tick();
	}

	@Override
	public void render(Graphics2D g)
	{
		options.render(g);
	}

	
}