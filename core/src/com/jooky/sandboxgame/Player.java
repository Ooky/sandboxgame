/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jooky.sandboxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 *
 * @author Ooky
 */
public class Player {

//==============================================================================
//Initialization
//==============================================================================
    //PlayerStats
    private String name;
    private int life;
    private int level;
    private int xp;
    private int score;
    public static final int PLAYER_WIDTH = 32;
    public static final int PLAYER_HEIGHT = 48;
    //PlayerPosition
    private float PlayerPosX = 900;
    private float PlayerPosY = 500;
    //PlayerMovement
    private final float playerSpeedWalking = 75.0f;
    private final float playerSpeedRunning = 150.0f;
    boolean playerLeft;
    boolean playerRight;
    boolean playerUp;
    boolean playerDown;
    //Textures
    Texture PlayerTexture;
    //TextureRegions
    TextureRegion PlayerTextureRegion;
    //Animation
    Animation walkAnimation;
    TextureRegion[] walkFrames;
    float stateTime;
    TextureRegion currentFrame;
    private static final int FRAME_COLS = 4;
    private static final int FRAME_ROWS = 4;

//==============================================================================
//Methods
//==============================================================================
    public Player() {
        PlayerTexture = new Texture(Gdx.files.internal("Graphics/Player/Char.png"));

        TextureRegion[][] tmp = TextureRegion.split(PlayerTexture, PlayerTexture.getWidth() / FRAME_COLS, PlayerTexture.getHeight() / FRAME_ROWS);
        walkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                System.out.println("index = " + index);
                walkFrames[index++] = tmp[i][j];
            }
        }
        walkAnimation = new Animation(0.5f, walkFrames);
        stateTime = 0f;
        currentFrame = walkAnimation.getKeyFrame(stateTime, true);
    }

    public void updateMotion() {
        if (leftOrA()) {
            if (running()) {
                walkAnimation.setFrameDuration(0.3f);
                runLeft();
            } else {
                walkAnimation.setFrameDuration(0.5f);
                walkLeft();
            }
            stateTime += Gdx.graphics.getDeltaTime();
            currentFrame = walkAnimation.getKeyFrame(stateTime, true);
        } else if (rightOrA()) {
            walkRight();
            if (running()) {
                runRight();
            }
        } else if (upOrW()) {
            walkUp();
            if (running()) {
                runUp();
            }
        } else if (downOrS()) {
            walkDown();
            if (running()) {
                runDown();
            }
        } else {
//            System.out.println("not moving");
        }
    }

    private void runLeft() {
        setPlayerPosX(getPlayerPosX() - (playerSpeedRunning * Gdx.graphics.getDeltaTime()));
    }

    private void walkLeft() {
        setPlayerPosX(getPlayerPosX() - (playerSpeedWalking * Gdx.graphics.getDeltaTime()));
    }

    private void runRight() {
        setPlayerPosX(getPlayerPosX() + (playerSpeedRunning * Gdx.graphics.getDeltaTime()));
    }

    private void walkRight() {
        setPlayerPosX(getPlayerPosX() + (playerSpeedWalking * Gdx.graphics.getDeltaTime()));
    }

    private void runUp() {
        setPlayerPosY(getPlayerPosY() + (playerSpeedRunning * Gdx.graphics.getDeltaTime()));
    }

    private void walkUp() {
        setPlayerPosY(getPlayerPosY() + (playerSpeedWalking * Gdx.graphics.getDeltaTime()));
    }

    private void runDown() {
        setPlayerPosY(getPlayerPosY() - (playerSpeedRunning * Gdx.graphics.getDeltaTime()));
    }

    private void walkDown() {
        setPlayerPosY(getPlayerPosY() - (playerSpeedWalking * Gdx.graphics.getDeltaTime()));
    }

    private boolean leftOrA() {
        return Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A);
    }

    private boolean rightOrA() {
        return Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D);
    }

    private boolean upOrW() {
        return Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W);
    }

    private boolean downOrS() {
        return Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S);
    }

    private boolean running() {
        return Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT);
    }

//==============================================================================
//Setter
//==============================================================================
    public void setName(String name) {
        this.name = name;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setPlayerPosX(float PlayerPosX) {
        this.PlayerPosX = PlayerPosX;
    }

    public void setPlayerPosY(float PlayerPosY) {
        this.PlayerPosY = PlayerPosY;
    }

    public void setPlayerLeft(boolean playerLeft) {
        this.playerLeft = playerLeft;
    }

    public void setPlayerRight(boolean playerRight) {
        this.playerRight = playerRight;
    }

    public void setPlayerUp(boolean playerUp) {
        this.playerUp = playerUp;
    }

    public void setPlayerDown(boolean playerDown) {
        this.playerDown = playerDown;
    }

    public void setCurrentFrame(TextureRegion currentFrame) {
        this.currentFrame = currentFrame;
    }

//==============================================================================
//Getter
//==============================================================================
    public String getName() {
        return name;
    }

    public int getLife() {
        return life;
    }

    public int getLevel() {
        return level;
    }

    public int getXp() {
        return xp;
    }

    public int getScore() {
        return score;
    }

    public static int getWIDTH_PLAYER() {
        return PLAYER_WIDTH;
    }

    public static int getHEIGHT_PLAYER() {
        return PLAYER_HEIGHT;
    }

    public float getPlayerPosX() {
        return PlayerPosX;
    }

    public float getPlayerPosY() {
        return PlayerPosY;
    }

    public float getPlayerSpeed() {
        return playerSpeedWalking;
    }

    public static int getPLAYER_WIDTH() {
        return PLAYER_WIDTH;
    }

    public static int getPLAYER_HEIGHT() {
        return PLAYER_HEIGHT;
    }

    public float getStateTime() {
        return stateTime;
    }

    public void setStateTime(float stateTime) {
        this.stateTime = stateTime;
    }

    public Animation getWalkAnimation() {
        return walkAnimation;
    }

}
