package fiap.com.app.service;

import fiap.com.app.models.Client;
import fiap.com.app.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAllClients(){
        return clientRepository.findAll();
    }

    public Optional<Client> findClientById(Long id){
        return clientRepository.findById(id);
    }

    public Client saveClient(Client client){
        return clientRepository.save(client);
    }

    public void deleteClientById(Long id){
        clientRepository.deleteById(id);
    }
}
