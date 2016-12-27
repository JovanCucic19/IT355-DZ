/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.route;

import com.mycompany.dao.ArtiklDao;
import com.mycompany.model.Artikl;
import java.awt.PageAttributes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class WeShopRestController {
    
    @Autowired
    ArtiklDao artiklDao;
    
    //metoda koja prikazuje sve produkte, tipa get, a proizvode prikazuje u JSON formatu
    @RequestMapping(value = "/artiklici", method = RequestMethod.GET)
    public ResponseEntity<List<Artikl>> getProducts() {
        System.out.println("Fetching products");
        List<Artikl> products = artiklDao.getAllArtikls();
        if (products.isEmpty()) {
            System.out.println("Product list empty");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Artikl>>(products, HttpStatus.OK);
    }
    
    //metoda koja po id-ju prikazuje jedan produkt. 
    //na adresi http://localhost:8080/HibernateCRUD/product/4 pozivamo ovu metodu
    //
    @RequestMapping(value = "/artiklic/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Artikl> getProduct(@PathVariable("id") int id) {
        System.out.println("Fetching product with id " + id);
        Artikl product = artiklDao.getArtiklById(id);
        if (product == null) {
            System.out.println("Product with " + id + " not found");
            return new ResponseEntity<Artikl>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Artikl>(product, HttpStatus.OK);
    }
    
    
    //metoda koja cuva proizvod u bazu
    @RequestMapping(value = "/artiklic/", method = RequestMethod.POST)
    public ResponseEntity<Void> addProduct(@RequestBody Artikl product) {
        System.out.println("Adding product " + product.toString());
        artiklDao.addArtiklic(product);
 
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
      
    //metoda koja po id-u nalazi i brise produkt iz baze
    @RequestMapping(value = "/artiklic/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Artikl> deleteProduct(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting product with id " + id);
 
        Artikl produc = artiklDao.getArtiklById(id);
        if (produc == null) {
            System.out.println("Unable to delete. Product with id " + id + " not found");
            return new ResponseEntity<Artikl>(HttpStatus.NOT_FOUND);
        }
 
        artiklDao.delete(produc);
        return new ResponseEntity<Artikl>(HttpStatus.OK);
    }
 
  
 
    
}
