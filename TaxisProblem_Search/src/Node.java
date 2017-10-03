import java.util.ArrayList;
import java.util.List;

public class Node implements Comparable<Node> {

    List<Character> variables;
    //each slot represents a taxi
    Variable var; //just stores information about costs

    public Node(){
      /*  variables = new char[4];
        for(int i = 0; i < 4; i++)
            variables[i] = 'X';
        costSoFar = 0;*/
      variables = new ArrayList<>(4);
      for(int i = 0; i < 4; i++)
          variables.add('X');
      var = new Variable();
    }

    public Node(Node n){
        variables = new ArrayList<>(4);
        for(int i = 0; i < n.variables.size(); i++)
            variables.add(n.variables.get(i));
    }

    @Override
    public int compareTo(Node n) {
        if(this.f() > n.f())
            return 1;
        else if(this.f() < n.f())
            return -1;
        else
            return 0;
    }

    public int f(){
        return real()+h();
    }

    public int h(){
        int qz = 0;
        /*for(int i = 0; i < variables.length; i++)
            if(variables[i] != 'X')
                qz++;*/
        for(int i = 0; i < variables.size(); i++)
            if(variables.get(i) != 'X')
                qz++;

        return qz*-1;
    }

    public int real(){
        int realCost = 0;
        /*for(int i = 0; i < variables.length; i++){
            if(variables[i] != 'X'){
                realCost += Variable.values.get((i+1)).get(variables[i]);
            }
        }*/

        for(int i = 0; i < variables.size(); i++){
            if(variables.get(i) != 'X'){
                //System.out.println(variables.get(i));
                //System.out.println(Variable.values.get(i));
                realCost += Variable.values.get((i)).get(variables.get(i));
            }

        }

        return realCost;
    }

    public boolean isOk(){
        for(int i = 0; i < 4; i++)
            if(variables.get(i) == 'X')
                return false;

        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for(int i = 0; i < variables.size(); i++){
            builder.append(variables.get(i));
            if(i != 3)
                builder.append(", ");
            else
                builder.append("}");
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() == Node.class){
            Node n = (Node) obj;
            for(int i = 0; i < 4; i++)
                if(n.variables.get(i) != this.variables.get(i))
                    return false;
            return true;
        }
        else
            return false;
    }
}
