/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0057;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Scanner;

/**
 *
 * @author vannn
 */
public class Validate {

    private final static Scanner sc = new Scanner(System.in);
    private final static Scanner scStr = new Scanner(System.in);
    private final static String VALID_USERNAME = "^\\S{5}\\S*$";
    private final static String VALID_PASSWORD = "^\\S{6}\\S*$";
//------------------------------------------------------------------------------

    protected static int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = sc.nextInt();
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please enter " + min + " to " + max + "!");
            }
        }
    }
//------------------------------------------------------------------------------

    protected static String checkInputString() {
        while (true) {
            try {
                String result = scStr.nextLine();
                if (result.isEmpty()) {
                    throw new NullPointerException();
                }
                return result;
            } catch (NullPointerException n) {
                System.out.print("Enter again: ");
                System.err.println("Please input String!");
            }
        }
    }
//------------------------------------------------------------------------------

    protected static boolean checkInputYN() {
        System.out.print("Do you want to countinue: ");
        while (true) {
            try {
                String result = scStr.nextLine();
                if (result.equalsIgnoreCase("yes") || result.equalsIgnoreCase("no")) {
                    return true;
                }
                if (result.isEmpty()) {
                    throw new NullPointerException();
                }
            } catch (NullPointerException n) {
                System.err.println("Please enter yes or no only!");
                System.out.print("Enter again: ");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.print("Enter again: ");
            }
        }
    }
//------------------------------------------------------------------------------

    protected static boolean checkFileExist() {
        File f = new File("user.dat");
        if (!f.exists()) {
            try {
                System.err.println("File not exist");
                f.createNewFile();
                System.err.println("File created!");
                return false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }
//------------------------------------------------------------------------------

    protected static String checkInputUsername() {
        System.out.print("Enter username: ");

        while (true) {
            String result = scStr.nextLine();
            if (result.matches(VALID_USERNAME)) {
                return result;
            }

            System.err.println("You must enter least at 5 character, and no space!");
            System.out.print("Enter again: ");
        }
    }
//------------------------------------------------------------------------------

    protected static String checkInputPassword() {
        System.out.print("Enter password: ");

        while (true) {
            String result = scStr.nextLine();
            if (result.matches(VALID_PASSWORD)) {
                return result;
            }
            System.err.println("You must enter least at 6 character and no space!");
            System.out.print("Enter again: ");
        }
    }
//------------------------------------------------------------------------------

    protected static boolean checkUserExist(String username) {
        File f = new File("user.dat");
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] account = line.split(";");
                if (username.equals(account[0])) {
                    return false;
                }
            }
            br.close();
            fr.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException i) {
            i.printStackTrace();
        }
        return true;
    }
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------    
}
