package com.mapping;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Question {
	
	@Id
	@Column(name = "ques_id")
	private int quesId;
	private String question;
	
	@OneToMany(mappedBy = "question", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Answer> answers;
	
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(int quesId, String question, List<Answer> answers) {
		super();
		this.quesId = quesId;
		this.question = question;
		this.answers = answers;
	}

	public int getQuesId() {
		return quesId;
	}

	public void setQuesId(int quesId) {
		this.quesId = quesId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

}
