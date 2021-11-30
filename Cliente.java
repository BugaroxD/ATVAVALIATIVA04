import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Cliente extends Pessoa{

    private static String telefone;
    ArrayList<Receita> receitas = new ArrayList<>();

    private final static String url = "jdbc:mysql://localhost:3306/atividadeavaliativa04?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";

    public Cliente(int id, String nome, String cpf, Date dataNasc, String telefone   
    ) {
        super(id, nome, cpf, dataNasc);
        Cliente.telefone = telefone;
    }

    public Cliente(String nome, String cpf, Date dataNasc, String telefone) {
      super(nome, cpf, dataNasc);
      Cliente.telefone = telefone;
    }

    public String getTelefone() {
        return Cliente.telefone;
    }

    public void setTelefone(String telefone) {
        Cliente.telefone = telefone;
    }

    public ArrayList<Receita> getReceitas() {
        return this.receitas;
    }

    public void setReceitas(ArrayList<Receita> receitas) {
        this.receitas = receitas;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cliente)) {
            return false;
        }
        Cliente cliente = (Cliente) o;
        return Objects.equals(this.getCpf(), cliente.getCpf());
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

    /*
    public void executaReceita(Receita receita) 
    {this.receitas.adicionarElemento(receita);
     receita.liberaReceita(this);}
    */

    @Override
    public String carteira() {
        return null;
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
    public static ArrayList<Cliente> getClienteS() throws Exception {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM cliente;");
            ArrayList<Cliente> clientes = new ArrayList<>();
            while (rs.next()) {
                clientes.add(
                    new Cliente(
                        rs.getInt("id"),
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

    public static Cliente getClienteInsert() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o nome do cliente");
        String nome = scanner.next();
        System.out.println("Informe o CPF do cliente");
        String cpf = scanner.next();
        System.out.println("Informe a Data de Nascimento do cliente");
        String dataNasc = scanner.next();
        System.out.println("Informe o Telefone do cliente");
        String telefone = scanner.next();
        scanner.close();

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
            boolean sql = stm.execute("INSERT INTO cliente "
                + "(nome, cpf, datanascimento, telefone) VALUES "
                + "('"+cliente.getNome()+"', '"+cliente.getCpf()+"', '"+cliente.getDataNasc()+"', '"+cliente.getTelefone()+"')");
            if(!sql) {
                System.out.println("Falha na execução");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Case 3 UPDATE COM STATEMENT

    public static Cliente getClienteUpdate() throws Exception {
        try {
            Scanner scanner = new Scanner(System.in);
           Cliente cliente = Cliente.getCliente();
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
            scanner.close();
            return cliente;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void updateClienteS (Cliente cliente) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            boolean sql = stm.execute("UPDATE cliente SET "
                + " nome = '" + cliente.getNome() + "'"
                + ", cpf = '" + cliente.getCpf() + "'"
                + ", datanascimento = '" + cliente.getDataNasc() + "'"
                + ", matricula = '" + cliente.getTelefone() + "'"
                + " WHERE id = " + cliente.getId());
            if(!sql) {
                System.out.println("Falha na execução");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Case 4 DELETE COM STATEMENT

    public static Cliente getCliente() throws Exception { 
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o ID de exclusão: ");
            int id = scanner.nextInt();
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM cliente WHERE id = " + id);
            
            if(!rs.next()) {
                throw new Exception("Id inválido");
            }
            scanner.close();
            return new Cliente(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("cpf"),
                rs.getDate("data_nascimento"),
                rs.getString("matricula")
            );

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void deleteClienteS(Cliente cliente) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            boolean sql = stm.execute("DELETE FROM cliente "
                + " WHERE id = " + cliente.getId());
            if(!sql) {
                System.out.println("Falha na execução");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
