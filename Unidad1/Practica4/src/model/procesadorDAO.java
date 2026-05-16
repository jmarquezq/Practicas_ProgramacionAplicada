package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class procesadorDAO {
    private final String RUTA_ARCHIVO = "src/doc/archivo.txt";
    private ProcesadorModel pm;
    public procesadorDAO() {
    }
    public procesadorDAO(ProcesadorModel pm_) {
        this.pm = pm_;
    }
    public boolean writeTexto() throws IOException {
        File archivo = new File(RUTA_ARCHIVO);
        File carpeta = archivo.getParentFile();
        if (carpeta != null && !carpeta.exists()) {
            carpeta.mkdirs();
        }
        FileWriter out = new FileWriter(RUTA_ARCHIVO, false);
        out.write(pm.getTextoEnMemoria() + "\n"); 
        out.close();
        return true;
    }
    public String readTexto() throws IOException {
        File archivo = new File(RUTA_ARCHIVO);
        if (!archivo.exists()) {
            return "";
        }

        StringBuilder contenido = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        }
        return contenido.toString().trim(); 
    }
}