
import br.edu.ifsp.pep.modelo.Pessoa;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Principal {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FP1C4PU");
        
        Pessoa pessoa = new Pessoa();
        pessoa.setDataNascimento(new Date());
        pessoa.setNome("Juka");
        pessoa.setSalario(new BigDecimal(555.9909d));
        
        EntityManager em = emf.createEntityManager(); // gerente de entidade
        em.getTransaction().begin();
        
        //em.persist(pessoa);// insert
        em.merge(pessoa);// update 
        
        
        em.getTransaction().commit();
        
        
    }
}
