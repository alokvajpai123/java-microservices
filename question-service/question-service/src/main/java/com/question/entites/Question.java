package com.question.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Question {
    @Id
    private String questionID;
    private String quizID;
    private String questDesc;

    public String getQuizID() {
        return quizID;
    }

    public String getQuestionID() {
        return questionID;
    }

    public String getQuestDesc() {
        return questDesc;
    }

    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    public void setQuizID(String quizID) {
        this.quizID = quizID;
    }

    public void setQuestDesc(String questDesc) {
        this.questDesc = questDesc;
    }
}
