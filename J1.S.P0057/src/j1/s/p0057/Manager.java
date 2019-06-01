/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0057;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author vannn
 */
public class Manager {

    protected static int menu() {
        System.out.println("1. Create a new account\n"
                + "2. Login System\n"
                + "3. Exit");
        System.out.print("Enter your choise: ");

        int choise = Validate.checkInputIntLimit(1, 3);
        return choise;
    }

    protected static void createNewAccount() {
        if (!Validate.checkFileExist()) {
            return;
        }
        File f = new File("user.dat");

        String userid = Validate.checkInputUsername();
        String pw = Validate.checkInputPassword();

        if (!Validate.checkUserExist(userid)) {
            System.err.println("Username exist!");
            return;
        }

        addAccountData(userid, pw);
    }

    protected static void addAccountData(String id, String pw) {
        File f = new File("user.dat");
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(id +";" + pw + "\n");
            fw.close();
            System.err.println("Create successful!");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
