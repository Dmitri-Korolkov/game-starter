package dev.local.game.drop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;
import dev.local.game.fabric.CoreTexture;

import javax.inject.Inject;

public class GameScreen implements Screen {

  private OrthographicCamera camera;
  private Vector3 touchPos;
  private CoreTexture coreTexture;
  public Texture bgBall;
  public Sprite ballSprite;

  private int ballX = 50;
  private int ballY = 50;
  private String position = null;

  @Inject
  public GameScreen(CoreTexture coreTexture) {
    this.coreTexture = coreTexture;
    camera = new OrthographicCamera();
    camera.setToOrtho(false, 800, 480);

    bgBall = new Texture("data/ball.png");
    ballSprite = new Sprite(bgBall);

    touchPos = new Vector3();
  }

  @Override
  public void render(float delta) {

    coreTexture.render(Color.WHITE);

    if (Gdx.input.isTouched()) {
      touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
      camera.unproject(touchPos);

      position = String.format("Touch position is `%s` for X and `%s` for Y", touchPos.x, touchPos.y);
      ballX = ballX > touchPos.x ? ballX - 2 : ballX + 2;
      ballY = ballY > touchPos.y ? ballY - 2 : ballY + 2;
    }
    if (position != null) {
      GlyphLayout layoutTouch = new GlyphLayout(new BitmapFont(), position, Color.BLACK, 0, 0, false);
      coreTexture.font().draw(coreTexture.batch(), layoutTouch, (camera.viewportWidth / 2) + (layoutTouch.width / 2), camera.viewportHeight - 50);
    }

    ballSprite.setPosition(ballX, ballY);

    ballSprite.draw(coreTexture.batch());
    coreTexture.batch().end();
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
    bgBall.dispose();
  }

  @Override
  public void show() {
  }
}
