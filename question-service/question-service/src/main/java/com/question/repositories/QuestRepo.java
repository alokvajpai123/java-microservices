package com.question.repositories;

import com.question.entites.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestRepo  extends JpaRepository<Question,String> {
    List<Question> findByQuizID(String quizID);
}
