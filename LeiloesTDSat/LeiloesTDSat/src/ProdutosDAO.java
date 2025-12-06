import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void conectar(){
        conectaDAO cd = new conectaDAO();
        conn = cd.connectDB();
    }
    
    public void desconectar(){
        try{
            conn.close();
        }catch(SQLException ex){
            
        }
    }
    
    public int cadastrarProduto (ProdutosDTO produto){
        int status;
        try{
            conectar();
            prep = conn.prepareStatement("INSERT INTO produtos (nome,valor,status) VALUES (?,?,?)");
            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor());
            prep.setString(3, produto.getStatus());
            status = prep.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastro feito");
            desconectar();
            return status;
        }catch(SQLException ex){
            System.out.println("Erro ao conecatar: "+ex);
            JOptionPane.showMessageDialog(null, "Cadastro Falhou");
            return ex.getErrorCode();
        }
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

