package businessLogic;

import dataModels.Polynomial;

import java.util.*;

public abstract class Operations {
    public static Polynomial add(Polynomial p1, Polynomial p2){
        Map<Integer, Double> nMap = new HashMap<Integer, Double>((Map<? extends Integer, ? extends Double>) p1.getMap());
        Integer  exp;
        Double coef;
        for (Map.Entry<Integer, Double> entry : p2.getMap().entrySet()){
            exp = entry.getKey();
            coef=entry.getValue();
            if(nMap.containsKey(exp))
                coef += nMap.get(exp);
            nMap.put(exp,coef);
        }

        return new Polynomial(nMap);
    }
    public static Polynomial substract(Polynomial p1, Polynomial p2){
        Map<Integer, Double> nMap = new HashMap<Integer, Double>((Map<? extends Integer, ? extends Double>) p1.getMap());
        Integer  exp;
        Double coef;
        for (Map.Entry<Integer, Double> entry : p2.getMap().entrySet()){
            exp = entry.getKey();
            coef=-1*entry.getValue();
            if(nMap.containsKey(exp))
                coef += nMap.get(exp);
            nMap.put(exp,coef);
        }
        return new Polynomial(nMap);
    }
    public static Polynomial multiply(Polynomial p1, Polynomial p2){
        Map<Integer, Double> nMap = new HashMap<Integer, Double>();
        Double coef;
        Integer exp;
        for(Map.Entry<Integer, Double> entry1:p1.getMap().entrySet())
            for(Map.Entry<Integer,Double> entry2:p2.getMap().entrySet()){
                coef = entry1.getValue()*entry2.getValue();
                exp=entry1.getKey()+entry2.getKey();
                if(nMap.containsKey(exp))
                    coef+=nMap.get(exp);
                nMap.put(exp,coef);
            }
        return new Polynomial(nMap);
    }
    public static Polynomial derivative(Polynomial p){
        Map<Integer, Double> nMap = new HashMap<>();
        for(Map.Entry<Integer, Double> entry: p.getMap().entrySet())
            if(entry.getKey()!=0)
                nMap.put(entry.getKey()-1, entry.getValue()*entry.getKey());
            else if(!p.getMap().containsKey(1))
                nMap.put(0,0.0);
        return new Polynomial(nMap);
    }
    public static Polynomial[] division(Polynomial p1, Polynomial p2){
        if(p1.getMap().isEmpty() || p2.getMap().isEmpty())
            return null;
        if(p1.getDegree()<p2.getDegree())
            return null;
        Polynomial remainder = new Polynomial(p1.getMap());
        Polynomial quotient  = new Polynomial();
        Map.Entry<Integer, Double> nTerm;
        Map<Integer,Double> auxMap;
        Polynomial auxP = new Polynomial();
            while(remainder.getDegree()>=p2.getDegree()){
                nTerm=new AbstractMap.SimpleEntry<>(remainder.getDegree()-p2.getDegree(),remainder.getMap().get(remainder.getDegree())/p2.getMap().get(p2.getDegree()));
                auxMap=new HashMap<>();
                auxMap.put(nTerm.getKey(),nTerm.getValue());
                quotient.getMap().put(nTerm.getKey(),nTerm.getValue());
                auxP = new Polynomial(auxMap);
                remainder=Operations.substract(remainder,Operations.multiply(p2,auxP));

            }
            Polynomial[] p = new Polynomial[2];
            p[0]=new Polynomial(quotient.getMap());
            p[1]=new Polynomial(remainder.getMap());
            return p;
    }
    public static Polynomial integral(Polynomial p){
        Map<Integer,Double> nMap = new HashMap<>();
        for(Map.Entry<Integer,Double> entry: p.getMap().entrySet()){
            nMap.put(entry.getKey()+1, entry.getValue()/(entry.getKey()+1));
        }
        return new Polynomial(nMap);
    }
}
