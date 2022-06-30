class PWorker{					//정규직
	
	private int bonus;				//성과금
	private int oBonus;				//추가금
	private int level;				//연차
	private int oTime;				//초과 근무 시간
	
	private Info info;
	
	public PWorker() {
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
	
	
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	public int getOBonus() {
		return oBonus;
	}
	public void setOBonus(int oBonus) {
		this.oBonus = oBonus;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getOTime() {
		return oTime;
	}

	public void setOTime(int oTime) {
		this.oTime = oTime;
	}
	
	
	
}