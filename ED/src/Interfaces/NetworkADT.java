/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Exception.ElementNotFoundException;

/**
 *
 * @author 8150121 e 8150133
 * @param <T> tipo genérico
 */
public interface NetworkADT<T extends Object> extends GraphADT<T> {

    /**
     * Inserts an edge between two vertices of this graph.
     *
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     * @param weight the weight
     */
    public void addEdge(T vertex1, T vertex2, double weight) throws ElementNotFoundException;

    /**
     * Returns the weight of the shortest path in this network.
     *
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     * @return the weight of the shortest path in this network
     */
    public double shortestPathWeight(T vertex1, T vertex2) throws ElementNotFoundException;
}
