import java.util.Scanner;

public class PayrollM {
//필드
	private Db[] emp;				// emp == employee 라는 뜻
	private int maxPeople = 10;		//최대 회사원
	private int pos = 0;			//회사에 등록된 순서
	
	//생성자
	public PayrollM() {			
		emp = new Db[maxPeople];
		for(int i=0; i<emp.length; i++) {
			emp[i] = new Db();
		}
	}
	
	
	//메소드


	public void setPWorker(String name,int pNum,int code ,int pw,int lank, int wTime,int oTime, int div, int bonus, int oBonus, int pay) {
		
		emp[pos].setPworkerName(name);
		emp[pos].setPworkerPNum(pNum);
		emp[pos].setPworkerCode(code);
		emp[pos].setPworkerPw(pw);
		emp[pos].setPworkerLank(lank);
		emp[pos].setPworkerWTime(wTime);
		emp[pos].setPworkerOTime(oTime);
		emp[pos].setPworkerDiv(div);
		emp[pos].setPworkerBonus(bonus);
		emp[pos].setPworkerOBonus(oBonus);
		emp[pos].setPworkerPay(pay);
		
		pos++;
	}
		

	
	
	// npWorker set메서드
	public void setNPWorker(String name,int pNum,int code ,int pw,int lank, int wTime, int pay, int div, int firstDate, int term) {
										
		emp[pos].setNPworkerName(name);
		emp[pos].setNPworkerPNum(pNum);
		emp[pos].setNPworkerCode(code);
		emp[pos].setNPworkerPw(pw);
		emp[pos].setNPworkerLank(lank);
		emp[pos].setNPworkerWTime(wTime);
		emp[pos].setNPworkerPay(pay);
		emp[pos].setNPworkerDiv(div);
		emp[pos].setNPworkerFirstDate(firstDate);
		emp[pos].setNPworkerTerm(term);
		
		pos++;
	}
	
	
	
	/*
	 * 메인 메소드***********************************************
	 */
	public static void main(String[] args) {
		int masterKey = 0000;// 관리자 모드 비밀번호
		int masterCount = 0; // 한번 비번 성공하면 마스터키 획득
		int sel1 = 0; // 선택 변수
		int sel2 = 0;
		int sel3 = 0;

		Scanner scanner = new Scanner(System.in);
		PayrollM pay = new PayrollM();

		do {
			if (masterCount == 1) {			//마스터키 획득
				System.out.println("MasterMode"); 	
			}
			System.out.println("<GEUB YEO>");
			System.out.println("1.관리자모드   2.사용자모드  0.종료");
			sel1 = scanner.nextInt();
			switch (sel1) {
			case 0:
				System.exit(-1);

			case 1:
				if (masterCount == 0) {
					System.out.print("관리자모드 비밀번호를 입력하세요 : ");
					masterKey = scanner.nextInt();

				}

				if (masterKey == 0000 || masterCount == 1) {
					pay.masterMode(scanner, pay); // 관리자모드 메소드 시작
					masterCount = 1;
				} else {
					System.out.print("비밀번호가 틀렸습니다. 프로그램을 종료합니다.");
					System.exit(-1);
				}
				break;
			case 2:
				pay.userMode(scanner, pay);// 사용자모드
				break;
			default:
				System.out.println("1,2,0중 입력하세요");

			}
		} while (true);

	}

