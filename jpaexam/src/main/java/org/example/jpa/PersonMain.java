package org.example.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PersonMain {
    public static void main(String[] args) {
    }

    public static void create(){
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();
            Person person = new Person("carami");
            Passport passport = new Passport("123456789");

            person.setPerson(person);
            person.setPassport(passport);

            entityManager.persist(person);

            transaction.commit();

        }finally{
            entityManager.close();
        }
    }
}
