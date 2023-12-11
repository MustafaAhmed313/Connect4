/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect4.GameEngine;

 
public class UserData {
   public String username ;
    public int level ;  // 1 for easy and 2 for minimum and 3 for hard
    public int design ;   // 1 for Basic Them and 2 for Ice and Fire Them

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
}