	/*
	 * 기능 메소드
	 */
	// 관리자모드 메소드
	public int masterMode(Scanner scanner, PayrollM pay) {
		do {
			System.out.println("GEUB YEO → <관리자 모드>");
			System.out.println("1.사원입력   2.삭제  3.검색  0.뒤로가기");
			int sel2;
			sel2 = scanner.nextInt();

			if (sel2 == 1) {

				pay.memberAdder(scanner, pay); // 관리자모드.사원입력 메소드

			} else if (sel2 == 2) {
				// 삭제
				pay.deleteData(scanner, pay);
			} else if (sel2 == 3) {
				// 검색
				pay.serch(scanner, pay);

			} else if (sel2 == 0) // 뒤로가기
				return 0;

		} while (true);
	}
	
	
	// 관리자모드. 사원추가 메소드
	public int memberAdder(Scanner scanner, PayrollM pay) {
		do {
			System.out.println("GEUB YEO → 관리자 모드 → <사원입력>");
			System.out.println("1.정규직 추가   2.비정규직 추가  0.뒤로가기");
			int sel3;
			sel3 = scanner.nextInt();

			if (sel3 == 1) {
				// 관리자모드.사원입력.정규직 정보 입력
				pay.pWorkerAdder(scanner, pay);

			} else if (sel3 == 2) {
				// 관리자모드.사원입력.비정규직 정보 입력
				pay.nPWorkerAdder(scanner, pay);

			} else if (sel3 == 0) { // 뒤로가기 →프로그램.관리자 모드로
				return 0;
			}

		} while (true);

	}

		
	// 관리자모드.사원추가메소드.정규직 추가 메소드
	public int pWorkerAdder(Scanner scanner, PayrollM _pay) {
		String name;
		int pNum;
		int code;
		int pw;
		int lank;
		int wTime;
		int oTime;
		int div = 0;
		int bonus;
		int oBonus;
		int pay;
		
		
		System.out.print("이름을 입력하세요 : ");
		name = scanner.next();				
		System.out.print("전화번호를 입력하세요 :");
		pNum = scanner.nextInt();
		System.out.print("사번을 입력하세요 :");
		code = scanner.nextInt();
		System.out.print("비밀번호를 입력하세요 :");
		pw = scanner.nextInt();
		System.out.print("직급을 입력하세요 (1. 과장 2. 팀장 3. 대리 4. 사원):");
		lank = scanner.nextInt();
		System.out.print("근무 시간을 입력하세요(단위: 시간) : ");
		wTime = scanner.nextInt();
		System.out.print("초과 근무 시간을 입력하세요(단위: 시간) : ");
		oTime = scanner.nextInt();
		System.out.print("성과금을 입력하세요: ");
		bonus = scanner.nextInt();
		System.out.print("추가금을 입력하세요: ");
		oBonus = scanner.nextInt();
		System.out.print("급여를 입력하세요: ");
		pay = scanner.nextInt();
		
		// 성과금, 추가금, 급여
		//pay쪽 setPworker쪽에 형식에 맞춰 매개변수로 보내준다.
		_pay.setPWorker(name, pNum, code, pw, lank, wTime, oTime, div, bonus, oBonus, pay);
		
		return 0;
	}
	
	
	// 관리자모드.사원추가메소드.비정규직 추가 메소드
	public int nPWorkerAdder(Scanner scanner, PayrollM _pay) {
		String name;
		int pNum;
		int code;
		int pw;
		int lank;
		int wTime;
		int pay;
		int div=1;
		int firstDate;
		int term;
		
		System.out.print("이름을 입력하세요 : ");
		name = scanner.next();
		System.out.print("전화번호 를 입력하세요 :");
		pNum = scanner.nextInt();
		System.out.print("사번을 입력하세요 :");
		code = scanner.nextInt();
		System.out.print("비밀번호를 입력하세요 :");
		pw = scanner.nextInt();
		System.out.print("입사 일을 입력하세요 :");
		firstDate = scanner.nextInt();
		System.out.print("직급을 입력하세요  1. 과장 2. 팀장 3. 대리 4. 사원:");
		lank = scanner.nextInt();
		System.out.print("근무 시간을 입력하세요(단위: 시간) : ");
		wTime = scanner.nextInt();
		System.out.print("시급을 입력하세요 :");
		pay = scanner.nextInt();
		System.out.print("계약기간을 입력하세요: ");
		term = scanner.nextInt();
		
		
		_pay.setNPWorker(name, pNum, code, pw, lank, wTime, pay, div, firstDate, term);
		return 0;
	}
		
	
	// 관리자모드.검색 메소드
	public int serch(Scanner scanner,PayrollM pay) {
		do {
			int sel2;
			System.out.println("관리자모드.<검색기능>");
			System.out.println("1.전체출력   2.이름검색   3.사번검색   4.직급출력 0.뒤로가기");
			sel2 = scanner.nextInt();
			switch(sel2) {
			case 0:
				return 0;
			case 1:
				pay.allPrint(scanner, pay);
				break;
			case 2:
				pay.namePrint(scanner);
				break;
			case 3:
				pay.mSearchCode(scanner, pay);
				break;
			case 4:
				pay.printLank(scanner);
				break;
			}
		}while(true);
	}

				
	// 관리자모드.검색.전체 출력 메소드
	 public int allPrint(Scanner scanner, PayrollM pay) {
	      double[] pwPay = new double[emp.length];		//계산
	         double[] npwPay = new double[emp.length];	//비정규직 계산
	         
	         System.out.println("===========\n\n<<<<<<<<<정규직>>>>>>>>>\n\n============");
	         for(int i=0;i<maxPeople;i++) {			
	            if(emp[i].getPworkerCode()==0) {   //사번이 0이라면 출력하지마
	               continue;
	            }
	            // 총 급여 계산 후 
	            pwPay[i] = (emp[i].getPworkerPay() + emp[i].getPworkerBonus() + emp[i].getPworkerOBonus()) * 0.91;
	            
	            if(emp[i].getPworkerDiv()==0) {   System.out.print("<"+"정직원"+"\t");}
	            System.out.print(emp[i].getPworkerName()+"\t");
	            if(emp[i].getPworkerLank()==1) {
	            System.out.print("과장"+"\t");
	            }else if(emp[i].getPworkerLank()==2) {
	            System.out.print("팀장"+"\t");
	            }else if(emp[i].getPworkerLank()==3) {
	            System.out.print("대리"+"\t");
	            }else if(emp[i].getPworkerLank()==4) {
	            System.out.print("사원"+"\t");   
	            }
	            System.out.print("0"+emp[i].getPworkerPNum()+">\n");
	            System.out.print("사번 : "+ String.format("%03d", emp[i].getPworkerCode()) +"\t");
	            System.out.print("근무시간 : "+emp[i].getPworkerWTime()+"시간\t");
	            System.out.print("초과 근무 : "+emp[i].getPworkerOTime()+"시간\n");
	            System.out.print("성과금 :"+emp[i].getPworkerBonus());
	            System.out.print("\n추가금 :"+emp[i].getPworkerOBonus());
	            System.out.printf("\n총 급여: %.2f\n", pwPay[i]);
	            System.out.println("=========================================================");
	         }
	         
	         
	         
	         System.out.println("===========\n\n<<<<<<비정규직>>>>>>\n\n============");
	      
	         for(int j=0;j<maxPeople;j++) {
	            if(emp[j].getNPworkerCode()==0) {   //사번이 0이라면 출력하지마
	               continue;
	            }
	            // 총 급여 계산
	            npwPay[j] = (emp[j].getNPworkerPay() * emp[j].getNPworkerWTime() * 5 * 4) * 0.91;
	            
	            if(emp[j].getNPworkerDiv()==1) {System.out.print("<"+ "비정규직"+"\t");}
	            System.out.print(emp[j].getNPworkerName()+"\t");
	            if(emp[j].getNPworkerLank()==1) {
	            	System.out.print("과장"+"\t");
	            }else if(emp[j].getNPworkerLank()==2) {
	            	System.out.print("팀장"+"\t");
	            }else if(emp[j].getNPworkerLank()==3) {
	            	System.out.print("대리"+"\t");
	            }else if(emp[j].getNPworkerLank()==4) {
	            	System.out.print("사원"+"\t");   
	            }   
	            
	            System.out.print("0"+emp[j].getNPworkerPNum()+">\n");
	            System.out.print("사번 : "+ String.format("%03d", emp[j].getNPworkerCode())+"\t");
	            System.out.println("입사일 :"+emp[j].getNPworkerFirstDate());
	            System.out.println("계약기간 :"+emp[j].getNPworkerTerm());
	            System.out.println("시간 당 급여 :"+emp[j].getNPworkerPay());
	            System.out.printf("총 급여: %.2f\n", npwPay[j]);
	            System.out.println("=========================================================");
	               
	           }

	      return 0;
	   }	
	
	
	// 관리자모드.검색.이름 검색 메서드
	public void namePrint(Scanner scanner) {
		System.out.print("이름을 입력하세요: ");
		String name = scanner.next();
		double[] pwPay = new double[emp.length];
		double[] npwPay = new double[emp.length];
		
		
		for(int i=0; i<maxPeople; i++) {
			if(name.equals(emp[i].getPworkerName()) && emp[i].getPworkerDiv()==0) {
				// 총 급여 계산
				pwPay[i] = (emp[i].getPworkerPay() + emp[i].getPworkerBonus() + emp[i].getPworkerOBonus()) * 0.91;
				
	            if(emp[i].getPworkerDiv()==0) {   System.out.print("<"+"정직원"+"\t");}
	            System.out.print(emp[i].getPworkerName()+"\t");
	            if(emp[i].getPworkerLank()==1) {
	            System.out.print("과장"+"\t");
	            }else if(emp[i].getPworkerLank()==2) {
	            System.out.print("팀장"+"\t");
	            }else if(emp[i].getPworkerLank()==3) {
	            System.out.print("대리"+"\t");
	            }else if(emp[i].getPworkerLank()==4) {
	            System.out.print("사원"+"\t");   
	            }
	            
				System.out.print("0"+emp[i].getPworkerPNum()+">\n");
				System.out.print("사번 : "+ String.format("%03d", emp[i].getPworkerCode()) +"\t");
				System.out.print("근무시간 : "+emp[i].getPworkerWTime()+"시간\t");
				System.out.print("초과 근무 : "+emp[i].getPworkerOTime()+"시간\n");
				System.out.print("성과금 :"+emp[i].getPworkerBonus());
				System.out.print("\n추가금 :"+emp[i].getPworkerOBonus());
				System.out.println("\n총 급여 :"+ pwPay[i]);
				System.out.println("----------------------------------");
			}else if(name.equals(emp[i].getNPworkerName()) && emp[i].getNPworkerDiv()==1) {
				// 총 급여 계산
	            npwPay[i] = (emp[i].getNPworkerPay() * emp[i].getNPworkerWTime() * 5 * 4) * 0.91;
	            
	            if(emp[i].getNPworkerDiv()==1) {System.out.print("<"+ "비정규직"+"\t");}
	            System.out.print(emp[i].getNPworkerName()+"\t");
	            if(emp[i].getNPworkerLank()==1) {
	            	System.out.print("과장"+"\t");
	            }else if(emp[i].getNPworkerLank()==2) {
	            	System.out.print("팀장"+"\t");
	            }else if(emp[i].getNPworkerLank()==3) {
	            	System.out.print("대리"+"\t");
	            }else if(emp[i].getNPworkerLank()==4) {
	            	System.out.print("사원"+"\t");   
	            }   
				System.out.print("0"+emp[i].getNPworkerPNum()+">\n");
				System.out.print("사번 : "+ String.format("%03d", emp[i].getNPworkerCode()) +"\t");
				System.out.println("입사일 :"+emp[i].getNPworkerFirstDate());
				System.out.println("계약기간 :"+emp[i].getNPworkerTerm());
				System.out.println("시간 당 급여 :"+emp[i].getNPworkerPay());
				System.out.println("총 급여: " + npwPay[i]);
				System.out.println("----------------------------------");
			}
		}
		
	}
	
