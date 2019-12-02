package com.pigeon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import org.mini2Dx.core.engine.geom.CollisionPoint;
import org.mini2Dx.core.game.BasicGame;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.graphics.Sprite;
import org.mini2Dx.core.graphics.viewport.FitViewport;
import org.mini2Dx.core.graphics.viewport.Viewport;

import java.awt.*;

public class Pigeon extends BasicGame {
	public static final String GAME_IDENTIFIER = "com.pigeon";

    private Sprite sprite;
    private Viewport viewport;
    private CollisionPoint point;

	@Override
    public void initialise() {
        float gameWidth = 800;
        float gameHeight = 600;
        viewport = new FitViewport(gameWidth, gameHeight);
        point = new CollisionPoint();
        sprite = new Sprite(new Texture(Gdx.files.internal("pigeon.png")));
    }
    
    @Override
    public void update(float delta) {
	    //preUpdate() must be called before any changes are made to the CollisionPoint
        point.preUpdate();
        //Move the point by 4 pixels on the X and Y axis
        Point mouse = MouseInfo.getPointerInfo().getLocation();
        point.set(((float) mouse.getX())-450, ((float) mouse.getY())-300);
    }
    
    @Override
    public void interpolate(float alpha) {
        //This method uses the lerp (linear interpolate) method from LibGDX
        //to interpolate between the previous and current positions
        //and set the render coordinates correctly
        point.interpolate(null, alpha);
    }
    
    @Override
    public void render(Graphics g) {
        viewport.apply(g);
        //Use the point's render coordinates to draw the sprite
        g.drawSprite(sprite, point.getRenderX(), point.getRenderY());
    }
}
