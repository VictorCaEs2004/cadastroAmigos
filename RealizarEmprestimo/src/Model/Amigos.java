
package Model;

import java.util.*;
import DAO.AmigosDAO;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Amigos {
    
    private String nome;
    private int telefone;
    private String sobrenome;
    private int id; 
    private final AmigosDAO dao;
    
    public Amigos() {
        this.dao = new AmigosDAO();
    }
    
    public Amigos(int id, String nome, int telefone, String sobrenome) {
        
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.sobrenome = sobrenome;
        this.dao = new AmigosDAO();
    }

    

    public String getNome() {
        return nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDaoAmgs() {
        return sobrenome;
    }

    public void setDaoAmgs(String sobrenome) {
        this.sobrenome = sobrenome;
    }  
    
    @Override
    public String toString() {
        return "\n ID: " + this.getId()
                + "\n Nome: " + this.getNome()
                + "\n Sobrenome: " + this.getDaoAmgs()
                + "\n Telefone:" + this.getTelefone()
                + "\n ---------";
    }
    
    //retorna a lista de amigos(objetos)
    public ArrayList getMinhaLista() {
    
        //return AmigosDAO.getMinhaLista;
        return dao.getMinhaLista();
    }
    
    //cadastra novo aluno
    public boolean InsertAmigosBD(String nome, int telefone, String sobrenome) throws SQLException {
    
        int id = this.maiorID() + 1;
        Amigos objeto = new Amigos(id, nome, telefone, sobrenome);
        
        dao.InsertAmigosBD(objeto);
        
        return true;
    }
    
    //deleta um aluno específico pelo seu campo ID
    public boolean DeleteAmigosBD(int id){
        dao.DeleteAmigosBD(id);
        return true;
    }
    
    public boolean UpdateAmigosBD(int id, String nome, int telefone, String sobrenome) {
    
        Amigos objeto = new Amigos(id, nome, telefone, sobrenome);
        dao.UpdateAmigosBD(objeto);
        return true;
    }
    
    public Amigos carregaAmigos(int id) {
    
        dao.carregaAmigos(id);
        return null;

}
    
    //retorna maiorID da base de dados
    public int maiorID() throws SQLException {
        return dao.maiorID();
    }

}
