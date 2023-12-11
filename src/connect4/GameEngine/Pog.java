/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect4.GameEngine;

/**
 *
 * @author mosta
 */
public class Pog {
    private int xposition , yposition , assetIndex , minHeight;

    public Pog(int xpositon , int yposition , int assetIndex , int minHeight) {
        this.xposition = xpositon;
        this.yposition = yposition;
        this.assetIndex = assetIndex;
    }

    public int getXposition() {
        return xposition;
    }

    public void setXposition(int xposition) {
        this.xposition = xposition;
    }

    public int getYposition() {
        return yposition;
    }

    public void setYposition(int yposition) {
        this.yposition = yposition;
    }

    public int getAssetIndex() {
        return assetIndex;
    }

    public void setAssetIndex(int assetIndex) {
        this.assetIndex = assetIndex;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }
}
