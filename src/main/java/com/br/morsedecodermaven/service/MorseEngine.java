package com.br.morsedecodermaven.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MorseEngine {

    private static final Map<Character, String> MORSE_MAP = new HashMap<>();

    private static final String DIVIDER = "   ";

    static {
        MORSE_MAP.put('A', ".-");
        MORSE_MAP.put('B', "-...");
        MORSE_MAP.put('C', "-.-.");
        MORSE_MAP.put('D', "-..");
        MORSE_MAP.put('E', ".");
        MORSE_MAP.put('F', "..-.");
        MORSE_MAP.put('G', "--.");
        MORSE_MAP.put('H', "....");
        MORSE_MAP.put('I', "..");
        MORSE_MAP.put('J', ".---");
        MORSE_MAP.put('K', "-.-");
        MORSE_MAP.put('L', ".-..");
        MORSE_MAP.put('M', "--");
        MORSE_MAP.put('N', "-.");
        MORSE_MAP.put('O', "---");
        MORSE_MAP.put('P', ".--.");
        MORSE_MAP.put('Q', "--.-");
        MORSE_MAP.put('R', ".-.");
        MORSE_MAP.put('S', "...");
        MORSE_MAP.put('T', "-");
        MORSE_MAP.put('U', "..-");
        MORSE_MAP.put('V', "...-");
        MORSE_MAP.put('W', ".--");
        MORSE_MAP.put('X', "-..-");
        MORSE_MAP.put('Y', "-.--");
        MORSE_MAP.put('Z', "--..");
        MORSE_MAP.put(' ', DIVIDER);
    }

    public String encode(String text) {
        StringBuilder morse = new StringBuilder();

        char[] charArray = text.toUpperCase().toCharArray();
        for (char c : charArray) {
            if (MORSE_MAP.containsKey(c)) {
                String morseCode = MORSE_MAP.get(c);
                morse.append(morseCode).append(" ");
            }
        }

        return morse.toString().trim();
    }

    public String decode(String morse) {
        StringBuilder decodedMorse = new StringBuilder();
        String[] morseWords = morse.split(DIVIDER);

        for (String word : morseWords) {
            decodedMorse.append(decodeWord(word)).append(" "); // Decode each word
        }

        return decodedMorse.toString().trim();
    }

    private String decodeWord(String word) {
        StringBuilder decodedWord = new StringBuilder();
        String[] symbols = word.split(" ");

        for (String symbol : symbols) {
            Character c = findCharacterByMorse(symbol);
            if (c != null) {
                decodedWord.append(c);
            }
        }

        return decodedWord.toString();
    }

    private Character findCharacterByMorse(String morseCode) {
        for (Map.Entry<Character, String> entry : MORSE_MAP.entrySet()) {
            if (entry.getValue().equals(morseCode)) {
                return entry.getKey();
            }
        }
        return null;
    }
}