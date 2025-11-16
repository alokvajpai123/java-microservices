package com.quiz.serviceimpl;

import com.quiz.config.AppConstants;
import com.quiz.entities.Question;
import com.quiz.entities.Quiz;
import com.quiz.repositories.QuizRepo;
import com.quiz.services.QuizService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    QuizRepo quizRepo;
    RestTemplate restTemplate;

    public QuizServiceImpl(QuizRepo quizRepo, RestTemplate restTemplate) {
        this.quizRepo = quizRepo;
        this.restTemplate = restTemplate;
    }


    @Override
    public Quiz createQuiz(Quiz quiz) {
        String quizID= UUID.randomUUID().toString();
        quiz.setQuizID(quizID);
        Quiz savedQuiz=quizRepo.save(quiz);
        return savedQuiz;
    }

    @Override
    public Quiz getQuizByID(String quizID) {
        Quiz quiz =quizRepo.findById(quizID).orElseThrow(()-> new RuntimeException("Quiz not found"));
        List<Question> questions=restTemplate.getForObject(AppConstants.questionServiceUrl+"quiz/"+quizID,List.class);
        quiz.setQuestions(questions);
        return quiz;
    }

    @Override
    public List<Quiz> getAllQuizzes() {
        List<Quiz> quizzes=quizRepo.findAll();
        List<Quiz> updatedQuiz=quizzes.stream().map(
                quiz -> {
                    List<Question> questions=restTemplate.getForObject(AppConstants.questionServiceUrl+"quiz/"+quiz.getQuizID(),List.class);
                    quiz.setQuestions(questions);
                    return quiz;
                }
        ).collect(Collectors.toList());
        return quizRepo.findAll();
    }
}
