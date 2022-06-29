package models;

import entities.Curso;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class CursoModel {

    public void create(Curso c) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            em.close();
            System.err.println("Erro ao criar curso !!!" + e.getMessage());
        } finally {
            em.close();
        }
    }

    public Curso findById(Curso c) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();
        Curso curso = null;

        try{
            curso = em.find(Curso.class, c.getId());
        } catch (Exception e){
            System.err.println(e.getMessage());
        }

        em.close();
        emf.close();
        return curso;
    }

    public List<Curso> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();
        List<Curso> cursos = new ArrayList<>();

        try{
            cursos = em.createQuery("from Curso").getResultList();
        } catch (Exception e){
            System.err.println(e.getMessage());
        }

        em.close();
        emf.close();
        return cursos;
    }

    public void update(Curso c) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();

            em.merge(c);

            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
            System.err.println(e.getMessage());
        }
        em.close();
        emf.close();
    }

    public void delete(Curso c) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();

            Curso curso = em.find(Curso.class, c.getId());
            em.remove(curso);

            em.getTransaction().commit();
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        em.close();
        emf.close();
    }
}
