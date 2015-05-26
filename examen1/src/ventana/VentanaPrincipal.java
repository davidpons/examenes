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

import modelo.ConexionDB;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		mnPrincipal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Numero de Paneles: "+contentPane.getComponentCount());
				contentPane.remove(panelDelincuentes);
				contentPane.add(panelPrincipal, "Principal");
				setTitle("Principal");
				contentPane.validate();
			}
		});
		menuBar.add(mnPrincipal);
		
		JMenu mnDelincuentes = new JMenu("Delincuentes");
		mnDelincuentes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Numero de Paneles: "+contentPane.getComponentCount());
				contentPane.remove(panelPrincipal);
				contentPane.remove(panelAntecedentes);
				//contentPane.validate();
				contentPane.add(panelDelincuentes, "Delincuentes");
				setTitle("Delincuentes");
				contentPane.validate();
			}
		});
		menuBar.add(mnDelincuentes);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		String HOST="localhost";
		String BBDD="delincuentes";
		String USER="root";
		String PASS="";
		ConexionDB conBD = new ConexionDB(HOST, BBDD, USER, PASS);
		
		panelAntecedentes=new PanelAntecedentes();
		
		panelDelincuentes=new PanelDelincuentes(this, panelAntecedentes);
			
		panelPrincipal=new PanelPrincipal();
		contentPane.add(panelPrincipal, "Principal");
				

	}
}
