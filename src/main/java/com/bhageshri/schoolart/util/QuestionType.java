/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.util;

/**
 *
 * @author mahavir.singh
 */
public enum QuestionType {

    VERY_SHORT(1, "Very Short Questions"), SHORT(2, "Short Questions"),
    LONG(3, "Long Questions"), FILL_IN_THE_BLANK(4, "Fill in the blanks"),
    DEFINE(5, "Define the following"), MATCH(6, "Match the following");
    private Integer id;
    private String name;

    private QuestionType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
