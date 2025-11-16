package com.quiz.entities;

import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Question {
    private String questionID;
    private String quizID;
    private String questDesc;
}
