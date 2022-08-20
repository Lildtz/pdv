package com.all.pdv.service;

import com.all.pdv.dto.UserDTO;
import com.all.pdv.entity.User;
import com.all.pdv.exceptions.NoItemException;
import com.all.pdv.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(user -> new UserDTO(user.getId(), user.getName(), user.isEnabled())).collect(Collectors.toList());
    }
    public UserDTO save(UserDTO user) {
        User userToSave = new User();
        userToSave.setEnabled(user.isEnabled());
        userToSave.setName(user.getName());

        userRepository.save(userToSave);

        return new UserDTO(userToSave.getId(), userToSave.getName(), userToSave.isEnabled());
    }
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    public UserDTO update(UserDTO user) {
        User userToSave = new User();
        userToSave.setEnabled(user.isEnabled());
        userToSave.setName(user.getName());
        userToSave.setId(user.getId());

        Optional<User> userEdit = userRepository.findById(userToSave.getId());

        if (userEdit.isEmpty()) {
            throw new NoItemException("Usuário não encontrado!");
        }
        userRepository.save(userToSave);
        return new UserDTO(userToSave.getId(), userToSave.getName(), userToSave.isEnabled());
    }
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }
}
