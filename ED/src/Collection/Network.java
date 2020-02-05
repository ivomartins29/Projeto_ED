/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

import Exception.ElementNotFoundException;
import Exception.EmptyCollectionException;
import Exception.EmptyException;
import Interface.NetworkADT;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 8150121 e 8150133
 * @param <T>
 */
public class Network<T> extends Graph<T> implements NetworkADT<T> {

    private double[][] adjMatrixConnectionCost; //Matriz de Adjacência com o custo da ligação.

    double DEFAULT_WEIGHT = 0.0;

    /**
     * Construtor da Network
     */
    public Network() {
        super();
        this.adjMatrixConnectionCost = new double[super.DEFAULT_SIZE][super.DEFAULT_SIZE];

        for (int i = 0; i < super.DEFAULT_SIZE; i++) {
            for (int u = 0; u < super.DEFAULT_SIZE; u++) {
                this.adjMatrixConnectionCost[i][u] = 0.0;
            }
        }
    }

    public Network(int numVertices) {
        super(numVertices);

        this.adjMatrixConnectionCost = new double[numVertices][numVertices];

        for (int i = 0; i < numVertices; i++) {
            for (int u = 0; u < numVertices; u++) {
                this.adjMatrixConnectionCost[i][u] = Double.POSITIVE_INFINITY;
            }
        }
    }

    /**
     * Permite definir uma ligação entre dois vertices
     *
     * @param vertix1 1 Vértice que se pretende ligar
     * @param vertix2 2 Vértice que se pretende ligar
     * @param weight
     * @throws ElementNotFoundException
     */
    @Override
    public void addEdge(T vertix1, T vertix2, double weight) throws ElementNotFoundException {
        int index1 = super.getVertexIndex(vertix1);
        int index2 = super.getVertexIndex(vertix2);

        super.addEdge(vertix1, vertix2);
        this.adjMatrixConnectionCost[index1][index2] = weight;
    }

    /**
     * Permite remover uma ligação entre dois vertices
     *
     * @param vertix1 1 Vértice que se pretende ligar
     * @param vertix2 2 Vértice que se pretende ligar
     * @throws ElementNotFoundException
     */
    @Override
    public void removeEdge(T vertix1, T vertix2) throws ElementNotFoundException {
        int index1 = super.getVertexIndex(vertix1);
        int index2 = super.getVertexIndex(vertix2);

        super.removeEdge(vertix1, vertix2);
        this.adjMatrixConnectionCost[index1][index2] = 0.0;
    }

    /**
     *
     * Iterador que calcula o caminho mais curto em função do custo de ligação
     *
     * @param startVertex vértice de partida
     * @param targetVertex vértice de destino
     * @return iterador com o percurso mais curto em distancia entre 2 vertices
     */
    public Iterator iteratorShortestPathConnectionCost(T startVertex, T targetVertex) throws EmptyCollectionException, EmptyException {
        int startIndex = getVertexIndex(startVertex);
        int targetIndex = getVertexIndex(targetVertex);
        int index;
        double weight;
        int[] predecessor = new int[super.count];
        LinkedHeap<Double> traversalMinHeap = new LinkedHeap<>();
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<>();
        LinkedStack<Integer> stack = new LinkedStack<>();

        double[] pathWeight = new double[super.count];
        for (int i = 0; i < super.count; i++) {
            pathWeight[i] = Double.POSITIVE_INFINITY;
        }

        boolean[] visited = new boolean[super.count];
        for (int i = 0; i < super.count; i++) {
            visited[i] = false;
        }

        if (!indexIsValid(startIndex) || !indexIsValid(targetIndex) || (startIndex == targetIndex) || isEmpty()) {
            return resultList.iterator();
        }

        pathWeight[startIndex] = 0;
        predecessor[startIndex] = -1;
        visited[startIndex] = true;

        //atualiza o pathWeight de cada vertice
        for (int i = 0; i < super.count; i++) {
            if (!visited[i]) {
                pathWeight[i] = pathWeight[startIndex] + adjMatrixConnectionCost[startIndex][i];
                predecessor[i] = startIndex;
                traversalMinHeap.addElement(pathWeight[i]);
            }
        }

        do {
            weight = traversalMinHeap.removeMin();
            traversalMinHeap.removeAllElements();
            if (weight == Double.POSITIVE_INFINITY) // sem caminho possivel
            {
                return resultList.iterator();
            } else {
                index = getIndexOfAdjVertexWithWeightOf(visited, pathWeight, weight);
                visited[index] = true;
            }

            //atualiza o pathWeight de cada vertice
            for (int i = 0; i < super.count; i++) {
                if (!visited[i]) {
                    if ((adjMatrixConnectionCost[index][i] < Double.POSITIVE_INFINITY) && (pathWeight[index] + adjMatrixConnectionCost[index][i]) < pathWeight[i]) {
                        pathWeight[i] = pathWeight[index] + adjMatrixConnectionCost[index][i];
                        predecessor[i] = index;
                    }
                    traversalMinHeap.addElement(pathWeight[i]);
                }
            }
        } while (!traversalMinHeap.isEmpty() && !visited[targetIndex]);

        index = targetIndex;
        stack.push(index);
        do {
            index = predecessor[index];
            stack.push(index);
        } while (index != startIndex);

        while (!stack.isEmpty()) {
            resultList.addToRear(vertices[(stack.pop())]);
        }
        return resultList.iterator();
    }

    
    private int getIndexOfAdjVertexWithWeightOf(boolean[] visited, double[] pathWeight, double weight) {
        for (int i = 0; i < super.count; i++) {
            if ((pathWeight[i] == weight) && !visited[i]) {
                return i;

            }
        }
        System.out.println("erro");
        return -1;
    }

