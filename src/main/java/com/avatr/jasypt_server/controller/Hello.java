package com.avatr.jasypt_server.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Hello {
    @GetMapping(value = "/hello")
    @Operation(summary = "hello", description = "hello", method = "GET", tags = "hello", responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema( implementation = HelloResponse.class))
            }),
            @ApiResponse(responseCode = "405", description = "Invalid input")
    })
    public HelloResponse hello(@RequestParam(required = false, defaultValue = "World") String name) {
        HelloResponse helloResponse = new HelloResponse();
        helloResponse.setMessage("Hello " + name);
        return helloResponse;
    }

    @GetMapping(value = "/")
    public String index() {
        return new String("hello world");
    }
    
}

@lombok.Data
class HelloResponse {
    private String message;
    public HelloResponse() {
    }
}



