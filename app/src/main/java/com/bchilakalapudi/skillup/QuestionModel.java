package com.bchilakalapudi.skillup;

public class QuestionModel {
    public String question;
    public String a_option;
    public String b_option;
    public String c_option;
    public String d_option;
    public String e_option;
    public String f_option;
    public String g_option;
    public String h_option;
    public String answer;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getA_option() {
        return a_option;
    }

    public void setA_option(String a_option) {
        this.a_option = a_option;
    }

    public String getB_option() {
        return b_option;
    }

    public void setB_option(String b_option) {
        this.b_option = b_option;
    }

    public String getC_option() {
        return c_option;
    }

    public void setC_option(String c_option) {
        this.c_option = c_option;
    }

    public String getD_option() {
        return d_option;
    }

    public void setD_option(String d_option) {
        this.d_option = d_option;
    }

    public String getE_option() {
        return e_option;
    }

    public void setE_option(String e_option) {
        this.e_option = e_option;
    }

    public String getF_option() {
        return f_option;
    }

    public void setF_option(String f_option) {
        this.f_option = f_option;
    }

    public String getG_option() {
        return g_option;
    }

    public void setG_option(String g_option) {
        this.g_option = g_option;
    }

    public String getH_option() {
        return h_option;
    }

    public void setH_option(String h_option) {
        this.h_option = h_option;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "QuestionModel{" +
                "question='" + question + '\'' +
                ", a_option='" + a_option + '\'' +
                ", b_option='" + b_option + '\'' +
                ", c_option='" + c_option + '\'' +
                ", d_option='" + d_option + '\'' +
                ", e_option='" + e_option + '\'' +
                ", f_option='" + f_option + '\'' +
                ", g_option='" + g_option + '\'' +
                ", h_option='" + h_option + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
