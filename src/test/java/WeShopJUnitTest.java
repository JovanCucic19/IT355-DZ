
import com.mycompany.dao.ArtiklDao;
import com.mycompany.model.Artikl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jovan
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/WeShop-servlet.xml"})
public class WeShopJUnitTest {

    @Autowired
    protected ArtiklDao artiklDao;

    @Before
    public void setUp() {

    }

//    @Test
    public void addArtiklTest() {
        Artikl artikl = new Artikl();
        artikl.setKnjiga_naziv("Prvi test naziv knjige");
        artikl.setKnjiga_cena(222);
        artikl.setKnjiga_opis("test opis");
        artikl.setKnjiga_slika("nesto");
        Artikl newArt = artiklDao.addArtiklic(artikl);
        artiklDao.delete(newArt);
        Assert.assertNotNull(newArt);
    }

//    @Test
    public void getArtiklByIdTest() {
        Artikl artikl = new Artikl();
        artikl.setKnjiga_naziv("Prvi test naziv knjige");
        artikl.setKnjiga_cena(222);
        artikl.setKnjiga_opis("test opis");
        artikl.setKnjiga_slika("nesto");
        Artikl newArt = artiklDao.addArtiklic(artikl);
        Artikl get = artiklDao.getArtiklById(newArt.getKnjiga_id());
        artiklDao.delete(get);
        Assert.assertNotNull(get);
    }

//    @Test
    public void getCountTest() {
        int get = artiklDao.getCount();
        Assert.assertNotNull(get);
    }

//    @Test
    public void deletArtiklTest() {
        Artikl artikl = new Artikl();
        artikl.setKnjiga_naziv("Prvi test naziv knjige");
        artikl.setKnjiga_cena(222);
        artikl.setKnjiga_opis("test opis");
        artikl.setKnjiga_slika("nesto");
        Artikl newArt = artiklDao.addArtiklic(artikl);
        Artikl deletedArtikl = artiklDao.getArtiklById(newArt.getKnjiga_id());
        artiklDao.delete(newArt);
        Assert.assertNotNull(deletedArtikl);
    }

//    @Test
    public void updateArtiklTest() {
        Artikl artikl = new Artikl();
        artikl.setKnjiga_naziv("Prvi test naziv knjige");
        artikl.setKnjiga_cena(222);
        artikl.setKnjiga_opis("test opis");
        artikl.setKnjiga_slika("nesto");
        Artikl newArt = artiklDao.addArtiklic(artikl);
        newArt.setKnjiga_naziv("Izmenjen naziv");
        artiklDao.updateArtikl(newArt);
        Assert.assertNotNull(newArt);
    }

    @Test
    public void getAllArtiklsTest() {
//        List<Artikl> artikli = Arrays.asList(
//                new Artikl(1, "Naziv 1", 111, "Opis prve", "Slika prve"),
//                new Artikl(2, "Naziv 2", 222, "Opis druge", "Slika druge"),
//                new Artikl(3, "Naziv 3", 333, "Opis trece", "Slika trece")
//        );
//        List<Artikl> dodatiArtikli = new ArrayList<>();
//        for (int i = 0; i < artikli.size(); i++) {
//            System.out.println(artikli.get(i).getKnjiga_naziv());
//            dodatiArtikli.add(artiklDao.addArtiklic(artikli.get(i)));
//        }
        
        List<Artikl> artikli =  artiklDao.getAllArtikls();
        for (int i = 0; i < artikli.size(); i++){
            System.out.println("Artikl: " + artikli.get(i).getKnjiga_naziv());
             Assert.assertNotNull(artikli.get(i));
        }
        
    }

}
