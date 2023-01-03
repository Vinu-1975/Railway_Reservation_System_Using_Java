package Project5;

import java.util.ArrayList;

public class Admin implements LoginSystem{
    String Admin_id;
    String Admin_pass;
    boolean status;
    public Admin(){
        //empty
    }
    public Admin(String id, String pass){
        this.Admin_id=id;
        this.Admin_pass=pass;
        System.out.println("Admin Added !...");
        this.status=false;
    }

    public void displayMenu(){
        System.out.println("1. Add Train");
        System.out.println("2. Remove Train");
        System.out.println("3. Schedule Train");
        System.out.println("4. Cancel Train");
        System.out.println("5. Update Train");
        System.out.println("6. Print Specific Train");
        System.out.println("7. Print All Trains");
        System.out.println("8. Log out");
    }
    public boolean validate(ArrayList<Admin> a, String id, String pass){
        boolean valid = false;
        for(int i=0;i<a.size();i++){
            if(a.get(i).Admin_id.equals(id)){
                if(a.get(i).Admin_pass.equals(pass)){
                    a.get(i).status=true;
                    valid=true;
                    break;
                }
            }
        }

        if(valid){
            System.out.println("Welcome Admin, Login Successful !!!");
        }
        else{
            System.out.println("Sorry , Invalid Credentials !...");
        }
        return valid;
    }
    public void logout(ArrayList<Admin> a,String id,String pass){
        for(int i=0;i<a.size();i++) {
            if ((a.get(i).Admin_id).equals(id)) {
                if ((a.get(i).Admin_pass).equals(pass)) {
                    a.get(i).status = false;
                }
            }
        }
    }
}