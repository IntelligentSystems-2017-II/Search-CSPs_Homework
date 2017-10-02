import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ProcessorsProblem extends Problem {
    public static int deadline;
    public static HashMap<Variable, Integer> tasksLength;

    public ProcessorsProblem(int n, int m, int d, HashMap<String, Variable> varNames,List<Integer> lengths, HashMap<Variable, List<String>> ui,
                             HashMap<Variable, List<String>> ue, HashMap<Variable,Variable> be, HashMap<Variable,Variable> bne,
                             HashMap<HashMap<Variable,Variable>, List<String>> binaryNS){
        variables = new ArrayList<>(n);
        constraints = new LinkedList<>();
        varConst = new HashMap<>();

        deadline = d;
        List<String> domain = new ArrayList<>(m);
        tasksLength = new HashMap<>();

        for(int i = 0; i < m; i++)
            domain.add("Processor" + (i+1));

        for(String s: varNames.keySet()){
            variables.add(varNames.get(s));
        }

        for(int i = 0; i < n; i++)
            tasksLength.put(variables.get(i), lengths.get(i));

        //System.out.println("Task length");
        /*for(Variable v: tasksLength.keySet())
            System.out.println("v:" + v.getName() + ": " + tasksLength.get(v));*/



        /*System.out.println("for ui:");
        for(Variable s: ui.keySet()){
            System.out.println(s.getName());
            System.out.println(ui.get(s).size());
            if(ui.get(s).size() > 0)
                for(String st: ui.get(s))
                    System.out.println(st);
        }*/
        for(Variable s: ui.keySet()){
            //System.out.println("at for "+ s);
            //System.out.println("contains:" + variables.contains(s));
            constraints.add(new UnaryConstraintP<>(true,
                    variables.get(variables.indexOf(s)), ui.get(s), "unary constraint"));
        }
        //System.out.println(variables.size());

        /*System.out.println("for ue:");
        for(Variable s: ue.keySet()){
            System.out.println(s.getName());
            System.out.println(ue.get(s).size());
            if(ue.get(s).size() > 0)
                for(String st: ue.get(s))
                    System.out.println(st);
        }*/
        for(Variable s: ue.keySet())
            constraints.add(new UnaryConstraintP<>(false,
                    variables.get(variables.indexOf(s)), ue.get(s), "unary constraint"));

        BinaryConstraintP cp;
        for(Variable s: be.keySet()){
            cp = new BinaryConstraintP((short) 1,
                    variables.get(variables.indexOf(s)),
                    variables.get(variables.indexOf(be.get(s))),
                    "binary constraint 1");
            constraints.add(cp);
        }

        for(Variable s: bne.keySet()){
            constraints.add(new BinaryConstraintP<>( (short) 2,
                    variables.get(variables.indexOf(s)),
                    variables.get(variables.indexOf(bne.get(s)))
                    , "binary constraint 2"
            ));
        }

        //for(int i  = 0; i < binaryNS.size(); i++){
        for(HashMap h: binaryNS.keySet()){
            for(Object s: h.keySet()){
                constraints.add(new BinaryConstraintP<>((short)3,
                        variables.get(variables.indexOf(s)),
                        variables.get(variables.indexOf(h.get(s))),
                        binaryNS.get(h).get(0), binaryNS.get(h).get(1)
                        , "binary constraint 3"
                        ));
            }
        }
        //}


        constraints.add(new TimeConstraint( d, variables));

        for(Constraint c: constraints){
            System.out.println(c.toString());
        }
        List<Constraint> relatedConstrains;

        for(Variable var: variables){
            relatedConstrains =  new ArrayList<>();
            for(Constraint c: constraints){
                if(c.getScope().contains(var))
                    relatedConstrains.add(c);
            }
            varConst.put(var, relatedConstrains);
        }
    }
}
