package com.example.fit_in_application.Classes;

import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private final String filename = "FoodList2.txt";
    private static File f;
    private List<Object> list_food_object = new ArrayList<>();
    private List<Object> list_Meat = new ArrayList<>();
    private List<Object> list_calories = new ArrayList<>();
    private List<Object> list_categories = new ArrayList<>();
    private List<Object> list_food1 = new ArrayList<>();

     void main() {
        // TODO Auto-generated method stub

        initLists();

        List<Object> list_categories1=new ArrayList<>();


        //choose category meal
        calories_calculator(list_food1);
    }

    private  void initLists() {
         String food = "cornflakes, 27, cereal\n" +
                 "brunflakes 22 cereal\n rice 31 cereal\n pasta 36 cereal\n" +
                 "milk 98 diary\n" +
                 "pepper 20 veg\n" +
                 "tomato 21 veg\n" +
                 "carrot 25 veg\n" +
                 "cucumber 9 veg\n" +
                 "onion 13 veg\n" +
                 "olives 45 veg\n" +
                 "Tahini 45 veg\n" +
                 "Apple 19 fruit\n" +
                 "egg 75 diary";
         String[] split = food.split("\n");
        for (String str: split)
            list_food_object.add(str);
    }

    //food calculator with checks
    private int calories_calculator (List<Object> menu){

        int calories = 0;
        for (int i = 0; i < menu.size(); i++){
            double tmp = (double) list_calories.get(list_Meat.indexOf(menu.get(i)));
            calories += tmp;
        }
        Log.d("CAL", "your meal contain: "+ calories +" calories");

        return calories;
    }
    //print specipic menu and allow choose food for meal
    private List<Object> choose_food(String food){
        String str = null;
        for(int i = 0; i < list_Meat.size(); i++){
            if(list_categories.get(i).equals(food)){
                //ask the person if he want, then add or not
                System.out.println("you want in your "+food+" ,"+ list_Meat.get(i)+"?\npress y/n:");
                Scanner s = new Scanner(System.in);
                String d = s.next();
                if(d.equals("y"))
                {
                    System.out.println(list_Meat.get(i));
                    list_food1.add(list_Meat.get(i));
                }
            }
        }
        return list_food1;
    }

}