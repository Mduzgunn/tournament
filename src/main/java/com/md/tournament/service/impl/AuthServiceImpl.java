//package com.md.tournament.service.impl;
//
//import com.md.tournament.dto.AuthRequestDTO;
//import com.md.tournament.dto.AuthResponseDTO;
//import com.md.tournament.model.User;
//import com.md.tournament.exception.CommonException;
//import com.md.tournament.repository.UserRepository;
//import com.md.tournament.service.AuthService;
//import com.md.tournament.util.JwtUtil;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//@Slf4j
//public class AuthServiceImpl implements AuthService {
//    private final UserRepository authRepository;
//
//    private final JwtUtil jwtUtil;
//
//    public AuthResponseDTO getToken(AuthRequestDTO request){
//        if (authRepository.findByEmail(request.getEmail()) == null) {
//            throw new CommonException("User Email not found", HttpStatus.NOT_FOUND);
//        }
//        User user = authRepository.findByEmail(request.getEmail());
//
//        if (!isValidPassword(user.getPassword(), request.getPassword())) {
//            log.error("User's password not valid " + request.getEmail());
//            throw new CommonException("User's password not valid", HttpStatus.BAD_REQUEST);
//        }
//
//        return new AuthResponseDTO(jwtUtil.generateToken(user));
//    }
//
//    public static boolean isValidPassword(String password, String password2) {
//        return password.equals(password2);
//    }
//}
