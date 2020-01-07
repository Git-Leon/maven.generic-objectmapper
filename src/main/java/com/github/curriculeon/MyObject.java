package com.github.curriculeon;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.curriculeon.financialtypes.FinancialTypeInterface;

import java.io.IOException;

public class MyObject implements Runnable {
    public void run() {
    }

    public <SomeType> SomeType create(SomeType someObject, String json) {
        try {
            return (SomeType) new ObjectMapper().readValue(json, someObject.getClass());
        } catch (IOException e) {
            throw new Error(e);
        }
    }


    public <FinancialType extends FinancialTypeInterface> FinancialType _create(FinancialType someFinancialObject, String json) {
        return create(someFinancialObject, json);
    }
}
