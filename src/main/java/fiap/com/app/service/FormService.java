package fiap.com.app.service;

import fiap.com.app.models.Form;
import fiap.com.app.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormService {

    @Autowired
    private FormRepository formRepository;

    public List<Form> findAllForms(){
        return formRepository.findAll();
    }

    public Optional<Form> findFormById(Long id){
        return formRepository.findById(id);
    }

    public Form saveForm(Form form){
        return formRepository.save(form);
    }

    public void deleteFormById(Long id){
        formRepository.deleteById(id);
    }
}

