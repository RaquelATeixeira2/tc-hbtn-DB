package demo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entities.Aluno;
import entities.Curso;
import entities.Endereco;
import entities.MaterialCurso;
import entities.Professor;
import entities.Telefone;
import models.AlunoModel;
import models.CursoModel;

public class GestaoCursosMain {
    public static void main(String[] args) {

        CursoModel cursoModel = new CursoModel();
        AlunoModel alunoModel = new AlunoModel();
        List<Aluno> alunos;
        List<Curso> cursos;

        Telefone tel1 = new Telefone();
        tel1.setDdd("11");
        tel1.setNumero("98492-4325");

        Telefone tel2 = new Telefone();
        tel2.setDdd("81");
        tel2.setNumero("97824-49214");

        Telefone tel3 = new Telefone();
        tel3.setDdd("96");
        tel3.setNumero("44325-2352");

        Endereco end1 = new Endereco();
        end1.setLogradouro("Avenida");
        end1.setEndereco("Antonio Agu");
        end1.setNumero("232");
        end1.setBairro("Vila Campesina");
        end1.setCidade("Osasco");
        end1.setEstado("Sao Paulo");
        end1.setCep(43244000);


        Endereco end2 = new Endereco();
        end2.setLogradouro("Rua");
        end2.setEndereco("Primitiva Avianco");
        end2.setNumero("987");
        end2.setBairro("Vila Campesina");
        end2.setCidade("Osasco");
        end2.setEstado("Sao Paulo");
        end2.setCep(46344000);

        //Criando alunos

        System.out.println("Criando dois Alunos: Aluno-1 com Telefone-3 Endereco-1 e Aluno2 com Telefone 2 Telefone 1 Endereco 2");
        Aluno aluno1 = new Aluno();
        Aluno aluno2 = new Aluno();

        aluno1.setNomeCompleto("Elizabeth Micari");
        aluno1.setMatricula("01-ALUNE");
        aluno1.setNascimento(LocalDate.of(2004, 2, 24));
        aluno1.setEmail("lis@alune.com");
        aluno1.setTelefones(new ArrayList<Telefone>(List.of(tel3)));
        aluno1.setEnderecos(new ArrayList<Endereco>(List.of(end1)));

        aluno2.setNomeCompleto("Gavriel Nascimento");
        aluno2.setMatricula("02-ALUNE");
        aluno2.setNascimento(LocalDate.of(2001, 4, 12));
        aluno2.setEmail("gav@alune.com");
        aluno2.setTelefones(new ArrayList<Telefone>(List.of(tel1, tel2)));
        aluno2.setEnderecos(new ArrayList<Endereco>(List.of(end2)));

        alunoModel.create(aluno1);
        alunoModel.create(aluno2);

        //Buscando Alunos pelo ID

        System.out.println("Buscando Aluno-1 e Aluno-2");
        Aluno searchAlunoId1 = new Aluno();
        Aluno searchAlunoId2 = new Aluno();

        searchAlunoId1.setId(1L);
        searchAlunoId1 = alunoModel.findById(searchAlunoId1);
        searchAlunoId2.setId(2L);
        searchAlunoId2 = alunoModel.findById(searchAlunoId2);
        System.out.println(searchAlunoId1);
        System.out.println(searchAlunoId2);

        //Deletando Aluno-1

        System.out.println("Deletando Aluno-1");
        Aluno deleteAluno = new Aluno();
        deleteAluno.setId(1L);
        alunoModel.delete(deleteAluno);

        //Buscando todos os alunos
        alunos = alunoModel.findAll();
        System.out.println(alunos);

        //Atualizando Nome do Aluno e mudando numero do Telefone-3
        System.out.println("Atualizando Nome do Aluno-2 e mudando numero do Telefone-3");
        Aluno updateAluno = new Aluno();
        updateAluno.setId(2L);
        updateAluno = alunoModel.findById(updateAluno);
        updateAluno.setNomeCompleto("Bella Oliveira");
        updateAluno.getTelefones().forEach(telefone -> {
            if (telefone.getId() == 3L){
                telefone.setNumero("87878-8787");
            }
        });
        alunoModel.update(updateAluno);


        Professor prof1 = new Professor();
        prof1.setNomeCompleto("Logan");
        prof1.setMatricula("01-PROF");
        prof1.setEmail("wolverine@prof.com");
        Professor prof2 = new Professor();
        prof2.setId(1L);

        MaterialCurso material1 = new MaterialCurso();
        material1.setUrl("www.alura.com");

        MaterialCurso material2 = new MaterialCurso();
        material2.setUrl("www.origamid.com");

        //Criando Curso com professor e material
        System.out.println("Criando cursos com o mesmo Professor");
        Curso curso1 = new Curso();
        curso1.setNome("BackEnd");
        curso1.setSigla("BE");
        curso1.setProfessor(prof1);
        curso1.setMaterialCurso(material1);

        Curso curso2 = new Curso();
        curso2.setNome("FrontEnd");
        curso2.setSigla("FE");
        curso2.setProfessor(prof2);
        curso2.setMaterialCurso(material2);

        cursoModel.create(curso1);
        cursoModel.create(curso2);

        //Buscando Cursos pelo ID

        System.out.println("Buscando cursos pelo ID");
        Curso searchCursoId1 = new Curso();
        Curso searchCursoId2 = new Curso();
        searchCursoId1.setId(1L);
        searchCursoId2.setId(2L);
        searchCursoId1 = cursoModel.findById(searchCursoId1);
        searchCursoId2 = cursoModel.findById(searchCursoId2);
        System.out.println(searchCursoId1);
        System.out.println(searchCursoId2);

        //Deletando Curso
        System.out.println("Deletando Curso-2");
        Curso deleteCurso = new Curso();
        deleteCurso.setId(2L);
        cursoModel.delete(deleteCurso);

        Professor prof3 = new Professor();
        prof3.setNomeCompleto("Larissa Moreira");
        prof3.setMatricula("02-PROF");
        prof3.setEmail("moreira@prof.com");

        //Atualizando Nome, Professor e Material
        System.out.println("Atualizando Nome, Professor e Material");
        Curso updateCurso = new Curso();
        updateCurso.setId(1L);
        updateCurso = cursoModel.findById(updateCurso);
        updateCurso.setNome("HTML");
        updateCurso.setProfessor(prof3);
        updateCurso.getMaterialCurso().setUrl("www.origamid.com/html");
        cursoModel.update(updateCurso);


        //Buscando todos os Cursos
        System.out.println("Buscando todos os Cursos");
        cursos = cursoModel.findAll();
        System.out.println(cursos);

        //Atualizando o Curso com um novo aluno
        System.out.println("Adicionando um aluno ao Curso");
        updateCurso = cursoModel.findById(updateCurso);
        searchAlunoId1 = alunoModel.findById(searchAlunoId1);
        updateCurso.setAluno(new ArrayList<Aluno>(List.of(searchAlunoId1)));
        cursoModel.update(updateCurso);

        //Buscando todos os cursos outra vez
        System.out.println("Buscando todos os Cursos");
        cursos = cursoModel.findAll();
        System.out.println(cursos);

    }
}
