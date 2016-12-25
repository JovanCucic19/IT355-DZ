package com.mycompany.dao;

import com.mycompany.model.Artikl;
import java.util.List;


public interface ArtiklDao {

    public void addArtikl();

    public String addArtiklRet();

    public void addArtiklThrowException() throws Exception;
    
    public int getCount();

    public List<Artikl> getAllArtikls();

    public Artikl addArtiklic(Artikl artikl);
    
    public boolean updateArtikl(Artikl artikl);
    
    public Artikl getArtiklById(int id);
    
    public void delete(Artikl artikl);
    

}
