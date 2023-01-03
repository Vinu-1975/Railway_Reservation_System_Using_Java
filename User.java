package Project5;

import java.util.ArrayList;

public class User implements LoginSystem{
    String User_id;
    String User_pass;
    boolean status;
    User(){
        //empty
    }
    User(String id,String pass){
        this.User_id=id;
        this.User_pass=pass;
        System.out.println("User Added !...");
        this.status=false;
    }
    public void displayMenu(){
        System.out.println("1. Book Ticket");
        System.out.println("2. View Ticket");
        System.out.println("3. Search for Train");
        System.out.println("4. Cancel Ticket");
        System.out.println("5. Log out");
    }
    public boolean validate(ArrayList<User> u, String id, String pass){
        boolean valid = false;
        for(int i=0;i<u.size();i++){
            if(u.get(i).User_id.equals(id)){
                if(u.get(i).User_pass.equals(pass)){
                    u.get(i).status=true;
                    valid=true;
                    break;
                }
            }
        }
        if(valid){
            System.out.println("Welcome User, Login Successful !!!");
        }else{
            System.out.println("Sorry , Invalid Credentials !...");
        }
        return valid;
    }
    public void logout(ArrayList<User> u,String id,String pass){
        for(int i=0;i<u.size();i++) {
            if ((u.get(i).User_id).equals(id)) {
                if ((u.get(i).User_pass).equals(pass)) {
                    u.get(i).status = false;
                }
            }
        }
    }
}