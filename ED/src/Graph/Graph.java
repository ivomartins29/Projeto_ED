package Graph;

import Interfaces.GraphADT;
import LinkedQueue.LinkedQueue;
import ArrayList.ArrayUnorderedList;
import java.util.Iterator;
import java.util.EmptyStackException;
import Exceptions.EmptyCollectionException;
import Exceptions.EmptyException;
import LinkedHeap.LinkedHeap;
import LinkedQueue.LinearNode;
import java.util.logging.Level;
import java.util.logging.Logger;
import linkedstack.LinkedStack;
import queues.Queue;

public class Graph<T> implements GraphADT<T> {

    protected final int DEFAULT_CAPACITY = 10;
    protected int numVertices; // number of vertices in the graph
    protected boolean[][] adjMatrix; // adjacency matrix
    protected double[][] adjMatrixWeights;
    protected T[] vertices; // values of vertices
    boolean found = false;
    int countPath = 0;
    boolean[] visited;

    /**
     * Creates an empty graph.
     */
    public Graph() {
        numVertices = 0;
        this.adjMatrix = new boolean[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
        this.adjMatrixWeights = new double[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
        this.vertices = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    public Graph(int numVertices) {
        this.numVertices = 0;
        this.adjMatrix = new boolean[numVertices][numVertices];
        this.adjMatrixWeights = new double[numVertices][numVertices];
        this.vertices = (T[]) (new Object[numVertices]);
    }

    /**
     * Inserts an edge between two vertices of the graph.
     *
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     */
    @Override
    public void addEdge(T vertex1, T vertex2) {
        addEdge(getIndex(vertex1), getIndex(vertex2));
    }

    /**
     * Inserts an weighed edge between two vertices of the graph.
     *
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     * @param weight weight of the connection
     */
    public void addEdge(T vertex1, T vertex2, double weight) {
        addEdgeWeight(getIndex(vertex1), getIndex(vertex2), weight);
    }

    /**
     * Returns the index of a vertex
     *
     * @param vertex1 the vertex
     */
    public int getIndex(T vertex1) {
        for (int i = 0; i < numVertices; i++) {
            if (vertex1.equals(vertices[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void removeEdge(T vertex1, T vertex2) {
        adjMatrix[getIndex(vertex1)][getIndex(vertex2)] = false;
        adjMatrix[getIndex(vertex2)][getIndex(vertex1)] = false;

    }

    @Override
    public Iterator iteratorBFS(T startIndex) {

        Integer x = null;
        int start = getIndex(startIndex);
        LinkedQueue<Integer> traversalQueue = new LinkedQueue<Integer>();
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<T>();
        if (!indexIsValid(start)) {
            return resultList.iterator();
        }
        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        traversalQueue.enqueue(new Integer(start));
        visited[start] = true;

        while (!traversalQueue.isEmpty()) {
            try {
                x = traversalQueue.dequeue();
            } catch (EmptyStackException e) {
                e.printStackTrace();
            }
            resultList.addToRear(vertices[x.intValue()]);
            for (int i = 0; i < numVertices; i++) {
                if (adjMatrix[x.intValue()][i] && !visited[i]) {
                    traversalQueue.enqueue(i);
                    visited[i] = true;
                }
            }
        }
        return resultList.iterator();
    }

    @Override
    public Iterator iteratorDFS(T startVertex) throws EmptyCollectionException {
        Integer x = null;
        boolean found;
        int startIndex = getIndex(startVertex);
        LinkedStack<Integer> traversalStack = new LinkedStack<>();
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<>();
        boolean[] visited = new boolean[numVertices];
        if (!indexIsValid(startIndex)) {
            return resultList.iterator();
        }
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        traversalStack.push(new LinearNode<Integer>(new Integer(startIndex)));
        resultList.addToRear(vertices[startIndex]);
        visited[startIndex] = true;
        while (!traversalStack.isEmpty()) {
            try {
                x = traversalStack.peek();
            } catch (Exceptions.EmptyStackException ex) {
                Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
            }
            found = false;

            for (int i = 0; (i < numVertices) && !found; i++) {
                if (adjMatrix[x.intValue()][i] && !visited[i]) {
                    traversalStack.push(new LinearNode<Integer>(new Integer(i)));
                    resultList.addToRear(vertices[i]);
                    visited[i] = true;
                    found = true;
                }
            }
            if (!found && !traversalStack.isEmpty()) {
                try {
                    traversalStack.pop();
                } catch (Exceptions.EmptyStackException ex) {
                    Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return resultList.iterator();

    }

    public Iterator<T> iteratorShortestPaths(T startVertex, T targetVertex) throws Exception {
        if (isEmpty()) {
            throw new Exception("empty");
        }
        return iteratorShortestPath(getIndex(startVertex), getIndex(targetVertex));
    }

    protected Iterator<T> iteratorShortestPath(int startIndex, int targetIndex)
            throws Exception {

        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<>();
        if (!indexIsValid(startIndex) || !indexIsValid(targetIndex)) {
            return resultList.iterator();
        }

        Iterator<Integer> it = (Iterator<Integer>) iteratorShortestPathIndices(startIndex, targetIndex);
        while (it.hasNext()) {
            Integer i = it.next();
            if (i != null) {
                resultList.addToRear(vertices[i]);
            }
        }
        return resultList.iterator();
    }

    protected Iterator<T> iteratorShortestPathIndex(int startIndex, int targetIndex) throws Exception {
        int index = startIndex;
        int[] pathLength = new int[numVertices];
        int[] predecessor = new int[numVertices];
        LinkedQueue<Integer> traversalQueue = new LinkedQueue<>();
        ArrayUnorderedList<Integer> resultList = new ArrayUnorderedList<>();
        if (!indexIsValid(startIndex) || !indexIsValid(targetIndex) || (startIndex == targetIndex)) {
            return resultList.iterator();
        }
        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }
        traversalQueue.enqueue(startIndex);
        visited[startIndex] = true;
        pathLength[startIndex] = 0;
        predecessor[startIndex] = -1;

        while (!traversalQueue.isEmpty() && (index != targetIndex)) {
            index = (traversalQueue.dequeue());
            for (int i = 0; i < numVertices; i++) {
                if (adjMatrix[index][i] && !visited[i]) {
                    pathLength[i] = index;
                    predecessor[i] = index;
                    traversalQueue.enqueue(i);
                    visited[i] = true;
                }
            }
        }

        if (index != targetIndex) {
            return resultList.iterator();
        }
        LinkedStack<Integer> stack = new LinkedStack<>();
        index = targetIndex;
        stack.push(new LinearNode<Integer>(new Integer(index)));
        while (index != startIndex) {
            index = predecessor[index];
            stack.push(new LinearNode<Integer>(new Integer(index)));
        }

        while (!stack.isEmpty()) {
            resultList.addToRear((stack.pop()));
        }
        return resultList.iterator();
    }

    public Iterator<Integer> iteratorShortestPathIndices(int startIndex, int targetIndex) throws EmptyException, EmptyCollectionException, Exceptions.EmptyStackException {
        int index;
        double weight;
        int[] predecessor = new int[numVertices];
        LinkedHeap<Double> traversalMinHeap = new LinkedHeap<>();
        ArrayUnorderedList<Integer> resultList = new ArrayUnorderedList<>();

        double[] pathWeight = new double[numVertices];
        for (int i = 0; i < numVertices; i++) {
            pathWeight[i] = Double.POSITIVE_INFINITY;
        }

        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        if (!indexIsValid(startIndex) || !indexIsValid(targetIndex) || (startIndex == targetIndex) || isEmpty()) {
            return resultList.iterator();
        }

        pathWeight[startIndex] = 0;
        predecessor[startIndex] = -1;
        visited[startIndex] = true;
        

        //atualiza o pathWeight de cada vertice
       for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                pathWeight[i] = pathWeight[startIndex] + adjMatrixWeights[startIndex][i];
                predecessor[i] = startIndex;
                traversalMinHeap.addElement(pathWeight[i]);
            }
        }

        do {
            weight = traversalMinHeap.removeMin();
            //traversalMinHeap.removeAllElements();
            if (weight == Double.POSITIVE_INFINITY) // sem caminho possivel
            {
                return resultList.iterator();
            } else {
                index = getIndexOfAdjVertexWithWeightOf(visited, pathWeight, weight);
                visited[index] = true;
            }

            //atualiza o pathWeight de cada vertice
            for (int i = 0; i < numVertices; i++) {
                if (adjMatrix[index][i] && !visited[i]) {
                    if ((adjMatrixWeights[index][i] < Double.POSITIVE_INFINITY) && (pathWeight[index] + adjMatrixWeights[index][i]) <= pathWeight[i]) {
                        pathWeight[i] = pathWeight[index] + adjMatrixWeights[index][i];
                        predecessor[i] = index;
                        System.out.println(index);
                        visited[i] = true;
                    }
                    traversalMinHeap.addElement(pathWeight[i]);
                }
            }
        } while (!traversalMinHeap.isEmpty() && !visited[targetIndex]);

        
        LinkedStack<Integer> stack = new LinkedStack<>();
        index = targetIndex;
        stack.push(new LinearNode<Integer>(new Integer(index)));
        while (index != startIndex) {
            index = predecessor[index];
            stack.push(new LinearNode<Integer>(new Integer(index)));
        }

        while (!stack.isEmpty()) {
            resultList.addToRear((stack.pop()));
        }
        return resultList.iterator();
    }

    private int getIndexOfAdjVertexWithWeightOf(boolean[] visited, double[] pathWeight, double weight) {
        for (int i = 0; i < numVertices; i++) {
            if ((pathWeight[i] == weight) && !visited[i]) {
                return i;
            }
        }
        System.out.println("erro");
        return -1;
    }

    @Override
    public Iterator iteratorShortestPath(T startVertex, T targetVertex) {
        ArrayUnorderedList<Object>[] findPaths = new ArrayUnorderedList[100000];
        for (int i = 0; i < findPaths.length; i++) {
            findPaths[i] = new ArrayUnorderedList<>();
        }
        visited = new boolean[numVertices];
        int count = 0;
        getAllPaths(getIndex(startVertex), getIndex(startVertex), getIndex(targetVertex), findPaths, count);
        int size = 0;
        for (int i = 0; i < countPath; i++) {
            if (findPaths[i].size() > size) {
                size = findPaths[i].size();
            }
        }
        int[][] pathsWeight = new int[countPath][size];
        double[] pathsSum = new double[countPath];
        double shortestPath = Double.MAX_VALUE;
        for (int i = 0; i < countPath; i++) {
            Queue<Object> path = new Queue();
            Iterator<Object> it = findPaths[i].iterator();
            int a = 0;
            while (it.hasNext()) {
                pathsWeight[i][a] = (int) it.next();
                a++;
            }
        }
        int storePath = 0;
        for (int x = 0; x < countPath; x++) {
            for (int y = 0; y < findPaths[x].size(); y++) {
                if (y + 1 != findPaths[x].size() && y + 1 != findPaths[x].size()) {
                    pathsSum[x] = pathsSum[x] + adjMatrixWeights[pathsWeight[x][y + 1]][pathsWeight[x][y]];
                }
            }
            if (pathsSum[x] < shortestPath) {
                shortestPath = pathsSum[x];
                storePath = x;
            }
        }
        //System.out.println("Shortest path connecting "+startVertex+" - "+targetVertex+": "+shortestPath);
        countPath = 0;
        return findPaths[storePath].iterator();
    }

    /**
     * Recursively gets all the possible paths connecting two vertex of the
     * graph;
     *
     * @param aux the index of the first startVertex
     * @param startVertex the index of the startVertex in each recursive cicle
     * @param targetVertex the index of the targetVertex
     * @param findPaths all the paths found
     * @param count number of the path
     */
    private void getAllPaths(int aux, int startVertex, int targetVertex, ArrayUnorderedList<Object>[] findPaths, int count) {
        if (startVertex == targetVertex) {
            found = true;
            findPaths[count].addToRear(startVertex);
            countPath++;
            visited[startVertex] = true;
        } else {
            visited[aux] = true;
            for (int i = 0; i < numVertices; i++) {
                if (adjMatrix[startVertex][i] && !visited[i]) {
                    if (startVertex == aux && found) {
                        found = false;
                        count++;
                        visited = new boolean[numVertices];
                        visited[aux] = true;
                    }
                    getAllPaths(aux, i, targetVertex, findPaths, count);
                }
            }
            if (startVertex != aux && found) {
                findPaths[count].addToRear(startVertex);
                visited[startVertex] = true;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        if (numVertices == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isConnected() {
        if (isEmpty()) {
            return false;
        }
        for (int i = 0; i < numVertices; i++) {
            for (int a = 0; a < numVertices; a++) {
                if (!adjMatrix[i][a]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int size() {
        return numVertices;
    }

    /**
     * Inserts an edge between two vertices of the graph.
     *
     * @param index1 the first index
     * @param index2 the second index
     */
    private void addEdge(int index1, int index2) {
        if (indexIsValid(index1) && indexIsValid(index2)) {
            adjMatrix[index1][index1] = true;
            adjMatrix[index2][index2] = true;
            adjMatrix[index1][index2] = true;
            adjMatrix[index2][index1] = true;
        }
    }

    /**
     * Inserts an weighed edge between two vertices of the graph.
     *
     * @param index1 the first index
     * @param index2 the second index
     * @param weight the weight of the edge
     */
    private void addEdgeWeight(int index1, int index2, double weight) {
        if (indexIsValid(index1) && indexIsValid(index2)) {
            adjMatrix[index1][index2] = true;
            adjMatrixWeights[index1][index2] = (weight);
        }

    }

    /**
     * Checks if the index is valid
     *
     * @param index index of the vertex
     * @return true if its valid, false if otherwise
     */
    private boolean indexIsValid(int index) {
        return (index >= 0) && (index < numVertices);
    }

    /**
     * Adds a vertex to the graph, expanding the capacity of the graph if
     * necessary. It also associates an object with the vertex.
     *
     * @param vertex the vertex to add to the graph
     */
    @Override
    public void addVertex(T vertex) {
        if (numVertices == vertices.length) {
            expandCapacity();
        }
        vertices[numVertices] = vertex;
        for (int i = 0; i <= numVertices; i++) {
            adjMatrix[numVertices][i] = false;
            adjMatrix[i][numVertices] = false;
        }
        numVertices++;
    }

    @Override
    public void removeVertex(T vertex) {

    }

    @SuppressWarnings("Unchecked")
    private void expandCapacity() {
        T[] array_copy = vertices;
        boolean[][] matrix_copy = adjMatrix;
        vertices = (T[]) new Object[vertices.length * 2];
        adjMatrix = new boolean[vertices.length * 2][vertices.length * 2];

        for (int i = 0; i < array_copy.length; i++) {
            vertices[i] = array_copy[i];
        }

        for (int i = 0; i < matrix_copy.length; i++) {
            for (int a = 0; i < matrix_copy.length; a++) {
                adjMatrix[i][a] = matrix_copy[i][a];
            }
        }
    }

    public int getNumVertices() {
        return numVertices;
    }

    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    public boolean[][] getAdjMatrix() {
        return adjMatrix;
    }

    public void setAdjMatrix(boolean[][] adjMatrix) {
        this.adjMatrix = adjMatrix;
    }

    public double[][] getAdjMatrixWeights() {
        return adjMatrixWeights;
    }

    public void setAdjMatrixWeights(double[][] adjMatrixWeights) {
        this.adjMatrixWeights = adjMatrixWeights;
    }

    public T[] getVertices() {
        return vertices;
    }

    public void setVertices(T[] vertices) {
        this.vertices = vertices;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public int getCountPath() {
        return countPath;
    }

    public void setCountPath(int countPath) {
        this.countPath = countPath;
    }

    public boolean[] getVisited() {
        return visited;
    }

    public void setVisited(boolean[] visited) {
        this.visited = visited;
    }

    public void imprimir() {
        for (int i = 0; i < vertices.length; i++) {
            for (int j = 0; j < vertices.length; j++) {
                System.out.printf("[" + adjMatrix[i][j] + "] ");
            }
            System.out.printf("\n");
        }
    }

    public void imprimirMatrizWeight() {
        for (int i = 0; i < vertices.length; i++) {
            for (int j = 0; j < vertices.length; j++) {
                System.out.printf("[" + adjMatrixWeights[i][j] + "] ");
            }
            System.out.printf("\n");
        }
    }

    public void multiplicar_adjmatrizweight(int multiplicador) {
        for (int i = 0; i < adjMatrixWeights.length; i++) {
            for (int j = 0; j < adjMatrixWeights.length; j++) {
                adjMatrixWeights[i][j] = adjMatrixWeights[i][j] * multiplicador;
            }
        }
    }

    public ArrayUnorderedList<T> getNeightbors(T vertex) {
        int pos = getIndex(vertex);
        int array_tam = num_Neighbors(pos);
        ArrayUnorderedList<T> array = new ArrayUnorderedList<>(array_tam);
        int count = 0;

        for (int i = 0; i < numVertices; i++) {
            if (adjMatrix[pos][i]) {
                array.addToFront(vertices[i]);
                count++;
            }
        }
        return array;
    }

    public int num_Neighbors(int pos) {
        int count = 0;
        for (int i = 0; i < numVertices; i++) {
            if (adjMatrix[pos][i] == true) {
                count++;
            }
        }
        return count;
    }
}
