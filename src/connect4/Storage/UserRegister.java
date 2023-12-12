package connect4.Storage;

import connect4.GameEngine.UserData;

import java.io.*;

public class UserRegister {
    private static String filename = "C:\\Users\\mosta\\IdeaProjects\\Connect4\\src\\connect4\\Storage\\data.txt";
    private static UserData data = new UserData();
    public static void writeUser(UserData user) {
        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(filename , true)
            );
            writer.append(user.username + ":" + user.level + "\n");
            writer.close();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String readUsers() {
        String result = "";
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader(filename)
            );
            String s;
            while ((s = reader.readLine()) != null) {
                result += s + "\n";
            }
            reader.close();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}