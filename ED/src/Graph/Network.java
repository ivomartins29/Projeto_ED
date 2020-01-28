package Graph;


import ed_t.Aposentos;
import java.util.Iterator;

public class Network<T> extends Graph<T> implements NetworkADT<T> {
    /**
     * Creates an empty Network.
     */
    public Network() {
       super();
    }
    
    public Network(int numVertices){
        super(numVertices);
    }

    @Override
    public void addEdge(T vertex1, T vertex2, double weight) {
        super.addEdge(vertex1,vertex2,weight);
    }

    @Override
    public double shortestPathWeight(T vertex1, T vertex2) {
        Iterator shortestPath = super.iteratorShortestPath(vertex1,vertex2);
        while (shortestPath.hasNext())
            System.out.println(shortestPath.next());
        return 0;
    }

}
