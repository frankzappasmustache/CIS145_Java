/*
    Author: Dustin McClure
    Project Name: Labs
    Sub-project: Lab 6
    File Name: QuestionNode.java
    Lab: 20 Questions
    Modified Date: 06/10/2022

    This class defines a question node.
*/
public class QuestionNode {
    public QuestionNode yes;
    public QuestionNode no;
    public String nData;

    // Empty Question Node Constructor that accepts string for the initial guess.
    public QuestionNode(String dat) {
        this(null, null, dat);
    }

    public QuestionNode(QuestionNode yes, QuestionNode no, String dat) {
        this.yes = yes;
        this.no = no;
        this.nData = dat;
    }
}
