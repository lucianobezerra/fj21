package jdbc.model;

import java.util.Calendar;

public class Contato {
  public Long id;
  public String nome;
  public String email;
  public String endereco;
  public Calendar dataNascimento;
  
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getNome() {
    return nome;
  }
  
  public void setNome(String nome) {
    this.nome = nome;
  }
  
  public String getEmail() {
    return email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  public String getEndereco() {
    return endereco;
  }
  
  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }
  
  public Calendar getDataNascimento() {
    return dataNascimento;
  }
  
  public void setDataNascimento(Calendar dataNascimento) {
    this.dataNascimento = dataNascimento;
  }
    
}
