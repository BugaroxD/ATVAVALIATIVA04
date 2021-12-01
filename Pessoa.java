import java.sql.Date;
import java.util.Objects;

public abstract class Pessoa {
    private int id;
    private String nome;
    private String cpf;
    private Date dataNasc;

    protected Pessoa(
        int id, 
        String nome, 
        String cpf, 
        Date dataNasc
    ) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
    }

    public Pessoa(String nome, String cpf, Date dataNasc) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
    }

    protected int getId() {
        return this.id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    protected String getNome() {
        return this.nome;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }

    protected String getCpf() {
        return this.cpf;
    }

    protected void setCpf(String cpf) {
        this.cpf = cpf;
    }

    protected Date getDataNasc() {
        return this.dataNasc;
    }

    protected void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pessoa)) {
            return false;
        }

        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(cpf, pessoa.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf, dataNasc);
    }
    
    @Override
    public String toString()
    {
        return  " \n" +
                " \nNome:" + getNome() +
                " \nCPF:" + getCpf() +
                " \nDataDeNascimento:" + getDataNasc() +
                " \n";
    }

    public abstract String carteira();

}
