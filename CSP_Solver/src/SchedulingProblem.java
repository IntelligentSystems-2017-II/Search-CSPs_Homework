import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SchedulingProblem extends Problem {
    public SchedulingProblem(){
        variables = new ArrayList<>(5);
        List<Integer> domain = new ArrayList<>(4);
        constraints = new ArrayList<>(8);
        varConst = new HashMap<>();


        for(int i = 1; i <= 4; i++ )
            domain.add(i);

        variables.add(new Variable("A", domain));
        variables.add(new Variable("B", domain));
        variables.add(new Variable("C", domain));
        variables.add(new Variable("D", domain));
        variables.add(new Variable("E", domain));

        constraints.add(new BinarySchedulingConstraint<>(variables.get(0), variables.get(3), (short)1));
        constraints.add(new BinarySchedulingConstraint<>(variables.get(3), variables.get(4), (short)1));
        constraints.add(new BinarySchedulingConstraint<>(variables.get(2), variables.get(0), (short)4));
        constraints.add(new BinarySchedulingConstraint<>(variables.get(2), variables.get(4), (short)1));
        constraints.add(new BinarySchedulingConstraint<>(variables.get(2), variables.get(3), (short)4));
        constraints.add(new BinarySchedulingConstraint<>(variables.get(1), variables.get(0), (short)2));
        constraints.add(new BinarySchedulingConstraint<>(variables.get(1), variables.get(2), (short)4));
        constraints.add(new BinarySchedulingConstraint<>(variables.get(2), variables.get(3), (short)5));

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
