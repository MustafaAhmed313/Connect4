/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect4.Listeners;

/**
 *
 * @author mosta
 */

import connect4.Connect4;
import connect4.Frames.Player_One_Win;
import connect4.Frames.Player_Two_Win;
import connect4.GameEngine.Pog;
import connect4.Storage.GameStatus;
import connect4.Texture.TextureReader;
import connect4.GameEngine.gameEngineMulti;
import org.w3c.dom.ls.LSOutput;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.swing.*;



public class GameBackGroundListener extends JFrame
        implements GLEventListener, MouseListener, KeyListener, ActionListener, MouseMotionListener {
    int maxWidth = 100; // Initial Positions
    int maxHeight = 100;
    int xposition = 0, yposition = 0;
    ArrayList<Pog> listOfPogs;
    int currentPog = 0;

    int row = 5;
    boolean player1 = false , player2 = false , noGameLoop = false;
    int spaceIn = 22;
    int baseSpace = -50;
    // -50 // row= 5
    // -30 // row= 4
    // -10 // row= 3
    // 20
    // 40
    // 60
    // 80

    int x = 0, y = 0;

    GameStatus gameStatus = Connect4.getGameStatus();
    static gameEngineMulti game = new gameEngineMulti();
    static int nextColumnIndex = 0;

    String[] textureNames = { "Bord-1.png", "POG-red.png", "POG-yellow.png", "BG-1.png" }; // The Sprits

    TextureReader.Texture[] texture = new TextureReader.Texture[textureNames.length];
    int textureIndex[] = new int[textureNames.length];
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(final KeyEvent e) {
        int keyCode = e.getKeyCode();
        keyBits.set(keyCode);
    }

    @Override
    public void keyReleased(final KeyEvent e) {
        int keyCode = e.getKeyCode();
        keyBits.clear(keyCode);
    }

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {

        System.out.println("the theme is "+gameStatus.getTheme());
        if(gameStatus.getTheme() == 2){
            textureNames = new String[]{"Bord-2.png", "POG-fire.png", "POG-ice.png", "BG-2.png"};
            texture = new TextureReader.Texture[textureNames.length];
            textureIndex = new int[textureNames.length];
        }
        listOfPogs = new ArrayList<>(42);
        for (int i = 0; i < 42; i++) {
            int assetIndex = (i % 2 == 0) ? 1 : 2;
            Pog ele = new Pog(0, 110, assetIndex, 250);
            listOfPogs.add(ele);
        }

        GL gl = glAutoDrawable.getGL(); // This Will Clear The Background Color To Black
        gl.glClearColor(0f, 0f, 0f, 0f);

        // [New Part Of Code] {-->

        gl.glEnable(GL.GL_TEXTURE_2D); // Enable Texture Mapping
        gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);

        // number of textures,array to hold the indeces
        gl.glGenTextures(textureNames.length, textureIndex, 0);

        for (int i = 0; i < textureNames.length; i++) {
            try {
                String assetsFolderName = "Connect4//Assets";
                texture[i] = TextureReader.readTexture(assetsFolderName + "//" + textureNames[i], true);
                gl.glBindTexture(GL.GL_TEXTURE_2D, textureIndex[i]);

                // mipmapsFromPNG(gl, new GLU(), texture[i]);

                // <--}

                new GLU().gluBuild2DMipmaps(
                        GL.GL_TEXTURE_2D,
                        GL.GL_RGBA, // Internal Texel Format,
                        texture[i].getWidth(), texture[i].getHeight(),
                        GL.GL_RGBA, // External format from image,
                        GL.GL_UNSIGNED_BYTE,
                        texture[i].getPixels() // Imagedata
                );
            } catch (IOException e) {
                System.out.println(e);
                e.printStackTrace();
            }
        }
    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {

        GL gl = glAutoDrawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT); // Clear The Screen And The Depth Buffer
        gl.glLoadIdentity();

        drawBackground(gl);
        // Draw the POG
        updatePogsPosition(gl);
        drawPogs(gl, x, y);
        // Draw the POG
        drawBoard(gl, 0, -2, 0, 8);

    }

    private void updatePogsPosition(GL gl) {
        for (int i = 0; i < listOfPogs.size(); i++) {
            Pog ele = listOfPogs.get(i);
            int startPoint = ele.getYposition();
            if (ele.isDrop() && ele.getYposition() >= ele.getMinHeight()) {
                startPoint--;
                ele.setYposition(startPoint);
            }
        }
    }

    private void drawBackground(GL gl) {
        gl.glEnable(GL.GL_BLEND); // Turn Blending On
        gl.glBindTexture(GL.GL_TEXTURE_2D, textureIndex[textureNames.length - 1]);

        gl.glBegin(GL.GL_QUADS);
        // Front Face
        gl.glTexCoord2f(0.0f, 0.0f); // Mix Image Coordinates with Mask Coordinates
        gl.glVertex3f(-1.0f, -1.0f, -1.0f); // drawMask
        gl.glTexCoord2f(1.0f, 0.0f); // Mix Image Coordinates with Mask Coordinates
        gl.glVertex3f(1.0f, -1.0f, -1.0f); // drawMask
        gl.glTexCoord2f(1.0f, 1.0f); // Mix Image Coordinates with Mask Coordinates
        gl.glVertex3f(1.0f, 1.0f, -1.0f); // drawMask
        gl.glTexCoord2f(0.0f, 1.0f); // Mix Image Coordinates with Mask Coordinates
        gl.glVertex3f(-1.0f, 1.0f, -1.0f); // drawMask
        gl.glEnd();

        gl.glDisable(GL.GL_BLEND);
    }

    private void drawPogs(GL gl, int x, int y) {
        for (int i = 0; i < listOfPogs.size(); i++) {
            Pog ele = listOfPogs.get(i);
            drawSprite(gl, ele.getXposition(), ele.getYposition(), ele.getAssetIndex(), 1);
        }
    }

    private void drawSprite(GL gl, int x, int y, int index, int scale) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textureIndex[index]); // Turn Blending On

        gl.glPushMatrix();

        gl.glTranslated(x / (maxWidth / 1.0) * scale, y / (maxHeight / 1.0) * scale, 0);

        gl.glScaled(0.1 * scale, 0.1 * scale, 1);

        gl.glBegin(GL.GL_QUADS);
        // Front Face
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(-1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, -1.0f);
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(-1.0f, 1.0f, -1.0f);
        gl.glEnd();
        gl.glPopMatrix();

        gl.glDisable(GL.GL_BLEND);
    }

    private void drawBoard(GL gl, int x, int y, int index, int scale) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textureIndex[index]); // Turn Blending On

        gl.glPushMatrix();

        gl.glTranslated(x / (maxWidth / 2.0), y / (maxHeight / 2.0), 0);

        gl.glScaled(0.1 * scale, 0.1 * scale, 1);

        gl.glBegin(GL.GL_QUADS);
        // Front Face
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(-1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, -1.0f);
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(-1.0f, 1.0f, -1.0f);
        gl.glEnd();
        gl.glPopMatrix();

        gl.glDisable(GL.GL_BLEND);
    }

    public BitSet keyBits = new BitSet(256); // Key Pressed Detector

    public void handleKeyPress() {

        if (isKeyPressed(KeyEvent.VK_LEFT)) {
            xposition--;
        }
        if (isKeyPressed(KeyEvent.VK_RIGHT)) {
            xposition++;
        }
        if (isKeyPressed(KeyEvent.VK_DOWN)) {
            yposition--;
        }
        if (isKeyPressed(KeyEvent.VK_UP)) {
            yposition++;
        }
    }

    public boolean isKeyPressed(final int keyCode) {
        return keyBits.get(keyCode);
    }

    private void handleMousePosition() {
        if (xposition >= -271 && xposition <= -210) {
            nextColumnIndex = 0;
            x = -60;
        }
        if (xposition >= -191 && xposition <= -130) {
            nextColumnIndex = 1;
            x = -40;
        }
        if (xposition >= -112 && xposition <= -51) {
            nextColumnIndex = 2;
            x = -20;
        }
        if (xposition >= -32 && xposition <= 29) {
            nextColumnIndex = 3;
            x = 0;
        }
        if (xposition >= 47 && xposition <= 109) {
            nextColumnIndex = 4;
            x = 20;
        }
        if (xposition >= 128 && xposition <= 188) {
            nextColumnIndex = 5;
            x = 40;
        }
        if (xposition >= 207 && xposition <= 269) {
            nextColumnIndex = 6;
            x = 60;
        }
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }

    @Override
    public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        double x = e.getX(), y = e.getY();
        Component c = e.getComponent();
        double width = c.getWidth(), height = c.getHeight();
        xposition = (int) (x - (width / 2));
        yposition = (int) ((height / 2) - y);
        System.out.println("x : " + xposition + " y : " + yposition);
        handleMousePosition();
        if (!noGameLoop) {
            if (currentPog < listOfPogs.size() && game.dropToken(nextColumnIndex)) {
                game.switchPlayer();
                int r = game.indexMove(nextColumnIndex);
                game.printBoard();
                if (game.checkWin()) {
                    if (game.getCurrentPlayer() == 'X'){
                        player1 = true;
                        noGameLoop = true;
                    }else {
                        noGameLoop = true;
                        player2 = true;
                    }
                }
                dropPogTo(r, currentPog); // TODO: check if i can drop here or no ^^
                if (player1) new Player_One_Win();
                if (player2) new Player_Two_Win();
            }
        }
    }

    private void dropPogTo(int r, int current) {
        int minHeight = -50;
        // -50 // row= 6
        // -30 // row= 5
        // -10 // row= 4
        // 20  // row= 3
        // 40  // row= 2
        // 60  // row= 1
        // 80  // row= 0
        System.out.println("the row : " + r);
        switch (r){
            case 5: minHeight = baseSpace; break;
            case 4: minHeight = baseSpace + spaceIn; break;
            case 3: minHeight = baseSpace + (spaceIn*2); break;
            case 2: minHeight = baseSpace + (spaceIn*3); break;
            case 1: minHeight = baseSpace + (spaceIn*4); break;
            case 0: minHeight = baseSpace + (spaceIn*5); break;
        }
        Pog ele = listOfPogs.get(current);
        ele.setMinHeight(minHeight);
        ele.setDrop(true);
        currentPog++;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        double xM = e.getX(), yM = e.getY();
        Component c = e.getComponent();
        double width = c.getWidth(), height = c.getHeight();
        xposition = (int) (xM - (width / 2));
        yposition = (int) ((height / 2) - yM);
        handleMousePosition();
        for (int i = currentPog; i < listOfPogs.size(); i++) {
            listOfPogs.get(i).setXposition(x);
        }
    }
}