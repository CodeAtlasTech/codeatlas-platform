package com.codeatlas.backend.security;

import com.codeatlas.backend.entity.User;
import com.codeatlas.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.*;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {

    private final UserService userService;
    private final JwtService jwtService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException {

        OAuth2User oauthUser =
                (OAuth2User) authentication.getPrincipal();

        String provider = request.getRequestURI().contains("github")
                ? "GITHUB"
                : "GOOGLE";

        String email = oauthUser.getAttribute("email");
        String name = oauthUser.getAttribute("name");

        // 🔥 GitHub fix
        if ("GITHUB".equals(provider) && email == null) {
            String login = oauthUser.getAttribute("login");
            email = login + "@github.com";  // create unique email
        }

        if (email == null) {
            response.setContentType("application/json");
            response.getWriter().write("{\"error\":\"Email not found\"}");
            return;
        }

        if (name == null) {
            name = email;
        }

        User user = userService.saveOrGetUser(email, name, provider);

        String token = jwtService.generateToken(
                user.getEmail(),
                user.getName(),
                user.getRole()
        );



        response.setContentType("application/json");
        String jsonResponse = String.format("""
{
  "token": "%s",
  "user": {
    "email": "%s",
    "name": "%s",
    "role": "%s"
  }
}
""", token, user.getEmail(), user.getName(), user.getRole());

        response.getWriter().write(jsonResponse);
    }
}
    