package dev.local.game.fabric;

import com.badlogic.gdx.Gdx;

public class AppCoreContext {

  public static final String DEBUG = "DEBUG";
  public static final CoreContext CONTEXT = DaggerCoreContext.builder().build();

  public static void logDebug(String msg) {
    if (Gdx.app != null) Gdx.app.debug(DEBUG, msg);
  }
}
