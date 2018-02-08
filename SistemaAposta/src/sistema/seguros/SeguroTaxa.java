package sistema.seguros;

public class SeguroTaxa extends Seguro{
	private double taxa;
	
	public SeguroTaxa(double taxa) {
		super();
		if (taxa <= 0) {
			throw new IllegalArgumentException("Taxa não pode ser negativa ou nula");
		}
		this.taxa = taxa;
	}

	public double getTaxa() {
		return taxa;
	}
	
	@Override
	public String toString(){
	
		return String.format("%.0f%%", this.taxa * 100);
	}
	
}
