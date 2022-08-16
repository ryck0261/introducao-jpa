
import br.edu.ifsp.pep.modelo.Categoria;
import br.edu.ifsp.pep.modelo.Produto;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class TesteProdutoCategoria {
    
    
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("FP1C4PU").createEntityManager();
        Categoria categoria = new Categoria();
        categoria.setDescricao("Informatica");
        
        Produto produto = new Produto();
        produto.setDescricao("teclado");
        produto.setPreco(new BigDecimal(60.0));
        produto.setQuantidade(2);
        produto.setCategoria(categoria);
        
        
        em.getTransaction().begin();
        
        em.persist(categoria);
        em.persist(produto);
        
        em.getTransaction().commit();
        
        TypedQuery<Produto> query = em.createQuery("select p from Produto p ", Produto.class);
        
        List<Produto> produtos = query.getResultList();
        
        for (Produto p : produtos){
            System.out.println("Descrição : "+ p.getDescricao());
            System.out.println("Categoria : "+ p.getCategoria().getDescricao());
        } 
        
        em.close();
        
        
    }
}
