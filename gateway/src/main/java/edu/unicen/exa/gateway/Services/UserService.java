package edu.unicen.exa.gateway.Services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import edu.unicen.exa.gateway.Entities.User;
import edu.unicen.exa.gateway.Repositories.AuthorityRepository;
import edu.unicen.exa.gateway.Repositories.UserRepository;
import edu.unicen.exa.gateway.Services.Dto.User.UserDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthorityRepository authorityRepository;

    public long saveUser( UserDTO request ) {
        final var user = new User( request.getUsername() );
        user.setPassword( passwordEncoder.encode( request.getPassword() ) );
        final var roles =  this.authorityRepository.findAllById( request.getAuthorities() );
        user.setAuthorities( roles );
        final var result = this.userRepository.save( user );
        return result.getId();
    }
}
