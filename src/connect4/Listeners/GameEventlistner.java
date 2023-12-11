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
import java.io.IOException;

public class GameEventlistner implements GLEventListener {

    String[] textureNames = {"GameBackground.png"}; //The Sprits
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

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        GL gl =glAutoDrawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);       //Clear The Screen And The Depth Buffer
        gl.glLoadIdentity();

        drawBackground(gl);

    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }

    @Override
    public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {

    }
}