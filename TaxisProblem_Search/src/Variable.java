import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;

public class Variable {
    public static char[] domain = {'P', 'Q', 'R', 'S'};
    public static HashMap<Integer, HashMap<Character,Integer>> values = new HashMap<>();

    public Variable(){
        //ArrayList<Integer> vals = new ArrayList<>(4);
        //values = new HashMap<>();
        HashMap<Character, Integer> theValues = new HashMap();
        theValues.put('P',10);
        theValues.put('Q',8);
        theValues.put('R',4);
        theValues.put('S',6);

        values.put(0, theValues);

        theValues = new HashMap();

        theValues.put('P',6);
        theValues.put('Q',4);
        theValues.put('R',12);
        theValues.put('S',8);

        values.put(1, theValues);

        theValues = new HashMap();

        theValues.put('P',14);
        theValues.put('Q',10);
        theValues.put('R',8);
        theValues.put('S',2);

        values.put(2, theValues);

        theValues = new HashMap();

        theValues.put('P',4);
        theValues.put('Q',14);
        theValues.put('R',10);
        theValues.put('S',9);

        values.put(3, theValues);

        /*System.out.println(values.toString());
        for(Integer i: values.keySet()){
            System.out.println("i:"+ i);
            for(Character c: values.get(i).keySet()){
                System.out.println("c:" + c + " " + values.get(i).get(c));
            }
        }*/
    }

}
