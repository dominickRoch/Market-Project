package dao;

import java.util.List;
import modelo.Mercado;


public interface CompraDAO {
    
    public int inserir(Mercado mercado);
    public List<Mercado> listar();
    public String exibirCompra();
    public String cancelarCompra(String produto);
   
}
