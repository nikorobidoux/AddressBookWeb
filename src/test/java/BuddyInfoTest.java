import jpa.BuddyInfo;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.*;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by craigshorrocks on 1/12/2017.
 */
public class BuddyInfoTest {

    private String name, name2, number, number2;

    @Before
    public void setUp() throws Exception {
        name = "Craig";
        name2 = "Bob";
        number = "666";
        number2 = "555";
    }

    @Test
    public void testPersist() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-4806");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        BuddyInfo b = new BuddyInfo(name,number);
        em.persist(b);
        tx.commit();

        Query q = em.createQuery("SELECT buddy FROM BuddyInfo buddy");

        List<BuddyInfo> results = q.getResultList();
        BuddyInfo buddy = results.get(0);
        assertTrue(buddy.getName().equals(b.getName()));
        assertTrue(buddy.getPhoneNumber().equals(b.getPhoneNumber()));
    }

    @Test
    public void getName() throws Exception {
        BuddyInfo b = new BuddyInfo(name,number);

        assertTrue(b.getName().equals(name));
    }

    @Test
    public void setName() throws Exception {
        BuddyInfo b = new BuddyInfo(name,number);
        b.setName(name2);
        assertTrue(b.getName().equals(name2));
    }

    @Test
    public void getPhoneNumber() throws Exception {
        BuddyInfo b = new BuddyInfo(name,number);

        assertTrue(b.getPhoneNumber().equals(number));
    }

    @Test
    public void setPhoneNumber() throws Exception {
        BuddyInfo b = new BuddyInfo(name,number);
        b.setPhoneNumber(number2);
        assertTrue(b.getPhoneNumber().equals(number2));
    }

}