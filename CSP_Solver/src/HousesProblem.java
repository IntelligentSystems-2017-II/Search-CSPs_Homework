import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HousesProblem extends Problem {

    public HousesProblem() {
        variables = new ArrayList<>(30);
        List<String> domain = new ArrayList<>(5);
        constraints = new ArrayList<>(30);
        varConst = new HashMap<>();

        domain.add("Blue");
        domain.add("Red");
        domain.add("Yellow");
        domain.add("Green");
        domain.add("Ivory");
        //Variable houseColor = new Variable("Color", domain);

        for (int i = 1; i <= 5; i++) {
            variables.add(new Variable("Color" + i, domain));
        }


        domain.clear();

        domain.add("Dog");
        domain.add("Fox");
        domain.add("Snails");
        domain.add("Horse");
        domain.add("Zebra");

        //Variable pet = new Variable("Pet", domain);
        for (int i = 1; i <= 5; i++) {
            variables.add(new Variable("Pet" + i, domain));
        }

        domain.clear();


        domain.add("Spaniard");
        domain.add("English");
        domain.add("Norwegian");
        domain.add("Japanese");
        domain.add("Ukranian");
        //Variable nationality = new Variable("Nationality", domain);
        //variables.add(nationality);
        for (int i = 1; i <= 5; i++) {
            variables.add(new Variable("Nationality" + i, domain));
        }

        domain.clear();

        domain.add("Tea");
        domain.add("Orange Juice");
        domain.add("Coffee");
        domain.add("Milk");
        domain.add("Water");
        //Variable beverage = new Variable("Beverage", domain);
        //variables.add(beverage);
        for (int i = 1; i <= 5; i++) {
            variables.add(new Variable("Beverage" + i, domain));
        }
        domain.clear();

        domain.add("Kools");
        domain.add("Chesterfields");
        domain.add("Winston");
        domain.add("Lucky Strike");
        domain.add("Parliaments");

        //Variable smokeBrand = new Variable("SmokeBrand", domain);
        //variables.add(smokeBrand);
        for (int i = 1; i <= 5; i++) {
            variables.add(new Variable("SmokeBrand" + i, domain));
        }

        List<Integer> domain1 = new ArrayList<>(5);
        domain1.add(1);
        domain1.add(2);
        domain1.add(3);
        domain1.add(4);
        domain1.add(5);
        //Variable location = new Variable("Location1", domain1);
        //variables.add(location);
        for (int i = 1; i <= 5; i++) {
            variables.add(new Variable("Location" + i, domain1));
        }

        /*for(Variable var: variables)
            System.out.println(var.getName());*/

        for(int i = 0; i < variables.size(); i++){
            System.out.println(variables.get(i).getName());
        }

        Constraint constraint;

        ArrayList<Variable> alldiff = new ArrayList<>(5);
        for(int i  = 0; i < 5; i++){
          //  System.out.println("var to constraint");
         //   System.out.println(variables.get(i).getName());
            alldiff.add(variables.get(i));
        }

        constraint = new AllDiffConstraint<>(alldiff, "all dif colors");
        constraints.add(constraint);


        alldiff.clear();
        for(int i  = 5; i <= 9; i++){
            //  System.out.println("var to constraint");
            //   System.out.println(variables.get(i).getName());
            alldiff.add(variables.get(i));
        }

        constraint = new AllDiffConstraint<>(alldiff, "all dif pets");
        constraints.add(constraint);


        alldiff.clear();
        for(int i  = 10; i <= 14; i++){
            //  System.out.println("var to constraint");
            //   System.out.println(variables.get(i).getName());
            alldiff.add(variables.get(i));
        }
        constraint = new AllDiffConstraint<>(alldiff, "all dif nationality");
        constraints.add(constraint);

        alldiff.clear();
        for(int i  = 15; i <= 19; i++){
            //  System.out.println("var to constraint");
            //   System.out.println(variables.get(i).getName());
            alldiff.add(variables.get(i));
        }
        constraint = new AllDiffConstraint<>(alldiff, "all dif beverage");
        constraints.add(constraint);

        alldiff.clear();
        for(int i  = 20; i <= 24; i++){
            //  System.out.println("var to constraint");
            //   System.out.println(variables.get(i).getName());
            alldiff.add(variables.get(i));
        }
        constraint = new AllDiffConstraint<>(alldiff, "all dif smoke brand");
        constraints.add(constraint);

        alldiff.clear();
        for(int i  = 25; i <= 29; i++){
            //  System.out.println("var to constraint");
            //   System.out.println(variables.get(i).getName());
            alldiff.add(variables.get(i));
        }
        constraint = new AllDiffConstraint<>(alldiff, "all dif location");
        constraints.add(constraint);

        /*for(Constraint c1: constraints){
            System.out.println("vars invovled");
            for(Variable var: c1.getScope()){
                System.out.print(var.getName());
            }
            System.out.println();
        }*/


        //english red
        int j = 10;
        for (int i = 1; i <= 5; i++ ){
            constraints.add(new BinaryConstraint<>(variables.get(i-1), variables.get(j),
                    variables.get(i-1).getDomain().get(1),variables.get(j).getDomain().get(1),
                    "English lives in red house"));
            j++;
        }

        //Spaniard dog
        j = 5;
        for(int i = 10; i <= 14; i++){
            constraints.add(new BinaryConstraint<>(variables.get(i), variables.get(j),
                    variables.get(i).getDomain().get(0), variables.get(j).getDomain().get(0),
                    "Spaniard owns the dog"
                    ));
            j++;
        }

        //Norwegian first
        j = 25;
        for(int i = 10; i <= 14; i++){
            constraints.add(new BinaryConstraint<>(variables.get(i), variables.get(j),
                    variables.get(i).getDomain().get(2), variables.get(j).getDomain().get(0),
                    "Norwegian leftmost house. "
            ));
            j++;
        }

        //Kools are smoked in the yellow house.
        j = 20;
        for(int i = 0; i <= 4; i++){
            constraints.add(new BinaryConstraint<>(variables.get(i), variables.get(j),
                    variables.get(i).getDomain().get(2), variables.get(j).getDomain().get(0),
                    "Kools smoked at yellow house. "
            ));
            j++;
        }
        //The Norwegian lives next to the blue house.
        j = 25;
        for(int i = 0; i <= 4; i++){
            constraints.add(new BinaryConstraint<>(variables.get(i), variables.get(j),
                    variables.get(i).getDomain().get(0), variables.get(j).getDomain().get(1),
                    "House 2: blue"
            ));
            j++;
        }

        //The Winston smoker owns snails.
        j = 5;
        for(int i = 20; i <= 24; i++){
            constraints.add(new BinaryConstraint<>(variables.get(i), variables.get(j),
                    variables.get(i).getDomain().get(2), variables.get(j).getDomain().get(2),
                    "Winston smoker owns snails"
            ));
            j++;
        }

        //The Lucky Strike smoker drinks orange juice.
        j = 15;
        for(int i = 20; i <= 24; i++){
            constraints.add(new BinaryConstraint<>(variables.get(i), variables.get(j),
                    variables.get(i).getDomain().get(3), variables.get(j).getDomain().get(1),
                    "Lucky Strike smoker drinks orange juice."
            ));
            j++;
        }

        //The Ukrainian drinks tea.
        j = 15;
        for(int i = 10; i <= 14; i++){
            constraints.add(new BinaryConstraint<>(variables.get(i), variables.get(j),
                    variables.get(i).getDomain().get(4), variables.get(j).getDomain().get(0),
                    "Ukrainian drinks tea."
            ));
            j++;
        }

        //The Japanese smokes Parliaments.
        j = 20;
        for(int i = 10; i <= 14; i++){
            constraints.add(new BinaryConstraint<>(variables.get(i), variables.get(j),
                    variables.get(i).getDomain().get(3), variables.get(j).getDomain().get(4),
                    "Japanese smokes Parliaments."
            ));
            j++;
        }

        //Coffee is drunk in the green house.
        j = 0;
        for(int i = 15; i <= 19; i++){
            constraints.add(new BinaryConstraint<>(variables.get(i), variables.get(j),
                    variables.get(i).getDomain().get(2), variables.get(j).getDomain().get(3),
                    "Coffee drunk at green house."
            ));
            j++;
        }

        //Milk is drunk in the middle house.
        j = 25;
        for(int i = 15; i <= 19; i++){
            constraints.add(new BinaryConstraint<>(variables.get(i), variables.get(j),
                    variables.get(i).getDomain().get(3), variables.get(j).getDomain().get(2),
                    "Milk is drunk in the middle house."
            ));
            j++;
        }



        //green must be on the right of the ivory house
        for(int i = 3; i <=4; i++){
            constraints.add(new NextHouseConstraint<>(
                    variables.get(i-1), variables.get(i),
                    variables.get(i-1).getDomain().get(4),
                    variables.get(i).getDomain().get(3),
                    "Green must be on the right of ivory"
            ));
        }


        //horse next to kools smoker
        j = 6;
        for(int i = 20; i <=23; i++){
            constraints.add(new NextHouseConstraint<>(
                    variables.get(i), variables.get(j),
                    variables.get(i).getDomain().get(0),
                    variables.get(j).getDomain().get(3),
                    "Horse is next to kools smoker"
            ));
            j++;
        }
        //Chesterfields smoker right to fox
        j = 21;
        for(int i = 5; i <=8; i++){
            constraints.add(new NextHouseConstraint<>(
                    variables.get(i), variables.get(j),
                    variables.get(i).getDomain().get(1),
                    variables.get(j).getDomain().get(1),
                    "Chesterfields smoker right to fox"
            ));
            j++;
        }

        /*---*/
        //Ukranian second
        j = 25;
        for(int i = 10; i <= 14; i++){
            constraints.add(new BinaryConstraint<>(variables.get(i), variables.get(j),
                    variables.get(i).getDomain().get(4), variables.get(j).getDomain().get(1),
                    "Ukranian 2nd house. "
            ));
            j++;
        }

        j = 5;
        for(int i = 10; i <= 14; i++){
            constraints.add(new BinaryConstraint<>(variables.get(i), variables.get(j),
                    variables.get(i).getDomain().get(4), variables.get(j).getDomain().get(3),
                    "Ukranian owns the horse"
            ));
            j++;
        }
         /*-------*/
        System.out.println(constraints.size());
        List<Constraint> relatedConstrains;

        for(Variable var: variables){
            relatedConstrains =  new ArrayList<>();
            for(Constraint c: constraints){
                if(c.getScope().contains(var))
                    relatedConstrains.add(c);
            }
            varConst.put(var, relatedConstrains);
        }

        //------- |clues: Constraints
    }
}
