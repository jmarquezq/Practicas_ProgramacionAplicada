package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import model.ProcesadorModel;
import view.ProcesadorTxtView;

public class ProcesadorController {

    private ProcesadorTxtView vista;
    private ProcesadorModel modelo;

    public ProcesadorController(ProcesadorTxtView vista, ProcesadorModel modelo) {
        this.vista = vista;
        this.modelo = modelo;
        try {
            String textoRecuperado = modelo.cargarDatosAlInicio();
            this.vista.textArea.setText(textoRecuperado);
        } catch (IOException ex) {
            System.out.println("Iniciando aplicación sin archivo previo.");
        }
        this.vista.btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String contenido = vista.textArea.getText();
                    modelo.guardarDatos(contenido);
                    JOptionPane.showMessageDialog(vista, "Texto guardado con éxito");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(vista, "Error al escribir: " + ex.getMessage());
                }
            }
        });
        this.vista.btnAnalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String regex = vista.textExpresion.getText();
                    List<String> resultados = modelo.buscarPalabrasConRegex(regex);
                    vista.modeloLista.clear();
                    for (String palabra : resultados) {
                        vista.modeloLista.addElement(palabra);
                    }
                    vista.textPalabrasEncontradas.setText(modelo.getUltimoConteo());
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(vista, "Error al procesar la expresión regular");
                }
            }
        });
    }
}
