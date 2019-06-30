package dev.local.game.fabric;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.inject.Inject;

@Accessors(chain = true, fluent = true)
@Data
public class CoreTexture {

  private SpriteBatch batch = new SpriteBatch();
  private BitmapFont font = new BitmapFont();
  private OrthographicCamera camera;

  @Inject
  public CoreTexture() {
    camera = new OrthographicCamera();
    camera.setToOrtho(false, 800, 480);

    AppCoreContext.logDebug("Create CoreTexture");
  }

  public void dispose() {
    dispose(batch, font);
  }

  public CoreTexture render(Color bgColor) {

    Gdx.gl.glClearColor(bgColor.r, bgColor.g, bgColor.b, bgColor.a);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    camera.update();
    batch.setProjectionMatrix(camera.combined);
    batch.begin();

    return this;
  }

  public void dispose(Disposable... disposableArr) {
    for (Disposable disposable : disposableArr) {
      if (disposable != null) {
        try {
          disposable.dispose();
        } catch (Exception e) {
          System.err.println(e);
        }
      }
    }
  }
}
