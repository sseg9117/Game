package dev.sheradon.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import dev.sheradon.game.display.Display;
import dev.sheradon.game.gfx.Assets;
import dev.sheradon.game.gfx.GameCamera;
import dev.sheradon.game.input.KeyManager;
import dev.sheradon.game.input.MouseManager;
import dev.sheradon.game.state.GameState;
import dev.sheradon.game.state.MenuState;
import dev.sheradon.game.state.OptionState;
import dev.sheradon.game.state.State;
//USED  CodeNMore YoutubeChannle as a refernce for the code in here he has a youtube tutorial video 
public class Game implements Runnable
{
	private Display display;
	private int width, height;
	public String title;

	private boolean running = false;
	private Thread thread;
	private BufferStrategy bs;
	private Graphics2D g;

	// States i will be adding more as i write more code
	public State gameState;
	public State menuState;
	public State optionState;
	// Input
	private KeyManager keyManager;
	private MouseManager mouseManager;

	// Camera
	private GameCamera gameCamera;
	// Handler
	private Handler handler;

	public Game(String title, int width, int height)
	{
		this.width = width;
		this.height = height;
		this.title = title;
		mouseManager = new MouseManager();
		keyManager = new KeyManager();

	}

	private void init()
	{
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();

		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);

		
		gameState = new GameState(handler);
		optionState = new OptionState(handler);
		setMenuState(new MenuState(handler));
		State.setState(menuState);
	}

	private void tick()
	{
		keyManager.tick();

		if (State.getState() != null)
			State.getState().tick();
	}

	private void render()
	{
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null)
		{
			display.getCanvas().createBufferStrategy(3);
			return;

		}

		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(-6, -28);
		// Clear Screen
		g2d.setColor(Color.YELLOW);
		g2d.clearRect(1, 1, width, height);
		g2d.fillRect(0, 0, width, height);

		// Draw here
		if (State.getState() != null)
			State.getState().render(g2d);

		// End Drawing
		g.dispose();
		bs.show();
	}

	public void run()
	{
		init();

		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;

		while (running)
		{
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1)
			{
				tick();
				render();
				ticks++;
				delta--;
			}

			// if (timer >= 1000000000)
			// {
			// System.out.println("Ticks and Frames: " + ticks);
			// ticks = 0;
			// timer = 0;
			// }
		}
		stop();// just in case it doesn't stop
	}

	public MouseManager getMouseManager()
	{
		return mouseManager;
	}
	public KeyManager getKeyManager()
	{
		return keyManager;
	}
	public GameCamera getGameCamera()
	{
		return gameCamera;
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}
	public synchronized void start()
	{
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop()
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

	public State getMenuState()
	{
		return menuState;
	}

	public void setMenuState(State menuState)
	{
		this.menuState = menuState;
	}
	
}
