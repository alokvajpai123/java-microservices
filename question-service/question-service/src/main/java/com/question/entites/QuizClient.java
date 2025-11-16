package com.question.entites;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="quiz-service",url = "http://localhost:9091/quiz")
public interface QuizClient {
    @GetMapping("/{quizID}")
    Quiz getQuizByID(@PathVariable String quizID);
}
