/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import ed_t.Aposentos;
/**
 *
 * @author jogui
 * @param <T>
 */
public abstract interface GraphADT<T> {

    public void addVertex(Aposentos<T> vertex);

    public void addEdge(Aposentos<T> vertex1, Aposentos<T> vertex2);

    public void removeVertex(Aposentos<T> vertex);

    public void removeEdge(Aposentos<T> vertex1, Aposentos<T> vertex2);

    public Aposentos[] getNeighbors(Aposentos<T> vertex);

    public int getNumberOfVertices();

    public int getNumberOfEdges();
}
