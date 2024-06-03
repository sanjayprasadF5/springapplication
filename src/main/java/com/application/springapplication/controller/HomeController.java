// package com.application.springapplication.controller;

// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;

// @Controller
// public class HomeController {

//     @GetMapping("/")
//     public String index() {
//         return "index.html"; // This will return the index.html file from src/main/resources/static
//     }
// }
package com.application.springapplication.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/")
    public String index() {
        logger.info("Handling request to root endpoint");
        return "index.html"; // This will return the index.html file from src/main/resources/static
    }

    @GetMapping("/user-details")
    @ResponseBody
    public OidcUser userDetails(@AuthenticationPrincipal OidcUser oidcUser) {
        logger.info("Fetching user details");
        return oidcUser; // Returns user details as JSON response
    }
}
