import java.util.ArrayList;

public class Padaria extends Estabelecimento{

    private String horafunciona;
    private ArrayList<Receita> receitas = new ArrayList<>();
    
    public Padaria(
        int id,
        String nome,
        String dataAbertura,
        String horafunciona,
        int idEnd,
        String cep,
        String rua,
        String numero,
        String bairro,
        String cidade
    ) {
        super(id, nome, dataAbertura,idEnd, cep, rua, numero, bairro, cidade);
        this.horafunciona = horafunciona;
    }

    public String getHorafunciona() {
        return this.horafunciona;
    }

    public void setHorafunciona(String horafunciona) {
        this.horafunciona = horafunciona;
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
        if (!(o instanceof Padaria)) {
            return false;
        }
        Padaria padaria = (Padaria) o;
        return this.getId() == padaria.getId()
            && this.getNome() == padaria.getNome()
            && this.getDataAbertura() == padaria.getDataAbertura();
    }

    @Override
    public String toString()
    {
        return  " \n" +
                " \nId:" + getId() +
                " \nNome:" + getNome() +
                " \nDataAbertura:" + getDataAbertura() +
                " \nEndereco:" + getEndereco() +
                " \nHorário de funcionamento:" + getHorafunciona() +
                " \nReceitas:" + getReceitas() +
                " \n";
    }
}