package com.catalisa.biblioteca.security;

import com.catalisa.biblioteca.model.UserModel;
import com.catalisa.biblioteca.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel usuarioModel = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Esse usuário não foi encontrado!"));
        return new User(usuarioModel.getUsername(), usuarioModel.getPassword(), true, true, true, true,
                usuarioModel.getAuthorities());
    }
}
