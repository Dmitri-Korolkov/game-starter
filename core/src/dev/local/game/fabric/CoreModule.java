package dev.local.game.fabric;

import dagger.Module;
import dagger.Provides;
import dev.local.game.AppGame;
import dev.local.game.drop.GameScreen;
import dev.local.game.drop.MainMenuScreen;

import javax.inject.Singleton;

@Module
public class CoreModule {

  @Provides
  @Singleton
  public CoreTexture coreTexture() {
    return new CoreTexture();
  }

  @Provides
  @Singleton
  public MainMenuScreen mainMenuScreen(CoreTexture texture, ScreenDispatcher dispatcher) {
    return new MainMenuScreen(texture, dispatcher);
  }

  @Provides
  @Singleton
  public ScreenDispatcher screenDispatcher(AppGame game, GameScreen gameScreen) {
    return new ScreenDispatcher(game, gameScreen);
  }

  @Provides
  @Singleton
  public AppGame appGame() {
    return new AppGame();
  }


  @Provides
  @Singleton
  public GameScreen gameScreene(CoreTexture texture) {
    return new GameScreen(texture);
  }

}
