package com.quiz.controllers;

import com.quiz.entities.Quiz;
import com.quiz.services.QuizService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping
    ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz){
        return new ResponseEntity<>(quizService.createQuiz(quiz), HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<Quiz>> getAllQuizzes(){
        return new ResponseEntity<>(quizService.getAllQuizzes(), HttpStatus.OK);
    }


    @GetMapping("/{quizID}")
    ResponseEntity<Quiz> getAllQuizzes(@PathVariable String quizID){
        return new ResponseEntity<>(quizService.getQuizByID(quizID), HttpStatus.OK);
    }

}
