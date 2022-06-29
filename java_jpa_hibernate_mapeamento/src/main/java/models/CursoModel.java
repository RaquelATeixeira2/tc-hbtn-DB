package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Curso;

public class CursoModel {
    public void create(Curso curso) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(curso);
            em.getTransaction().commit();
            System.out.println("Curso criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar um Curso !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public Curso findById(Curso Curso) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();
        Curso a = null;

        try{
            a = em.find(Curso.class, Curso.getId());
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        em.close();
        emf.close();

        return a;
    }

    public  List<Curso> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        List<Curso> Cursos = new ArrayList<Curso>();

        try{
            Cursos = em.createQuery("from Curso").getResultList();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        em.close();
        emf.close();

        return Cursos;
    }

    public void update(Curso Curso) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();

            em.merge(Curso);

            em.getTransaction().commit();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        em.close();
        emf.close();
    }

    public void delete(Curso Curso) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();

            Curso a = em.find(Curso.class, Curso.getId());
            em.remove(a);

            em.getTransaction().commit();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        em.close();
        emf.close();
    }
}
