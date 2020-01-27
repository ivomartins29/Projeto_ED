package ed_t;

import Graph.WeightedAdjMatrixGraph;
import Interface.BFSSearcherADT;

public class BFSSearcher<T> implements BFSSearcherADT {

    private WeightedAdjMatrixGraph<T> matrix;

    public BFSSearcher(WeightedAdjMatrixGraph<T> matrix) {
        this.matrix = matrix;
    }

    @Override
    public boolean containsPath(Aposentos v1, Aposentos v2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long getPathLenght(Aposentos v1, Aposentos v2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Aposentos[] getPath(Aposentos v1, Aposentos v2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
