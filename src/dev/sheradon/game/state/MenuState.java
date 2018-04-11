package dev.sheradon.game.state;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import dev.sheradon.game.Handler;
import dev.sheradon.game.gfx.Assets;
import dev.sheradon.game.ui.ClickListener;
import dev.sheradon.game.ui.UIImageButton;
import dev.sheradon.game.ui.UIManager;
import dev.sheradon.game.ui.UIObject;

public class MenuState extends State
{
	private BufferedImage menu;
	private UIManager uiManager;
	protected Rectangle start;
	private boolean running = false;
	private Thread thread;
	
	public MenuState(Handler handler)
	{
		super(handler);
		try
		{
			menu = ImageIO.read(new File("res/textures/Menu.png"));
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		// Buttons
		// State.setState(handler.getGame().gameState);
//		Rectangle start = new Rectangle(300, 500, 230, 100);
//		
//		if(handler.getMouseManager().isLeftPressed())
//		{
//			State.setState(handler.getGame().menuState);
//		}
//		else
//			State.setState(handler.getGame().gameState);
		///////////////////////////////////////////////////////////
//		uiManager.addObject(new UIImageButton(352, 200, 256, 128, Assets.btn_start, new ClickListener() 
//		{
//				@Override
//				public void onCick()
//				{
//				 handler.getMouseManager().setUIManager(uiManager);
//				 State.setState(handler.getGame().gameState);
//			}}));
	}	

	@Override
	public void tick()
	{
		uiManager.tick();
	}

	@Override
	public void render(Graphics g)
	{
		g.drawImage(menu, 0, 0, null);
		uiManager.render(g);
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
}
