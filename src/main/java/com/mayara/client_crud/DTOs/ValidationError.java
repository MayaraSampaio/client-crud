package com.mayara.client_crud.DTOs;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError {
    private List<FieldMessage> error= new ArrayList<>();

    public ValidationError(Instant moment, Integer status, String error, String path) {
        super(moment, status, error, path);
    }

    public List<FieldMessage> getList() {
        return error;
    }
    public void addList(String fieldName,String message){
        error.add(new FieldMessage(fieldName,message));
    }
}
