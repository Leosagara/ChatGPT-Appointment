package fiap.com.app.controller;

import fiap.com.app.models.Form;
import fiap.com.app.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/form")
public class FormController {

    @Autowired
    private FormService formService;

    @GetMapping
    public String menu(Model model){
        model.addAttribute("form",formService.findAllForms());
        return "forms/menu";
    }

    @GetMapping("/response")
    public String response(@ModelAttribute("createdForm") Form createdForm, Model model){
        createdForm.setPrompt(createdForm.generatePrompt());
        createdForm.setPrompt(createdForm.generatePrompt());
        System.out.println(createdForm.getResponse());
        return "forms/response";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("form", new Form());
        return "forms/form";
    }

    @PostMapping
    public String saveForm(@ModelAttribute Form form) throws IOException, InterruptedException {
        form.setPrompt(form.generatePrompt());
        form.setResponse(form.generateResponse(form));
        formService.saveForm(form);
        return "redirect:form/response";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Form form = formService.findFormById(id).orElseThrow(() -> new IllegalArgumentException("Formulário não encotrado Id: " + id));
        model.addAttribute("form", form);
        return "forms/form";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable Long id, @ModelAttribute Form form) {
        formService.saveForm(form);
        return "forms/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable Long id) {
        formService.deleteFormById(id);
        return "redirect:/form";
    }



}