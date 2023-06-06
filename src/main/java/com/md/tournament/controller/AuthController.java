//package com.md.tournament.controller;
//
//import com.md.tournament.dto.AuthRequestDTO;
//import com.md.tournament.dto.AuthResponseDTO;
//import com.md.tournament.service.AuthService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/auth")
//@RequiredArgsConstructor
//public class AuthController {
//
//    private final AuthService authService;
//    @PostMapping
//    public ResponseEntity<AuthResponseDTO> getToken(@RequestBody AuthRequestDTO request){
//        return new ResponseEntity<>(authService.getToken(request), HttpStatus.OK);
//    }
//}
