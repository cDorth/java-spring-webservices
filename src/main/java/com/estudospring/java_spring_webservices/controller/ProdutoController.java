package com.estudospring.java_spring_webservices.controller;

import com.estudospring.java_spring_webservices.database.model.ProdutoEntity;
import com.estudospring.java_spring_webservices.dto.ProdutoDto;
import com.estudospring.java_spring_webservices.exception.NotFoundException;
import com.estudospring.java_spring_webservices.service.ProdutoService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoEntity> findAll(){
        return produtoService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoEntity createProduct(@RequestBody ProdutoDto produtoDto){
        return produtoService.createProduto(produtoDto);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoEntity updateProduct(@PathVariable Integer id,
                                       @RequestBody ProdutoDto produtoDto) throws NotFoundException {
        return produtoService.updateProduto(produtoDto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Integer id){
        produtoService.deleteProduto(id);
    }


}
