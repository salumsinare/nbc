/*
 *  Author            : Salum Sinare
 *  Author id         : A243345
 *  Author email      : salum.sinare@stanbic.co.tz
 *  Organization      : Stanbic Bank Tanzania LTD
 *  Organization Unit : Software Engineering
 *  Copyright (C) 2022

 *  Created on 20 Sep 2022
 */
package tz.salum.sinare.nbc.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tz.salum.sinare.nbc.model.*;

/**
 *
 * @author A243345
 */
@Slf4j
@RestController
public class ApiController {

    @Autowired
    public UploadRepository repository;

    @PostMapping("/bank-b-engine/api/v1/transactions")
    public ResponseEntity<String> post(@RequestHeader("instituion-name") XY header,
            @RequestParam("file") MultipartFile file) {

        // Save the file in db
        PartnersTransactions a = new PartnersTransactions();
        a.setName(StringUtils.cleanPath(file.getOriginalFilename()));
        a.setType(file.getContentType());
        a.setInstitution(header);
        a.setUplodedOn(LocalDateTime.now());
        try {
            a.setData(file.getBytes());
            a = repository.save(a);
            log.info("Uploaded document : " + a);
            return ResponseEntity.ok("file received and saved");
        } catch (IOException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Could not save the file");
        }
    }
}
