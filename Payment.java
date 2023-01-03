package Project5;

import java.util.HashMap;
import java.util.Map;

public class Payment{
    public float  calc_pay(HashMap<String,Integer> p, String st, String dt,int n){
        int a=0,b=0;
        float total=0;
        for(Map.Entry m : p.entrySet()){
            if(m.getKey().equals(st)){
                a= (int) m.getValue();
            }
            if(m.getKey().equals(dt)){
                b= (int) m.getValue();
            }

        }
        total=Math.abs(a-b)*(float)10.5*n;
        return total;
    }

}
