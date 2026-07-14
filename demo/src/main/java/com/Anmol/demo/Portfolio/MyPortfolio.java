package com.Anmol.demo.Portfolio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyPortfolio {

    @GetMapping("/myself")
    public String myself(){
        return """
                <h1>Myself</h1>
                <p>I am very resilient</p>
                <ul>
                <li>Fighter</li>
                <li>Worker</li>
                <li>Enjoyer</li>
                </ul>
                """;
    }

    @GetMapping("/skills")
    public String skills(){
        return """
                <h1>Skills On Display</h1>
                <p>I am a Skilled programmer </p>
                <ul>
                <li>Java</li>
                <li>CPP</li>
                <li>Python</li>
                </ul>
                """;
    }
    @GetMapping("/education")
    public String education(){
        return """
                <h1>Highly Educated</h1>
                <p>I am a Skilled programmer </p>
                <ul>
                <li>12th pass</li>
                <li>10th pass</li>
                <li>BA pass</li>
                </ul>
                """;
    }

}
