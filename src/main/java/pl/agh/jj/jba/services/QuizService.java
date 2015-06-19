package pl.agh.jj.jba.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.agh.jj.jba.entities.Quiz;
import pl.agh.jj.jba.repository.QuizRepository;

@Service
@Transactional
public class QuizService {

	@Autowired
	private QuizRepository quizRepository;
	
	public void save(Quiz quiz) {
		quizRepository.save(quiz);		
	}
	public List<Quiz> findAll() {
		return quizRepository.findAll();
	}
	public Quiz findByID(Integer id){
		return quizRepository.getOne(id);
	}
	public Quiz findOne(Integer id){
		return quizRepository.findOne(id);
	}
	public void delete(Integer id) {
		quizRepository.delete(id);		
	}
	

}
