package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.ConnectionFactory;
import model.Contato;

public class ContatoDao {

  private final Connection connection;
  public ContatoDao(){
    this.connection = new ConnectionFactory().getConnection();
  }
  
  public void adiciona(Contato contato){
    String sql =  "insert into contatos\n";
           sql += "(nome, email, endereco, dataNascimento)\n";
           sql += "values\n";
           sql += "(?,?,?,?)";
    try{
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.setString(1, contato.getNome());
      stmt.setString(2, contato.getEmail());
      stmt.setString(3, contato.getEndereco());
      stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
      stmt.execute();
      stmt.close();
    }catch(SQLException e){
      throw new RuntimeException(e);
    }
  }
  
  public void altera(Contato contato){
    String sql = "update contatos set nome = ?, email = ?, endereco = ?, dataNascimento = ? where id = ?";
    try{
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.setString(1, contato.getNome());
      stmt.setString(2, contato.getEmail());
      stmt.setString(3, contato.getEndereco());
      stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
      stmt.setLong(5, contato.getId());
      stmt.execute();
      stmt.close();
    }catch(SQLException e){
      throw new RuntimeException(e);
    }
  }
  
  public void remove(Contato contato){
    try{
      PreparedStatement stmt = connection.prepareStatement("delete from contatos where id = ?");
      stmt.setLong(1, contato.getId());
      stmt.execute();
      stmt.close();
    }catch(SQLException e){
      throw new RuntimeException(e);
    }
  }
  
  public List<Contato> getContatos(){
    try{
      List<Contato> contatos = new ArrayList<>();
      PreparedStatement stmt = connection.prepareStatement("select * from contatos");
      ResultSet rs = stmt.executeQuery();
      while(rs.next()){
        Contato contato = new Contato();
        contato.setId(rs.getLong("id"));
        contato.setNome(rs.getString("nome"));
        contato.setEmail(rs.getString("email"));
        contato.setEndereco(rs.getString("endereco"));
        Calendar data = Calendar.getInstance();
        data.setTime(rs.getDate("dataNascimento"));
        contato.setDataNascimento(data);
        contatos.add(contato);
      }
      rs.close();
      stmt.close();
      return contatos;
    }catch(SQLException e){
      throw new RuntimeException(e);
    }
  }
  
  public Contato getContato(Long id){
    Contato contato = new Contato();
    try {
      PreparedStatement stmt = connection.prepareStatement("select * from contatos where id = ?");
      stmt.setLong(1, id);
      ResultSet rs = stmt.executeQuery();
      if(rs.next()){
        contato.setId(rs.getLong("id"));
        contato.setNome(rs.getString("nome"));
        contato.setEmail(rs.getString("email"));
        contato.setEndereco(rs.getString("endereco"));
        Calendar data = Calendar.getInstance();
        data.setTime(rs.getDate("dataNascimento"));
        contato.setDataNascimento(data);
      }
      rs.close();
      stmt.close();
    } catch (SQLException ex) {
      Logger.getLogger(ContatoDao.class.getName()).log(Level.SEVERE, null, ex);
    }
      return contato;
  }
}
