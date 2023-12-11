package sg.edu.nus.iss.ssftest3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import sg.edu.nus.iss.ssftest3.service.NewsService;

@Controller
public class NewsController {

    @Autowired
    private NewsService svc;

    /*
     * ae ar at au be bg br ca ch cn co cu cz de eg fr gb gr hk hu id ie il in it jp kr lt lv ma mx my ng nl no nz ph pl pt ro rs ru sa se sg si sk th tr tw ua us ve za 
     */

    // ae,ar,at,au,be,bg,br,ca,ch,cn,co,cu,cz,de,eg,fr
    
    @GetMapping
    public String homePage(Model model) {
        String[] categories = { "business", "entertainment", "general", "health", "science", "sports", "technology"};
        model.addAttribute("categories", categories);
        model.addAttribute("countries", svc.getCountryNames());
        return "view1";
    }

}
