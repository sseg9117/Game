package dev.sheradon.game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.sheradon.game.display.Display;
import dev.sheradon.game.gfx.Assets;
import dev.sheradon.game.gfx.GameCamera;
import dev.sheradon.game.input.KeyManager;
import dev.sheradon.game.state.GameState;
import dev.sheradon.game.state.MenuState;
import dev.sheradon.game.state.State;

public class Game implements Runnable
{
	private Display display;
	private int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	private State gameState;
	private State menuState;
	
	//Input
	private KeyManager keyManager;
	
	
	//Camera
	private GameCamera gameCamera;
	
	public Game(String title, int width, int height)
	{
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		
	}
	
	private void init()
	{
		
		Assets.init();
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		
		gameCamera = new GameCamera(this, 0,0);
		
		gameState = new GameState(this);
		menuState = new MenuState(this);
		State.setState(gameState);
		
	}
	
	private void tick()
	{
		keyManager.tick();
		
		if(State.getState() != null)
			State.getState().tick();
	}
	
	private void render()
	{
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null)
		{
			display.getCanvas().createBufferStrategy(3);
			return;
			
		}
		g = bs.getDrawGraphics();
		//Clear Screen
		
		g.clearRect(0, 0, width, height);
		
		
		//Draw here
		
		if(State.getState() != null)
			State.getState().render(g);
		
		//End Drawing
		bs.show();
		g.dispose();
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
		
		while(running)
		{
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			
			if(delta >= 1)
			{
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000)
			{
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		stop();// just in case it doesn't stop
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
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	public KeyManager getKeyManager()
	{
		return keyManager;
	}
	
	
	public synchronized void stop()
	{
		if(!running)
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
}
