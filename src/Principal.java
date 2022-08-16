
import br.edu.ifsp.pep.modelo.Pessoa;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Principal {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FP1C4PU");
        
        Pessoa p1 = new Pessoa();
        p1.setDataNascimento(new Date());
        p1.setNome("Juka");
        p1.setSalario(new BigDecimal(555.9909d));
        p1.setEmail("juka.com");
        p1.setLogradouro("x");
        p1.setNumero(1);
        
        Pessoa p2 = new Pessoa();
        p2.setDataNascimento(new Date());
        p2.setNome("Juka2");
        p2.setSalario(new BigDecimal(555.9909d));
        p2.setEmail("juka2.com");
        p2.setLogradouro("x");
        p2.setNumero(2);
        
        Pessoa p3 = new Pessoa();
        p3.setDataNascimento(new Date());
        p3.setNome("Juka3");
        p3.setSalario(new BigDecimal(555.9909d));
        p3.setEmail("juk3.com");
        p3.setLogradouro("y");
        p3.setNumero(1);
        
        EntityManager em = emf.createEntityManager(); // gerente de entidade
        em.getTransaction().begin();
        
        //em.persist(pessoa);// insert
        em.merge(p1);// update ou insert
        em.merge(p2);// update  ou insert
        em.merge(p3);// update  ou insert
        
        
        em.getTransaction().commit();

        
        
    }
}
