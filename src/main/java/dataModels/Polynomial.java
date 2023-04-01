package dataModels;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private Map<Integer, Double> map = new HashMap<Integer, Double>();
    public void removeZeroCoeffs(){
        Map<Integer,Double> nMap = new HashMap<>();
        for(Map.Entry<Integer,Double> entry: this.map.entrySet())
            if(entry.getValue()==0.0)
                nMap.put(entry.getKey(), entry.getValue());
        for(Map.Entry<Integer,Double> entry: nMap.entrySet())
            this.map.remove(entry.getKey());
    }
    public Polynomial(){
        this.map.put(0,0.0);
    }
    public Polynomial(Map map){
        this.map=map;
        this.removeZeroCoeffs();
    }
    public Polynomial(String s){
        Pattern pattern = Pattern.compile("(-)?(((\\d+)X\\^(\\d+))|(X\\^(\\d+))|((\\d+)X)|(X)|(\\d+))");
        Matcher matcher = pattern.matcher(s);
        while(matcher.find()){
            if(matcher.group(3)!=null)
                if(matcher.group(1)!=null)
                    this.map.put(Integer.parseInt(matcher.group(5)),-1*Double.parseDouble(matcher.group(4)));
                else
                    this.map.put(Integer.parseInt(matcher.group(5)),Double.parseDouble(matcher.group(4)));
            else if(matcher.group(6)!=null)
                if(matcher.group(1)!=null)
                    this.map.put(Integer.parseInt(matcher.group(7)),-1.0);
                else
                    this.map.put(Integer.parseInt(matcher.group(7)),1.0);
            else if(matcher.group(8)!=null)
                if(matcher.group(1)!=null)
                    this.map.put(1,-1*Double.parseDouble(matcher.group(9)));
                else
                    this.map.put(1,Double.parseDouble(matcher.group(9)));
            else if(matcher.group(10)!=null)
                if(matcher.group(1)!=null)
                    this.map.put(1,-1.0);
                else
                    this.map.put(1,1.0);
            else if(matcher.group(11)!=null)
                if(matcher.group(1)!=null)
                    this.map.put(0,-1*Double.parseDouble(matcher.group(11)));
                else
                    this.map.put(0,Double.parseDouble(matcher.group(11)));
        }this.removeZeroCoeffs();
    }

    public Map<Integer, Double> getMap() {
        return map;
    }

    public Integer getDegree(){
        Integer d = -1;
        for(Map.Entry<Integer,Double> entry: this.map.entrySet())
            if(entry.getKey()>d)
                d=entry.getKey();
        return d;
    }
    public String toString(){
        TreeMap<Integer, Double> auxMap = new TreeMap<Integer,Double>(Comparator.reverseOrder());
        auxMap.putAll(this.map);

        String s="";
        for(Map.Entry<Integer,Double> entry: auxMap.entrySet()){
            if(entry.getValue()>0 && entry.getKey()!=auxMap.firstKey())
                s=s+" +" +entry.getValue();
            else
                s=s+" "+entry.getValue();
            if(entry.getKey()!=0)
                if(entry.getKey()==1)
                s=s+"X";
                else
                    s=s+"X^"+entry.getKey();
        }
        return s;

    }

}
