/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;

import com.mycompany.dao.ArtiklDao;

public class ArtiklDaoImpl implements ArtiklDao {

    @Override
    public void addArtikl() {
        System.out.println("Dodajem artikl..");
    }

    @Override
    public String addArtiklRet() {
        System.out.println("Dodajem artikl i vracam vrednost..");
        return "dodato";
    }

    @Override
    public void addArtiklThrowException() throws Exception {
        System.out.println("Dodajem artikl, ali bacicu gresku");
        throw new Exception("Generic Error");
    }
    
}
