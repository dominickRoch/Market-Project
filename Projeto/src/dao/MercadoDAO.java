package dao;

import java.util.List;
import modelo.Mercado;

public interface MercadoDAO {
    
    public int inserir(Mercado mercado);
    public int editar(Mercado mercado);
    public int apagar(int id);
    public List<Mercado> listar();
    public Mercado encontrar(String produto);  
    public List<Mercado> consultar(String item);
    
}
