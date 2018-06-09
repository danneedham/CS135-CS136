protected Vector defs;
public Dictionary() {
    defs = new Vector();
}

public void addWord(String word, String def) {
    defs.add(new Association(word, def));
}

// post: returns the definition of word, or "" if not found.
//public String lookup
