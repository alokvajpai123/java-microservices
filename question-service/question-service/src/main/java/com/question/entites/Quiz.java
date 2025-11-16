package com.question.entites;

import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Quiz {
    private  String quizID;
    private String quizName;
    private  String quizDesc;
}
