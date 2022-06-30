public class NpWorker {				//비정규직
	
	private int term;				//계약기간
		
	private Info info;
	
	public NpWorker() {
		info = new Info();	
	}
	
	 
	public String getName() {
		return this.info.getName();
	}
	public void setName(String name) {
		this.info.setName(name);
	}

	public int getPNum() { return this.info.getpNum();}
	public void setPNum(int pNum) {this.info.setpNum(pNum);}
	
	public int getCode() {return this.info.getCode();}
	public void setCode(int code) {this.info.setCode(code);}
	
	public int getLank() {return this.info.getLank();}
	public void setLank(int lank) {this.info.setLank(lank);}

	public int getWTime() {return this.info.getWTime();}
	public void setWTime(int wTime) {this.info.setWTime(wTime);}
	
	public int getPay() {return this.info.getPay();}
	public void setPay(int pay) {this.info.setPay(pay);}
	
	public int getFirstDate() {return this.info.getFirstDate();}
	public void setFirstDate(int firstDate) {this.info.setFirstDate(firstDate);}
	
	public int getPw() {return this.info.getPw();}
	public void setPw(int pw) {this.info.setPw(pw);} 
	
	public int getDiv() {return this.info.getDiv();}
	public void setDiv(int div) {this.info.setDiv(div);} 
	
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
}