package dev.local.game.fabric;

import dagger.Component;
import dev.local.game.AppGame;
import dev.local.game.drop.GameScreen;
import dev.local.game.drop.MainMenuScreen;

import javax.inject.Singleton;

@Component(modules = {CoreModule.class})
@Singleton
public interface CoreContext {

  MainMenuScreen mainMenuScreen();

//  GameScreen gameScreen();

  CoreTexture coreTexture();

  AppGame appGame();

}
