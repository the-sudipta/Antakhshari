package com.example.antakhshari;

import java.util.Random;

public class Utility {

    private  int team_A_points = 0;
    private  int team_B_points = 0;
    private int flag = 0;
    private int First_Choice = -1;


    // region Settter Getter

    public int getTeam_A_points() {
        return team_A_points;
    }

    public void setTeam_A_points(int team_A_points) {
        this.team_A_points = team_A_points;
    }

    public int getTeam_B_points() {
        return team_B_points;
    }

    public void setTeam_B_points(int team_B_points) {
        this.team_B_points = team_B_points;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    // endregion Settter Getter

    public double calculateDimension(double item_Dimension, double MY_PHONE_DIMENSION, int USER_dimension){
        return ((item_Dimension/MY_PHONE_DIMENSION)*USER_dimension);
    }

    public double calculateTextSize(double USER_height,double FONT,double MY_PHONE_HEIGHT, double dp ){
        return USER_height*(FONT/MY_PHONE_HEIGHT)/dp;
    }

    public int points(char team){
        if(team == 'A' || team == 'a'){
            setTeam_A_points((getTeam_A_points()+1));
            return getTeam_A_points();
        }else if((team == 'B' || team == 'b')){
            setTeam_B_points((getTeam_B_points()+1));
            return getTeam_B_points();
        }else{
            return -1; // It means there's a problem
        }
    }

    public char getRandomAlphabet(){

        Random gen = new Random();
        int num =  gen.nextInt(26)+65; // 26 alphabets
        char alphabet = (char)num;
        return alphabet;
    }

    public int getTeamName(){

        if(flag <= 0 && First_Choice == -1){
            Random gen = new Random();
            flag++;
            First_Choice = gen.nextInt(2);
            return First_Choice;
        }else if(flag%2 == 0 && First_Choice == 0){
            flag++;
            return 0;
        }else if(flag%2 == 0 && First_Choice == 1){
            flag++;
            return 1;
        }else if(flag%2 != 0 && First_Choice == 0){
            flag++;
            return 1;
        }else if(flag%2 != 0 && First_Choice == 1){
            flag++;
            return 0;
        }else{
            return -1;
        }


        }

    }




