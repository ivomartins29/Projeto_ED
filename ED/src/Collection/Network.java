/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Exceptions.EmptyException;
import Interfaces.NetworkADT;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 8150121 e 8150133
 * @param <T> tipo genérico
 */
public class Network<T> extends Graph<T> implements NetworkADT<T> {

    private double[][] adjMatrixWeight; //Matriz de Adjacência com o peso da ligação.

    double DEFAULT_WEIGHT = 0.0;

    /**
     * Construtor da Network
     */
    public Network() {
        super();
        this.adjMatrixWeight = new double[super.DEFAULT_SIZE][super.DEFAULT_SIZE];

        for (int i = 0; i < super.DEFAULT_SIZE; i++) {
            for (int u = 0; u < super.DEFAULT_SIZE; u++) {
                this.adjMatrixWeight[i][u] = 0.0;
            }
        }
    }

    /**
     * 
     * @param numVertices numero de vertices
     */
    public Network(int numVertices) {
        super(numVertices);

        this.adjMatrixWeight = new double[numVertices][numVertices];

        for (int i = 0; i < numVertices; i++) {
            for (int u = 0; u < numVertices; u++) {
                this.adjMatrixWeight[i][u] = Double.POSITIVE_INFINITY;
            }
        }
    }

    /**
     * Permite definir uma ligação entre dois vertices
     *
     * @param vertix1 1 Vértice que se pretende ligar
     * @param vertix2 2 Vértice que se pretende ligar
     * @param weight
     */
    @Override
    public void addEdge(T vertix1, T vertix2, double weight) throws ElementNotFoundException {
        int index1 = super.getVertexIndex(vertix1);
        int index2 = super.getVertexIndex(vertix2);

        super.addEdge(vertix1, vertix2);
        this.adjMatrixWeight[index1][index2] = weight;
    }

    /**
     * Permite remover uma ligação entre dois vertices
     *
     * @param vertix1 1 Vértice que se pretende ligar
     * @param vertix2 2 Vértice que se pretende ligar
     */
    @Override
    public void removeEdge(T vertix1, T vertix2) throws ElementNotFoundException {
        int index1 = super.getVertexIndex(vertix1);
        int index2 = super.getVertexIndex(vertix2);

        super.removeEdge(vertix1, vertix2);
        this.adjMatrixWeight[index1][index2] = 0.0;
    }

    /**
     *
     * Iterador que calcula o caminho mais curto em função do peso
     *
     * @param startVertex vértice de partida
     * @param targetVertex vértice de destino
     * @return iterador com o percurso mais curto em distancia e em peso entre 2 vertices
     */
    public Iterator iteratorShortestPathWeight(T startVertex, T targetVertex) throws EmptyCollectionException, EmptyException {
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
                pathWeight[i] = pathWeight[startIndex] + adjMatrixWeight[startIndex][i];
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
                    if ((adjMatrixWeight[index][i] < Double.POSITIVE_INFINITY) && (pathWeight[index] + adjMatrixWeight[index][i]) < pathWeight[i]) {
                        pathWeight[i] = pathWeight[index] + adjMatrixWeight[index][i];
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

    /**
     * 
     * @param visited array dos vertices visitados
     * @param pathWeight array com o peso do caminha
     * @param weight peso a procurar
     * @return a posição do vartice em que o pathWeight é igual a weight
     */
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
     * 
     * @param startVertex vértice inicial
     * @return um iterador com todos os vértices ordenados
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
                if ((adjMatrixWeight[x][i] < 1.0) && !visited[i]) {
                    traversalQueue.enqueue(i);
                    visited[i] = true;
                }
            }

        }
        return resultList.iterator();
    }

    /**
     * Peso do caminho mais curto (Peso de Ligação)
     *
     * @param startVertex vertice de partida
     * @param targetVertex vertice de chegada
     * @return tamanho do caminho mais curto tendo em conta o peso
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
            it = this.iteratorShortestPathWeight(startVertex, targetVertex);

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
            pathWeight += this.adjMatrixWeight[aux1][aux2];
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
                    adjMatrixWeight[i][j] = 0.0;
                }
            }
            for (int i = index; i < count; i++) {
                for (int j = 0; j < count; j++) {
                    adjMatrixWeight[j][i] = 0.0;
                }
            }
        } else {
            throw new ElementNotFoundException("Elemento não existe.");
        }

        super.removeVertex(t);
    }

    /**
     *
     * Método responsável por obter o peso duma matriz adjacente
     *
     * @param vertex1 vértice 1
     * @param vertex2 vértice 2
     * @return peso do vértice 1 ao vértice 2
     */
    public double getEdgeWeight(T vertex1, T vertex2) {
        int index1 = super.getVertexIndex(vertex1);
        int index2 = super.getVertexIndex(vertex2);
        return this.adjMatrixWeight[index1][index2];
    }

    /**
     *
     * Método responsável por estabelecer o peso duma matriz adjacente
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

        this.adjMatrixWeight[index1][index2] = newWeight;
    }

    /**
     * 
     * @return a matriz dos pesos
     */
    public double[][] getAdjMatrixConnectionCost() {
        return adjMatrixWeight;
    }

    /**
     * Este método mutiplica todos os valores da adjMatrixWeight pelo 
     * valor fornecido
     * 
     * @param multiplicador valor pelo qual os pesos serão multiplicados
     */
    public void multiplicar_adjmatrizweight(int multiplicador) {
        for (int i = 0; i < adjMatrixWeight.length; i++) {
            for (int j = 0; j < adjMatrixWeight.length; j++) {
                adjMatrixWeight[i][j] = adjMatrixWeight[i][j] * multiplicador;
            }
        }
    }

    /**
     * Imprime na consola a matriz Weight
     */
    public void imprimirMatrizWeight() {
        for (int i = 0; i < vertices.length; i++) {
            for (int j = 0; j < vertices.length; j++) {
                System.out.printf("[" + adjMatrixWeight[i][j] + "] ");
            }
            System.out.printf("\n");
        }
    }
}
