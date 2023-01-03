package Project5;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Ticket extends Payment {
    int Tickt_No;
    static int cnt=1;
    String st;
    String dt;
    LocalDate book_date;
    int bTrain_no;
    int b_no_of_tickets;

    float Tickt_price;
    Scanner sc=new Scanner(System.in);
    Ticket(){
        //nothing
    }
    public void disp_train(ArrayList<Train> t, String st, String dt){
        for(int i=0;i<t.size();i++){
            if((t.get(i).TStartPoint).equals(st)){
                if((t.get(i).TDestination).equals(dt)){
                    System.out.println(t.get(i));
                }
            }
        }
    }
    public Ticket(HashMap<String,Integer> p, ArrayList<User> user, ArrayList<Train> train, String st, String dt, int tno, String date, int no_of_tickets){
        this.st=st;
        this.dt=dt;
        this.book_date=LocalDate.parse(date);
        this.b_no_of_tickets=no_of_tickets;
        this.bTrain_no=tno;
        for(int i=0;i<train.size();i++){
            if((train.get(i).TStartPoint).equals(st)){
                if((train.get(i).TDestination).equals(dt)){
                    if((train.get(i).Tno)==tno){
                        if((train.get(i).Schedule_date).equals(book_date)){

                            train.get(i).TAvailableSeats-=b_no_of_tickets;
                        }
                    }
                }
            }
        }
        this.Tickt_No=cnt;
        cnt++;
        System.out.println("Ticket Booked");
        System.out.println("Your Ticket_ID: "+Tickt_No);
        this.Tickt_price=calc_pay(p,st,dt,b_no_of_tickets);
    }
    public void view_ticket(ArrayList<Ticket> ticket,int tickt_no){
        for(int i=0;i<ticket.size();i++){
            if(ticket.get(i).Tickt_No==tickt_no) {
                System.out.println("Ticket_No:"+ticket.get(i).Tickt_No + "\nNo. of Tickets : " + ticket.get(i).b_no_of_tickets+"\nTicket_Cost : \u20B9"+ticket.get(i).Tickt_price);
            }
        }
    }
    public String toString(){
        return "TicketNo:"+Tickt_No+" No.of_Seats:"+b_no_of_tickets;
    }
    public void cancel_ticket(ArrayList<Train> train, ArrayList<Ticket> ticket, int tickt_no){
        int tno = 0;
        LocalDate tdate = null;
        int nooftickets = 0;
        for(int i=0;i<ticket.size();i++){
            if(ticket.get(i).Tickt_No==tickt_no){
                tno=ticket.get(i).bTrain_no;
                tdate=ticket.get(i).book_date;
                nooftickets=ticket.get(i).b_no_of_tickets;
                ticket.remove(i--);
            }
        }
        for(int i=0;i<train.size();i++){
            if(train.get(i).Tno==tno){
                if((train.get(i).Schedule_date).equals(tdate)){
                    train.get(i).TAvailableSeats+=nooftickets;
                }
            }
        }
        System.out.println("Ticket Cancellation Successful");
    }
    public void search_train(ArrayList<Train> t){
        System.out.println("1. Search by Tno : ");
        System.out.println("2. Search by Train Name : ");
        System.out.println("3. Search by Date : ");
        System.out.println("4. Search by Starting Point : ");
        System.out.println("5. Search by Destination Point : ");
        int ch;
        ch=sc.nextInt();
        if(ch==1){
            System.out.println("Enter Tno : ");
            int tno;
            tno=sc.nextInt();
            for(int i=0;i<t.size();i++){
                if(t.get(i).Tno==tno){
                    System.out.println(t.get(i));
                }
            }
        }else if(ch==2){
            System.out.println("Enter Train_name");
            String name;
            name=sc.next();
            for(int i=0;i<t.size();i++){
                if((t.get(i).Tname).equalsIgnoreCase(name)){
                    System.out.println(t.get(i));
                }
            }
        }else if(ch==3){
            System.out.println("Enter date : ");
            String d;
            d= sc.next();
            LocalDate date=LocalDate.parse(d);
            for(int i=0;i<t.size();i++){
                if((t.get(i).Schedule_date).equals(date)){
                    System.out.println(t.get(i));
                }
            }
        }else if(ch==4){
            System.out.println("Enter Starting Point : ");
            String st;
            st=sc.next();
            for(int i=0;i<t.size();i++){
                if((t.get(i).TStartPoint).equalsIgnoreCase(st)){
                    System.out.println(t.get(i));
                }
            }
        }else if(ch==5){
            System.out.println("Enter Destination Point : ");
            String dt;
            dt=sc.next();
            for(int i=0;i<t.size();i++){
                if((t.get(i).TDestination).equalsIgnoreCase(dt)){
                    System.out.println(t.get(i));
                }
            }
        }
    }
}
