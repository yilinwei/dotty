public record R1(String s, int i) {
    
    public R1(int i) {
	this(Integer.valueOf(i).toString(), i);
    }

    public R1 {
	s = s + "test";
    }

    @Override
    public int i() {
	return i + 10;
    }
}
