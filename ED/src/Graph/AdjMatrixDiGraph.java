/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import Interface.GraphADT;
import ed_t.Aposentos;

/**
 *
 * @author jogui
 * @param <T>
 */
public class AdjMatrixDiGraph<T> implements GraphADT<T> {

    protected int numberOfVertices;

    protected int numberOfEdges;

    protected int[][] adjMatrix;

    protected Aposentos<T>[] vertices;

    protected int v1Pos, v2Pos;

    public AdjMatrixDiGraph(Aposentos [] aposentos) {
        this.numberOfVertices = aposentos.length;
        this.numberOfEdges = 0;
        this.vertices = aposentos;
        this.adjMatrix = new int[aposentos.length][aposentos.length];
    }

    @Override
    public void addEdge(Aposentos<T> vertex1, Aposentos<T> vertex2) {
        v1Pos = getAposentosIndexFor(vertex1);
        v2Pos = getAposentosIndexFor(vertex2);

        if (v1Pos == -1 || v2Pos == -1) {
            throw new IllegalArgumentException("aposento not found");
        }
        
        

        if (this.adjMatrix[v1Pos][v2Pos] == 0) {
            this.adjMatrix[v1Pos][v2Pos] = 1;
            this.numberOfEdges++;
        } else {
            throw new IllegalArgumentException("duplicate edge " + vertex1 + " " + vertex2);
        }
    }
    
    public void imprimir(){
        for(int i = 0 ; i < vertices.length ; i++){
                for(int j = 0 ; j < vertices.length ; j++)
                    System.out.printf("["+adjMatrix[i][j]+"] ");
                System.out.printf("\n");
            }     
    }

    @Override
    public void removeEdge(Aposentos<T> vertex1, Aposentos<T> vertex2) {
        v1Pos = getAposentosIndexFor(vertex1);
        v2Pos = getAposentosIndexFor(vertex2);

        if (v1Pos == -1 || v2Pos == -1) {
            throw new IllegalArgumentException("aposento not found");
        }
        if (this.adjMatrix[v1Pos][v2Pos] == 1) {
            this.adjMatrix[v1Pos][v2Pos] = 0;
            this.adjMatrix[v2Pos][v1Pos] = 0;
            this.numberOfEdges--;
        } else {
            throw new IllegalArgumentException("edge not found");
        }
    }

    @Override
    public Aposentos[] getNeighbors(Aposentos<T> vertex) {
        v1Pos = getAposentosIndexFor(vertex);
        Aposentos[] aposento = new Aposentos[numberOfVertices];
        int j = 0;
        for (int i = 0; i < vertices.length; i++) {
            if (this.adjMatrix[v1Pos][i] == 1) {
                aposento[j] = vertices[i];
                j++;
            }
        }
        return aposento;
    }

    @Override
    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    @Override
    public int getNumberOfEdges() {
        return numberOfEdges;
    }

    public int getAposentosIndexFor(Aposentos<T> ap) {
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].equals(ap)) {
                return i;
            }
        }
        return -1;
    }

}
