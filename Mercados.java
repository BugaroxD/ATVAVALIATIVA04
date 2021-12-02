import java.util.ArrayList;

public class Mercados extends Estabelecimento {

    private String promocoes;
    private ArrayList<Receita> receitas = new ArrayList<>();
    
    public Mercados(
        int id,
        String nome,
        String dataAbertura,
        String promocoes,
        int idEnd,
        String cep,
        String rua,
        String numero,
        String bairro,
        String cidade
       
    ) {
        super(id, nome, dataAbertura,idEnd, cep, rua, numero, bairro, cidade);
        this.promocoes = promocoes;
    }

    public String getPromocoes() {
        return this.promocoes;
    }

    public void setPromocoes(String promocoes) {
        this.promocoes = promocoes;
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
        if (!(o instanceof Mercados)) {
            return false;
        }
        Mercados mercado = (Mercados) o;
        return this.getId() == mercado.getId()
            && this.getNome() == mercado.getNome()
            && this.getDataAbertura() == mercado.getDataAbertura();
    }

    @Override
    public String toString()
    {
        return " \n" +
               " \nId:" + getId() +
               " \nNome:" + getNome() +
               " \nDataAbertura:" + getDataAbertura() +
               " \nEndereco:" + getEndereco() +
               " \nReceitas:" + getReceitas() +
               " \nPromoções:" + getPromocoes() +
               " \n";
    }
}
