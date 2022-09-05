package uk.co.which.forensicsapi.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.which.forensicsapi.exception.IncorrectGuesslException;
import uk.co.which.forensicsapi.model.NavigationData;
import uk.co.which.forensicsapi.model.Position;
import uk.co.which.forensicsapi.service.ForensicsNavigationDataService;
import uk.co.which.forensicsapi.utils.ForensicsUtils;

import javax.validation.constraints.NotNull;

@OpenAPIDefinition(
        info = @Info(
                title = "Which UK Forensics API",
                description = "This API to designed to find the Missing the Cats",
                termsOfService = "General Usage",
                license = @License(
                        name = "Apache 2.0",
                        url = "http://which.co.uk"),
                version = "v1"
        ))
@Tag(name = "Forensics API", description = "The below API are helpful to find the missing cats")
@RestController
@RequestMapping("/api/v1")
@Slf4j
public class ForensicsController {

    private static int counter = 5;

    @GetMapping("/heartbeat")
    public ResponseEntity heartBeat(){
        return new ResponseEntity(HttpStatus.OK);
    }

    @Autowired
    ForensicsNavigationDataService service;

    @Autowired
    ForensicsUtils utils;

    @GetMapping("/{email}/directions")
    public ResponseEntity<NavigationData> directions(@PathVariable @Validated String email){
        log.info("directions API CALL Revived at {} with email {}", System.currentTimeMillis(), email);
        counter = 5;
        log.debug("counter reset to 5");
        if(!utils.userAuthenticated(email)){
            log.debug("The user is un authorised");
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
        NavigationData navigationData = service.fetchNavigationData();
        return new ResponseEntity<NavigationData>(navigationData,HttpStatus.OK);
    }

    @GetMapping("/{email}/location/{x}/{y}")
    public ResponseEntity<String> findLocation(@PathVariable @Validated @NotNull String email, @NotNull @PathVariable("x")  int xPosition, @NotNull @PathVariable("y") int yPosition){
        log.info("location API CALL Revived at {} ", System.currentTimeMillis());
        log.debug("User Given Positions are x {}, y {}", xPosition, yPosition);
        if(!utils.userAuthenticated(email)){
            log.debug("The user is un authorised");
            return new ResponseEntity("We are Sorry !!! your request is failed to Authorised to use this API", HttpStatus.UNAUTHORIZED);
        }

        if(counter == 0){
            return new ResponseEntity("We are Sorry !!! you are only allowed for 5 Guess", HttpStatus.FORBIDDEN);
        }

        boolean positionFound = service.findFinalPosition(new Position(xPosition, yPosition));

        if(!positionFound){
            counter--;
            throw new IncorrectGuesslException("Oops !!! It was a Wrong Guess :(.");
        }

        return new ResponseEntity<String>("Hey You found the Cats !!! Congratulations !!!",HttpStatus.OK);


    }
}
