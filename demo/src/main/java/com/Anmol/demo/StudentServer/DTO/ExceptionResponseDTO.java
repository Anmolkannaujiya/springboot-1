package com.Anmol.demo.StudentServer.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ExceptionResponseDTO {

    private LocalDateTime timestamp;
    private int statusCode;
    private String error;
    private String path;
    private String message;


    //this is parameterised constructor, can use ALLArgsConstructor to get it
//    public ExceptionResponseDTO(LocalDateTime timestamp,int statusCode, String error,String message,String path){
//        this.timestamp = timestamp;
//        this.error = error;
//        this.statusCode = statusCode;
//    }


}
