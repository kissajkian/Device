package br.com.santander.app.rest;

import br.com.santander.app.service.ContractionService;
import br.com.santander.app.dto.DeviceContracted;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/event")
class EventController {

    private static final Logger logger = LoggerFactory.getLogger(EventController.class);

    @Autowired
    private ContractionService service;

    @GetMapping("/contraction")
    public ResponseEntity<String> hello(@RequestBody DeviceContracted device) {
        logger.info("Recebendo dados de Contraction: ".concat(device.getDevice())
                .concat(" ReleaseDate: ".concat(device.getReleaseDate())
                        .concat(" ClientName: ".concat(device.getClientName()))));

        service.execute(device);

        return ResponseEntity.status(HttpStatus.CREATED).body("OK");
    }

}