package com.jooky.idlegame.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.jooky.sandboxgame.Main;

public class DesktopLauncher {

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = Main.W_WIDTH * Main.SCALE;
        config.height = Main.W_HEIGTH * Main.SCALE;
//                config.fullscreen = true;
        config.addIcon("Graphics/Icon/Icon.gif", Files.FileType.Internal);
        config.title = Main.GAMENAME;
        config.resizable = true;
        //Window Position
//        config.x = 0;
//        config.y = 0;
        new LwjglApplication(new Main(), config);
    }
}
