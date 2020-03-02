package model;

import java.util.Vector;

public class TruffleField {
    public Vector<TruffleTree> truffleTrees = new Vector<>();

    public TruffleField() {
    }

    public void addTruffleOaks(TruffleTree truffleTree) {
        truffleTrees.add(truffleTree);
    }

    public Vector<TruffleTree> getTruffleTrees() {
        return truffleTrees;
    }

    public TruffleTree getTruffleOakWithId(int id) {
        return truffleTrees.get(id);
    }

    public String toString() {
        StringBuilder data = new StringBuilder();
        data.append("<TruffleOaks>\n");
        for (TruffleTree t: truffleTrees) {
            data.append(t.toString());
        }
        data.append("</TruffleOaks>\n");
        return data.toString();
    }
}
