package dev.sheradon.game.entities.statics;

import dev.sheradon.game.Handler;
import dev.sheradon.game.entities.Entity;

public abstract class StaticEntity extends Entity
{
	public StaticEntity(Handler handler, float x, float y, int width,
			int height)
	{
		super(handler, x, y, width, height);
	}
}
