package com.mycompany.route;

import com.mycompany.dao.ArtiklDao;
import com.mycompany.route.data.Artikl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    private ArtiklDao artiklDao;

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String printHello(ModelMap model) {
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/artikl")
    public ModelAndView dodavanjeArtikla(ModelMap model) {
        
        artiklDao.addArtikl();
        model.addAttribute("artikl", new Artikl());
        return new ModelAndView("artikl", "command", new Artikl());
    }

    @RequestMapping(value = "/dodavanjeArtikla", method  = RequestMethod.POST)
    public String addArtikl(@ModelAttribute Artikl artikl, ModelMap model) {
        model.addAttribute("titl", artikl.getTitl());
        model.addAttribute("cena", artikl.getCena());
        model.addAttribute("opis", artikl.getOpis());
        return "dodavanjeArtikla";
    }

}
