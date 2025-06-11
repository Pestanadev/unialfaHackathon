package unialfa.hackathon;

import unialfa.hackathon.gui.EventoGui;
import unialfa.hackathon.service.EventoService;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::executar);
    }

    private static void executar() {
        var EventoGui = new EventoGui(new EventoService());
        EventoGui.setVisible(true);
    }
}

