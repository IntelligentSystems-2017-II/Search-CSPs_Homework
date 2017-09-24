import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Problem theProblem = new HousesProblem();
        Assignment theAssignment = new Assignment();


        BackTrackSolver solver = new BackTrackSolver();
        theAssignment = solver.solve(theProblem);

        System.out.println(theAssignment.toString());

        /*
        Variable v = theProblem.variables.get(5);
        Variable v1 = theProblem.variables.get(21);
        System.out.println("var 1 "+ v.getName());
        System.out.println("var 2 "+ v1.getName());
        System.out.println(v.getDomain().get(1));
        System.out.println(v1.getDomain().get(2));

        a.setAssignment(v, v.getDomain().get(1));

        a.setAssignment(v1, v1.getDomain().get(2));
        System.out.println("as: " + a.toString());
        NextHouseConstraint c = (NextHouseConstraint) theProblem.constraints.get(67);
        System.out.println(c.getDescription());
        System.out.println("ex 1: " + c.expectedValue1.toString());
        System.out.println("ex 2: " + c.expectedValue2.toString());
        System.out.println(c.satisfiedWith(a));
        */

        //milk drunk at middle house
        /*Variable v = theProblem.variables.get(17);
        Variable v1 = theProblem.variables.get(27);

        System.out.println("var 1 "+ v.getName());
        System.out.println("var 2 "+ v1.getName());
        System.out.println(v.getDomain().get(3));
        System.out.println(v1.getDomain().get(2));

        a.setAssignment(v, v.getDomain().get(3));
        a.setAssignment(v1, v1.getDomain().get(2));

        BinaryConstraint c = (BinaryConstraint) theProblem.constraints.get(58);
        System.out.println("expected: " + c.valueVar1);
        System.out.println("expected: " + c.valueVar2);
        System.out.println(c.getDescription());
        System.out.println(c.satisfiedWith(a));*/

        /* //coffee drunk at green house
        Variable v = theProblem.variables.get(18);
        Variable v1 = theProblem.variables.get(3);

        System.out.println(v.getName());
        System.out.println(v1.getName());
        System.out.println(v.getDomain().get(1));
        System.out.println(v1.getDomain().get(4));

        a.setAssignment(v, v.getDomain().get(1));
        a.setAssignment(v1, v1.getDomain().get(4));

        BinaryConstraint c = (BinaryConstraint) theProblem.constraints.get(54);
        System.out.println(c.valueVar1);
        System.out.println(c.valueVar2);
        System.out.println(c.getDescription());
        System.out.println(c.satisfiedWith(a));
        /*

        /* //japanese smokes Parliaments
        Variable v = theProblem.variables.get(12);
        Variable v1 = theProblem.variables.get(22);

        System.out.println(v.getName());
        System.out.println(v1.getName());
        System.out.println(v.getDomain().get(2));
        System.out.println(v1.getDomain().get(3));

        a.setAssignment(v, v.getDomain().get(2));
        a.setAssignment(v1, v1.getDomain().get(3));

        BinaryConstraint c = (BinaryConstraint) theProblem.constraints.get(48);
        System.out.println(c.valueVar1);
        System.out.println(c.valueVar2);
        System.out.println(c.getDescription());
        System.out.println(c.satisfiedWith(a));
        /*

         */
        /* //ukranian drinks tea
        Variable v = theProblem.variables.get(12);
        Variable v1 = theProblem.variables.get(17);

        System.out.println(v.getName());
        System.out.println(v1.getName());
        System.out.println(v.getDomain().get(3));
        System.out.println(v1.getDomain().get(0));

        a.setAssignment(v, v.getDomain().get(3));
        a.setAssignment(v1, v1.getDomain().get(0));

        BinaryConstraint c = (BinaryConstraint) theProblem.constraints.get(43);
        System.out.println(c.valueVar1);
        System.out.println(c.valueVar2);
        System.out.println(c.getDescription());
        System.out.println(c.satisfiedWith(a));*/


        /* // lucy strike smoker drinks orange juice
        Variable v = theProblem.variables.get(23);
        Variable v1 = theProblem.variables.get(18);

        System.out.println(v.getName());
        System.out.println(v1.getName());
        System.out.println(v.getDomain().get(1));
        System.out.println(v1.getDomain().get(2));

        a.setAssignment(v, v.getDomain().get(1));
        a.setAssignment(v1, v1.getDomain().get(2));

        BinaryConstraint c = (BinaryConstraint) theProblem.constraints.get(39);
        System.out.println(c.valueVar1);
        System.out.println(c.valueVar2);
        System.out.println(c.getDescription());
        System.out.println(c.satisfiedWith(a));*/

        /* //winston smoker owns snails
        Variable v = theProblem.variables.get(21);
        Variable v1 = theProblem.variables.get(6);

        System.out.println(v.getName());
        System.out.println(v1.getName());
        System.out.println(v.getDomain().get(3));
        System.out.println(v1.getDomain().get(3));

        a.setAssignment(v, v.getDomain().get(3));
        a.setAssignment(v1, v1.getDomain().get(3));

        BinaryConstraint c = (BinaryConstraint) theProblem.constraints.get(32);
        System.out.println(c.valueVar1);
        System.out.println(c.valueVar2);
        System.out.println(c.getDescription());
        System.out.println(c.satisfiedWith(a));
        */
        /*
        //house 2: blue
        Variable v = theProblem.variables.get(1);
        Variable v1 = theProblem.variables.get(26);

        System.out.println(v.getName());
        System.out.println(v1.getName());
        System.out.println(v.getDomain().get(0));
        System.out.println(v1.getDomain().get(1));

        a.setAssignment(v, v.getDomain().get(0));
        a.setAssignment(v1, v1.getDomain().get(1));

        BinaryConstraint c = (BinaryConstraint) theProblem.constraints.get(27);
        System.out.println(c.valueVar1);
        System.out.println(c.valueVar2);
        System.out.println(c.getDescription());
        System.out.println(c.satisfiedWith(a));/*

        /*
        //kools somked at yellow
        Variable v = theProblem.variables.get(0);
        Variable v1 = theProblem.variables.get(20);

        System.out.println(v.getName());
        System.out.println(v1.getName());
        System.out.println(v.getDomain().get(2));
        System.out.println(v1.getDomain().get(0));

        a.setAssignment(v, v.getDomain().get(2));
        a.setAssignment(v1, v1.getDomain().get(0));

        BinaryConstraint c = (BinaryConstraint) theProblem.constraints.get(21);
        System.out.println(c.valueVar1);
        System.out.println(c.valueVar2);
        System.out.println(c.getDescription());
        System.out.println(c.satisfiedWith(a));
        */


      /*  Variable v = theProblem.variables.get(10);
        Variable v1 = theProblem.variables.get(25);
        System.out.println(v.getName());
        System.out.println(v1.getName());
        System.out.println(v.getDomain().get(2));
        System.out.println(v1.getDomain().get(0));

        a.setAssignment(v, v.getDomain().get(2));
        a.setAssignment(v1, v1.getDomain().get(0));

        BinaryConstraint c = (BinaryConstraint) theProblem.constraints.get(16);
        System.out.println(c.getDescription());
        System.out.println(c.satisfiedWith(a));*/

        //spaniard dog
        /*Variable v = theProblem.variables.get(6);
        Variable v1 = theProblem.variables.get(11);
        System.out.println(v.getName());
        System.out.println(v1.getName());
        System.out.println(v.getDomain().get(0));
        System.out.println(v1.getDomain().get(0));

        a.setAssignment(v, v.getDomain().get(0));
        a.setAssignment(v1, v1.getDomain().get(0));
        System.out.println(a.toString());

        BinaryConstraint c = (BinaryConstraint) theProblem.constraints.get(12);
        System.out.println(c.satisfiedWith(a));
        System.out.println(c.valueVar1.toString());
        System.out.println(c.valueVar2.toString());
        System.out.println();
        System.out.println(c.getDescription());
        */

    }
}
