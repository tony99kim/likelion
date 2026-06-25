package org.example.jpa;

import jakarta.persistence.EntityManager;

public class EmployeeMain {
    public static void main(String[] args){
        create();
    }

    public static void create(){
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        try {
            Employee employee = new Employee("Taeyeop");
            Project project = new Project();
            project.setTitle("lion project");

//            Project project = entityManager.find(Project.class, 1L);
            employee.getProjects().add(project);
            project.getEmployees().add(employee);

            entityManager.persist(project);
            entityManager.persist(employee);

            entityManager.getTransaction().commit();
        }finally {
            entityManager.close();
        }
    }

    public static void find(){
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        try {
            Employee employee = entityManager.find(Employee.class, 1L);
            Project project = entityManager.find(Project.class, 1L);
            System.out.println(employee);
            System.out.println(project);
        }finally {
            entityManager.close();
        }
    }
}
