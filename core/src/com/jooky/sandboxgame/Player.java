/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jooky.sandboxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
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
    private final float playerSpeedNormal = 75.0f;
    private final float playerSpeedRunning = 150.0f;
    boolean playerLeft;
    boolean playerRight;
    boolean playerUp;
    boolean playerDown;
    //Textures
    Texture PlayerTexture;
    //TextureRegions
    TextureRegion PlayerTextureRegionUp;
    TextureRegion PlayerTextureRegionDown;
    TextureRegion PlayerTextureRegionLeft;
    TextureRegion PlayerTextureRegionRight;

//==============================================================================
//Methods
//==============================================================================
    public Player() {
        PlayerTexture = new Texture(Gdx.files.internal("Graphics/Player/Char.png"));
        PlayerTextureRegionUp = new TextureRegion(PlayerTexture, 0, 0, PLAYER_WIDTH, PLAYER_HEIGHT);
        PlayerTextureRegionDown = new TextureRegion(PlayerTexture, 144, 0, PLAYER_WIDTH, PLAYER_HEIGHT);
        PlayerTextureRegionLeft = new TextureRegion(PlayerTexture, 196, 0, PLAYER_WIDTH, PLAYER_HEIGHT);
        PlayerTextureRegionRight = new TextureRegion(PlayerTexture, 32, 0, PLAYER_WIDTH, PLAYER_HEIGHT);
    }

    public void updateMotion() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)) {
            if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT)) {
                //Running
                setPlayerPosX(getPlayerPosX() - (playerSpeedRunning * Gdx.graphics.getDeltaTime()));
            } else {
                setPlayerPosX(getPlayerPosX() - (playerSpeedNormal * Gdx.graphics.getDeltaTime()));
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)) {
            if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT)) {
                //Running
                setPlayerPosX(getPlayerPosX() + (playerSpeedRunning * Gdx.graphics.getDeltaTime()));
            } else {
                setPlayerPosX(getPlayerPosX() + (playerSpeedNormal * Gdx.graphics.getDeltaTime()));
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W)) {
            if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT)) {
                //Running
                setPlayerPosY(getPlayerPosY() + (playerSpeedRunning * Gdx.graphics.getDeltaTime()));
            } else {
                setPlayerPosY(getPlayerPosY() + (playerSpeedNormal * Gdx.graphics.getDeltaTime()));
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S)) {
            if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT)) {
                //Running
                setPlayerPosY(getPlayerPosY() - (playerSpeedRunning * Gdx.graphics.getDeltaTime()));
            } else {
                setPlayerPosY(getPlayerPosY() - (playerSpeedNormal * Gdx.graphics.getDeltaTime()));
            }
        }

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
        return playerSpeedNormal;
    }

    public static int getPLAYER_WIDTH() {
        return PLAYER_WIDTH;
    }

    public static int getPLAYER_HEIGHT() {
        return PLAYER_HEIGHT;
    }

    public Texture getPlayerTexture() {
        return PlayerTexture;
    }

    public TextureRegion getPlayerTextureRegion() {
        return PlayerTextureRegionUp;
    }

}
