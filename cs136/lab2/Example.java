class Example {
    public static int num;

    public Example(int initial) {
	    num = initial;
    }

    public int getNum() {
	num = num + 1;
	return num;
    }

    public static void main (String args[]) {
	Example first = new Example(10);
	Example second = new Example(20);
	System.out.println(first.getNum());
	System.out.println(second.getNum());
    }
}
	
