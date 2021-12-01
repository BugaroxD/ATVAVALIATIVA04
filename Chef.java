import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Chef extends Pessoa implements AnoSalario { 

    private String especialidade;
    private Double salario;
    ArrayList<Receita> receitas = new ArrayList<>();

    private final static String url = "jdbc:mysql://localhost:3306/atividadeavaliativa04?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";

    public Chef(int id, String nome, String cpf, Date dataNasc, String especialidade, Double salario   
    ) {
        super(id, nome, cpf, dataNasc);
        this.especialidade = especialidade;
        this.salario = salario;
    }

    public Chef(String nome, String cpf, Date dataNasc, String especialidade, Double salario
    ) {
      super(nome, cpf, dataNasc);
      this.especialidade = especialidade;
      this.salario = salario;
    }

    public Double getSalario() {
        return this.salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getEspecialidade() {
        return this.especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setReceitas(Receita receita) {
        this.receitas.add(receita);
    }

    public ArrayList<Receita> getReceitas(){
        return this.receitas;
    }


    @Override
    public boolean equals(Object o){
        if (o == this)
            return true;
        if (!(o instanceof Chef)){
            return false;
        }
        Chef chef = (Chef) o;
        return this.getCpf() == chef.getCpf()
            && this.getReceitas() == chef.getReceitas()
            && this.getNome() == chef.getNome();
    }

    @Override
    public String toString() 
    {
        return  " \n" +
                " \nNome:" + getNome() + 
                " \nCPF:" + getCpf() +
                " \nDataDeNascimento:" + getDataNasc() +
                " \nEspecialidade:" + getEspecialidade() +
                " \nReceitas:" + getReceitas() +
                " \nSalario:" + getSalario() +
                " \nAno Salario:" + formatoAnoSalario() +
                " \n";
    }
    public String carteira(){
         return super.toString() +
                " \nEspecialidade:" + getEspecialidade() +
                " \nSalario:" + getSalario();
    }

    @Override
    public String formatoAnoSalario() {
        return Double.toString(getSalario() * 12);
    }

 /* INTRODUÇÃO DO BANCO DE DADOS*/

 public static void printChef(
  ArrayList<Chef> chefs
) {
  try {
      for (Chef chef : chefs) {
          System.out.println(chef);
      }
  } catch (Exception e) {
      System.out.println(e.getMessage());
  }
}

// Case 1 SELECT COM STATEMENT
public static ArrayList<Chef> getChefS(Scanner scanner) throws Exception {
  try {
      Connection con = DriverManager.getConnection(url, user, password);
      Statement stm = con.createStatement();
      ResultSet rs = stm.executeQuery("SELECT * FROM chef;");
      ArrayList<Chef> chefs = new ArrayList<>();
      while (rs.next()) {
          chefs.add(
              new Chef(
                  rs.getInt("id"),
                  rs.getString("nome"),
                  rs.getString("cpf"),
                  rs.getDate("datanascimento"),
                  rs.getString("especialidade"),
                  rs.getDouble("salario")
              )
          );
      }
      con.close();
      return chefs;
  } catch (Exception e) {
      throw new Exception(e.getMessage());
  }             
}

// Case 2 INSERT COM STATEMENT
public static Chef getChefInsert(Scanner scanner) {
  System.out.println("Informe o nome do chef");
  String nome = scanner.next();
  System.out.println("Informe o CPF do chef");
  String cpf = scanner.next();
  System.out.println("Informe a Data de Nascimento do chef");
  String dataNasc = scanner.next();
  System.out.println("Informe a Especialidade do chef");
  String especialidade = scanner.next();
  System.out.println("Informe o Salário do chef");
  Double salario = scanner.nextDouble();

  return new Chef(
      nome,
      cpf,
      Date.valueOf(dataNasc),
      especialidade,
      salario
  );
}

public static void insertChefS(Chef chef) {
  try{
      Connection con = DriverManager.getConnection(url, user, password);
      Statement stm = con.createStatement();
      stm.execute("INSERT INTO chef "
          + "(nome, cpf, datanascimento, especialidade, salario) VALUES "
          + "('"+chef.getNome()+"', '"+chef.getCpf()+"', '"+chef.getDataNasc()+"', '"+chef.getEspecialidade()+"', "+chef.getSalario()+")");
      con.close();
  } catch (Exception e) {
      System.out.println(e.getMessage());
  }
}

// Case 3 UPDATE COM STATEMENT
public static Chef getChefUpdate(Scanner scanner) throws Exception {
  try {
      Chef chef = Chef.getChef(scanner);
      System.out.println("Informe o nome do funcionário (Deixar vazio para manter)");
      String nome = scanner.next();
      if (nome.length() > 0){
          chef.setNome(nome);
      }
      System.out.println("Informe o CPF do funcionário (Deixar vazio para manter)");
      String cpf = scanner.next();
      if (cpf.length() > 0){
          chef.setCpf(cpf);
      }
      System.out.println("Informe a Data de Nascimento do funcionário (Deixar vazio para manter)");
      String dataNascimento = scanner.next();
      if (dataNascimento.length() > 0){
          chef.setDataNasc(Date.valueOf(dataNascimento));
      }
      System.out.println("Informe o Matricula do funcionário (Deixar vazio para manter)");
      String especialidade = scanner.next();
      if (especialidade.length() > 0){
          chef.setEspecialidade(especialidade);
      }
      return chef;
  } catch (Exception e) {
      throw new Exception(e.getMessage());
  }
}

public static void updateChefS (Chef chef) {
  try {
      Connection con = DriverManager.getConnection(url, user, password);
      Statement stm = con.createStatement();
      boolean sql = stm.execute("UPDATE chef SET "
          + " nome = '" + chef.getNome() + "'"
          + ", cpf = '" + chef.getCpf() + "'"
          + ", datanascimento = '" + chef.getDataNasc() + "'"
          + ", especialidade = '" + chef.getEspecialidade() + "'"
          + ", salario = '" + chef.getSalario() + "'"
          + " WHERE id = " + chef.getId());
      if(!sql) {
          System.out.println("Falha na execução");
      }
      con.close();
  } catch (Exception e) {
      System.out.println(e.getMessage());
  }
}

// Case 4 DELETE COM STATEMENT
public static Chef getChef(Scanner scanner) throws Exception { 
  try {
      System.out.println("Informe o ID de exclusão: ");
      int id = scanner.nextInt();
      Connection con = DriverManager.getConnection(url, user, password);
      Statement stm = con.createStatement();
      ResultSet rs = stm.executeQuery("SELECT * FROM chef WHERE id = " + id);
      
      if(!rs.next()) {
          throw new Exception("Id inválido");
      }
      return new Chef(
          rs.getInt("id"),
          rs.getString("nome"),
          rs.getString("cpf"),
          rs.getDate("datanascimento"),
          rs.getString("especialidade"),
          rs.getDouble("salario")
      );

  } catch (Exception e) {
      throw new Exception(e.getMessage());
  }
}

public static void deleteChefS(Chef chef) {
  try {
      Connection con = DriverManager.getConnection(url, user, password);
      Statement stm = con.createStatement();
      boolean sql = stm.execute("DELETE FROM chef "
          + " WHERE id = " + chef.getId());
      if(!sql) {
          System.out.println("Falha na execução");
      }
      con.close();
  } catch (Exception e) {
      System.out.println(e.getMessage());
  }
}
public static Chef getChef(Integer id) throws Exception { 
  try {
      Connection con = DriverManager.getConnection(url, user, password);
      Statement stm = con.createStatement();
      ResultSet rs = stm.executeQuery("SELECT * FROM chef WHERE id = " + id);
      
      if(!rs.next()) {
          throw new Exception("Id inválido");
      }
      return new Chef(
          rs.getInt("id"),
          rs.getString("nome"),
          rs.getString("cpf"),
          rs.getDate("datanascimento"),
          rs.getString("especialidade"),
          rs.getDouble("salario")
      );

  } catch (Exception e) {
      throw new Exception(e.getMessage());
  }
}
}


    

