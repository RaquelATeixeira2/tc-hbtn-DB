package demo;

import entities.*;
import models.AlunoModel;
import models.CursoModel;

import javax.swing.event.MenuDragMouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class GestaoCursosMain {
    public static void main(String[] args) {
        Endereco endereco = new Endereco();
        Telefone telefone = new Telefone();

        endereco.setEndereco("Rua Oitenta");
        endereco.setLogradouro("Rua Oitenta");
        endereco.setBairro("Curado");
        endereco.setCep("54000000");
        endereco.setCidade("Garanhuns");
        endereco.setEstado("Pernambuco");
        endereco.setNumero("80");

        telefone.setDdd("081");
        telefone.setNumero("88889988");


        Aluno aluno = new Aluno();
        aluno.setEnderecos(Arrays.asList(endereco));
        aluno.setTelefones(Arrays.asList(telefone));


        MaterialCurso materialCurso = new MaterialCurso();
        materialCurso.setUrl("algaworks.com.br");

        Curso curso = new Curso();
        curso.setNome("Micros Serviços");
        curso.setMaterialCurso(materialCurso);
        curso.setSigla("Spring Boot");

        Professor professor = new Professor();
        professor.setNome("Flávio Medeiros");
        professor.setEmail("flavio@medeiros.com");
        professor.setMatricula("1548");
        professor.setCursos(Arrays.asList(curso));

        AlunoModel alunoModel = new AlunoModel();
        CursoModel cursoModel = new CursoModel();

        cursoModel.create(curso);
        alunoModel.create(aluno);


    }
}
