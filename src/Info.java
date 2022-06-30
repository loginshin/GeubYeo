class  Info{				//개인정보
	
	private String name;			//이름
	private int pw;					//비밀번호
	private int pNum;				//전화번호
	private int code;				//사번
	private int lank;				//직급
	private int wTime;				//근무 시간
	private int firstDate;			//입사일
	private int div;				//구분
	private int pay;				//급여
	
	public int getwTime() {
		return wTime;
	}


	public void setwTime(int wTime) {
		this.wTime = wTime;
	}



	public Info(){}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getpNum() {
		return pNum;
	}


	public void setpNum(int pNum) {
		this.pNum = pNum;
	}


	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public int getLank() {
		return lank;
	}


	public void setLank(int lank) {
		this.lank = lank;
	}


	public int getWTime() {
		return wTime;
	}


	public void setWTime(int wTime) {
		this.wTime = wTime;
	}

	public int getPay() {
		return pay;
	}


	public int getPw() {
		return pw;
	}


	public void setPw(int pw) {
		this.pw = pw;
	}


	public void setPay(int pay) {
		this.pay = pay;
	}
	
	public int getFirstDate() {
		return firstDate;
	}
	public void setFirstDate(int firstDate) {
		this.firstDate = firstDate;
	}
	
	public int getDiv() {
		return div;
	}


	public void setDiv(int div) {
		this.div = div;
	}
}