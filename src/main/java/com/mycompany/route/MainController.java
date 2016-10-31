package com.mycompany.route;

import com.mycompany.route.data.Artikl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class MainController {

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String printHello(ModelMap model) {
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/artikl")
    public String dodavanjeArtikla(ModelMap model) {
        model.addAttribute("artikl", new Artikl());
        return "artikl";
    }

    @RequestMapping(value = "/dodavanjeArtikla", method
            = RequestMethod.POST)
    public String addArtikl(@ModelAttribute Artikl artikl,
            ModelMap model) {
        model.addAttribute("titl", artikl.getTitl());
        model.addAttribute("cena", artikl.getCena());
        model.addAttribute("opis", artikl.getOpis());
        return "dodavanjeArtikla";
    }

}
