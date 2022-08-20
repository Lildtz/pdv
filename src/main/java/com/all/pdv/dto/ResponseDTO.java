package com.all.pdv.dto;

import lombok.Getter;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ResponseDTO {
    @Getter
    private List<String> messages;
    public ResponseDTO(List<String> messages) {
        this.messages = messages;
    }
    public ResponseDTO(String message) {
        this.messages = List.of(message);
    }
}