	// 관리자모드.검색.사번검색 메서드
	// (사용자모드.사변조회와 같은 기능을 한다.)
	
	// 관리자모드.검색.직급출력 메서드
	public void printLank(Scanner scanner) {
		System.out.print("직급을 입력하세요: ");
		System.out.println("1.과장  2.팀장  3.대리  4.사원");
		int lank = scanner.nextInt();
		
		double[] pwPay = new double[emp.length];
		double[] npwPay = new double[emp.length];
		
		
		for(int i=0; i<maxPeople; i++) {
			if(lank == emp[i].getPworkerLank() && emp[i].getPworkerDiv()==0) {
				// 총 급여 계산
				pwPay[i] = (emp[i].getPworkerPay() + emp[i].getPworkerBonus() + emp[i].getPworkerOBonus()) * 0.91;
				
	            if(emp[i].getPworkerDiv()==0) {   System.out.print("<"+"정직원"+"\t");}
	            System.out.print(emp[i].getPworkerName()+"\t");
	            if(emp[i].getPworkerLank()==1) {
	            System.out.print("과장"+"\t");
	            }else if(emp[i].getPworkerLank()==2) {
	            System.out.print("팀장"+"\t");
	            }else if(emp[i].getPworkerLank()==3) {
	            System.out.print("대리"+"\t");
	            }else if(emp[i].getPworkerLank()==4) {
	            System.out.print("사원"+"\t");   
	            }
	            
				System.out.print("0"+emp[i].getPworkerPNum()+">\n");
				System.out.print("사번 : "+ String.format("%03d", emp[i].getPworkerCode()) +"\t");
				System.out.print("근무시간 : "+emp[i].getPworkerWTime()+"시간\t");
				System.out.print("초과 근무 : "+emp[i].getPworkerOTime()+"시간\n");
				System.out.print("성과금 :"+emp[i].getPworkerBonus());
				System.out.print("\n추가금 :"+emp[i].getPworkerOBonus());
				System.out.printf("\n총 급여: %.2f\n", pwPay[i]);
				System.out.println("----------------------------------");
			}else if(lank == emp[i].getNPworkerLank() && emp[i].getNPworkerDiv()==1) {
				// 총 급여 계산
	            npwPay[i] = (emp[i].getNPworkerPay() * emp[i].getNPworkerWTime() * 5 * 4) * 0.91;
	            
	            if(emp[i].getNPworkerDiv()==1) {System.out.print("<"+ "비정규직"+"\t");}
	            System.out.print(emp[i].getNPworkerName()+"\t");
	            if(emp[i].getNPworkerLank()==1) {
	            	System.out.print("과장"+"\t");
	            }else if(emp[i].getNPworkerLank()==2) {
	            	System.out.print("팀장"+"\t");
	            }else if(emp[i].getNPworkerLank()==3) {
	            	System.out.print("대리"+"\t");
	            }else if(emp[i].getNPworkerLank()==4) {
	            	System.out.print("사원"+"\t");   
	            }   
				System.out.print("0"+emp[i].getNPworkerPNum()+">\n");
				System.out.print("사번 : "+ String.format("%03d", emp[i].getNPworkerCode()) +"\t");
				System.out.println("입사일 :"+emp[i].getNPworkerFirstDate());
				System.out.println("계약기간 :"+emp[i].getNPworkerTerm());
				System.out.println("시간 당 급여 :"+emp[i].getNPworkerPay());
				System.out.printf("총 급여: %.2f\n", npwPay[i]);
				System.out.println("----------------------------------");
			}
		}
	}
	
	
	// 관리자모드.검색.사번검색 메서드
	public int mSearchCode(Scanner scanner, PayrollM pay) {

		double[] pwPay = new double[emp.length];
		double[] npwPay = new double[emp.length];

		do {
			int sel3;
			int checkCode = 0;
			int checkPw;
			
			System.out.println("GEUB YEO → 관리자 모드 → 검색 → <사번 검색>");
			System.out.println("1.사번검색 0. 뒤로가기");
			sel3 = scanner.nextInt();

			switch (sel3) {
			case 0:
				return 0;

			case 1:
				System.out.print("사번을 입력하세요 : ");
				checkCode = scanner.nextInt();

				for (int i = 0; i < maxPeople; i++) {
					// 정규직
					// 사번과 일치하는지 체크
					if(emp[i].getPworkerCode() == checkCode && emp[i].getPworkerDiv()==0) {
						
						// 총 급여 계산
						pwPay[i] = (emp[i].getPworkerPay() + emp[i].getPworkerBonus() + emp[i].getPworkerOBonus())
								* 0.91;

			            if(emp[i].getPworkerDiv()==0) {   System.out.print("<"+"정직원"+"\t");}
			            System.out.print(emp[i].getPworkerName()+"\t");
			            if(emp[i].getPworkerLank()==1) {
			            System.out.print("과장"+"\t");
			            }else if(emp[i].getPworkerLank()==2) {
			            System.out.print("팀장"+"\t");
			            }else if(emp[i].getPworkerLank()==3) {
			            System.out.print("대리"+"\t");
			            }else if(emp[i].getPworkerLank()==4) {
			            System.out.print("사원"+"\t");   
			            }
						System.out.print("0" + emp[i].getPworkerPNum() + ">\n");
						System.out.print("사번 : " + String.format("%03d", emp[i].getPworkerCode()) + "\t");
						System.out.print("근무시간 : " + emp[i].getPworkerWTime() + "시간\t");
						System.out.print("초과 근무 : " + emp[i].getPworkerOTime() + "시간\n");
						System.out.print("성과금 :" + emp[i].getPworkerBonus());
						System.out.print("\n추가금 :" + emp[i].getPworkerOBonus());
						System.out.printf("\n총 급여: %.2f\n", pwPay[i]);
						
					// 비정규직
					// 사번과 일치하는지 체크
					} else if(emp[i].getNPworkerCode() == checkCode && emp[i].getNPworkerDiv()==1) {
						
						// 총 급여 계산
						npwPay[i] = (emp[i].getNPworkerPay() * emp[i].getNPworkerWTime() * 5 * 4) * 0.91;

			            if(emp[i].getNPworkerDiv()==1) {System.out.print("<"+ "비정규직"+"\t");}
			            System.out.print(emp[i].getNPworkerName()+"\t");
			            if(emp[i].getNPworkerLank()==1) {
			            	System.out.print("과장"+"\t");
			            }else if(emp[i].getNPworkerLank()==2) {
			            	System.out.print("팀장"+"\t");
			            }else if(emp[i].getNPworkerLank()==3) {
			            	System.out.print("대리"+"\t");
			            }else if(emp[i].getNPworkerLank()==4) {
			            	System.out.print("사원"+"\t");   
			            }   
						System.out.print("0" + emp[i].getNPworkerPNum() + ">\n");
						System.out.print("사번 : " + String.format("%03d", emp[i].getNPworkerCode()) + "\t");

						System.out.println("입사일 :" + emp[i].getNPworkerFirstDate());
						System.out.println("계약기간 :" + emp[i].getNPworkerTerm());
						System.out.println("시간 당 급여 :" + emp[i].getNPworkerPay());
						System.out.printf("총 급여: %.2f\n", npwPay[i]);
						System.out.println("=======================================");

					}
				}

			}
		} while (true);

	}

	
	
