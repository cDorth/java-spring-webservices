package com.estudospring.java_spring_webservices.service;

import com.estudospring.java_spring_webservices.database.model.ProdutoEntity;
import com.estudospring.java_spring_webservices.dto.ProdutoDto;
import com.estudospring.java_spring_webservices.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private static final List<ProdutoEntity> PRODUTOS = new ArrayList<>();
    static{
       PRODUTOS.add(ProdutoEntity.builder()
                .id(1)
                .nome("cadeira")
                .preco(new BigDecimal(500))
                .quantidade(2)
                .build());

       PRODUTOS.add(ProdutoEntity.builder()
                .id(2)
                .nome("teclado")
                .preco(new BigDecimal(300))
                .quantidade(1)
                .build());
    }

    public List<ProdutoEntity> findAll(){
        return new ArrayList<>(PRODUTOS);
    }

    public ProdutoEntity createProduto(ProdutoDto produtoDto){

        Integer indentificador = PRODUTOS.stream()
                .mapToInt(ProdutoEntity::getId)
                .max()
                .orElse(0) + 1;

        ProdutoEntity novoProduto =   ProdutoEntity.builder()
                    .id(indentificador)
                    .nome(produtoDto.getNome())
                    .preco(produtoDto.getPreco())
                    .quantidade(produtoDto.getQuantidade())
                    .build();

        PRODUTOS.add(novoProduto);
        return novoProduto;
    }

    public ProdutoEntity updateProduto(ProdutoDto produtoDto, Integer id) throws NotFoundException {
        ProdutoEntity produto = PRODUTOS.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Produto não encontrado"));

        produto.setNome(produtoDto.getNome());
        produto.setPreco(produtoDto.getPreco());
        produto.setQuantidade(produtoDto.getQuantidade());

        return produto;
    }

    public void deleteProduto(Integer id){
        PRODUTOS.removeIf(p -> p.getId().equals(id));
    }

}
