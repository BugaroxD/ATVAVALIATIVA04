import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Cliente extends Pessoa{

    private String telefone;
    ArrayList<Receita> receitas = new ArrayList<>();

    private final static String url = "jdbc:mysql://localhost:3306/atividadeavaliativa04?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";

    public Cliente(int id, String nome, String cpf, Date dataNasc, String telefone   
    ) {
        super(id, nome, cpf, dataNasc);
        this.telefone = telefone;
    }

    public Cliente(String nome, String cpf, Date dataNasc, String telefone) {
      super(nome, cpf, dataNasc);
      this.telefone = telefone;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public ArrayList<Receita> getReceitas() {
        return this.receitas;
    }

    public void setReceitas(ArrayList<Receita> receitas) {
        this.receitas = receitas;
    }

    public void executaReceita(Receita receita) 
    {
        this.receitas.add(receita);
        receita.liberaReceita(this);
    };

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cliente)) {
            return false;
        }
        Cliente cliente = (Cliente) o;
        return Objects.equals(cliente.getId(), this.getId());
    }

    @Override
    public String toString() 
    {
        return  " \n" +
                " \nNome:" + getNome() +
                " \nCPF:" + getCpf() +
                " \nDataDeNascimento:" + getDataNasc() +
                " \nTelefone:" + getTelefone() +
                " \nReceitas:" + getReceitas() +
                " \n";
    }

    @Override
    public String carteira(){
        return "\nTelefone: " + this.getTelefone();
    };

    /* INTRODUÇÃO DO BANCO DE DADOS*/

    public static void printCliente(
        ArrayList<Cliente> clientes
    ) {
        try {
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Case 1 SELECT COM STATEMENT
    public static ArrayList<Cliente> getClienteS(Scanner scanner) throws Exception {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM cliente;");
            ArrayList<Cliente> clientes = new ArrayList<>();
            while (rs.next()) {
                clientes.add(
                    new Cliente(
                        rs.getInt("idCliente"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getDate("datanascimento"),
                        rs.getString("telefone")
                    )
                );
            }
            con.close();
            return clientes;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }             
    }

    // Case 2 INSERT COM STATEMENT
    public static Cliente getClienteInsert(Scanner scanner) {
        System.out.println("Informe o nome do cliente");
        String nome = scanner.next();
        System.out.println("Informe o CPF do cliente");
        String cpf = scanner.next();
        System.out.println("Informe a Data de Nascimento do cliente");
        String dataNasc = scanner.next();
        System.out.println("Informe o Telefone do cliente");
        String telefone = scanner.next();

        return new Cliente(
            nome,
            cpf,
            Date.valueOf(dataNasc),
            telefone
        );
    }
    
    public static void insertClienteS(Cliente cliente) {
        try{
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            stm.execute("INSERT INTO cliente "
                + "(nome, cpf, datanascimento, telefone) VALUES "
                + "('"+cliente.getNome()+"', '"+cliente.getCpf()+"', '"+cliente.getDataNasc()+"', '"+cliente.getTelefone()+"')");
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Case 3 UPDATE COM STATEMENT
    public static Cliente getClienteUpdate(Scanner scanner) throws Exception {
        try {
            Cliente cliente = Cliente.getCliente(scanner);
            System.out.println("Informe o nome do cliente (Deixar vazio para manter)");
            String nome = scanner.next();
            if (nome.length() > 0){
                cliente.setNome(nome);
            }
            System.out.println("Informe o CPF do cliente (Deixar vazio para manter)");
            String cpf = scanner.next();
            if (cpf.length() > 0){
                cliente.setCpf(cpf);
            }
            System.out.println("Informe a Data de Nascimento do cliente (Deixar vazio para manter)");
            String dataNascimento = scanner.next();
            if (dataNascimento.length() > 0){
                cliente.setDataNasc(Date.valueOf(dataNascimento));
            }
            System.out.println("Informe o Matricula do cliente (Deixar vazio para manter)");
            String telefone = scanner.next();
            if (telefone.length() > 0){
                cliente.setTelefone(telefone);
            }
            return cliente;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void updateClienteS (Cliente cliente) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            stm.execute("UPDATE cliente SET "
                + " nome = '" + cliente.getNome() + "'"
                + ", cpf = '" + cliente.getCpf() + "'"
                + ", datanascimento = '" + cliente.getDataNasc() + "'"
                + ", matricula = '" + cliente.getTelefone() + "'"
                + " WHERE id = " + cliente.getId());
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Case 4 DELETE COM STATEMENT
    public static Cliente getCliente(Scanner scanner) throws Exception { 
        try {
            System.out.println("Informe o ID EX/UP: ");
            int id = scanner.nextInt();
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM cliente WHERE idCliente = " + id);
            
            if(!rs.next()) {
                throw new Exception("Id inválido");
            }
            return new Cliente(
                rs.getInt("idCliente"),
                rs.getString("nome"),
                rs.getString("cpf"),
                rs.getDate("datanascimento"),
                rs.getString("telefone")
            );

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void deleteClienteS(Cliente cliente) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            stm.execute("DELETE FROM cliente "
                + " WHERE idCliente = " + cliente.getId());
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static Cliente getCliente(Integer id) throws Exception { 
      try {
          Connection con = DriverManager.getConnection(url, user, password);
          Statement stm = con.createStatement();
          ResultSet rs = stm.executeQuery("SELECT * FROM cliente WHERE idCliente = " + id);
          
          if(!rs.next()) {
              throw new Exception("Id inválido");
          }
          return new Cliente(
              rs.getInt("idCliente"),
              rs.getString("nome"),
              rs.getString("cpf"),
              rs.getDate("datanascimento"),
              rs.getString("telefone")
          );

      } catch (Exception e) {
          throw new Exception(e.getMessage());
      }
  }
}
