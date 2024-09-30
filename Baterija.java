package dz2;

public class Baterija {
	int energija;
	private int maks_kapacitet;
	
	
	public Baterija(int maks) {
		maks_kapacitet=maks;
		energija=maks;
	}
	
	
	public void dopuni(int dop) {
		if(energija < maks_kapacitet) {
			energija+=dop;
			if(energija>maks_kapacitet) energija=maks_kapacitet;
		}
	}
	
	public void isprazni() {
		energija=0;
	}
	public boolean proveri() {
		return (energija==maks_kapacitet);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
