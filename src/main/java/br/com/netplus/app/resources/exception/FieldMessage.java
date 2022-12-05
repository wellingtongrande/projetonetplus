package br.com.netplus.app.resources.exception;

import java.io.Serializable;

public class FieldMessage implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fieldName;
    private String meessage;

    public FieldMessage(){
    }

    public FieldMessage(String fieldName, String meessage) {
        super();
        this.fieldName = fieldName;
        this.meessage = meessage;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMeessage() {
        return meessage;
    }

    public void setMeessage(String meessage) {
        this.meessage = meessage;
    }
}
