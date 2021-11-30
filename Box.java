import java.util.ArrayList;

public class Box <T> {
    private ArrayList<T> caixa;
    
    
    public void adicionarElemento(T elemento) {
        this.caixa.add(elemento);
    }
}
