package dev.sheradon.game;

import dev.sheradon.game.display.Display;

public class Game implements Runnable
{
	private Display display;
	public int width, height;
	
	private boolean running = false;
	private Thread thread;
	
	public Game(String title, int width, int height)
	{
		this.width = width;
		this.height = height;
		
		display = new Display(title, width, height);
	}
	private void init()
	{
		
	}
	
	private void tick()
	{
		
	}
	
	private void render()
	{
		
	}
	public void run()
	{
		init();
		
		while(running)
		{
			tick();
			render();
		}
		stop();// just incase it dosnt stop
	}
	
	public synchronized void start()
	{
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop()
	{
		try
		{
			thread.join();
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
