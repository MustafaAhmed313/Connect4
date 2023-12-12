/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect4.GameEngine;

 
public class UserData {
  private String username ;
  private String name1;
  private String name2;
    private int level ;  // 1 for easy and 2 for minimum and 3 for hard
    private int design ;   // 1 for Basic Them and 2 for Ice and Fire Them
    private int  numPlayer ;
    private int backSound =1;
    private int gameSound =1;
    private int score = 0;
    private boolean flag = true ;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public UserData(){
        this.username ="user" ;
        this.level = 1 ;
        this.design = 1 ;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDesign() {
        return design;
    }

    public void setDesign(int design) {
        this.design = design;
    }

    public int getNumPlayer() {
        return numPlayer;
    }

    public void setNumPlayer(int numPlayer) {
        this.numPlayer = numPlayer;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public int getBackSound() {
        return backSound;
    }

    public void setBackSound(int backSount) {
        this.backSound = backSount;
    }

    public int getGameSound() {
        return gameSound;
    }

    public void setGameSound(int gameSound) {
        this.gameSound = gameSound;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

