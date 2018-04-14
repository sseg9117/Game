
package dev.sheradon.game.ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import dev.sheradon.game.Handler;
//USED  CodeNMore YoutubeChannle as a refernce for the code in here he has a youtube tutorial video 
public class UIManager
{
	private Handler handler;
	private ArrayList<UIObject> menuObjects;
	private ArrayList<UIObject> selectObjects;
	
	public UIManager(Handler handler)
	{
		this.handler = handler;
		
		menuObjects = new ArrayList<UIObject>();
		selectObjects = new ArrayList<UIObject>();
			
	}
	
	public Handler getHandler()
	{
		return handler;
	}

	public void setHandler(Handler handler)
	{
		this.handler = handler;
	}

	public ArrayList<UIObject> getMenuObjects()
	{
		return menuObjects;
	}
	public ArrayList<UIObject> getSelectObjuects()
	{
		return selectObjects;
	}

	public void setMenuObjects(ArrayList<UIObject> menuObjects)
	{
		this.menuObjects = menuObjects;
	}
	public void setSelectObjects(ArrayList<UIObject> selectObjects)
	{
		this.selectObjects = selectObjects;
	}
	public void tick()
	{
		for(UIObject mo : menuObjects)
			mo.tick();
		for (UIObject so : selectObjects)
			so.tick();
	}
	
	public void render(Graphics g)
	{
		for(UIObject mo : menuObjects)
			mo.render(g);
		for (UIObject so : selectObjects)
			so.render(g);
	}
	
	public void onMouseMove(MouseEvent e)
	{
		for(UIObject mo : menuObjects)
			mo.onMouseMove(e);
		for (UIObject so : selectObjects)
			so.onMouseMove(e);
	}
	
	public void onMouseRelease(MouseEvent e)
	{
		for(UIObject mo : menuObjects)
			mo.onMouseRelease(e);
		for (UIObject so : selectObjects)
			so.onMouseRelease(e);
	}
	
	public void addMenuObject(UIObject mo)
	{
		menuObjects.add(mo);
	}
	
	public void removeMenuObject(UIObject mo)
	{
		menuObjects.remove(mo);
	}
	public void addSelectObject(UIObject so)
	{
		selectObjects.add(so);
	}
	
	public void removeSelectObject(UIObject so)
	{
		selectObjects.remove(so);
	}


	
}