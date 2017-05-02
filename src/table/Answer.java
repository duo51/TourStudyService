package table;

public class Answer {
	private int answer_id,answer_user_id,support_count,question_id;
	private String answer_info,answer_date,answer_user_name,answer_user_img;
	public String getAnswer_user_img() {
		return answer_user_img;
	}
	public void setAnswer_user_img(String answer_user_img) {
		this.answer_user_img = answer_user_img;
	}
	public String getAnswer_user_name() {
		return answer_user_name;
	}
	public void setAnswer_user_name(String answer_user_name) {
		this.answer_user_name = answer_user_name;
	}
	private int showState;
public int getShowState() {
		return showState;
	}
	public void setShowState(int showState) {
		this.showState = showState;
	}
	//	private Question question;
//	public Question getQuestion() {
//		return question;
//	}
//	public void setQuestion(Question question) {
//		this.question = question;
//	}
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	
	public int getAnswer_id() {
		return answer_id;
	}
	public void setAnswer_id(int answer_id) {
		this.answer_id = answer_id;
	}
	public int getAnswer_user_id() {
		return answer_user_id;
	}
	public void setAnswer_user_id(int answer_user_id) {
		this.answer_user_id = answer_user_id;
	}
	public int getSupport_count() {
		return support_count;
	}
	public void setSupport_count(int support_count) {
		this.support_count = support_count;
	}
	public String getAnswer_info() {
		return answer_info;
	}
	public void setAnswer_info(String answer_info) {
		this.answer_info = answer_info;
	}
	public String getAnswer_date() {
		return answer_date;
	}
	public void setAnswer_date(String answer_date) {
		this.answer_date = answer_date;
	}
	
	
}
