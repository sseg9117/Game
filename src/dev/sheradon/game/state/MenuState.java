package dev.sheradon.game.state;

import java.awt.Graphics2D;

import dev.sheradon.game.Handler;
import dev.sheradon.game.gfx.Assets;
import dev.sheradon.game.ui.ClickListener;
import dev.sheradon.game.ui.UIImageButton;
import dev.sheradon.game.ui.UIManager;

public class MenuState extends State
{
	private UIManager uiManager;
	private boolean running = false;
	private Thread thread;
	public MenuState(Handler handler)
	{
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(352, 400, 256, 128, Assets.btn_menu, new ClickListener() 
		{
			@Override
			public void onCick()
			{
				if (!running)
					return;
				running = false;
				try
				{
					thread.join();
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			}));
	
		uiManager.addObject(new UIImageButton(352, 200, 256, 128, Assets.btn_start, new ClickListener() 
		{
			public void onCick()
			{
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
			}}));
	}

	@Override
	public void tick()
	{
		uiManager.tick();
	}

	@Override
	public void render(Graphics2D g)
	{
		
		uiManager.render(g);
	}

}
