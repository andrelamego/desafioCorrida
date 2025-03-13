package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CloseController;
import controller.CorridaController;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfSegundo;
	private JTextField tfPrimeiro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.setBackground(new Color(216, 216, 216));
		btnFechar.setBounds(720, 427, 154, 23);
		contentPane.add(btnFechar);
		
		JButton btnIniciar = new JButton("Iniciar Corrida");
		btnIniciar.setBackground(new Color(216, 216, 216));
		btnIniciar.setBounds(10, 427, 700, 23);
		contentPane.add(btnIniciar);
		
		tfSegundo = new JTextField();
		tfSegundo.setEditable(false);
		tfSegundo.setBounds(720, 365, 154, 20);
		contentPane.add(tfSegundo);
		tfSegundo.setColumns(10);
		
		tfPrimeiro = new JTextField();
		tfPrimeiro.setEditable(false);
		tfPrimeiro.setBounds(720, 334, 154, 20);
		contentPane.add(tfPrimeiro);
		tfPrimeiro.setColumns(10);
		
		JLabel lblPrimeiro = new JLabel("Vencedor");
		lblPrimeiro.setBounds(650, 337, 60, 14);
		contentPane.add(lblPrimeiro);
		
		JLabel lblSegundo = new JLabel("Segundo Lugar");
		lblSegundo.setBounds(618, 368, 92, 14);
		contentPane.add(lblSegundo);
		
		JLabel Carro1 = new JLabel("");
		Carro1.setIcon(new ImageIcon(Tela.class.getResource("/view/carro1.png")));
		Carro1.setBounds(-12, 76, 179, 65);
		contentPane.add(Carro1);
		
		JLabel Carro2 = new JLabel("");
		Carro2.setIcon(new ImageIcon(Tela.class.getResource("/view/carro2.png")));
		Carro2.setBounds(-12, 168, 179, 65);
		contentPane.add(Carro2);
		
		JLabel linhaChegada = new JLabel("");
		linhaChegada.setIcon(new ImageIcon(Tela.class.getResource("/view/linha.png")));
		linhaChegada.setBounds(823, 76, 23, 157);
		contentPane.add(linhaChegada);
		
		JLabel lblContagem = new JLabel("");
		lblContagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblContagem.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblContagem.setBounds(10, 130, 864, 51);
		contentPane.add(lblContagem);
		
		validate();
		
		CloseController close = new CloseController(this);
		btnFechar.addActionListener(close);
		
		CorridaController corrida = new CorridaController(Carro1 , Carro2, btnIniciar, tfPrimeiro, tfSegundo, lblContagem);
		btnIniciar.addActionListener(corrida);
		
	}
}
