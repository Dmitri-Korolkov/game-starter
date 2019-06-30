package dev.local.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import dev.local.game.fabric.AppCoreContext;

import static com.badlogic.gdx.Application.LOG_DEBUG;

public class DesktopLauncher {
  public static void main(String[] arg) {
    LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
    new LwjglApplication(AppCoreContext.CONTEXT.appGame().setLogLevel(LOG_DEBUG), config);
  }
}
