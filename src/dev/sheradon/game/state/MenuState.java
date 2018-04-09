package dev.sheradon.game.state;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;

import dev.sheradon.game.Handler;
import dev.sheradon.game.gfx.Assets;
import dev.sheradon.game.ui.ClickListener;
import dev.sheradon.game.ui.UIImageButton;
import dev.sheradon.game.ui.UIManager;

public class MenuState extends State implements ImageObserver
{

	private UIManager uiManager;
	private boolean running = false;
	private Thread thread;
	public MenuState(Handler handler)
	{
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);

		uiManager.addObject(new UIImageButton(352, 200, 256, 128, Assets.btn_menu, new ClickListener() 
		{
			@Override
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
	public void render(Graphics2D g2d)
	{
		uiManager.render(g2d);
	}

	public boolean isRunning()
	{
		return running;
	}

	public void setRunning(boolean running)
	{
		this.running = running;
	}

	public Thread getThread()
	{
		return thread;
	}

	public void setThread(Thread thread)
	{
		this.thread = thread;
	}

	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height)
	{
		return false;
	}

}
