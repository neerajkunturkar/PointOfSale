package com.pos.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pos.app.dto.ErrorDto;
import com.pos.app.dto.UserDto;
import com.pos.app.dto.order.SuccessDto;
import com.pos.app.model.core.User;
import com.pos.app.services.SecurityService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 4/13/2018.
 */

@RestController
@RequestMapping(value = "/")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private transient SecurityService securityService;
    @Autowired(required = true)
    private HttpServletRequest request;

    /**
     * Authentication of the user.
     *
     * @return User
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> authenticate(@RequestBody final UserDto userDto) {

        String error;
        ModelMapper modelMapper = new ModelMapper();

        try {
            User user = modelMapper.map(userDto, User.class);
            User authenticatedUser = securityService.validUser(user);
            if (authenticatedUser == null) {
                Map map = new HashMap<String, String>();
                map.put("error", "Invalid Crdentials.");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(map);
            }

            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(authenticatedUser);
        } catch (Exception e) {
            logger.error("Error while authenticating the User.", e);
            error = e.getMessage();
        }
        Map map = new HashMap<String, String>();
        map.put("error", error);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> logout() {

        String error;

        try {
            User authenticatedUser = (User) request.getSession().getAttribute("SESSION_USER");
            securityService.releaseToken(authenticatedUser);
            if (authenticatedUser == null) {
                ErrorDto errorDto = new ErrorDto();
                errorDto.setMessage("Invalid Credentials.");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorDto);
            }

            SuccessDto successDto = new SuccessDto();
            successDto.setMessage("User is successfully Logout.");
            return ResponseEntity.status(HttpStatus.OK).body(successDto);
        } catch (Exception e) {
            logger.error("Error while logging out the User.", e);
            error = e.getMessage();
        }

        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("Something went wrong, please contact the Administrator");
        errorDto.setError(error);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDto);
    }
}
