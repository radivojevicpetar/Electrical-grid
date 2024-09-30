package dz2;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Energetski_sistem extends Frame {
	
	private Panel buttonPanel=new Panel();
	private Button dodajButton=new Button("Dodaj");
	private Plac plac;
	private Baterija b;
	
	public Energetski_sistem(int r,int c,int x) {
		setBounds(700, 200,500, 500);
		setResizable(false);
		plac=new Plac(r,c);
		b=new Baterija(x);
		b.isprazni();
		populateWindow();
		//pack();
		
		
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				plac.zaustaviRad();
				dispose();
			}
		});
		
		setVisible(true);
	}

	

	private void populateWindow() {
		buttonPanel.add(dodajButton);
		add(buttonPanel, BorderLayout.NORTH);
		add(plac,BorderLayout.CENTER);
		dodajButton.addActionListener((ae) -> {
			plac.dodajProizvodjaca(new Hidroelektrana(b) );
		});
	}



	public static void main(String[] args) {
		new Energetski_sistem(5,5,100);
	}

}
