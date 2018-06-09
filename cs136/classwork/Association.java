import structure.*;

class Association {
    protected Object key;
    protected Object value;

    //pre: key != null
    public Association (Object K, Object V) {
	Assert.pre (K!=null, "Null key");
	key = K;
	Value = V;
    }

    public Object getKey() {return key;}
    public Object getValue() {return value;}
    public Object setValue(Object V) {
	Object old = value;
	value = v;
	return old;
    }
}
	
