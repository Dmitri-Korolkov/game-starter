package dev.local.game.fabric;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import dev.local.game.drop.GameScreen;
import lombok.experimental.Accessors;

import javax.inject.Inject;

@Accessors(chain = true, fluent = true)
public class ScreenDispatcher {

  public static final int SCREEN_GAME = 1;

  private Game game;
  private GameScreen gameScreen;

  @Inject
  public ScreenDispatcher(Game game, GameScreen gameScreen) {
    this.game = game;
    this.gameScreen = gameScreen;
  }

  public void screen(Screen screen) {
    if (game != null && screen != null) game.setScreen(screen);
  }

  public void screen(Integer screen) {
    if (game == null) return;
    if (screen.equals(SCREEN_GAME)) game.setScreen(gameScreen);
  }
}
