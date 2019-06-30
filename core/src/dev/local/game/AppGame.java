package dev.local.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import dev.local.game.fabric.AppCoreContext;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
public class AppGame extends Game {

  private int logLevel = 2;

  @Override
  public void create() {
    Gdx.app.setLogLevel(logLevel);
    this.setScreen(AppCoreContext.CONTEXT.mainMenuScreen());
  }

  @Override
  public void render() {
    super.render();
  }

  @Override
  public void dispose() {
    super.dispose();
    AppCoreContext.CONTEXT.coreTexture().dispose();
    AppCoreContext.logDebug("AppGame dispose");
  }

  public AppGame setLogLevel(int logLevel) {
    if (logLevel > 0 && logLevel < 5) this.logLevel = logLevel;
    return this;
  }

}
