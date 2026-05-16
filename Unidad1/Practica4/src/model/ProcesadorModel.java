package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Libreria_generica.generic;

public class ProcesadorModel {

    private generic<String, String> dt_p;
    private procesadorDAO dao;

    public ProcesadorModel() {
        this.dt_p = new generic<>();
        this.dao = new procesadorDAO(this); 
    }
    public void guardarDatos(String texto) throws IOException {
        this.dt_p.setAttributeT1(texto); 
        this.dao.writeTexto();         
    }
    public String cargarDatosAlInicio() throws IOException {
        String textoArchivo = dao.readTexto();
        this.dt_p.setAttributeT1(textoArchivo); 
        return textoArchivo;
    }
    public List<String> buscarPalabrasConRegex(String expresionRegular) throws IOException {
        List<String> resultados = new ArrayList<>();
        this.dt_p.setAttributeT2(expresionRegular); 
        String textoAProcesar = this.dt_p.getAttributeT1();
        if (textoAProcesar == null || textoAProcesar.isEmpty()) {
            textoAProcesar = cargarDatosAlInicio();
        }
        Pattern patron = Pattern.compile(expresionRegular);
        Matcher buscador = patron.matcher(textoAProcesar);
        while (buscador.find()) {
            resultados.add(buscador.group());
        }
        this.dt_p.setAttributeS3(String.valueOf(resultados.size()));
        return resultados;
    }
    public String getTextoEnMemoria() {
        return dt_p.getAttributeT1();
    }
    public String getUltimoConteo() {
        return dt_p.getAttributeS3();
    }
}