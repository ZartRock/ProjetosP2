
public class exemplo {
	private int num;
	
	
	public exemplo(int num){
		if (num < 0) {
			throw new IndexOutOfBoundsException("valor negativo");
		}
	}
}
