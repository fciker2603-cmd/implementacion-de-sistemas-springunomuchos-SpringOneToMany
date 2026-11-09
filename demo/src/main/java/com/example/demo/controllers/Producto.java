package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.repo.productoRepo;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class Producto {
  private final productoRepo repo;

  public Producto(productoRepo repo) {
    this.repo = repo;
  }

@GetMapping("productos")
  public List<Product> findAllProductos() {
    return this.repo.findAll();
  }

@PostMapping("producto")
  public Product addProducto(@RequestBody Product producto) {
    return repo.save(producto);
  }

@GetMapping("producto/{id}")
public Optional<Product> getById(@PathVariable String id) {
    return repo.findById(id);
}


@PutMapping("producto/{id}")
public Product putProduct(@PathVariable String id, @RequestBody Product product) {
    product.setId(id);
    return repo.save(product);
}

@DeleteMapping("producto/{id}")
public String deleteMailbox(@PathVariable("id") String id) {
    repo.deleteById(id);
    return "{\"success\":true}";
}

}
