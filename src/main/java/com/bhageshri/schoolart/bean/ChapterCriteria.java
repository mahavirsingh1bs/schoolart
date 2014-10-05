/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.bean;

import com.bhageshri.schoolart.util.Operand;
import java.io.Serializable;

/**
 *
 * @author Mahavir Singh
 */
public class ChapterCriteria implements Serializable {
    private Integer leftExpr;
    private Operand operand;
    private Integer rightExpr;

    public ChapterCriteria() { }
    
    public ChapterCriteria(Operand operand) {
        this.operand = operand;
    }
    
    public ChapterCriteria(Integer leftExpr, Operand operand, Integer rightExpr) {
        this.leftExpr = leftExpr;
        this.operand = operand;
        this.rightExpr = rightExpr;
    }
    
    public Integer getLeftExpr() {
        return leftExpr;
    }

    public void setLeftExpr(Integer leftExpr) {
        this.leftExpr = leftExpr;
    }

    public Operand getOperand() {
        return operand;
    }

    public void setOperand(Operand operand) {
        this.operand = operand;
    }

    public Integer getRightExpr() {
        return rightExpr;
    }

    public void setRightExpr(Integer rightExpr) {
        this.rightExpr = rightExpr;
    }
    
}
