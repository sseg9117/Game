package dev.sheradon.game.state;


import java.awt.Graphics2D;

import dev.sheradon.game.Handler;
import dev.sheradon.game.gfx.Assets;
import dev.sheradon.game.ui.ClickListener;
import dev.sheradon.game.ui.OptionManager;
import dev.sheradon.game.ui.UIImageButton;

public class OptionState extends State
{
	private boolean running = false;
	private Thread thread;
	private OptionManager optionState;
	public OptionState(Handler handler)
	{
		super(handler);
		optionState = new OptionManager(handler);
		handler.getMouseManager().setOptionManager(optionState);

		optionState.setObjects(new UIImageButton(352, 200, 256, 128, Assets.btn_start, new ClickListener() 
		{
			public void onCick()
			{
				handler.getMouseManager().setOptionManager(null);
				State.setState(handler.getGame().optionState);
			}}));
	}
	@Override
	public void tick()
	{
		optionState.tick();
	}

	@Override
	public void render(Graphics2D g)
	{
		optionState.render(g);
	}

	
}