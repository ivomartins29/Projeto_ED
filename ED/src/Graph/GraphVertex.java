package Graph;

public class GraphVertex<T> {
    private T element;
    private float weight;

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
