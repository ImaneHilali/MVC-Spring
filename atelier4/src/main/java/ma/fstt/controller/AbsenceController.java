package ma.fstt.controller;

import ma.fstt.persistence.Absence;
import ma.fstt.persistence.Classe;
import ma.fstt.service.AbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/absence")
public class AbsenceController {

    @Autowired
    AbsenceService absenceService;

    @GetMapping("/add/{idEtudiant}")
    public String add(Model model){
        model.addAttribute("absence", new Absence());
        return "addAbsence";
    }

    @GetMapping("/save")
    public String save(Absence absence) {
        absenceService.addAbsence(absence);
        return "redirect:/etudiant/all";
    }
}
