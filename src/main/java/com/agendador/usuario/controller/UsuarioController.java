package com.agendador.usuario.controller;

import com.agendador.usuario.business.UsuarioService;
import com.agendador.usuario.business.dto.UsuarioDTO;
import com.agendador.usuario.infrastructure.entity.Usuario;
import com.agendador.usuario.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {


    private final UsuarioService usuarioService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    @PostMapping

    public ResponseEntity<UsuarioDTO> salvarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioService.salvarUsuario(usuarioDTO));
    }

    @PostMapping("/login")
    public String login(@RequestBody UsuarioDTO usuarioDTO) {
        // Corrigindo a sintaxe da chamada ao método authenticate
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuarioDTO.getEmail(), usuarioDTO.getSenha())
        );

        // Corrigindo a chamada ao jwtUtil, passando o nome correto da autenticação
        return "Bearer" + jwtUtil.generateToken(authentication.getName());
    }

    @GetMapping
    public ResponseEntity<Usuario> buscarPorEmail(@RequestParam("email") String email) {
        return ResponseEntity.ok(usuarioService.buscarPorEmail(email));
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deletaUsuarioPorEmail(@PathVariable String email) {
        usuarioService.deletaUsuarioPorEmail(email);
        return ResponseEntity.ok().build();

    }
}
