package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.ConnectionFactory;
import model.Funcionario;

public class FuncionarioDao {

  private final Connection connection;

  public FuncionarioDao() {
    this.connection = new ConnectionFactory().getConnection();
  }

  public void adiciona(Funcionario funcionario) {
    String sql = "insert into funcionarios (nome, usuario, senha) values (?,?,?)";
    try {
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.setString(1, funcionario.getNome());
      stmt.setString(2, funcionario.getUsuario());
      stmt.setString(3, funcionario.getSenha());
      stmt.execute();
      stmt.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void altera(Funcionario funcionario) {
    String sql = "update funcionarios set nome = ?, usuario = ?, senha = ? where id = ?";
    try {
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.setString(1, funcionario.getNome());
      stmt.setString(2, funcionario.getUsuario());
      stmt.setString(3, funcionario.getSenha());
      stmt.setLong(4, funcionario.getId());
      stmt.execute();
      stmt.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void remove(Funcionario funcionario) {
    try {
      PreparedStatement stmt = connection.prepareStatement("delete from funcionarios where id = ?");
      stmt.setLong(1, funcionario.getId());
      stmt.execute();
      stmt.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public List<Funcionario> getFuncionarios() {
    try {
      List<Funcionario> funcionarios = new ArrayList<>();
      PreparedStatement stmt = connection.prepareStatement("select * from funcionarios");
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        Funcionario funcionario = new Funcionario();
        funcionario.setId(rs.getLong("id"));
        funcionario.setNome(rs.getString("nome"));
        funcionario.setUsuario(rs.getString("usuario"));
        funcionario.setSenha(rs.getString("senha"));
        funcionarios.add(funcionario);
      }
      rs.close();
      stmt.close();
      return funcionarios;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public Funcionario getFuncionario(Long id) {
    Funcionario funcionario = new Funcionario();
    try {
      PreparedStatement stmt = connection.prepareStatement("select * from funcionarios where id = ?");
      stmt.setLong(1, id);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        funcionario.setId(rs.getLong("id"));
        funcionario.setNome(rs.getString("nome"));
        funcionario.setUsuario(rs.getString("usuario"));
        funcionario.setSenha(rs.getString("senha"));
      }
      rs.close();
      stmt.close();
    } catch (SQLException ex) {
      Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return funcionario;
  }
}
