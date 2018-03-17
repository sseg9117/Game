package dev.sheradon.game.inventory;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import dev.sheradon.game.Handler;
import dev.sheradon.game.items.Item;

public class Inventory
{
	private Handler handler;
	private boolean active = false;
	private ArrayList<Item> inventoryItems;
	
	public Inventory(Handler handler)
	{
		this.handler = handler;
		inventoryItems = new ArrayList<Item>();
	}
	
	public void tick()
	{
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_Q))
			active = !active;
		if(!active)
			return;
	}
	
	public void render(Graphics g)
	{
		if(!active)
			return;	
	}
	
	public void addItem(Item item)
	{
		for(Item i : inventoryItems)
		{
			if(i.getId() == item.getId())
			{
				i.setCount(i.getCount() + item.getCount());
				return;
			}
		}
		inventoryItems.add(item);
	}
	public Handler getHandler()
	{
		return handler;
	}

	public void setHandler(Handler handler)
	{
		this.handler = handler;
	}
}
