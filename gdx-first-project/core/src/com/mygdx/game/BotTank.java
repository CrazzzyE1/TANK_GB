package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BotTank {

    private Texture texture;
    private float x;
    private float y;
    private float speed;
    private float scale;
    private int health;

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    // получение урона от пули
    public void damage(int damage) {
        if (damage > health) {
            health = 0;
        } else {
            health -= damage;
        }
    }

    public BotTank() {
        this.x = 1000;
        this.y = 760;
        this.texture = new Texture("bot.png");
        this.speed = 150.0f;
        this.scale = 3f;
        this.health = 100;
    }

    public void update(float dt) {
        y -= speed * dt;
        if (x < -60 || x > 1340 || y < -60 || y > 780) {
            y = 760;
        }

        // рандомное появление после возрождения бота
        if (health <= 0) {
            health = 100;
            x = (float) (Math.random() * 1200 + 40);
            y = 760;
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, x - 20, y - 20, 20, 20, 40, 40, scale, scale, 270, 0, 0, 40, 40, false, false);
    }

    public void dispose() {
        texture.dispose();
    }
}