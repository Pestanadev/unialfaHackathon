package uniAlfa.hackathon.gui;

public interface GuiUtil {
// Método para montar as restrições de layout do GridBagLayout
    /**
     * Monta as restrições de layout do GridBagLayout.
     *
     * @param coluna a coluna onde o componente será posicionado
     * @param linha  a linha onde o componente será posicionado
     * @return um objeto GridBagConstraints configurado
     */
    default java.awt.GridBagConstraints montarGrid(int coluna, int linha) { 
        var constraints = new java.awt.GridBagConstraints();
        constraints.insets = new java.awt.Insets(5, 5, 5, 5);
        constraints.gridx = coluna;
        constraints.gridy = linha;
        return constraints;
    }
}
