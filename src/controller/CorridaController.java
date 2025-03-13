package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CorridaController implements ActionListener {

	private JLabel carro1;
	private JLabel carro2;
	private JButton start;
	private JTextField primeiro;
	private JTextField segundo;
	private JLabel contagem;

	public CorridaController(JLabel carro1, JLabel carro2, JButton start, JTextField primeiro, JTextField segundo, JLabel contagem) {
		super();
		this.carro1 = carro1;
		this.carro2 = carro2;
		this.start = start;
		this.primeiro = primeiro;
		this.segundo = segundo;
		this.contagem = contagem;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {		
		final int distancia = 700;
		
		Podio p = new Podio(start, distancia, carro1, carro2, primeiro, segundo, contagem);
		p.start();
	}
}
