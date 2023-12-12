/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect4.Listeners;

import connect4.Texture.TextureReader;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.BitSet;

/**
 *
 * @author moham
 */
public class GameEventListner3 implements GLEventListener , KeyListener {
    int maxWidth = 100; //Initial Positions
    int maxHeight = 100;
    int xposition = 0 , yposition = 0;

    int x = 0 , y = 0;
    String[] textureNames = {"Bord2.png" , "POG-fire.png" , "POG-ice.png" , "Fire And ICE Text.png" ,  "Game_Background_71 1.png"}; //The Sprits
    TextureReader.Texture[] texture = new TextureReader.Texture[textureNames.length];
    int textureIndex[] = new int[textureNames.length];

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        GL gl = glAutoDrawable.getGL(); //This Will Clear The Background Color To Black
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);

        // [New Part Of Code] {-->

        gl.glEnable(GL.GL_TEXTURE_2D);  // Enable Texture Mapping
        gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);

        //number of textures,array to hold the indeces
        gl.glGenTextures(textureNames.length, textureIndex, 0);

        for (int i = 0; i < textureNames.length ; i++) {
            try {
                String assetsFolderName = "Connect4//Assets";
                texture[i] = TextureReader.readTexture(assetsFolderName + "//" + textureNames[i], true);
                gl.glBindTexture(GL.GL_TEXTURE_2D, textureIndex[i]);

                //mipmapsFromPNG(gl, new GLU(), texture[i]);

                //<--}

                new GLU().gluBuild2DMipmaps(
                        GL.GL_TEXTURE_2D,
                        GL.GL_RGBA, // Internal Texel Format,
                        texture[i].getWidth(), texture[i].getHeight(),
                        GL.GL_RGBA, // External format from image,
                        GL.GL_UNSIGNED_BYTE,
                        texture[i].getPixels() // Imagedata
                );
            } catch( IOException e ) {
                System.out.println(e);
                e.printStackTrace();
            }
        }
    }

    private void drawBackground(GL gl){
        gl.glEnable(GL.GL_BLEND);	// Turn Blending On
        gl.glBindTexture(GL.GL_TEXTURE_2D, textureIndex[textureNames.length - 1]);

        gl.glBegin(GL.GL_QUADS);
        // Front Face
        gl.glTexCoord2f(0.0f, 0.0f); //Mix Image Coordinates with Mask Coordinates
        gl.glVertex3f(-1.0f, -1.0f, -1.0f); //drawMask
        gl.glTexCoord2f(1.0f, 0.0f); //Mix Image Coordinates with Mask Coordinates
        gl.glVertex3f(1.0f, -1.0f, -1.0f); //drawMask
        gl.glTexCoord2f(1.0f, 1.0f); //Mix Image Coordinates with Mask Coordinates
        gl.glVertex3f(1.0f, 1.0f, -1.0f); //drawMask
        gl.glTexCoord2f(0.0f, 1.0f); //Mix Image Coordinates with Mask Coordinates
        gl.glVertex3f(-1.0f, 1.0f, -1.0f); //drawMask
        gl.glEnd();

        gl.glDisable(GL.GL_BLEND);
    }

    private void drawSprite(GL gl , int x , int y ,  int index , int scale){
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textureIndex[index]);	// Turn Blending On

        gl.glPushMatrix();

        gl.glTranslated(x / (maxWidth / 1.0) * scale, y / (maxHeight / 1.0) * scale, 0);

        gl.glScaled(0.1 * scale, 0.1 * scale, 1);

//        System.out.println(x + " " + y);

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

    private void drawBoard(GL gl , int x , int y ,  int index , int scale) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textureIndex[index]);	// Turn Blending On

        gl.glPushMatrix();

        gl.glTranslated(x / (maxWidth / 2.0), y / (maxHeight / 2.0), 0);

        gl.glScaled(0.1 * scale, 0.1 * scale, 1);

//        System.out.println(x + " " + y);

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

    public BitSet keyBits = new BitSet(256); //Key Pressed Detector

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

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        GL gl =glAutoDrawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);       //Clear The Screen And The Depth Buffer
        gl.glLoadIdentity();
        drawBackground(gl);
        drawBoard(gl , -20 , -20  ,0 , 5);
        drawSprite(gl , -20 ,  25 , 3 , 2);
        drawSprite(gl , 30  , 20 , 1 , 2);
        drawSprite(gl , 30  , -20 , 2 , 2);
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }

    @Override
    public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {

    }

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
}
