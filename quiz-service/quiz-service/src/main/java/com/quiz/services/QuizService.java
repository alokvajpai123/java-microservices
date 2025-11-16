package com.quiz.services;

import com.quiz.entities.Quiz;

import java.util.List;

public interface QuizService {

    Quiz createQuiz(Quiz quiz);
    Quiz getQuizByID(String quizID);
    List<Quiz> getAllQuizzes();

}
