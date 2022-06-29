package models;

import entities.Aluno;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class AlunoModel {

    public void create(Aluno a) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            em.close();
            System.err.println("Erro ao criar aluno !!!" + e.getMessage());
        } finally {
            em.close();
        }
    }

    public Aluno findById(Aluno a) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();
        Aluno aluno = null;

        try{
            aluno = em.find(Aluno.class, a.getId());
        } catch (Exception e){
            System.err.println(e.getMessage());
        }

        em.close();
        emf.close();
        return aluno;
    }

    public List<Aluno> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();
        List<Aluno> alunos = new ArrayList<>();

        try{
            alunos = em.createQuery("from Aluno").getResultList();
        } catch (Exception e){
            System.err.println(e.getMessage());
        }

        em.close();
        emf.close();
        return alunos;
    }

    public void update(Aluno a) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();

            em.merge(a);

            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
            System.err.println(e.getMessage());
        }
        em.close();
        emf.close();
    }

    public void delete(Aluno a) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();

            Aluno aluno = em.find(Aluno.class, a.getId());
            em.remove(aluno);

            em.getTransaction().commit();
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        em.close();
        emf.close();
    }
}

