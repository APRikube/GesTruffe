package model;

import java.util.Vector;

public class TruffleField {
    public Vector<TruffleOak> truffleOaks = new Vector<>();

    public TruffleField() {
    }

    public void addTruffleOaks(TruffleOak truffleOak) {
        truffleOaks.add(truffleOak);
    }

    public Vector<TruffleOak> getTruffleOaks() {
        return truffleOaks;
    }

    public TruffleOak getTruffleOakWithId(int id) {
        return truffleOaks.get(id);
    }

    public String toString() {
        StringBuilder data = new StringBuilder();
        data.append("<TruffleOaks>\n");
        for (TruffleOak t:truffleOaks) {
            data.append(t.toString());
        }
        data.append("</TruffleOaks>\n");
        return data.toString();
    }
}