	// 관리자모드.삭제 메서드
	public void deleteData(Scanner scanner, PayrollM _pay) {
		int deleteCode;
		_pay.allPrint(scanner, _pay);
		System.out.print("삭제할 사번 입력: ");
		deleteCode = scanner.nextInt();
		
		for(int i=0; i<maxPeople; i++) {
			if(emp[i].getPworkerCode() == deleteCode || emp[i].getNPworkerCode() == deleteCode) {
				emp[i] = new Db();
				System.out.println("사번: " + deleteCode + "은 정상적으로 삭제되었습니다.");
			}
		}
	}
	
	
	//--------------------------------------------------------------------

	// 사용자 모드 메소드
	public int userMode(Scanner scanner, PayrollM pay) {
			do {
				System.out.println("GEUB YEO → <사용자 모드>");
				System.out.println("1.전화번호 수정   2.이름 수정   3.사번 조회   0.뒤로가기");
				int sel2;
				sel2 = scanner.nextInt();
				switch (sel2) {
				case 0:
					return 0; // 뒤로가기
				case 1:
					// 전화번호 수정
					pay.rePNum(scanner);
					break;
				case 2:
					// 이름 수정
					pay.reName(scanner);
					break;
				case 3:
					// 조회 사번받고 출력해줘
					uSearchCode(scanner, pay);
					break;
				}

			} while (true);
		}

	
	// 사용자모드.사번조회
	public int uSearchCode(Scanner scanner, PayrollM pay) {

		double[] pwPay = new double[emp.length];
		double[] npwPay = new double[emp.length];

		do {
			int sel3;
			int checkCode = 0;
			int checkPw;
			
			System.out.println("GEUB YEO → 사용자 모드 → <사번 조회>");
			System.out.println("1.사번조회 0. 뒤로가기");
			sel3 = scanner.nextInt();

			switch (sel3) {
			case 0:
				return 0;

			case 1:
				System.out.print("사번을 입력하세요 : ");
				checkCode = scanner.nextInt();
				System.out.print("비밀번호를 입력하세요 : ");
				checkPw = scanner.nextInt();

				for (int i = 0; i < maxPeople; i++) {
					// 정규직
					// 사번과 일치하는 pw인지 체크
					if(emp[i].getPworkerCode() == checkCode && emp[i].getPworkerPw() == checkPw && emp[i].getPworkerDiv()==0) {
						
						// 총 급여 계산
						pwPay[i] = (emp[i].getPworkerPay() + emp[i].getPworkerBonus() + emp[i].getPworkerOBonus())
								* 0.91;

			            if(emp[i].getPworkerDiv()==0) {   System.out.print("<"+"정직원"+"\t");}
			            System.out.print(emp[i].getPworkerName()+"\t");
			            if(emp[i].getPworkerLank()==1) {
			            System.out.print("과장"+"\t");
			            }else if(emp[i].getPworkerLank()==2) {
			            System.out.print("팀장"+"\t");
			            }else if(emp[i].getPworkerLank()==3) {
			            System.out.print("대리"+"\t");
			            }else if(emp[i].getPworkerLank()==4) {
			            System.out.print("사원"+"\t");   
			            }
						System.out.print("0" + emp[i].getPworkerPNum() + ">\n");
						System.out.print("사번 : " + String.format("%03d", emp[i].getPworkerCode()) + "\t");
						System.out.print("근무시간 : " + emp[i].getPworkerWTime() + "시간\t");
						System.out.print("초과 근무 : " + emp[i].getPworkerOTime() + "시간\n");
						System.out.print("성과금 :" + emp[i].getPworkerBonus());
						System.out.print("\n추가금 :" + emp[i].getPworkerOBonus());
						System.out.printf("\n총 급여: %.2f\n", pwPay[i]);
						
					// 비정규직
					// 사번과 일치하는 pw인지 체크
					} else if(emp[i].getNPworkerCode() == checkCode && emp[i].getNPworkerPw() == checkPw&& emp[i].getNPworkerDiv()==1) {
						
						// 총 급여 계산
						npwPay[i] = (emp[i].getNPworkerPay() * emp[i].getNPworkerWTime() * 5 * 4) * 0.91;

			            if(emp[i].getNPworkerDiv()==1) {System.out.print("<"+ "비정규직"+"\t");}
			            System.out.print(emp[i].getNPworkerName()+"\t");
			            if(emp[i].getNPworkerLank()==1) {
			            	System.out.print("과장"+"\t");
			            }else if(emp[i].getNPworkerLank()==2) {
			            	System.out.print("팀장"+"\t");
			            }else if(emp[i].getNPworkerLank()==3) {
			            	System.out.print("대리"+"\t");
			            }else if(emp[i].getNPworkerLank()==4) {
			            	System.out.print("사원"+"\t");   
			            }   
						System.out.print("0" + emp[i].getNPworkerPNum() + ">\n");
						System.out.print("사번 : " + String.format("%03d", emp[i].getNPworkerCode()) + "\t");

						System.out.println("입사일 :" + emp[i].getNPworkerFirstDate());
						System.out.println("계약기간 :" + emp[i].getNPworkerTerm());
						System.out.println("시간 당 급여 :" + emp[i].getNPworkerPay());
						System.out.printf("총 급여: %.2f\n", npwPay[i]);
						System.out.println("=======================================");

					}
				}

			}
		} while (true);

	}

	
	// 사용자모드.전화번호 수정
	public void rePNum(Scanner scanner) {
		int checkCode;
		int checkPw;
		System.out.print("사번 입력: ");
		checkCode = scanner.nextInt();
		System.out.print("비밀번호 입력: ");
		checkPw = scanner.nextInt();
		
		for(int i=0; i<maxPeople; i++) {
			// 정규직
			// 사번과 일치하는 pw인지 체크
			if(emp[i].getPworkerCode() == checkCode && emp[i].getPworkerPw() == checkPw && emp[i].getPworkerDiv()==0) {
				System.out.print("수정할 전화번호를 입력하세요: ");
				emp[i].setPworkerPNum(scanner.nextInt());
				break;
				
			// 비정규직
			// 사번과 일치하는 pw인지 체크
			}else if(emp[i].getNPworkerCode() == checkCode && emp[i].getNPworkerPw() == checkPw&& emp[i].getNPworkerDiv()==1) {
				System.out.print("수정할 전화번호를 입력하세요: ");
				emp[i].setNPworkerPNum(scanner.nextInt());
				break;
			}
		}
	}
	
	
	// 사용자모드.이름 수정
	public void reName(Scanner scanner) {
		int checkCode;
		int checkPw;
		System.out.print("사번 입력: ");
		checkCode = scanner.nextInt();
		System.out.print("비밀번호 입력: ");
		checkPw = scanner.nextInt();
		
		for(int i=0; i<maxPeople; i++) {
			if(checkCode == emp[i].getPworkerCode() && checkPw == emp[i].getPworkerPw() && emp[i].getPworkerDiv()==0) {
				System.out.print("수정할 이름을 입력하세요: ");
				emp[i].setPworkerName(scanner.next());
			}else if(checkCode == emp[i].getNPworkerCode() && checkPw == emp[i].getNPworkerPw() && emp[i].getNPworkerDiv()==1) {
				System.out.print("수정할 이름을 입력하세요: ");
				emp[i].setNPworkerName(scanner.next());
			}
		}
	}
	
}