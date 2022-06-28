package demo;

import java.util.List;

import entities.Produto;
import models.ProdutoModel;

public class AdmnistrativoApp {
    public static void main(String[] args) {
        ProdutoModel produtoModel = new ProdutoModel();

        Produto p1 = new Produto();
        p1.setNome("TV");
        p1.setPreco(300.0);
        p1.setQuantidade(100);
        p1.setStatus(true);

        Produto p2 = new Produto();
        p2.setNome("Sofa");
        p2.setPreco(100.0);
        p2.setQuantidade(130);
        p2.setStatus(true);

        // 1) Criando um produto
        produtoModel.create(p1);

        //2) Buscando todos os produtos na base de dados
        List<Produto> produtos = produtoModel.findAll();
        System.out.println("Qtde de produtos encontrados : " + produtos.size());

        // TODO - Testar os demais metódos das classes: ProdutoModel e PessoaModel
        //3) Atualizando um produto
        p1.setNome("Armario");
        p1.setPreco(400.0);
        p1.setQuantidade(320);
        p1.setStatus(false);
        produtoModel.update(p1);
        System.out.println("Produto atualizado");

        System.out.println("Produtos: " + produtoModel.findAll());

        produtoModel.delete(p1);
        System.out.println("Produto deletado");

        System.out.println("Produtos: " + produtoModel.findAll());

        System.out.println("Criando outro produto");
        produtoModel.create(p2);

        System.out.println("Procurando por ID");
        System.out.println("Id: " + p2.getId() + "Produto encontrado" + produtoModel.findById(p2));

    }
}
