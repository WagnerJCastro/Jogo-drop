package com.badlogic.drop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.Texture;

public class MainMenuScreen implements Screen {

    final Drop game;

    Texture zenImage;
    Texture survivalImage;
    Rectangle zen;
    Rectangle survival;


    OrthographicCamera camera;

    public MainMenuScreen(final Drop game) {
        this.game = game;

        // load the images for the droplet and the bucket, 64x64 pixels each
        zenImage = new Texture(Gdx.files.internal("bZen.png"));
        survivalImage = new Texture(Gdx.files.internal("bSurvival.png"));

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        zen = new Rectangle();
        zen.x = 200;
        zen.y = 240;
        zen.width = 170;
        zen.height = 66;

        survival = new Rectangle();
        survival.x = 400;
        survival.y = 240;
        survival.width = 170;
        survival.height = 66;
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
        game.font.draw(game.batch, "Um jogo desenvolvido por Wagnaldo - O gostoso! ", 100, 150);
        game.font.draw(game.batch, "Senta o dedo na tela pra começar", 100, 100);
        game.batch.draw(zenImage, zen.x, zen.y, zen.width, zen.height);
        game.batch.draw(survivalImage, survival.x, survival.y, survival.width, survival.height);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);

            if (zen.contains(touchPos.x, touchPos.y)) {
                game.setScreen(new GameScreen(game));
            } else if (survival.contains(touchPos.x, touchPos.y)) {
                game.setScreen(new SurvivalGameScreen(game));
            }

            dispose();
        }
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
