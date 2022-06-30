public class Db {			//데이터 관리
private PWorker pworker;
private NpWorker npworker;

//생성자
public Db() {
	pworker = new PWorker();
	npworker = new NpWorker();
}

// 정규직 getter
public String getPworkerName() {return pworker.getName();}
public int getPworkerPw() {return pworker.getPw();}
public int getPworkerPNum() {return pworker.getPNum();}
public int getPworkerCode() {return pworker.getCode();}
public int getPworkerLank() {return pworker.getLank();}
public int getPworkerWTime() {return pworker.getWTime();}
public int getPworkerPay() {return pworker.getPay();}
public int getPworkerFirstDate() {return pworker.getFirstDate();}
public int getPworkerDiv() {return pworker.getDiv();}
public int getPworkerBonus() {return pworker.getBonus();}
public int getPworkerOBonus() {return pworker.getOBonus();}
public int getPworkerLevel() {return pworker.getLevel();}
public int getPworkerOTime() {return pworker.getOTime();}

// 정규직 setter
public void setPworkerName(String name) {this.pworker.setName(name);}
public void setPworkerPw(int pw) {this.pworker.setPw(pw);}
public void setPworkerPNum(int pNum) {this.pworker.setPNum(pNum);}
public void setPworkerCode(int code) {this.pworker.setCode(code);}
public void setPworkerLank(int lank) {this.pworker.setLank(lank);}
public void setPworkerWTime(int wTime) {this.pworker.setWTime(wTime);}
public void setPworkerPay(int pay) {this.pworker.setPay(pay);}
public void setPworkerFirstDate(int firstDate) {this.pworker.setFirstDate(firstDate);}
public void setPworkerDiv(int div) {this.pworker.setDiv(div);}
public void setPworkerBonus(int bonus) {this.pworker.setBonus(bonus);}
public void setPworkerOBonus(int oBonus) {this.pworker.setOBonus(oBonus);}
public void setPworkerLevel(int level) {this.pworker.setLevel(level);}
public void setPworkerOTime(int oTime) {this.pworker.setOTime(oTime);}

//--------------------------------
// 비정규직 getter
public String getNPworkerName() {return npworker.getName();}
public int getNPworkerPw() {return npworker.getPw();}
public int getNPworkerPNum() {return npworker.getPNum();}
public int getNPworkerCode() {return npworker.getCode();}
public int getNPworkerLank() {return npworker.getLank();}
public int getNPworkerWTime() {return npworker.getWTime();}
public int getNPworkerPay() {return npworker.getPay();}
public int getNPworkerFirstDate() {return npworker.getFirstDate();}
public int getNPworkerDiv() {return npworker.getDiv();}
public int getNPworkerTerm() {return npworker.getTerm();}


// 비정규직 setter
public void setNPworkerName(String name) {this.npworker.setName(name);}
public void setNPworkerPw(int pw) {this.npworker.setPw(pw);}
public void setNPworkerPNum(int pNum) {this.npworker.setPNum(pNum);}
public void setNPworkerCode(int code) {this.npworker.setCode(code);}
public void setNPworkerLank(int lank) {this.npworker.setLank(lank);}
public void setNPworkerWTime(int wTime) {this.npworker.setWTime(wTime);}
public void setNPworkerPay(int pay) {this.npworker.setPay(pay);}
public void setNPworkerFirstDate(int firstDate) {this.npworker.setFirstDate(firstDate);}
public void setNPworkerDiv(int div) {this.npworker.setDiv(div);}
public void setNPworkerTerm(int term) {this.npworker.setTerm(term);}

}