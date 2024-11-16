package edu.unicen.exa.gateway.Controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import edu.unicen.exa.gateway.Services.UserService;
import edu.unicen.exa.gateway.Services.Dto.User.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping
    public ResponseEntity<?> saveUser( @RequestBody @Valid UserDTO userDTO) {
        final var id = userService.saveUser( userDTO );
        return new ResponseEntity<>( id, HttpStatus.CREATED );
    }
}

