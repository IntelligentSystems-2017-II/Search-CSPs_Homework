import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Taxis extends Problem{
    public Taxis(){
        variables = new ArrayList<>(4);
        constraints = new ArrayList<>();
        varConst = new HashMap<>();

        List<String> domain = new ArrayList<>(4);

        domain.add("P");
        domain.add("Q");
        domain.add("R");
        domain.add("S");

        for(int i = 0; i < 4; i++)
            variables.add(new Variable("Taxi " + (i+1), domain));

        for(int i = 0; i <  4; i++)
            constraints.add(new AllDiffConstraint<>(variables, "Different client for each taxi"));



        List<Constraint> related ;

        for(Variable v: variables){
            related = new ArrayList<>();
            for(Constraint c: constraints){
                if(c.getScope().contains(v))
                    related.add(c);
            }
            varConst.put(v, related);
        }


    }
}
