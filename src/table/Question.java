package table;

import java.util.HashSet;
import java.util.Set;

public class Question{
	private int question_id,question_user_id,visit_count,answer_count;
	private String question_title,question_info,question_date,question_user_name,question_user_img;
	public String getQuestion_user_img() {
		return question_user_img;
	}
	public void setQuestion_user_img(String question_user_img) {
		this.question_user_img = question_user_img;
	}
	private int tour_id;
	
	
	public int getTour_id() {
		return tour_id;
	}
	public void setTour_id(int tour_id) {
		this.tour_id = tour_id;
	}
	public String getQuestion_user_name() {
		return question_user_name;
	}
	public void setQuestion_user_name(String question_user_name) {
		this.question_user_name = question_user_name;
	}
	private Set<Answer> answers=new HashSet<Answer>();
	public Set<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}
	
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public int getQuestion_user_id() {
		return question_user_id;
	}
	public void setQuestion_user_id(int question_user_id) {
		this.question_user_id = question_user_id;
	}
	public int getVisit_count() {
		return visit_count;
	}
	public void setVisit_count(int visit_count) {
		this.visit_count = visit_count;
	}
	public int getAnswer_count() {
		return answer_count;
	}
	public void setAnswer_count(int answer_count) {
		this.answer_count = answer_count;
	}
	public String getQuestion_title() {
		return question_title;
	}
	public void setQuestion_title(String question_title) {
		this.question_title = question_title;
	}
	public String getQuestion_info() {
		return question_info;
	}
	public void setQuestion_info(String question_info) {
		this.question_info = question_info;
	}
	public String getQuestion_date() {
		return question_date;
	}
	public void setQuestion_date(String question_date) {
		this.question_date = question_date;
	}
	
	
}
