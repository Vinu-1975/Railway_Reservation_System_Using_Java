package Project5;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;



public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Admin> admins = new ArrayList<>();
        ArrayList<User> users = new ArrayList<>();

        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLACK = "\u001B[30m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_PURPLE = "\u001B[35m";
        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_WHITE = "\u001B[37m";

        final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
        final String ANSI_RED_BACKGROUND = "\u001B[41m";
        final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
        final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
        final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
        final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
        final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
        final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

        System.out.println(ANSI_RED);
        ArrayList<Train> t=new ArrayList<>();
        //pre-added trains
        t.add(new Train(1,"abc",10));
        t.add(new Train(2,"def",11));
        t.add(new Train(3,"ghi",12));
        t.add(new Train(4,"jkl",13));
        t.add(new Train(4,"jkl",13));
        t.add(new Train(5,"mno",14));
        t.add(new Train(6,"pqr",15));
        t.add(new Train(7,"xyz",16));

        //pre-scheduled trains
        new Train().pre_schedule_train(t,0,"2023-01-11","kot","pal","23:00:00","01:00:00");
        new Train().pre_schedule_train(t,1,"2023-01-03","ala","tcr","16:00:00","20:00:00");
        new Train().pre_schedule_train(t,2,"2023-01-04","ern","tvm","08:00:00","13:00:00");
        new Train().pre_schedule_train(t,3,"2023-01-07","ern","tvm","23:00:00","01:00:00");
        new Train().pre_schedule_train(t,4,"2023-01-08","tcr","pal","23:00:00","01:00:00");
        new Train().pre_schedule_train(t,5,"2023-01-03","idu","koz","23:00:00","01:00:00");
        new Train().pre_schedule_train(t,6,"2023-01-06","mal","way","23:00:00","01:00:00");
        new Train().pre_schedule_train(t,7,"2023-01-11","tcr","pal","23:00:00","01:00:00");

        HashMap<String,Integer> places=new HashMap<>();
        places.put("tvm",1);
        places.put("kol",2);
        places.put("pat",3);
        places.put("ala",4);
        places.put("idu",5);
        places.put("kot",6);
        places.put("ern",7);
        places.put("tcr",8);
        places.put("pal",9);
        places.put("mal",10);
        places.put("koz",11);
        places.put("way",12);
        places.put("kan",13);
        places.put("kas",14);
//        for(Map.Entry m : places.entrySet()){
//            System.out.println(m.getKey()+" "+m.getValue());
//        }
        //tvm-trivandrum-1
        //kol-kollam-2
        //pat-pathanamthitta-3
        //ala- alappuzha-4
        //idu-idukki-5
        //kot-kottayam-6
        //Ern-ernamkulam-7
        //tcr-thrissur-8
        //pal-palakad-9
        //mal-malappuram-10
        //koz-kozhikode-11
        //way-wayanad-12
        //kan-kannur-13
        //kas-kasargod-14

        ArrayList<Ticket> ticket=new ArrayList<>();
        int ch0;
        do {
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Exit");
            System.out.println("Who are you?");
            ch0 = sc.nextInt();
            if (ch0 == 1) {
                System.out.println("1. Sign Up");
                System.out.println("2. Log In");
                System.out.println("3. Exit");
                int ch2;
                System.out.println("Enter your choice : ");
                ch2 = sc.nextInt();
                if (ch2 == 1) {
                    String id, pass;
                    System.out.println("Enter you Admin_id : ");
                    id = sc.next();
                    System.out.println("Enter you Admin_pass: ");
                    pass = sc.next();
                    admins.add(new Admin(id, pass));
                } else if (ch2 == 2) {
                    String id, pass;
                    System.out.println("Enter you Admin_id : ");
                    id = sc.next();
                    System.out.println("Enter you Admin_pass: ");
                    pass = sc.next();
                    if (new Admin().validate(admins, id, pass)) {
                        int ch3;
                        do {
                            System.out.println(ANSI_PURPLE);
                            new Admin().displayMenu();
                            System.out.println("Enter your choice : ");
                            ch3 = sc.nextInt();
                            if(ch3==1){
                                int tno,tcapacity;
                                String tname;
                                System.out.println("Enter Train_No : ");
                                tno=sc.nextInt();
                                System.out.println("Enter Train_Name : ");
                                tname= sc.next();
                                System.out.println("Enter Train_Capacity : ");
                                tcapacity=sc.nextInt();
                                t.add(new Train(tno,tname,tcapacity));
                            }else if(ch3==2){
                                System.out.println("Train_No LIST : ");
                                for(int i=0;i<t.size();i++){
                                    System.out.println("\t  "+t.get(i).Tno);
                                }
                                int remove_tno;
                                System.out.println("Enter train_no to be Removed :");
                                remove_tno=sc.nextInt();
                                new Train().remove_train(t,remove_tno);

                                System.out.println("Remaining Trains:");
                                for(int i=0;i<t.size();i++){
                                    System.out.println("\t  "+t.get(i).Tno);
                                }
                            }else if(ch3==3){
                                System.out.println("Train_ID\tTrain_No");
                                for(int i=0;i<t.size();i++){
                                    System.out.println("\t"+t.get(i).T_id+"\t\t\t"+t.get(i).Tno);
                                }
                                int schedule_tno;
                                System.out.println("Enter Train_id to be Scheduled :");
                                schedule_tno=sc.nextInt();
                                new Train().schedule_train(t,schedule_tno);
                            }
                            else if(ch3==4){
                                System.out.println("Train_ID\tTrain_No\tDate_of_Departure");
                                for(int i=0;i<t.size();i++){
                                    System.out.println("\t"+t.get(i).T_id+"\t\t    "+t.get(i).Tno+"\t\t\t"+t.get(i).Schedule_date);
                                }
                                int cancel_tno;
                                System.out.println("Enter Train_no to be Canceled :");
                                cancel_tno=sc.nextInt();
                                String date;
                                System.out.println("Enter date : ");
                                date=sc.next();
                                LocalDate cancel_date=LocalDate.parse(date);
                                new Train().cancel_train(t,cancel_tno,cancel_date);
                                System.out.println("Train Canceled Successfully !...");
                            }else if(ch3==5){
                                System.out.println("Train_ID\tTrain_No");
                                for(int i=0;i<t.size();i++){
                                    System.out.println("\t"+t.get(i).T_id+"\t\t\t"+t.get(i).Tno);
                                }
                                int update_tno;
                                System.out.println("Enter train_id to be updated :");
                                update_tno=sc.nextInt();
                                new Train().updateTrain(t,update_tno);
                                System.out.println("Train Updated Successfully !...");
                            }
                            else if(ch3==6){
                                System.out.println("Train_ID\tTrain_No");
                                for(int i=0;i<t.size();i++){
                                    System.out.println("\t"+t.get(i).T_id+"\t\t\t"+t.get(i).Tno);
                                }
                                int print_tno;
                                System.out.println("Enter train_id to be printed : ");
                                print_tno=sc.nextInt();
                                System.out.println(new Train().printTrain(t,print_tno));
                            }else if(ch3==7){
                                new Train().printAll(t);
                            }else{
//                                System.out.println(new Admin().currentStatus());
                                new Admin().logout(admins,id,pass);
//                                System.out.println(new Admin().currentStatus());
                            }
                        } while (ch3 <= 7);
                    }
                }
            } else if (ch0 == 2) {
                System.out.println("1. Sign Up");
                System.out.println("2. Log In");
                System.out.println("3. Exit");
                int ch2;
                System.out.println("Enter your choice : ");
                ch2 = sc.nextInt();
                if (ch2 == 1) {
                    String id, pass;
                    System.out.println("Enter you User_id : ");
                    id = sc.next();
                    System.out.println("Enter you User_pass: ");
                    pass = sc.next();
                    users.add(new User(id, pass));
                } else if (ch2 == 2) {
                    String id, pass;
                    System.out.println("Enter you User_id : ");
                    id = sc.next();
                    System.out.println("Enter you User_pass: ");
                    pass = sc.next();
                    if (new User().validate(users, id, pass)) {
                        int ch3;
                        do {
                            System.out.println(ANSI_CYAN);
                            new User().displayMenu();
                            System.out.println("Enter your choice : ");
                            ch3 = sc.nextInt();
                            if(ch3==1){
                                String st,dt;
                                int flag=0;
                                System.out.println("Enter your Starting Point : ");
                                st=sc.next();
                                System.out.println("Enter your destination : ");
                                dt=sc.next();
                                new Ticket().disp_train(t,st,dt);
                                int tno,no_of_tickets;
                                String date;
                                System.out.println("Enter TrainNo : ");
                                tno=sc.nextInt();
                                System.out.println("Enter Date : ");
                                date= sc.next();
                                System.out.println("Enter no of tickets you want to book : ");
                                do{
                                    no_of_tickets=sc.nextInt();
                                    int c=0;
                                    for(int i=0;i<t.size();i++){
                                        if(t.get(i).Schedule_date.toString().equals(date)){
                                            c=t.get(i).TAvailableSeats;
                                        }
                                    }
                                    if(no_of_tickets<=c){
                                        flag=1;
                                        break;
                                    }else{
                                        System.out.println("Not Enough Seats !!!");
                                    }
                                }while(true);
                                if(flag==1){
                                    ticket.add(new Ticket(places,users,t,st,dt,tno,date,no_of_tickets));
                                }
                            }else if(ch3==2){
                                int tickt_no;
                                System.out.println("Enter your Ticket_No : ");
                                tickt_no= sc.nextInt();
                                new Ticket().view_ticket(ticket,tickt_no);
                            }else if(ch3==3){
                                new Ticket().search_train(t);
                            }
                            else if (ch3==4){
                                System.out.println("Enter your Tickt-No : ");
                                int no;
                                no= sc.nextInt();
                                new Ticket().cancel_ticket(t,ticket,no);
                            }else{
                                new User().logout(users,id,pass);
                            }
                        } while (ch3 <= 4);
                    }
                }
            }
        } while (ch0 <= 2);
    }
}
