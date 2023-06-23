package com.example.demo.dto;

import com.example.demo.dto.ObjectDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class ObjectsDto {
    private Boolean status;
    private Integer statusCode;
    private List<ObjectDto> result;
    private String message;
}
