package com.catalisa.biblioteca.service;

import com.catalisa.biblioteca.model.UserModel;
import com.catalisa.biblioteca.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserModel> listAll() {
        return userRepository.findAll();
    }

    public Optional<UserModel> findById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<UserModel> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public UserModel create(UserModel userModel) {
        return userRepository.save(userModel);
    }

    public Optional<UserModel> update(Long id, UserModel userModel) {
        Optional<UserModel> optionalUser = userRepository.findById(id);
        optionalUser.ifPresent(model -> BeanUtils.copyProperties(userModel, model, "id_usuario"));

        return optionalUser;
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
