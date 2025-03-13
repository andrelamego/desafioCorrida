package controller;

import javax.swing.JLabel;

public class Carro extends Thread {

	private int distancia;
	private JLabel carro;
	private String nome;
	
	private long tempo = 0;
	
	public Carro(int distancia, JLabel carro, String nome) {
		super();
		this.distancia = distancia;
		this.carro = carro;
		this.nome = nome;
	}

	private void iniciarCorrida() {
		int aceleracao = 0;
		int distPercorrida = 0;
		
		while(distPercorrida < distancia) {
			aceleracao = (int) (Math.random() * 6);
			

			if((distPercorrida + aceleracao) < distancia) {
				distPercorrida += aceleracao;
				
				carro.setBounds(-12 + distPercorrida, carro.getY(), carro.getWidth(), carro.getHeight());
			}
			else {
				distPercorrida += (distancia - distPercorrida);
				
				carro.setBounds(-12 + distPercorrida, carro.getY(), carro.getWidth(), carro.getHeight());
			}
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		tempo = System.currentTimeMillis();
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public long getTempo() {
		return tempo;
	}
	
	@Override
	public void run() {
		iniciarCorrida();
	}
}
