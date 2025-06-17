package uniAlfa.hackathon;

import javax.swing.*;

import uniAlfa.hackathon.gui.EventoGui;
import uniAlfa.hackathon.service.EventoService;

/*
 * Classe principal para iniciar a aplicação.
 * Utiliza o Swing para criar a interface gráfica.
 */
// Autor: [Felipe Pestana]

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::executar);
    }

    /*
     * Método para inicializar a interface gráfica da aplicação.
     * Cria uma instância de EventoGui e a torna visível.
    */

    private static void executar() {
        var EventoGui = new EventoGui(new EventoService());
        EventoGui.setVisible(true);
    }
}

