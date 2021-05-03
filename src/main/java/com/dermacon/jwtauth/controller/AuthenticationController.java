package com.dermacon.jwtauth.controller;

import com.dermacon.jwtauth.data.Credentials;
import com.dermacon.jwtauth.exception.CredentialsException;
import com.dermacon.jwtauth.response.ErrorInfo;
import com.dermacon.jwtauth.response.JWTTokenResponse;
import com.dermacon.jwtauth.service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.CONFLICT;

@RestController
@RequestMapping
public class AuthenticationController {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private AuthenticationService authenticationService;

    /**
     * https://attacomsian.com/blog/set-cookie-with-response-entity-in-spring-boot
     * @param credentials credentials from the user
     * @return token for the given user
     */
    @PostMapping("/create-token")
    public ResponseEntity<String> createToken(@RequestBody Credentials credentials) {
        JWTTokenResponse jwtToken = authenticationService.generateJWTToken(credentials);
        return new ResponseEntity<>(jwtToken.getToken(), HttpStatus.OK);
    }

    @PostMapping("/health")
    public String isAlive_post() {
        log.info("token provider is alive - post");
        return "token provider is alive - post";
    }

    @GetMapping("/health")
    public String isAlive_get() {
        log.info("token provider is alive - get");
        return "token provider is alive - get";
    }

    /**
     * Handles exception thrown by service.
     * To centralize exception handling use @ControllerAdvice annotation
     * src: https://www.toptal.com/java/spring-boot-rest-api-error-handling
     * see also: https://howtodoinjava.com/spring-core/spring-exceptionhandler-annotation/
     * @param ex
     * @return
     */
    @ExceptionHandler({CredentialsException.class})
    @ResponseStatus(CONFLICT)
    @ResponseBody
    public ErrorInfo handleEntityNotFoundException(HttpServletRequest req, Exception ex) {
        return ErrorInfo.builder()
                .url(req)
                .status(CONFLICT)
                .exception(ex)
                .build();
    }

}
