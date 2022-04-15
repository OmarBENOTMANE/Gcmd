package org.backend.gdc.service;

import org.backend.gdc.dto.ClientDTO;
import org.backend.gdc.entity.ClientEntity;
import org.backend.gdc.exceptions.technical.ObjectNotFoundException;
import org.backend.gdc.mapper.ClientMapper;
import org.backend.gdc.repository.ClientRepository;
import org.backend.gdc.validator.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientMapper clientMapper;

    public ClientDTO findById(Long id) {
        Validate.notNull(id, "id mus be not null");
        Optional<ClientEntity> entity = clientRepository.findById(id);
        if (entity.isPresent()) {
            return clientMapper.convertToDto(entity.get());
        } else {
            throw new ObjectNotFoundException("ClientDTO not found");
        }
    }

    public ClientDTO save(ClientDTO dto) {
        Validate.notNull(dto, "ClientDTO must be not null");
        ClientEntity entity = clientMapper.convertToEntity(dto);

        ClientEntity saved = clientRepository.save(entity);
        return clientMapper.convertToDto(saved);
    }

    public ClientDTO update(ClientDTO dto) {
        Validate.notNull(dto, "ClientDTO must be not null");
        Validate.notNull(dto.getId(), "UserDTO id must be not null");
        findById(dto.getId());
        ClientEntity entity = clientMapper.convertToEntity(dto);
        ClientEntity saved = clientRepository.save(entity);
        return clientMapper.convertToDto(saved);

    }

    public void delete(Long id) {
        Validate.notNull(id, "Id must be not null");
        findById(id);
        clientRepository.deleteById(id);
    }

    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<ClientEntity> page = clientRepository.findAll(pageable);
        return clientMapper.convertToPageDto(page);

    }
}
