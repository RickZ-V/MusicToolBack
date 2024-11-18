package com.example.grupo1musictool.dtos;

import java.time.LocalDate;

public class SurveyDTO {
    private int id;
    private String question1;
    private String question2;
    private String title;
    private String description;
    private LocalDate creationDate;

    public int getId() {  return id;}

    public void setId(int id) {  this.id = id;}

    public String getQuestion1() {  return question1;}

    public void setQuestion1(String question1) {  this.question1 = question1;}

    public String getQuestion2() {  return question2;}

    public void setQuestion2(String question2) {  this.question2 = question2;}

    public String getTitle() {  return title;}

    public void setTitle(String title) {  this.title = title;}

    public String getDescription() {  return description;}

    public void setDescription(String description) {  this.description = description;}

    public LocalDate getCreationDate() {  return creationDate;}

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
