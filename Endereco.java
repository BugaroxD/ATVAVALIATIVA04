public class Endereco {

  private int idEnd;
  private String cep;
  private String rua;
  private String numero;
  private String bairro;
  private String cidade;
  
  public Endereco(
      int idEnd,
      String cep,
      String rua,
      String numero,
      String bairro,
      String cidade
  ){
      this.idEnd = idEnd;   
      this.cep = cep;
      this.rua = rua;
      this.numero = numero;
      this.bairro = bairro;
      this.cidade = cidade;   
  }

  public int getIdEnd() {
      return this.idEnd;
  }

  public void setIdEnd(int idEnd) {
      this.idEnd = idEnd;
  }

  public String getCep() {
      return this.cep;
  }

  public void setCep(String cep) {
      this.cep = cep;
  }

  public String getRua() {
      return this.rua;
  }

  public void setRua(String rua) {
      this.rua = rua;
  }

  public String getNumero() {
      return this.numero;
  }

  public void setNumero(String numero) {
      this.numero = numero;
  }

  public String getBairro() {
      return this.bairro;
  }

  public void setBairro(String bairro) {
      this.bairro = bairro;
  }

  public String getCidade() {
      return this.cidade;
  }

  public void setCidade(String cidade) {
      this.cidade = cidade;
  }

  @Override
  public String toString()
  {
      return  " \n" +
              " \nId Endereço:" + getIdEnd() +
              " \nCEP:" + getCep() +
              " \nRua:" + getRua() +
              " \nNumero:" + getNumero() +
              " \nBairro:" + getBairro() +
              " \nCidade:" + getCidade() +
              " \n";
  }
}
  