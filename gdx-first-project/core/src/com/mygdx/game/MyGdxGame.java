package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private Tank tank;
    private BotTank botTank;

    @Override
    public void create() {
        batch = new SpriteBatch();
        tank = new Tank();
        botTank = new BotTank();
    }

    @Override
    public void render() {
        float dt = Gdx.graphics.getDeltaTime();
        update(dt);
        Gdx.gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        tank.render(batch);
        botTank.render(batch);
        batch.end();
    }

    public void update(float dt) {
        tank.update(dt, botTank);
        botTank.update(dt);
    }

    @Override
    public void dispose() {
        batch.dispose();
        tank.dispose();
        botTank.dispose();
    }
}
