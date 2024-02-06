
package DAO;

import Model.Amigos;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AmigosDAO {
    
    
    public static ArrayList<Amigos> minhaLista = new ArrayList<Amigos>();
    
    public AmigosDAO(){
        
    }
        
    public int maiorID() throws SQLException {
        int maiorID = 0;
        
        try {
        
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tb_amigos");
            res.next();
            maiorID = res.getInt("id");
            stmt.close();
        
        }catch (SQLException ex){
        }
        return maiorID;
    }
    
    public Connection getConexao() throws SQLException {
    
        Connection connection = null; //instância da conexão
        
        try {
        
            // Carregamento do JDBC Driver
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            
            //Configurar a conexão
            String server = "localhost"; // caminho do MySQL
            String database = "db_amigos";
            String url = "jdbc:mysql://" + server + ":3306/" + database + "?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String password = "rootpass";
            
            connection = DriverManager.getConnection(url, user, password); // Configuração de fato
            
            //Testando...
            if (connection != null) {
            
                System.out.println("Status: Conectado");
            } else {
            
                System.out.println("Status: Não Conectado");
            }
            
            return connection;
        
        } catch (ClassNotFoundException e){ //Driver não encontrado
            System.out.println("O driver não foi encontrado "+e.getMessage());
            return null;
        }
        
    }
    
    //Retorna a Lista de Alunos(objetos)
    public ArrayList getMinhaLista() {
        
        minhaLista.clear();
        
        try {
        
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_amigos");
            while (res.next()) {
            
                int id = res.getInt("id");
                String nome = res.getString("nome");
                int telefone = res.getInt("telefone");
                String sobrenome = res.getString("sobrenome");
                
                Amigos objeto = new Amigos(id, nome, telefone, sobrenome);
                
                minhaLista.add(objeto);
            }
            
            stmt.close();
            
        } catch (SQLException ex){
        
            throw new UnsupportedOperationException ("Not supported yet");

        }
        
        return minhaLista;
        
    }
    
    public boolean InsertAmigosBD(Amigos objeto) {
        String sql = "INSERT INTO tb_amigos(id,nome,telefone,sobrenome) VALUES(?,?,?,?,?)";
        
        try {
        
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);
            
            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setInt(3, objeto.getTelefone());
            stmt.setString(4, objeto.getDaoAmgs());
            
            stmt.execute();
            stmt.close();
            
            return true;
        
        } catch (SQLException erro){
            throw new RuntimeException(erro);
        }
    }
    
    // Deleta um aluno específico pelo seu campo ID
    public boolean DeleteAmigosBD(int id) {
        try {
        
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM tb_amigos WHERE id = " + id);
            stmt.close();
        
        } catch (SQLException erro) {
        }
        
        return true;
    }

    public boolean UpdateAmigosBD(Amigos objeto){
    
        String sql = "UPDATE tb_amigos set nome = ?, telefone = ?, sobrenome = ? WHERE id = ?";
        
        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);
            
            stmt.setString(1, objeto.getNome());
            stmt.setInt(2, objeto.getTelefone());
            stmt.setString(3, objeto.getDaoAmgs());
            stmt.setInt(4, objeto.getId());
            
            stmt.execute();
            stmt.close();
            
            return true;
        
        } catch (SQLException erro){
            
            throw new RuntimeException(erro);
        }
    
    }
    
    public Amigos carregaAmigos(int id){
        
        Amigos objeto = new Amigos();
        objeto.setId(id);
        
        try {
            
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_amigos WHERE id = " + id);
            res.next();
            
            objeto.setNome(res.getString("nome"));
            objeto.setTelefone(res.getInt("telefone"));
            objeto.setDaoAmgs(res.getString("sobrenome"));
            
            stmt.close();
        
        } catch (SQLException erro) {
        }
        
        return objeto;
    }

    public void getNome(){
    
        throw new UnsupportedOperationException ("Not supported yet");
    }
    
    public void getTelefone(){
    
        throw new UnsupportedOperationException ("Not supported yet");
    }
        
}
