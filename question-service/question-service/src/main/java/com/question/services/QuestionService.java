package com.question.services;

import com.question.entites.Question;

import java.util.List;

public interface QuestionService {
  Question createQuestion(Question question);
  Question getQuestionByID(String  questID);
  List<Question> getALlQuestionsByQuizID(String quizID);
  List<Question> getAllQuestions();
}