    /**
     * Iterador que pesquisa em largura todos os vértices, começando no
     * startVertex Retorna um iterador com todos os vértices ordenados
     */
    @Override
    public Iterator iteratorBFS(T startVertex) {
        Integer x = -1;
        LinkedQueue<Integer> traversalQueue = new LinkedQueue<>();
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<>();
        int startIndex = super.getVertexIndex(startVertex);
        if (!indexIsValid(startIndex)) {
            return resultList.iterator();
        }

        boolean[] visited = new boolean[super.count];
        for (int i = 0; i < super.count; i++) {
            visited[i] = false;
        }

        traversalQueue.enqueue(startIndex);
        visited[startIndex] = true;

        while (!traversalQueue.isEmpty()) {
            try {
                x = traversalQueue.dequeue();
            } catch (EmptyCollectionException ex) {
            }

            resultList.addToRear(vertices[x]);

            for (int i = 0; i < super.count; i++) {
                if ((adjMatrixConnectionCost[x][i] < 1.0) && !visited[i]) {
                    traversalQueue.enqueue(i);
                    visited[i] = true;
                }
            }

        }
        return resultList.iterator();
    }

    /**
     * Peso do caminho mais curto (Custo de Ligação)
     *
     * @param startVertex vertice de partida
     * @param targetVertex vertice de chegada
     * @return
     * @throws ElementNotFoundException caso algum dos elementos não seja
     * encontrado
     */
    @Override
    public double shortestPathWeight(T startVertex, T targetVertex) throws ElementNotFoundException {
        double pathWeight = 0.00f;
        int startIndex = this.getVertexIndex(startVertex);
        int targetIndex = this.getVertexIndex(targetVertex);
        int aux1;
        int aux2;

        if (!indexIsValid(startIndex) || !indexIsValid(targetIndex)) {
            return 0.0;
        }

        Iterator it = null;

        try {
            it = this.iteratorShortestPathConnectionCost(startVertex, targetVertex);

        } catch (EmptyCollectionException ex) {
            Logger.getLogger(Network.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (EmptyException ex) {
            Logger.getLogger(Network.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        if (it.hasNext()) {
            T temp = (T) it.next();
            aux1 = this.getVertexIndex(temp);
        } else {
            return 0.0;
        }

        while (it.hasNext()) {
            T temp = (T) it.next();
            aux2 = this.getVertexIndex(temp);
            pathWeight += this.adjMatrixConnectionCost[aux1][aux2];
            aux1 = aux2;
        }
        return pathWeight;
    }

    /**
     *
     * Método responsável pela adição de um vértice
     *
     * @param t vértice a ser adicionado
     */
    @Override
    public void addVertex(T t) {
        super.addVertex(t);
    }

    /**
     * Método responsável pela remoção de um vértice
     *
     * @param t vértice a ser removido
     */
    @Override
    public void removeVertex(T t) throws ElementNotFoundException {
        int index = this.getVertexIndex(t);

        if (this.indexIsValid(index)) {

            for (int i = index; i < count; i++) {
                for (int j = 0; j <= count; j++) {
                    adjMatrixConnectionCost[i][j] = 0.0;
                }
            }
            for (int i = index; i < count; i++) {
                for (int j = 0; j < count; j++) {
                    adjMatrixConnectionCost[j][i] = 0.0;
                }
            }
        } else {
            throw new ElementNotFoundException("Elemento não existe.");
        }

        super.removeVertex(t);
    }

    /**
     *
     * Método responsável por obter o custo duma matriz adjacente
     *
     * @param vertex1 vértice 1
     * @param vertex2 vértice 2
     * @return peso do vértice 1 ao vértice 2
     */
    public double getEdgeWeight(T vertex1, T vertex2) {
        int index1 = super.getVertexIndex(vertex1);
        int index2 = super.getVertexIndex(vertex2);
        return this.adjMatrixConnectionCost[index1][index2];
    }

    /**
     *
     * Método responsável por estabelecer o custo duma matriz adjacente
     *
     * @param vertex1 vértice 1
     * @param vertex2 vértice 2
     * @param newWeight custo do vértice 1 ao vértice 2
     */
    public void setEdgeWeight(T vertex1, T vertex2, double newWeight) {
        int index1 = super.getVertexIndex(vertex1);
        int index2 = super.getVertexIndex(vertex2);

        if (newWeight <= 0) {
            throw new IllegalArgumentException("newWeight tem que ser > 0");
        }

        this.adjMatrixConnectionCost[index1][index2] = newWeight;
    }

    public double[][] getAdjMatrixConnectionCost() {
        return adjMatrixConnectionCost;
    }

    public void multiplicar_adjmatrizweight(int multiplicador) {
        for (int i = 0; i < adjMatrixConnectionCost.length; i++) {
            for (int j = 0; j < adjMatrixConnectionCost.length; j++) {
                adjMatrixConnectionCost[i][j] = adjMatrixConnectionCost[i][j] * multiplicador;
            }
        }
    }

    public void imprimirMatrizWeight() {
        for (int i = 0; i < vertices.length; i++) {
            for (int j = 0; j < vertices.length; j++) {
                System.out.printf("[" + adjMatrixConnectionCost[i][j] + "] ");
            }
            System.out.printf("\n");
        }
    }

}
