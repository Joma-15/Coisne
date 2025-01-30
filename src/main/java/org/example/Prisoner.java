package org.example;


public class Prisoner {
    private int prisonerId;
    private String firstName;
    private String lastName;
    private int age;
    private char sex;
    private String crimeCommitted;
    private int cellId;

    void setPrisonerId(int prisonerId){
        this.prisonerId = prisonerId;
    }

    void setFirstName(String firstName){
        this.firstName = firstName;
    }

    void setLastName(String lastName){
        this.lastName = lastName;
    }

    void setAge(int age){
        this.age = age;
    }

    void setSex(char sex){
        this.sex = sex;
    }

    void setCellId(int cellId){
        this.cellId = cellId;
    }

    int getPrisonerId(){
        return prisonerId;
    }

    String getFirstName(){
        return firstName;
    }

    String getLastName(){
        return lastName;
    }

    int getAge(){
        return age;
    }

    char getSex(){
        return sex;
    }

    int getCellId(){
        return cellId;
    }
}
