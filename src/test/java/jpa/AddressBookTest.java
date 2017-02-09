package jpa;

import jpa.AddressBook;
import jpa.BuddyInfo;
import org.junit.Test;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by craigshorrocks on 1/12/2017.
 */
public class AddressBookTest {
    private AddressBook a;
    private BuddyInfo b1, b2;

    @org.junit.Before
    public void setUp() throws Exception {
        a = new AddressBook();
        b1 = new BuddyInfo("Craig", "555");
        b2 = new BuddyInfo("Bob","666");
    }

    @Test
    public void testPersist() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-4806");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        AddressBook a1 = new AddressBook();
        a1.addBuddy(b1);
        a1.addBuddy(b2);
        em.persist(a1);
        tx.commit();

        Query q = em.createQuery("SELECT aBook FROM AddressBook aBook");

        List<AddressBook> results = q.getResultList();
        AddressBook aBook = results.get(0);
        List<BuddyInfo> buddies = aBook.getBuddies();
        assertTrue(buddies.get(0).equals(b1));
        assertTrue(buddies.get(1).equals(b2));
    }

    @org.junit.Test
    public void addBuddy() throws Exception {
        a.addBuddy(b1);

        BuddyInfo b = a.getBuddies().get(0);
        assertEquals(b.getName(), b1.getName());
        assertEquals(b.getPhoneNumber(), b1.getPhoneNumber());
    }

    @org.junit.Test
    public void removeBuddy() throws Exception {
        a.addBuddy(b1);
        a.removeBuddy(b1);

        assertTrue(a.getBuddies().isEmpty());
    }

    @org.junit.Test
    public void getBuddies() throws Exception {
        ArrayList<BuddyInfo> myBuddies = new ArrayList<BuddyInfo>();
        myBuddies.add(b1);
        myBuddies.add(b2);

        a.addBuddy(b1);
        a.addBuddy(b2);

        assertTrue(a.getBuddies().equals(myBuddies));

    }

}