package com.question.controllers;

import com.question.entites.Question;
import com.question.services.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestController {
    QuestionService questionService;

    public QuestController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    ResponseEntity<Question> createQuestion(@RequestBody Question question){
        return  new ResponseEntity<>(questionService.createQuestion(question), HttpStatus.CREATED);
    }
    @GetMapping("/quiz/{quizID}")
    ResponseEntity<List<Question>> getAllQuestionsByQuizID(@PathVariable String quizID){
        return  new ResponseEntity<>(questionService.getALlQuestionsByQuizID(quizID), HttpStatus.OK);
    }

    @GetMapping("/{questionID}")
    ResponseEntity<Question> getQuestionByID(@PathVariable String questionID){
        return  new ResponseEntity<>(questionService.getQuestionByID(questionID), HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity<List<Question>> getAllQuestions(){
        return  new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK);
    }



}
