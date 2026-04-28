package ioexam;

import java.io.*;

public class FriendMgr {
    public FriendMgr() {

    }

    public static void main(String[] args) {
        try(
                BufferedReader br = new BufferedReader(new FileReader("myFriendInfo.txt"))){
            String name = br.readLine();

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}

