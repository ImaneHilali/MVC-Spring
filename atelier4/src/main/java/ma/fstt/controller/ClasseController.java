package ma.fstt.controller;

import ma.fstt.persistence.Classe;
import ma.fstt.persistence.Etudiant;
import ma.fstt.service.ClasseService;
import ma.fstt.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/classe")
public class ClasseController {

    @Autowired
    ClasseService classeService;
    @Autowired
    EtudiantService etudiantService;

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("classe", new Classe());
        return "addClasse";
    }
    @GetMapping("/save")
    public String save(Classe classe){
        classeService.addClasse(classe);
        return "redirect:/classe/all";
    }
    @GetMapping("/addEtudiantToClasse")
    public String addEtudiantToClasse(@RequestParam("idClasse") Long idClasse, @RequestParam("idEtudiant") Long idEtudiant) {
        classeService.addEtudiantToClasse(idClasse, idEtudiant);
        return "redirect:/classe/all";
    }
    @GetMapping("/all")
    public String all(Model model){
        List<Classe> classeList = classeService.findAllClasses();
        model.addAttribute("listclasses",classeList);
        return "listClasses";
    }
    @GetMapping("/delete/{idClasse}")
    public String delete(Model model, @PathVariable(value = "idClasse") Long idClasse){
        classeService.deleteClasse(idClasse);
        return "redirect:/classe/all";
    }
    @GetMapping("/update/{idClasse}")
    public String update(Model model, @PathVariable(value = "idClasse") Long idClasse){
        model.addAttribute("classe",classeService.findById(idClasse));
        return "addClasse";
    }

}
