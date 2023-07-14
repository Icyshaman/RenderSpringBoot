package com.example.appDemo.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.appDemo.dao.ResponseEntityClass;

@RestController
public class DemoController {

    @GetMapping(path = "/hello")
    public @ResponseBody String printHello() throws UnknownHostException {
        InetAddress ipAddress = InetAddress.getLocalHost();
        return "Hello, you're connected to ip " + ipAddress.getHostAddress();
    }

    @GetMapping(path = "/getSum")
    public @ResponseBody ResponseEntityClass getSum(@RequestParam("num1") double num1, @RequestParam("num2") double num2) {
        ResponseEntityClass response = new ResponseEntityClass(num1 + num2);
        return response;
    }

    @GetMapping(path = "/getSquare")
    public @ResponseBody ResponseEntityClass getSquare(@RequestParam("num") int num) {
        ResponseEntityClass response = new ResponseEntityClass(Math.pow(num, 2));
        return response;
    }

    @GetMapping(path = "/getCube")
    public @ResponseBody ResponseEntityClass getCube(@RequestParam("num") int num) {
        ResponseEntityClass response = new ResponseEntityClass(Math.pow(num, 3));
        return response;
    }

    @GetMapping(path = "/getDelayedResponse")
    public @ResponseBody String getDelayedResponse() throws InterruptedException {
        Thread.sleep(10000);
        return "Delayed Response";
    }

    @GetMapping(path = "/get4xxError")
    public @ResponseBody  ResponseEntity<Object> get4xxError() {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "/get5xxError")
    public @ResponseBody  ResponseEntity<Object> get5xxError() {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(path = "/get408Error")
    public @ResponseBody  ResponseEntity<Object> get408Error() {
        return new ResponseEntity<>(HttpStatus.REQUEST_TIMEOUT);
    }

    @GetMapping(path = "/get504Error")
    public @ResponseBody  ResponseEntity<Object> get504Error() {
        return new ResponseEntity<>(HttpStatus.GATEWAY_TIMEOUT);
    }

    @GetMapping(path = "/getDelayedResponse5min")
    public @ResponseBody String getDelayedResponse5Min() throws InterruptedException {
        Thread.sleep(300000);
        return "Delayed Response";
    }

    @GetMapping(path = "/getDelayedResponse6min")
    public @ResponseBody String getDelayedResponse6Min() throws InterruptedException {
        Thread.sleep(360000);
        return "Delayed Response";
    }

}