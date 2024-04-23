package com.badlogic.drop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.Texture;

public class GameOverScreen implements Screen {

    final Drop game;
    OrthographicCamera camera;
    int score;
    Texture menuImage;
    Rectangle menu;



    public GameOverScreen(Drop game, int score) {
        this.game = game;
        this.score = score;

        menuImage = new Texture(Gdx.files.internal("bMenu.png"));

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        menu = new Rectangle();
        menu.x = 300;
        menu.y = 240;
        menu.width = 170;
        menu.height = 66;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.font.draw(game.batch, "Que pena, você perdeu!", 100, 150);
        game.font.draw(game.batch, "Seu placar foi de: " + score , 100, 100);
        game.batch.draw(menuImage, menu.x, menu.y, menu.width, menu.height);
        game.batch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
