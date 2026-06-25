package org.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StudentMain {
   public static void find(){
      EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
      try {
          School school = em.find(School.class, 1L);
          log.info("School Name: {}", school.getName());

          Student student = em.find(Student.class, 1L);
          log.info("Student Name: {}", student.getName());
          log.info("Student School: {}", student.getSchool().getName());
      }finally {
          em.close();
          JPAUtil.close();
      }
   }

    //    생성
    public static void create(){
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        try {
            School school = new School("멋사학교");
            entityManager.persist(school);

            entityManager.getTransaction().commit();
        }finally {
            entityManager.close();
        }
    }

    //    수정
    public static void update(){
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {

        }finally {
            entityManager.close();
        }
    }


    //    삭제
    public static void delete(){
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {

        }finally {
            entityManager.close();
        }
    }

   public static void main(String[] args) {
       find();
   }

}
