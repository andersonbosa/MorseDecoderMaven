package com.br.morsedecodermaven.controller;

import com.br.morsedecodermaven.service.MorseEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MorseCodeController {

    private final MorseEngine morseCode;

    @Autowired
    public MorseCodeController(MorseEngine morseCode) {
        this.morseCode = morseCode;
    }

    @GetMapping("/encode")
    public String encode(@RequestParam String input) {
        return this.morseCode.encode(input);
    }

    @GetMapping("/decode")
    public String decode(@RequestParam String input) {
        return this.morseCode.decode(input);
    }
}
