package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Aluno;

public class AlunoModel {

    public void create(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(aluno);
            em.getTransaction().commit();
            System.out.println("Aluno criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar um aluno !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public Aluno findById(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();
        Aluno a = null;

        try{
            a = em.find(Aluno.class, aluno.getId());
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        em.close();
        emf.close();

        return a;
    }

    public  List<Aluno> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        List<Aluno> alunos = new ArrayList<Aluno>();

        try{
            alunos = em.createQuery("from Aluno").getResultList();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        em.close();
        emf.close();

        return alunos;
    }

    public void update(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();

            em.merge(aluno);

            em.getTransaction().commit();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        em.close();
        emf.close();
    }

    public void delete(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();

            Aluno a = em.find(Aluno.class, aluno.getId());
            em.remove(a);

            em.getTransaction().commit();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        em.close();
        emf.close();
    }
}