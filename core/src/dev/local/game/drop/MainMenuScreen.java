package dev.local.game.drop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import dev.local.game.fabric.CoreTexture;
import dev.local.game.fabric.ScreenDispatcher;

import javax.inject.Inject;

import static dev.local.game.fabric.ScreenDispatcher.SCREEN_GAME;

public class MainMenuScreen implements Screen {

  private CoreTexture coreTexture;
  private ScreenDispatcher screenDispatcher;

  public Texture backgroundTexture;
  public Sprite backgroundSprite;

  @Inject
  public MainMenuScreen(CoreTexture texture, ScreenDispatcher dispatcher) {
    this.coreTexture = texture;
    this.screenDispatcher = dispatcher;

    backgroundTexture = new Texture("data/logo.png");
    backgroundSprite = new Sprite(backgroundTexture);

    backgroundSprite.setPosition(
        (texture.camera().viewportWidth - backgroundSprite.getWidth()) / 2,
        (texture.camera().viewportHeight - backgroundSprite.getHeight()) / 2
    );
  }

  @Override
  public void show() {

  }

  @Override
  public void render(float delta) {

    coreTexture.render(Color.WHITE);
    backgroundSprite.draw(coreTexture.batch());

    coreTexture.font().setColor(Color.BLACK);
    GlyphLayout layout = new GlyphLayout(new BitmapFont(), "Tap anywhere to begin!", Color.BLACK, 0, 0, false);
    coreTexture.font().draw(coreTexture.batch(), layout, (coreTexture.camera().viewportWidth / 2) + (layout.width / 2), 100);
    coreTexture.batch().end();

    if (Gdx.input.isTouched()) {
      screenDispatcher.screen(SCREEN_GAME);
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
    backgroundTexture.dispose();
  }

}
