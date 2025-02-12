package com.mayara.client_crud.services;
import com.mayara.client_crud.DTOs.ClientDTO;
import com.mayara.client_crud.entities.Client;
import com.mayara.client_crud.repositories.ClientRepository;
import com.mayara.client_crud.services.excepitions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id){
        Client client= clientRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Client not found"));
        return new ClientDTO(client);

    }
    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable){
      Page<Client> result = clientRepository.findAll(pageable);
      return result.map(x-> new ClientDTO(x));
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto){
        Client entity = new Client();
        copyToDTO(entity,dto);
        clientRepository.save(entity);
        return new ClientDTO(entity);

    }

    @Transactional
    public ClientDTO update(Long id,ClientDTO dto){
        try {
            Client entity = clientRepository.getReferenceById(id);
            copyToDTO(entity, dto);
            clientRepository.save(entity);
            return new ClientDTO(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Client not found");
        }
    }

    @Transactional
    public void delete(Long id){
        if(!clientRepository.existsById(id)){
            throw new ResourceNotFoundException("Client not found");
        }
        clientRepository.deleteById(id);
    }
    private void copyToDTO(Client entity, ClientDTO dto) {
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setChildren(dto.getChildren());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
    }

}
