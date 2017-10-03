import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Node initAssignment = new Node();
        //Node n = new Node(initAssignment);
        //n.variables.set(0,'P');
        //HashSet<Node> nodes = new HashSet<>();
        //nodes.add(initAssignment);

        //System.out.println(nodes.contains(n));
        //System.out.println(initAssignment.equals(n));
        //System.out.println(initAssignment.toString());
        Searcher searcher = new Searcher();
        initAssignment = searcher.theAStar(initAssignment);
        //System.out.println(initAssignment.toString());
        if(initAssignment == null)
            System.out.println("No se encontro respuesta");
        else
            System.out.println(initAssignment.toString());
    }
}
