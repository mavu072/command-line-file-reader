/*
* Program.java
* A command line driven java program that can be used to display a directory, open a file and display HTML content.
* Author: Avuyile Mgxotshwa
* */
package com.CommandLineProgram;
import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class Program {
    //Program menu
    static void menu(){
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Menu" +
                "\n1. List folders and files in a directory." +
                "\n2. Display the contents of a file." +
                "\n3. Display the HTML response of a Web Address." +
                "\n4. Exit");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Enter the number of an option:");
    }

    //1. list files and folders in a directory.
    static void listDirectory(){
        Scanner sc= new Scanner(System.in);
        String dirPath;
        System.out.println("Enter a path:   e.g. C:/Users/prezu/Documents/"); //e.g. C:\Users\prezu\Documents\
        dirPath = sc.nextLine();

        try { String[] pathList;
            File file = new File(dirPath);
            pathList = file.list();
            //print folders and files found on directory
            if (pathList != null) {
                for(String path : pathList) { System.out.println(path); }
            }
        }
        catch (Exception exc){
            System.out.println("Failed to reach directory. Check your path or Try again.");;
        }
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Press enter to continue"); //Press enter to continue
        sc.nextLine();
    }

    //2. Display the contents of a file.
    static void displayFileContents(){
        Scanner sc= new Scanner(System.in);
        String dirPath;
        System.out.println("Enter a path to a file:  e.g. C:/Users/prezu/Documents/Demo.txt "); //e.g. C:\Users\prezu\Documents\Demo.txt
        dirPath = sc.nextLine();

        try {
            File file = new File(dirPath);
            Scanner scan = new Scanner(file);
            //display contents
            while(scan.hasNext()) { System.out.println(scan.nextLine()); }
        }
        catch (FileNotFoundException ex) {
            System.out.println("Failed to open file. Check file path or Try again");;
        }
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Press enter to continue"); //Press enter to continue
        sc.nextLine();
    }

    //3. Display the HTML response of a Web Address.
    static void displayHtml(){
        Scanner sc= new Scanner(System.in);
        String webAddress;
        System.out.println("Enter a Web address:    e.g.https://demo.myworkpool.net"); //e.g.https://demo.myworkpool.net
        webAddress = sc.nextLine();

        try{
            URL url = new URL(webAddress);
            Scanner scan =new Scanner(url.openStream());
            //display content
            while(scan.hasNext()){ System.out.println(scan.nextLine());}
        }
        catch(Exception e){
            System.out.println("Failed to retrieve content, Check your internet connection or Try again.");
        }
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Press enter to continue"); //Press enter to continue
        sc.nextLine();
    }

    //main method
    public static void main(String[]args){
        //Get user input from the keyboard
        Scanner keybrd = new Scanner(System.in);
        //A variable to store a users choice
        int option;

        //Reiterating using a doWhile loop
        do {
            menu(); //Displays menu
            option = keybrd.nextInt(); //User enters the number of a choice from the menu
            System.out.println("------------------------------------------------------------------------------");

            //Actions
            switch (option) {
                case 1: //1. List folders and files in a directory.
                    listDirectory();
                    break;
                case 2:
                    //2. Display the contents of a file.
                    displayFileContents();
                    break;
                case 3:
                    //3. Display the HTML response of a Web Address.
                    displayHtml();
                    break;
                case 4:
                    //4. Exits program
                    System.out.println("Program stopped.");
                    System.exit(0);
                    break;
                default:
                    //if a random number is entered. program will request user to enter a valid number.
                    System.out.println("Invalid entry!\nPlease enter a valid number from the options.");
                    break;
            }//end of switch
        } while(true); //close loop
    }//end of main method
}//end of class Program
