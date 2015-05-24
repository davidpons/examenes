package ventana;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenu;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private PanelPrincipal panelPrincipal;
	private PanelDelincuentes panelDelincuentes;
	private PanelAntecedentes panelAntecedentes;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);				
							
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public VentanaPrincipal() {		
		setTitle("Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 392);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPrincipal = new JMenu("Principal");
		menuBar.add(mnPrincipal);
		
		JMenu mnDelincuentes = new JMenu("Delincuentes");
		menuBar.add(mnDelincuentes);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		panelDelincuentes=new PanelDelincuentes();
		contentPane.add(panelDelincuentes, "Delincuentes");
		
		panelPrincipal=new PanelPrincipal();
		contentPane.add(panelPrincipal, "Principal");
		

		
		panelAntecedentes=new PanelAntecedentes();
		contentPane.add(panelAntecedentes, "Delincuentes");		

	}
}
