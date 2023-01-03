package Project5;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Train{
    Scanner sc=new Scanner(System.in);
    static int cnt=0;
    int T_id;
    int Tno;
    String Tname;
    int Tcapcity;

    LocalDate Schedule_date;
    String TStartPoint;
    String TDestination;
    LocalTime TStartTime;
    LocalTime TArrivalTime;
    int TAvailableSeats;

    public Train(){
        //nothing
    }
    public Train(int tno,String tname,int tcapacity) {
        this.Tno=tno;
        this.Tname=tname;
        this.Tcapcity=tcapacity;
        this.T_id=cnt;
        cnt++;
    }
    public void remove_train(ArrayList<Train> t, int tno){
        for(int i=0;i<t.size();i++){
            if(t.get(i).Tno==tno){
                t.remove(i--);
            }
        }
    }
    public void pre_schedule_train(ArrayList<Train> t,int tno,String date,String st,String dt,String t1,String t2){
        for(int i=0;i<t.size();i++){
            if(t.get(i).T_id==tno){
                (t.get(i).Schedule_date)=LocalDate.parse(date);
                t.get(i).TStartPoint=st;
                t.get(i).TDestination=dt;
                (t.get(i).TStartTime)=LocalTime.parse(t1);
                (t.get(i).TArrivalTime)=LocalTime.parse(t2);
                t.get(i).TAvailableSeats=t.get(i).Tcapcity;
            }
        }
    }
    public void schedule_train(ArrayList<Train> t,int tno){
        int flag=1;
        for(int i=0;i<t.size();i++){
            if(t.get(i).T_id==tno){
                String date,starttime,endtime;
                System.out.println("Enter Date(YYYY-MM-DD) : ");
                int f=1;
                while(f==1){
                    try{
                        date= sc.next();
                        t.get(i).Schedule_date=LocalDate.parse(date);
                        f=0;
                    }
                    catch (Exception e){
                        System.out.println("Please enter a correct date :");
                    }
                }
                System.out.println("Enter Starting Point : ");
                t.get(i).TStartPoint=sc.next();
                System.out.println("Enter Destination : ");
                t.get(i).TDestination=sc.next();
                System.out.println("Enter starting time(HH:MM:SS) : ");
                int a=1;
                while(a==1){
                    try{
                        starttime=sc.next();
                        t.get(i).TStartTime=LocalTime.parse(starttime);
                        a=0;
                    }
                    catch (Exception e){
                        System.out.println("Enter correct time : ");
                    }
                }
                System.out.println("Enter arrival time(HH:MM:SS) : ");
                int b=1;
                while(b==1) {
                    try {
                        endtime = sc.next();
                        t.get(i).TArrivalTime = LocalTime.parse(endtime);
                        b = 0;
                    } catch (Exception e) {
                        System.out.println("Enter correct time");
                    }
                }
                t.get(i).TAvailableSeats=t.get(i).Tcapcity;
                System.out.println("TRAIN SCHEDULE SUCCESSFUL !...");
                flag=1;
                break;
            }else{
                flag=0;
            }
        }
        if(flag==0){
            System.out.println("Train ID Not FOund!");
        }
    }
    public void cancel_train(ArrayList<Train> t,int tno,LocalDate d){
        int flag=1;
        for(int i=0;i<t.size();i++){
            if(t.get(i).Tno==tno){
                if(d.equals(t.get(i).Schedule_date)){
                    t.remove(i);
                    flag=1;
                    break;
                }
            }else{
                flag=0;
            }
        }
        if(flag==0){
            System.out.println("Train ID Not FOund!");
        }
    }
    public void updateTrain(ArrayList<Train> t,int tno){
        System.out.println("1. Train_No");
        System.out.println("2. Train_Name");
        System.out.println("3. Train_Capacity");
        System.out.println("4. Train_Start_Time");
        System.out.println("5. Train_Arrival_Time");
        System.out.println("What do you want to update?");
        int ch=0;
        int v=1;
        ch=sc.nextInt();
        if(ch==1){
            System.out.println("Enter new Train_No : ");
            for(int i=0;i<t.size();i++){
                if(t.get(i).T_id==tno){
                    int w=1;
                    while(w==1){
                        try{
                            t.get(i).Tno=sc.nextInt();
                            w=0;
                        }
                        catch (Exception e){
                            System.out.println("Enter the correct detail : ");
                        }
                    }
                }
            }
        }else if(ch==2){
            System.out.println("Enter new Train_Name : ");
            for(int i=0;i<t.size();i++){
                if(t.get(i).T_id==tno){
                    int d=1;
                    while(d==1){
                        try{
                            t.get(i).Tname=sc.next();
                            d=0;
                        }
                        catch (Exception e){
                            System.out.println("Enter the correct name : ");
                        }
                    }
                }
            }
        }else if(ch==3){
            System.out.println("Enter new Train_capacity : ");
            for(int i=0;i<t.size();i++){
                if(t.get(i).T_id==tno){
                    int n=1;
                    while(n==1){
                        try{
                            t.get(i).Tcapcity=sc.nextInt();
                            n=0;}
                        catch (Exception e){
                            System.out.println("Enter the correct input : ");
                        }
                    }
                }
            }
        }else if(ch==4){
            System.out.println("Enter new Start time(HH:MM:SS) :");
            int z=1;
            while(z==1){
                try{
                    String time=sc.next();
                    for (int i = 0; i < t.size(); i++) {
                        if (t.get(i).T_id == tno) {
                            t.get(i).TStartTime = LocalTime.parse(time);
                            z=0;
                        }
                    }
                }catch(Exception e){
                    System.out.println("Enter correct input : ");
                }
            }
        }else if(ch==5){
            System.out.println("Enter new Arrival time(HH:MM:SS) :");
            int z=1;
            while(z==1){
                try{
                    String time=sc.next();
                    for (int i = 0; i < t.size(); i++) {
                        if (t.get(i).T_id == tno) {
                            t.get(i).TArrivalTime= LocalTime.parse(time);
                            z=0;
                        }
                    }
                }catch(Exception e){
                    System.out.println("Enter correct input : ");
                }
            }
        }

    }
    public String printTrain(ArrayList<Train> t,int tno) {
        for (int i = 0; i < t.size(); i++) {
            if (t.get(i).T_id == tno) {
                return "Train ID \t\t\t: "+t.get(i).T_id + "\n" +"Train No \t\t\t: "+ t.get(i).Tno + "\n" +"Train Name \t\t\t: "+ t.get(i).Tname + "\n" +"Train Capacity \t\t: "+t.get(i).Tcapcity + "\n" +"Date of Departure \t: "+ t.get(i).Schedule_date + "\n" +"Starting Point \t\t: "+t.get(i).TStartPoint + "\n" +"Destination \t\t: "+ t.get(i).TDestination + "\n" +"Departure Time \t\t: "+ t.get(i).TStartTime + "\n" +"Arrival Time \t\t: "+ t.get(i).TArrivalTime + "\n" +"Available Seats \t: "+ t.get(i).TAvailableSeats;
            }
        }
        return "Train not Found ! ..";
    }
    public void printAll(ArrayList<Train> t){
        System.out.println("Train_ID\tTrain_Number\tTrain_Name\tTrain_Capacity\tDate_of_Departure\tStarting_Point\tDestination\tDeparture_Time\tArrival_Time\tAvailable_Seats");
        for (int i = 0; i < t.size(); i++) {
            System.out.println("\t"+t.get(i).T_id + "\t\t\t" + t.get(i).Tno + "\t\t\t\t" + t.get(i).Tname + "\t\t\t " + t.get(i).Tcapcity + "\t\t\t\t" + t.get(i).Schedule_date + "\t\t\t" + t.get(i).TStartPoint + "\t\t\t\t" + t.get(i).TDestination + "\t\t\t" + t.get(i).TStartTime + "\t\t\t" + t.get(i).TArrivalTime + "\t\t\t  " + t.get(i).TAvailableSeats);
        }
    }

    public String toString(){
        return "TrainNo:"+Tno+" TrainName:"+Tname+" Date:"+Schedule_date+" AvailSeats:"+TAvailableSeats;
    }
}