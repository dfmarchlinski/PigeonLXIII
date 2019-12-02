package com.pigeon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import org.mini2Dx.core.engine.geom.CollisionPoint;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.graphics.Sprite;

public class Player {
    private CollisionPoint point;
    private Sprite sprite;

    public Player() {
        point = new CollisionPoint();
        sprite = new Sprite(new Texture(Gdx.files.internal("pigeon.png")));
    }

    public void update() {
        //preUpdate() must be called before any changes are made to the CollisionPoint
        point.preUpdate();
        //Move the point by 4 pixels on the X and Y axis
        point.set(point.getX() + 4f, point.getY() + 4f);
    }

    public void interpolate(float alpha) {
        //This method uses the lerp (linear interpolate) method from LibGDX
        //to interpolate between the previous and current positions
        //and set the render coordinates correctly
        point.interpolate(null, alpha);
    }

    public void render(Graphics g) {
        //Use the point's render coordinates to draw the sprite
        g.drawSprite(sprite, point.getRenderX(), point.getRenderY());
    }
}
