package dz2;

import java.awt.Color;

public class Hidroelektrana extends Proizvodjac {
	int broj_povrsi;
	public Hidroelektrana( Baterija b) {
		super('H', Color.BLUE, 1500, b);
		broj_povrsi=0;

	}

	@Override
	public synchronized void  proizvedi() {
		if(broj_povrsi>0) {
			b.dopuni(broj_povrsi);
			uspeh=true;
		}
		if(broj_povrsi==0) {
			uspeh=false;
		}
		System.out.println(this.b.energija);
	}
	
	public void postavi_broj_povrsi(int x){
		broj_povrsi=x;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
