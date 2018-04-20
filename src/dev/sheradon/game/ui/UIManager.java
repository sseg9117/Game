
package dev.sheradon.game.ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import dev.sheradon.game.Handler;
//USED  CodeNMore YoutubeChannle as a refernce for the code in here he has a youtube tutorial video 
public class UIManager
{
	private Handler handler;
	private ArrayList<UIObject> objects;
	private ArrayList<UIObject2> objects2;

	public UIManager(Handler handler)
	{
		this.handler = handler;
		objects = new ArrayList<UIObject>();
		objects2= new ArrayList<UIObject2>();		
	}
	
	public Handler getHandler()
	{
		return handler;
	}

	public void setHandler(Handler handler)
	{
		this.handler = handler;
	}

	public ArrayList<UIObject> getObjects()
	{
		return objects;
	}

	public void setObjects(ArrayList<UIObject> objects)
	{
		this.objects = objects;
	}

	public void tick()
	{
		for(UIObject o : objects)
			o.tick();
	}
	
	public void render(Graphics g)
	{
		for(UIObject o : objects)
			o.render(g);
	}
	
	public void onMouseMove(MouseEvent e)
	{
		for(UIObject o : objects)
			o.onMouseMove(e);
	}
	
	public void onMouseRelease(MouseEvent e)
	{
		for(UIObject o : objects)
			o.onMouseRelease(e);
	}
	
	public void addObject(UIObject o)
	{
		objects.add(o);
	}
	
	public void removeObject(UIObject o)
	{
		objects.remove(o);
	}

}