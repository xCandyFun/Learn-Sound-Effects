package org.example;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
        ChooseWhatToDo();
    }

    public static void playSound(String filePath){
        try (FileInputStream fileInputStream = new FileInputStream(filePath)){
            AdvancedPlayer player = new AdvancedPlayer(fileInputStream);
            player.play();
        }catch (JavaLayerException | IOException e){
            e.printStackTrace();
        }
    }

    public static void menu(){
        String menuText =
                """
                1. exit
                2. play sound
                """;
        System.out.println(menuText);
    }

    public static void ChooseWhatToDo(){
        String HomePath = System.getProperty("user.home") +"\\pop.mp3";


        String PickaNumber = sc.next();
        while (true){
            switch (PickaNumber){
                case "1" -> System.exit(1);
                case "2" -> {
                    playSound(HomePath);
                }
            }
        }
    }
}