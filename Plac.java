package dz2;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Plac extends Panel {
	private int rowNum;
	private int colNum;
	Parcela[][] parcele;
	public Plac(int r, int c) {
		this.setLayout(new GridLayout(r, c, 2, 2));
		rowNum=r;
		colNum=c;
		parcele=new Parcela[r][c];
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(Math.random()>0.7) {
					Vodena_povrs v=new Vodena_povrs();
					this.add(v);
					parcele[i][j]=v;
				}
				else {
					Travnata_povrs t=new Travnata_povrs();
					this.add(t);
					parcele[i][j]=t;
				}
			}
		}
		
		/*addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
            	if(!(e.getSource() instanceof Parcela)) return;
                Parcela parcela=(Parcela) e.getSource();
                parcela.uvecajTekst();
            }
        });*/
	}
	public void izaberiParcelu(Parcela p){
		p.setFont(new Font("Serif",Font.BOLD,20));
		p.izabrana=true;
	}
	public void zaustaviRad() {
		for(int i=0;i<rowNum;i++) {
			for(int j=0;j<colNum;j++) {
				if(parcele[i][j] instanceof Proizvodjac) {
					//synchronized ((Proizvodjac) parcele[i][j]) {
					//((Proizvodjac) parcele[i][j]).pause();
					//}
					if(((Proizvodjac) parcele[i][j]).thread!=null)
					((Proizvodjac) parcele[i][j]).thread.interrupt();
				}
				
			}
		}
	}
	
	public void dodajProizvodjaca(Proizvodjac p) {
		for(int i=0;i<rowNum;i++) {
			for(int j=0;j<colNum;j++) {
				if(parcele[i][j].izabrana==true) {
					if(p instanceof Hidroelektrana) {
						for(int k=i-1;k<=i+1;k++) {
							if(k<0||k>=rowNum) continue;
							for(int h=j-1;h<=j+1;h++) {
								if(h<0||h>=colNum) continue;
								if(parcele[i][j] instanceof Vodena_povrs) {
									if(parcele[k][h] instanceof Hidroelektrana) {
										((Hidroelektrana) parcele[k][h]).broj_povrsi-=1;
									}
								}
								if(parcele[k][h] instanceof Vodena_povrs) {
									if(k!=i||h!=j) {
									((Hidroelektrana) p).broj_povrsi+=1;
									}
								}
							}
						}
					}
					this.remove(i*rowNum+j);
					this.add(p,i*rowNum+j);
					this.parcele[i][j]=p;
					this.revalidate();
					
					p.thread.start();
					p.go();
			}
			}
		}	
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
