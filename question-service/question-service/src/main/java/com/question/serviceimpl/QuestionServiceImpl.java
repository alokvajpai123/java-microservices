package com.question.serviceimpl;

import com.question.entites.Question;
import com.question.entites.Quiz;
import com.question.entites.QuizClient;
import com.question.repositories.QuestRepo;
import com.question.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class QuestionServiceImpl implements QuestionService {
     QuestRepo questRepo;

     @Autowired
     QuizClient quizClient;


    public QuestionServiceImpl(QuestRepo questRepo) {
        this.questRepo = questRepo;
    }

    @Override
    public Question createQuestion(Question question) {
        Quiz quiz=quizClient.getQuizByID(question.getQuizID());
        if(quiz==null)
            throw new RuntimeException("Quiz ID Invalid");
        String questID= UUID.randomUUID().toString();
        question.setQuestionID(questID);
        Question quest=questRepo.save(question);
        return quest;
    }

    @Override
    public Question getQuestionByID(String questID) {
        Question question=questRepo.findById(questID).orElseThrow(()->new RuntimeException("question is invalid"));
        return question;
    }

    @Override
    public List<Question> getALlQuestionsByQuizID(String quizID) {
        return questRepo.findByQuizID(quizID);
    }

    @Override
    public List<Question> getAllQuestions() {
        return questRepo.findAll();
    }
}
