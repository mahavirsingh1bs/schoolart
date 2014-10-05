/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mahavir Singh
 */
public class QuestionsCriteria implements Serializable {
    private List<ChapterCriteria> chapters = new ArrayList<>();
    private List<SectionCriteria> sections = new ArrayList<>();

    public QuestionsCriteria() { }
    
    public List<ChapterCriteria> getChapters() {
        return chapters;
    }

    public void setChapters(List<ChapterCriteria> chapters) {
        this.chapters = chapters;
    }

    public List<SectionCriteria> getSections() {
        return sections;
    }

    public void setSections(List<SectionCriteria> sections) {
        this.sections = sections;
    }
    
}
