package com.question.serviceimpl;

import com.question.entites.Question;
import com.question.repositories.QuestRepo;
import com.question.services.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class QuestionServiceImpl implements QuestionService {
     QuestRepo questRepo;

    public QuestionServiceImpl(QuestRepo questRepo) {
        this.questRepo = questRepo;
    }

    @Override
    public Question createQuestion(Question question) {
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
