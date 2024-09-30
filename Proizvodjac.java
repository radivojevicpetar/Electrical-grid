package dz2;

import java.awt.Color;
import java.util.Random;

public abstract class Proizvodjac extends Parcela implements Runnable {
	Thread thread;
	protected Baterija b;
	protected int vreme;
	protected boolean uspeh=false;
	protected boolean work;
	
	@Override
	public void run() {
		
		try {
		while (!Thread.interrupted()) {	
			synchronized (this.thread) {
				while(!work){
					thread.wait();
				}
			}
			Thread.sleep(vreme);
			this.setForeground(Color.WHITE);
			revalidate();
			proizvedi();
			Thread.sleep(300);
			if(uspeh) {
				this.setForeground(Color.RED);
				revalidate();
			};
		}
	} 
		catch (InterruptedException e) {}
			
	}

	public Proizvodjac(char c, Color col, int vreme,Baterija b) {
		super(c, col);
		this.b=b;
		this.vreme=vreme+new Random().nextInt(300);
		thread=new Thread(this);
	}
	
	public synchronized void go() {
		work = true;
		notify();
	}
	
	public synchronized void pause() {
		work = false;
	}

	abstract public void proizvedi();

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
