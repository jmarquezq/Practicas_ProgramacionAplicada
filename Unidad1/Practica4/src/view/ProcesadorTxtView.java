package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.DefaultListModel; 
import javax.swing.JScrollPane;     

public class ProcesadorTxtView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel ProcesadorTxt;
	
	public JTextField textExpresion;
	public JTextField textPalabrasEncontradas;
	public JTextArea textArea;
	public JButton btnGuardar;
	public JButton btnAnalizar;
	
	public JList<String> listPalabras;
	public DefaultListModel<String> modeloLista;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProcesadorTxtView frame = new ProcesadorTxtView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ProcesadorTxtView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 483); 
		ProcesadorTxt = new JPanel();
		ProcesadorTxt.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ProcesadorTxt);
		ProcesadorTxt.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 400, 426);
		ProcesadorTxt.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Analisis de texto");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(0, 0, 120, 15);
		panel.add(lblNewLabel);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGuardar.setBounds(296, 179, 84, 20);
		panel.add(btnGuardar);
		
		textArea = new JTextArea();
		JScrollPane scrollArea = new JScrollPane(textArea); 
		scrollArea.setBounds(10, 25, 372, 143);
		panel.add(scrollArea);
		
		JLabel lblNewLabel_1 = new JLabel("Analisis de datos:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(5, 200, 115, 21);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("EXPRESION REGULAR:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 226, 130, 21);
		panel.add(lblNewLabel_2);
		
		textExpresion = new JTextField();
		textExpresion.setBounds(161, 228, 140, 20);
		panel.add(textExpresion);
		
		btnAnalizar = new JButton("...");
		btnAnalizar.setBounds(311, 227, 45, 20);
		btnAnalizar.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel.add(btnAnalizar);
		
		JLabel lblNewLabel_3 = new JLabel("Número de palabras encontradas:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(10, 258, 190, 21);
		panel.add(lblNewLabel_3);
		
		textPalabrasEncontradas = new JTextField();
		textPalabrasEncontradas.setEditable(false);
		textPalabrasEncontradas.setBounds(199, 258, 60, 18);
		panel.add(textPalabrasEncontradas);
		
		modeloLista = new DefaultListModel<>();
		JScrollPane scrollLista = new JScrollPane(); 
		scrollLista.setBounds(140, 306, 200, 110);
		panel.add(scrollLista);
		
		JLabel lblNewLabel_4 = new JLabel("Listado de palabras:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(10, 294, 120, 15);
		panel.add(lblNewLabel_4);
		listPalabras = new JList<>(modeloLista);
		listPalabras.setBounds(140, 308, 198, 108);
		panel.add(listPalabras);
		
		model.ProcesadorModel modelo = new model.ProcesadorModel();
		new controller.ProcesadorController(this, modelo);
	}
}
