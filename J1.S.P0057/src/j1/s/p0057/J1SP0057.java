/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0057;


/**
 *
 * @author vannn
 */
public class J1SP0057 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        while (true) {            
            int choise = Manager.menu();
            
            if(choise == 3)
                break;
            switch(choise){
                case 1:
                    Manager.createNewAccount();
                    break;
            }
        }
    }
    
}
