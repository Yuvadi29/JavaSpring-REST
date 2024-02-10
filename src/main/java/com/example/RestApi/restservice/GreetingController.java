// Here to build a RESTFUL web service, HTTP requests are handled by controller. These componenets are identified by the @RestController annotation. Here it handles GET reqursts by returning a new instance of Greeting class.

package com.example.RestApi.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    // @RequestParam binds the value of the query string parameter name into the
    // name parameter of the greeting() method. If the name parameter is absent in
    // the request, the defaultValue of World is used.

    // The implementation of the method body creates and returns a new Greeting
    // object with id and content attributes based on the next value from the
    // counter and formats the given name by using the greeting template.

    @GetMapping
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World!") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
