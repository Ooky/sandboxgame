package com.jooky.sandboxgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Main extends ApplicationAdapter {

//==============================================================================
//Initialization
//==============================================================================
    //Config
    public static final int W_WIDTH = 600;
    public static final int W_HEIGTH = 400;
    public static final int SCALE = 2;
    public static final String GAMENAME = "SandboxGame";
    //Textures
    Texture tree;
    Texture background1;
    Texture background2;
    //TextureRegions
    TextureRegion tree1;
    TextureRegion tree2;
    TextureRegion tree3;
    //Spritebatch
    SpriteBatch batch;
    //FPS
    FPSLogger fps;
    //Camera
    OrthographicCamera camera;
    //ShapeRenderer
    ShapeRenderer shapeRenderer;
    //InputProcessor
    MyInputProcessor inputProcessor;
    //TileSize
    int TILE_SIZE;
    //Player
    Player myPlayer;

//==============================================================================
//Methods
//==============================================================================
    @Override
    public void create() {
        //Textures
        tree = new Texture(Gdx.files.internal("Graphics/tree.png"));
        background1 = new Texture(Gdx.files.internal("Graphics/background1.png"));
        background2 = new Texture(Gdx.files.internal("Graphics/background2.png"));
        //TextureRegions
        tree1 = new TextureRegion(tree, 0, 2, 40, 88);
        tree2 = new TextureRegion(tree, 42, 0, 66, 78);
        tree3 = new TextureRegion(tree, 118, 0, 55, 78);
        //Spritebatch
        batch = new SpriteBatch();
        //FPSW
        fps = new FPSLogger();
        //Camera
        camera = new OrthographicCamera();
        //ShapeRenderer
        shapeRenderer = new ShapeRenderer();
        //TILE_SIZE
        TILE_SIZE = background2.getWidth();
        //Player
        myPlayer = new Player();
    }

    @Override
    public void render() {
        //ClearScreen
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        //Background(Kinda like a Bump Map)
        for (int i = 0; i <= Gdx.graphics.getWidth(); i += 200) {
            for (int j = 0; j <= Gdx.graphics.getHeight(); j += 200) {
                batch.draw(background1, i, j);
            }
        }
        for (int i = 0; i <= Gdx.graphics.getWidth() + TILE_SIZE; i += TILE_SIZE) {
            for (int j = 0; j <= Gdx.graphics.getHeight() + TILE_SIZE; j += TILE_SIZE) {
                batch.draw(background2, i, j);
            }
        }
        //Trees
        batch.draw(tree1, 100, 100);
        batch.draw(tree2, 200, 200);
        batch.draw(tree3, 350, 350);
        batch.draw(tree3, 400, 400);
        batch.draw(tree3, 450, 350);
        batch.draw(tree3, 500, 350);
        //Character
        batch.draw(myPlayer.PlayerTextureRegion, myPlayer.getPlayerPosX(), myPlayer.getPlayerPosY());
        
        myPlayer.setStateTime(myPlayer.getStateTime() + Gdx.graphics.getDeltaTime());
        myPlayer.setCurrentFrame(myPlayer.getWalkAnimation().getKeyFrame(myPlayer.stateTime, true));
        batch.draw(myPlayer.currentFrame, 150, 150);
        
        myPlayer.updateMotion();
        batch.end();
        //Grid
        if (Gdx.input.isKeyPressed(Input.Keys.G)) {
            shapeRenderer.begin(ShapeType.Line);
            shapeRenderer.setColor(Color.RED);
            for (int i = 0; i <= Gdx.graphics.getWidth() + TILE_SIZE; i += TILE_SIZE) {
                for (int j = 0; j <= Gdx.graphics.getHeight() + TILE_SIZE; j += TILE_SIZE) {
                    shapeRenderer.rect(0, 0, i, j);
                }
            }
        }
        shapeRenderer.setColor(Color.CLEAR);
        shapeRenderer.end();
        //fps
        fps.log();
    }

    @Override
    public void resize(int width, int height) {
        camera.setToOrtho(false, W_WIDTH, W_HEIGTH);
    }

    @Override
    public void pause() {
    }

    @Override
    public void dispose() {
        tree.dispose();
        batch.dispose();
        background1.dispose();
        background2.dispose();
    }

}

//COMMENTS
//For building: Right click desktop->Tasks->dist.
//jar file is located in desktop/build/libs/...folder.
//see documentation for more information
//https://github.com/libgdx/libgdx/wiki/Gradle-on-the-Commandline#packaging-for-the-desktop
//CTRL+SHIFT+I = Auto import all necessary imports!
//use Gdx.audio.newMusic() for files which takes longer than 10 seconds, otherwise 
//use Gdx.audio.newSound()!
