package dz2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Parcela extends Label {
	boolean izabrana=false;
	
	public Parcela(char c,Color col) {
		super(Character.toString(c));
		this.setForeground(Color.WHITE);
		this.setFont(new Font("Serif",Font.BOLD,14));
		this.setBackground(col);
		this.setAlignment(Label.CENTER);
		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				Plac plac=(Plac) getParent();
				for(int i=0;i<plac.parcele.length;i++) {
					for(int j=0;j<plac.parcele[0].length;j++) {
						if(plac.parcele[i][j].izabrana==true) {
							plac.parcele[i][j].izabrana=false;
							plac.parcele[i][j].setFont(new Font("Serif",Font.BOLD,14));
						}
					}
				}
				plac.izaberiParcelu((Parcela) e.getSource());
				
			}

		});
		
	}

	
	public void promeniPozadinu(Color col) {
		this.setBackground(col);
	}
	
	
	


	public static void main(String[] args) {
		Parcela p = new Parcela('"' ,Color.RED);
		p.setBackground(Color.RED);
		System.out.println();

	}

}
