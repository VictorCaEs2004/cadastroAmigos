
package Model;

import java.util.*;
import DAO.FerramentasDAO;
import java.sql.SQLException;

public class Ferramentas {
    
    private String ferramenta;
    private String marca;
    private double custo;
    private final FerramentasDAO dao;
    
        // Método Construtor de Objeto Vazio
    public Ferramentas() {
        this.dao = new FerramentasDAO(); // inicializado não importa em qual construtor
    }

 
    public Ferramentas(String ferramenta, String marca, double custo) {
        this.ferramenta = ferramenta;
        this.marca = marca;
        this.custo = custo;
        this.dao = new FerramentasDAO();
    }

    public String getFerramenta() {
        return ferramenta;
    }

    public String getMarca() {
        return marca;
    }

    public double getCusto() {
        return custo;
    }

    public void setFerramenta(String ferramenta) {
        this.ferramenta = ferramenta;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }
    
        public ArrayList getMinhaLista() {
        return dao.getMinhaLista();
        }
        
 
    private int maiorID(){
    
        throw new UnsupportedOperationException("Not supported");
    }
    
    public boolean InsertFerramentasBD(String ferramenta, String marca, double custo) throws SQLException{
    
        int id = this.maiorID() + 1;
        Ferramentas objeto = new Ferramentas(ferramenta, marca, custo);
        dao.InsertFerramentasBD(objeto);
        return true;
    
    }


    
    
    
}
