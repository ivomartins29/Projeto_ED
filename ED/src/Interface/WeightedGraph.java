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
public interface WeightedGraph<T> extends GraphADT<T> {

    public void addEdge(Aposentos<T> v1, double weight, Aposentos<T> v2);

    public void setEdgeWeight(Aposentos<T> v1, double weight, Aposentos<T> v2);

    public double getEdgeWeight(Aposentos<T> v1, Aposentos<T> v2);

}
