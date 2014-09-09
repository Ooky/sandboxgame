/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jooky.sandboxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
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
    private float PlayerPosX = 250;
    private float PlayerPosY = 250;
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

//==============================================================================
//Methods
//==============================================================================
    public Player() {
        PlayerTexture = new Texture(Gdx.files.internal("Graphics/Player/Char.png"));
        PlayerTextureRegion = new TextureRegion();
        //Up
        PlayerTextureRegion = new TextureRegion(PlayerTexture, 0, 0, PLAYER_WIDTH, PLAYER_HEIGHT);
    }

    public void updateMotion() {
        if (leftOrA()) {
            PlayerTextureRegion.setRegion(0, 144, PLAYER_WIDTH, PLAYER_HEIGHT);
            if (shiftLeftOrShiftRight()) {
                runLeft();
            } else {
                walkLeft();
            }
        }
        if (rightOrA()) {
            PlayerTextureRegion.setRegion(0, 48, PLAYER_WIDTH, PLAYER_HEIGHT);
            if (shiftLeftOrShiftRight()) {
                runRight();
            } else {
                walkRight();
            }
        }
        if (upOrW()) {
            PlayerTextureRegion.setRegion(0, 0, PLAYER_WIDTH, PLAYER_HEIGHT);
            if (shiftLeftOrShiftRight()) {
                runUp();
            } else {
                walkUp();
            }
        }
        if (downOrS()) {
            PlayerTextureRegion.setRegion(0, 96, PLAYER_WIDTH, PLAYER_HEIGHT);
            if (shiftLeftOrShiftRight()) {
                runDown();
            } else {
                walkDown();
            }
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

    private boolean shiftLeftOrShiftRight() {
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

}
