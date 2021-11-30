import java.util.ArrayList;

public class Receita {
  private int id;
  private String nome;
  private String etapas;
  private String numEtapas;
  private String valor;
  private Chef chef;

  private ArrayList<Mercados> mercado = new ArrayList<>();
  private ArrayList<Padaria> padaria = new ArrayList<>();
  private ArrayList<Cliente> cliente = new ArrayList<>();

  public Receita(
      int id, 
      String nome, 
      String etapas, 
      String numEtapas, 
      String valor, 
      Chef chef  
  ) {
      this.id = id;
      this.nome = nome;
      this.etapas = etapas;
      this.numEtapas = numEtapas;
      this.valor = valor;

      chef.setReceitas(this);
  }

  public int getId() {
      return this.id;
  }

  public void setId(int id) {
      this.id = id;
  }

  public String getNome() {
      return this.nome;
  }

  public void setNome(String nome) {
      this.nome = nome;
  }

  public String getEtapas() {
      return this.etapas;
  }

  public void setEtapas(String etapas) {
      this.etapas = etapas;
  }

  public String getNumEtapas() {
      return this.numEtapas;
  }

  public void setNumEtapas(String numEtapas) {
      this.numEtapas = numEtapas;
  }

  public String getValor() {
      return this.valor;
  }

  public void setValor(String valor) {
      this.valor = valor;
  }

  public Chef getChef() {
      return this.chef;
  }

  public void setChef(Chef chef) {
      this.chef = chef;
  }

  public ArrayList<Mercados> getMercados() {
      return this.mercado;
  }

  public void setMercados(ArrayList<Mercados> mercado) {
      this.mercado = mercado;
  }

  public ArrayList<Padaria> getPadaria() {
      return this.padaria;
  }

  public void setPadaria(ArrayList<Padaria> padaria) {
      this.padaria = padaria;
  }

  public ArrayList<Cliente> getCliente() {
      return this.cliente;
  }

  public void setCliente(ArrayList<Cliente> cliente) {
      this.cliente = cliente;
  }

  @Override
  public boolean equals(Object o) 
  {
      if (o == this)
          return true;
      if (!(o instanceof Receita)) {
          return false;
      }
      Receita receita = (Receita) o;
      return this.getChef().getCpf() == receita.getChef().getCpf()
          && this.getValor() == receita.getValor();
  }

  @Override
  public String toString() 
  {
      return  " \n" +
              " \nId:" + getId() +
              " \nNome:" + getNome() +
              " \nEtapas:" + getEtapas() +
              " \nQuantidade de Etapas:" + getNumEtapas() +
              " \n";
  }
  
  public void liberaReceita(Padaria padaria)
  {
      this.padaria.add(padaria);
  }

  public void liberaReceita(Mercados mercado) 
  {
      this.mercado.add(mercado);
  }

  public void liberaReceita(Cliente cliente) 
  {
      this.cliente.add(cliente);
  }
}