package br.com.generate.jwt.service;

import br.com.generate.jwt.model.JwtRequest;
import br.com.generate.jwt.model.JwtResponse;
import br.com.generate.jwt.model.User;
import br.com.generate.jwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public String save(JwtRequest request) {
        User user = User.builder()
                .email(request.getUsername())
                .password(new BCryptPasswordEncoder().encode(request.getPassword()))
                .build();
        repository.save(user);
        return "Salvo com sucesso";
    }
    public User getByEmail(String email) {
        return repository.findByEmail(email);
    }

}
