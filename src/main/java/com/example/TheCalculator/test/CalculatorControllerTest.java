package com.example.TheCalculator.test;

import com.example.TheCalculator.controller.CalculatorController;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
public class CalculatorControllerTest {

    @Autowired
    private TestRestTemplate template;

    @Autowired
    private CalculatorController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void webRequestshouldSucceedWith200() throws Exception {
        String input = "9+1";
        HttpEntity<String> requestEntity = new HttpEntity<>(input);

        ResponseEntity<String> result = template.postForEntity
                ("/calculator/web", requestEntity, String.class);
        Assert.assertEquals(200, result.getStatusCodeValue());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }
    @Test
    public void webRequestshouldFailWith400() throws Exception {
        HttpEntity<String> requestEntity = new HttpEntity<>(null);

        ResponseEntity<String> result = template.postForEntity
                ("/calculator/web", requestEntity, String.class);
        Assert.assertEquals(400, result.getStatusCodeValue());
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
    }

    @Test
    public void xmlRequestshouldSucceedWith200() throws Exception {
        String input = "C:\\Users\\Rolland G\\Master\\SEM2\\Calitate\\TheCalculator\\src\\main\\resources\\file.xml";
        HttpEntity<String> requestEntity = new HttpEntity<>(input);

        ResponseEntity<String> result = template.postForEntity
                ("/calculator/xml", requestEntity, String.class);
        Assert.assertEquals(200, result.getStatusCodeValue());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void xmlRequestshouldFailWith400() throws Exception {
        HttpEntity<String> requestEntity = new HttpEntity<>(null);

        ResponseEntity<String> result = template.postForEntity
                ("/calculator/xml", requestEntity, String.class);
        Assert.assertEquals(400, result.getStatusCodeValue());
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
    }
}

