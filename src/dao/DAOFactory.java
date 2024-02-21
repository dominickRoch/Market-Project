package dao;


public class DAOFactory {
    
    public static UsuarioDAO criarUsuarioDAO(){
        return new UsuarioDAOJDBC();
    }
    
    public static MercadoDAO criarMercadoDAO(){
        return new MercadoDAOJDBC();
    }
    
    public static CompraDAO criarCompraDAO(){
        return new CompraDAOJDBC();
    }
}
