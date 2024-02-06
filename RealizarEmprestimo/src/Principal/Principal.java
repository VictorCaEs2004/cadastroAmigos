
package Principal;

import View.TelaPrincipal;
import Model.Amigos;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Principal {

    
    public static void main(String[] args) {
        
        TelaPrincipal objetotela = new TelaPrincipal();
        objetotela.setVisible(true);
        
        
    }

    public boolean InsertAmigosBD(String nome, String telefone, String sobrenome) throws SQLException {
        
    if (sobrenome.equals(nome)){
        String n = JOptionPane.showInputDialog("Insira seu apelido"
                + " ou apenas o primeiro nome");      
        JOptionPane.showMessageDialog(null, n);
    }else{
        int n = 0;
        JOptionPane.showMessageDialog(null, "Registrado.");
        n++;
            
        }
        return true;
    }
}
