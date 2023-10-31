package ma.fstt.controller;

import ma.fstt.persistence.Classe;
import ma.fstt.persistence.Etudiant;
import ma.fstt.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/etudiant")
public class EtudiantController {
    @Autowired
    EtudiantService etudiantService;

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("etudiant", new Etudiant());
        return "addEtudiant";
    }
    @GetMapping("/save")
    public String save(Etudiant etudiant){
        etudiantService.addEtudiant(etudiant);
        return "redirect:/etudiant/all";
    }
    @GetMapping("/findByClasse/{idClasse}")
    public String findStudentsByClasse(Model model, @PathVariable("idClasse") Long idClasse) {
        List<Etudiant> etudiants = etudiantService.findByClasseId(idClasse);
        model.addAttribute("etudiants", etudiants);
        return "etudiantsByClass";
    }
    @GetMapping("/all")
    public String all(Model model){
        List<Etudiant> etudiantList = etudiantService.findAllEtudiants();
        model.addAttribute("listetudiants",etudiantList);
        return "listEtudiants";
    }
    @GetMapping("/delete/{idEtudiant}")
    public String delete(Model model, @PathVariable(value = "idEtudiant")Long idEtudiant){
        etudiantService.deleteEtudiant(idEtudiant);
        return "redirect:/etudiant/all";
    }
    @GetMapping("/update/{idEtudiant}")
    public String update(Model model, @PathVariable(value = "idEtudiant") Long idEtudiant){
        model.addAttribute("etudiant",etudiantService.findById(idEtudiant));
        return "addEtudiant";
    }
}
