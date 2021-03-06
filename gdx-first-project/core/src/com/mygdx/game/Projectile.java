package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class Projectile {
    private Texture texture;
    private float x;
    private float y;
    private float vx;
    private float vy;
    private float speed;
    private boolean active;
    private int damage;

    public boolean isActive() {
        return active;
    }

    public void deactivate() {
        active = false;
    }

    public Projectile() {
        this.texture = new Texture("projectile.png");
        this.speed = 600.0f;
        this.damage = 100;
    }

    public void shoot(float x, float y, float angle) {
        this.x = x;
        this.y = y;
        this.vx = speed * MathUtils.cosDeg(angle);
        this.vy = speed * MathUtils.sinDeg(angle);
        this.active = true;
    }

    public void update(float dt, BotTank botTank) {
        x += vx * dt;
        y += vy * dt;
        if(x > botTank.getX() - 60 && y > botTank.getY() - 60 && x < botTank.getX() + 60 && y < botTank.getY() + 60){
            botTank.damage(damage);
            deactivate();
        }
        if (x < 0 || x > 1280 || y < 0 || y > 720) {
            deactivate();
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, x - 8, y - 8, 8, 8, 16, 16, 2, 2, 0, 0, 0, 16, 16, false, false);
    }

    public void dispose() {
        texture.dispose();
    }
}
