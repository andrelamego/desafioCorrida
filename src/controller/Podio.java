package controller;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Podio extends Thread{
	
	private JButton start;
	private int distancia;
	private JLabel carro1;
	private JLabel carro2;
	private JTextField primeiro;
	private JTextField segundo;
	private JLabel contagem;

	public Podio(JButton start, int distancia, JLabel carro1, JLabel carro2, JTextField primeiro, JTextField segundo, JLabel contagem) {
		super();
		this.start = start;
		this.distancia = distancia;
		this.carro1 = carro1;
		this.carro2 = carro2;
		this.primeiro = primeiro;
		this.segundo = segundo;
		this.contagem = contagem;
	}
	
	private void fazContagem() {
		int sec = 0;
		while(sec < 5) {
			switch (sec) {
			case 1:
				contagem.setText("3");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				contagem.setText("2");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				contagem.setText("1");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				contagem.setText("GO!");
				break;
			default:
				break;
			}
			
			sec++;
		}
	}
	
	private void defineVencedor(Carro carro1, Carro carro2) {
		if(carro1.getTempo() < carro2.getTempo()) {
			primeiro.setText(carro1.getNome());
			segundo.setText(carro2.getNome());
		}
		else {
			primeiro.setText(carro2.getNome());
			segundo.setText(carro1.getNome());
		}
	}

	public void run() {
		start.setEnabled(false);
		
		primeiro.setText(null);
		segundo.setText(null);
		
		carro1.setBounds(-12, carro1.getY(), carro1.getWidth(), carro1.getHeight());
		carro2.setBounds(-12, carro2.getY(), carro2.getWidth(), carro2.getHeight());
		
		fazContagem();		
		
		Carro threadCarro1 = new Carro(distancia, carro1, "Laranja");
		Carro threadCarro2 = new Carro(distancia, carro2, "Rosa");
		threadCarro1.start();
		threadCarro2.start();
		
		try {
			threadCarro1.join();
			threadCarro2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		defineVencedor(threadCarro1, threadCarro2);
		
		
		start.setEnabled(true);
	}

	
}
