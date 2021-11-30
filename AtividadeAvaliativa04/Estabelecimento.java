import java.util.Objects;

public abstract class Estabelecimento {
    private int id;
    private String nome;
    private String dataAbertura;
    private Endereco endereco;

    protected Estabelecimento(
        int id, 
        String nome, 
        String dataAbertura, 
        int idEnd,
        String cep,
        String rua,
        String numero,
        String bairro,
        String cidade
    ) {
        this.id = id;
        this.nome = nome;
        this.dataAbertura = dataAbertura;
        this.endereco = new Endereco(
            idEnd,
            cep, 
            rua, 
            numero, 
            bairro, 
            cidade
        );
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

    protected String getDataAbertura() {
        return this.dataAbertura;
    }

    protected void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    protected Endereco getEndereco() {
        return this.endereco;
    }

    protected void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    protected Estabelecimento id(int id) {
        setId(id);
        return this;
    }

    protected Estabelecimento nome(String nome) {
        setNome(nome);
        return this;
    }

    protected Estabelecimento dataAbertura(String dataAbertura) {
        setDataAbertura(dataAbertura);
        return this;
    }

    protected Estabelecimento endereco(Endereco endereco) {
        setEndereco(endereco);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Estabelecimento)) {
            return false;
        }
        Estabelecimento estabelecimento = (Estabelecimento) o;

        return id == estabelecimento.id 
                  && Objects.equals(nome, estabelecimento.nome) 
                  && Objects.equals(dataAbertura, estabelecimento.dataAbertura) 
                  && Objects.equals(endereco, estabelecimento.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, dataAbertura, endereco);
    }

    @Override
    public String toString()
    {
        return  " \n" +
                " \nId:" + getId() +
                " \nNome:" + getNome() +
                " \nDataAbertura:" + getDataAbertura() +
                " \nEndereco:" + getEndereco() +
                " \n";
    }
}