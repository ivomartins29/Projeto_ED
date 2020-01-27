package Interface;

import ed_t.Aposentos;

public interface BFSSearcherADT {

    public boolean containsPath(Aposentos v1, Aposentos v2);

    public long getPathLenght(Aposentos v1, Aposentos v2);

    public Aposentos[] getPath(Aposentos v1, Aposentos v2);
}
