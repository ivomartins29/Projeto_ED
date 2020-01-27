package Graph;

import Interface.WeightedGraph;
import ed_t.Aposentos;

public class WeightedAdjMatrixGraph<T> extends AdjMatrixDiGraph<T> implements WeightedGraph<T> {

    public float DEFAULT_WEIGHT = (float) 0.0;

    protected double[][] weights;

    public WeightedAdjMatrixGraph(Aposentos[] aposentos) {
        super(aposentos);
        weights = new double[super.vertices.length][super.vertices.length];
    }

    @Override
    public void addEdge(Aposentos<T> v1, double weight, Aposentos<T> v2) {

        if (weight < 0.0) {
            throw new IllegalArgumentException("Edge weight "
                    + " must be >= 0.0");
        }

        super.addEdge(v1, v2);

        this.setEdgeWeight(v1, weight, v2);
    }

    @Override
    public void setEdgeWeight(Aposentos<T> v1, double weight, Aposentos<T> v2) {
        if (weight < 0.0) {
            throw new IllegalArgumentException("Edge weight "
                    + "must be >= 0.0");
        }
        int v1Pos = super.getAposentosIndexFor(v1);
        int v2Pos = super.getAposentosIndexFor(v2);

        weights[v1Pos][v2Pos] = weight;
        // weights[v2Pos][v1Pos] = weight;
    }

    @Override
    public double getEdgeWeight(Aposentos<T> v1, Aposentos<T> v2) {
        int v1Pos = super.getAposentosIndexFor(v1);
        int v2Pos = super.getAposentosIndexFor(v2);

        return weights[v1Pos][v2Pos];
    }

    /**
     *
     * @param v1
     * @param v2
     */
    @Override
    public void addEdge(Aposentos<T> v1, Aposentos<T> v2) {
        this.addEdge(v1, DEFAULT_WEIGHT, v2);
    }

    public void imprimirPesos() {
        for (int i = 0; i < vertices.length; i++) {
            for (int j = 0; j < vertices.length; j++) {
                System.out.printf("[" + weights[i][j] + "] ");
            }
            System.out.printf("\n");
        }
    }
}
