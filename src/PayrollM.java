import java.util.Scanner;

public class PayrollM {
//�ʵ�
	private Db[] emp;				// emp == employee ��� ��
	private int maxPeople = 10;		//�ִ� ȸ���
	private int pos = 0;			//ȸ�翡 ��ϵ� ����
	
	//������
	public PayrollM() {			
		emp = new Db[maxPeople];
		for(int i=0; i<emp.length; i++) {
			emp[i] = new Db();
		}
	}
	
	
	//�޼ҵ�


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
		

	
	
	// npWorker set�޼���
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
	 * ���� �޼ҵ�***********************************************
	 */
	public static void main(String[] args) {
		int masterKey = 0000;// ������ ��� ��й�ȣ
		int masterCount = 0; // �ѹ� ��� �����ϸ� ������Ű ȹ��
		int sel1 = 0; // ���� ����
		int sel2 = 0;
		int sel3 = 0;

		Scanner scanner = new Scanner(System.in);
		PayrollM pay = new PayrollM();

		do {
			if (masterCount == 1) {			//������Ű ȹ��
				System.out.println("MasterMode"); 	
			}
			System.out.println("<GEUB YEO>");
			System.out.println("1.�����ڸ��   2.����ڸ��  0.����");
			sel1 = scanner.nextInt();
			switch (sel1) {
			case 0:
				System.exit(-1);

			case 1:
				if (masterCount == 0) {
					System.out.print("�����ڸ�� ��й�ȣ�� �Է��ϼ��� : ");
					masterKey = scanner.nextInt();

				}

				if (masterKey == 0000 || masterCount == 1) {
					pay.masterMode(scanner, pay); // �����ڸ�� �޼ҵ� ����
					masterCount = 1;
				} else {
					System.out.print("��й�ȣ�� Ʋ�Ƚ��ϴ�. ���α׷��� �����մϴ�.");
					System.exit(-1);
				}
				break;
			case 2:
				pay.userMode(scanner, pay);// ����ڸ��
				break;
			default:
				System.out.println("1,2,0�� �Է��ϼ���");

			}
		} while (true);

	}

	/*
	 * ��� �޼ҵ�
	 */
	// �����ڸ�� �޼ҵ�
	public int masterMode(Scanner scanner, PayrollM pay) {
		do {
			System.out.println("GEUB YEO �� <������ ���>");
			System.out.println("1.����Է�   2.����  3.�˻�  0.�ڷΰ���");
			int sel2;
			sel2 = scanner.nextInt();

			if (sel2 == 1) {

				pay.memberAdder(scanner, pay); // �����ڸ��.����Է� �޼ҵ�

			} else if (sel2 == 2) {
				// ����
				pay.deleteData(scanner, pay);
			} else if (sel2 == 3) {
				// �˻�
				pay.serch(scanner, pay);

			} else if (sel2 == 0) // �ڷΰ���
				return 0;

		} while (true);
	}
	
	
	// �����ڸ��. ����߰� �޼ҵ�
	public int memberAdder(Scanner scanner, PayrollM pay) {
		do {
			System.out.println("GEUB YEO �� ������ ��� �� <����Է�>");
			System.out.println("1.������ �߰�   2.�������� �߰�  0.�ڷΰ���");
			int sel3;
			sel3 = scanner.nextInt();

			if (sel3 == 1) {
				// �����ڸ��.����Է�.������ ���� �Է�
				pay.pWorkerAdder(scanner, pay);

			} else if (sel3 == 2) {
				// �����ڸ��.����Է�.�������� ���� �Է�
				pay.nPWorkerAdder(scanner, pay);

			} else if (sel3 == 0) { // �ڷΰ��� �����α׷�.������ ����
				return 0;
			}

		} while (true);

	}

		
	// �����ڸ��.����߰��޼ҵ�.������ �߰� �޼ҵ�
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
		
		
		System.out.print("�̸��� �Է��ϼ��� : ");
		name = scanner.next();				
		System.out.print("��ȭ��ȣ�� �Է��ϼ��� :");
		pNum = scanner.nextInt();
		System.out.print("����� �Է��ϼ��� :");
		code = scanner.nextInt();
		System.out.print("��й�ȣ�� �Է��ϼ��� :");
		pw = scanner.nextInt();
		System.out.print("������ �Է��ϼ��� (1. ���� 2. ���� 3. �븮 4. ���):");
		lank = scanner.nextInt();
		System.out.print("�ٹ� �ð��� �Է��ϼ���(����: �ð�) : ");
		wTime = scanner.nextInt();
		System.out.print("�ʰ� �ٹ� �ð��� �Է��ϼ���(����: �ð�) : ");
		oTime = scanner.nextInt();
		System.out.print("�������� �Է��ϼ���: ");
		bonus = scanner.nextInt();
		System.out.print("�߰����� �Է��ϼ���: ");
		oBonus = scanner.nextInt();
		System.out.print("�޿��� �Է��ϼ���: ");
		pay = scanner.nextInt();
		
		// ������, �߰���, �޿�
		//pay�� setPworker�ʿ� ���Ŀ� ���� �Ű������� �����ش�.
		_pay.setPWorker(name, pNum, code, pw, lank, wTime, oTime, div, bonus, oBonus, pay);
		
		return 0;
	}
	
	
	// �����ڸ��.����߰��޼ҵ�.�������� �߰� �޼ҵ�
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
		
		System.out.print("�̸��� �Է��ϼ��� : ");
		name = scanner.next();
		System.out.print("��ȭ��ȣ �� �Է��ϼ��� :");
		pNum = scanner.nextInt();
		System.out.print("����� �Է��ϼ��� :");
		code = scanner.nextInt();
		System.out.print("��й�ȣ�� �Է��ϼ��� :");
		pw = scanner.nextInt();
		System.out.print("�Ի� ���� �Է��ϼ��� :");
		firstDate = scanner.nextInt();
		System.out.print("������ �Է��ϼ���  1. ���� 2. ���� 3. �븮 4. ���:");
		lank = scanner.nextInt();
		System.out.print("�ٹ� �ð��� �Է��ϼ���(����: �ð�) : ");
		wTime = scanner.nextInt();
		System.out.print("�ñ��� �Է��ϼ��� :");
		pay = scanner.nextInt();
		System.out.print("���Ⱓ�� �Է��ϼ���: ");
		term = scanner.nextInt();
		
		
		_pay.setNPWorker(name, pNum, code, pw, lank, wTime, pay, div, firstDate, term);
		return 0;
	}
		
	
	// �����ڸ��.�˻� �޼ҵ�
	public int serch(Scanner scanner,PayrollM pay) {
		do {
			int sel2;
			System.out.println("�����ڸ��.<�˻����>");
			System.out.println("1.��ü���   2.�̸��˻�   3.����˻�   4.������� 0.�ڷΰ���");
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

				
	// �����ڸ��.�˻�.��ü ��� �޼ҵ�
	 public int allPrint(Scanner scanner, PayrollM pay) {
	      double[] pwPay = new double[emp.length];		//���
	         double[] npwPay = new double[emp.length];	//�������� ���
	         
	         System.out.println("===========\n\n<<<<<<<<<������>>>>>>>>>\n\n============");
	         for(int i=0;i<maxPeople;i++) {			
	            if(emp[i].getPworkerCode()==0) {   //����� 0�̶�� ���������
	               continue;
	            }
	            // �� �޿� ��� �� 
	            pwPay[i] = (emp[i].getPworkerPay() + emp[i].getPworkerBonus() + emp[i].getPworkerOBonus()) * 0.91;
	            
	            if(emp[i].getPworkerDiv()==0) {   System.out.print("<"+"������"+"\t");}
	            System.out.print(emp[i].getPworkerName()+"\t");
	            if(emp[i].getPworkerLank()==1) {
	            System.out.print("����"+"\t");
	            }else if(emp[i].getPworkerLank()==2) {
	            System.out.print("����"+"\t");
	            }else if(emp[i].getPworkerLank()==3) {
	            System.out.print("�븮"+"\t");
	            }else if(emp[i].getPworkerLank()==4) {
	            System.out.print("���"+"\t");   
	            }
	            System.out.print("0"+emp[i].getPworkerPNum()+">\n");
	            System.out.print("��� : "+ String.format("%03d", emp[i].getPworkerCode()) +"\t");
	            System.out.print("�ٹ��ð� : "+emp[i].getPworkerWTime()+"�ð�\t");
	            System.out.print("�ʰ� �ٹ� : "+emp[i].getPworkerOTime()+"�ð�\n");
	            System.out.print("������ :"+emp[i].getPworkerBonus());
	            System.out.print("\n�߰��� :"+emp[i].getPworkerOBonus());
	            System.out.printf("\n�� �޿�: %.2f\n", pwPay[i]);
	            System.out.println("=========================================================");
	         }
	         
	         
	         
	         System.out.println("===========\n\n<<<<<<��������>>>>>>\n\n============");
	      
	         for(int j=0;j<maxPeople;j++) {
	            if(emp[j].getNPworkerCode()==0) {   //����� 0�̶�� ���������
	               continue;
	            }
	            // �� �޿� ���
	            npwPay[j] = (emp[j].getNPworkerPay() * emp[j].getNPworkerWTime() * 5 * 4) * 0.91;
	            
	            if(emp[j].getNPworkerDiv()==1) {System.out.print("<"+ "��������"+"\t");}
	            System.out.print(emp[j].getNPworkerName()+"\t");
	            if(emp[j].getNPworkerLank()==1) {
	            	System.out.print("����"+"\t");
	            }else if(emp[j].getNPworkerLank()==2) {
	            	System.out.print("����"+"\t");
	            }else if(emp[j].getNPworkerLank()==3) {
	            	System.out.print("�븮"+"\t");
	            }else if(emp[j].getNPworkerLank()==4) {
	            	System.out.print("���"+"\t");   
	            }   
	            
	            System.out.print("0"+emp[j].getNPworkerPNum()+">\n");
	            System.out.print("��� : "+ String.format("%03d", emp[j].getNPworkerCode())+"\t");
	            System.out.println("�Ի��� :"+emp[j].getNPworkerFirstDate());
	            System.out.println("���Ⱓ :"+emp[j].getNPworkerTerm());
	            System.out.println("�ð� �� �޿� :"+emp[j].getNPworkerPay());
	            System.out.printf("�� �޿�: %.2f\n", npwPay[j]);
	            System.out.println("=========================================================");
	               
	           }

	      return 0;
	   }	
	
	
	// �����ڸ��.�˻�.�̸� �˻� �޼���
	public void namePrint(Scanner scanner) {
		System.out.print("�̸��� �Է��ϼ���: ");
		String name = scanner.next();
		double[] pwPay = new double[emp.length];
		double[] npwPay = new double[emp.length];
		
		
		for(int i=0; i<maxPeople; i++) {
			if(name.equals(emp[i].getPworkerName()) && emp[i].getPworkerDiv()==0) {
				// �� �޿� ���
				pwPay[i] = (emp[i].getPworkerPay() + emp[i].getPworkerBonus() + emp[i].getPworkerOBonus()) * 0.91;
				
	            if(emp[i].getPworkerDiv()==0) {   System.out.print("<"+"������"+"\t");}
	            System.out.print(emp[i].getPworkerName()+"\t");
	            if(emp[i].getPworkerLank()==1) {
	            System.out.print("����"+"\t");
	            }else if(emp[i].getPworkerLank()==2) {
	            System.out.print("����"+"\t");
	            }else if(emp[i].getPworkerLank()==3) {
	            System.out.print("�븮"+"\t");
	            }else if(emp[i].getPworkerLank()==4) {
	            System.out.print("���"+"\t");   
	            }
	            
				System.out.print("0"+emp[i].getPworkerPNum()+">\n");
				System.out.print("��� : "+ String.format("%03d", emp[i].getPworkerCode()) +"\t");
				System.out.print("�ٹ��ð� : "+emp[i].getPworkerWTime()+"�ð�\t");
				System.out.print("�ʰ� �ٹ� : "+emp[i].getPworkerOTime()+"�ð�\n");
				System.out.print("������ :"+emp[i].getPworkerBonus());
				System.out.print("\n�߰��� :"+emp[i].getPworkerOBonus());
				System.out.println("\n�� �޿� :"+ pwPay[i]);
				System.out.println("----------------------------------");
			}else if(name.equals(emp[i].getNPworkerName()) && emp[i].getNPworkerDiv()==1) {
				// �� �޿� ���
	            npwPay[i] = (emp[i].getNPworkerPay() * emp[i].getNPworkerWTime() * 5 * 4) * 0.91;
	            
	            if(emp[i].getNPworkerDiv()==1) {System.out.print("<"+ "��������"+"\t");}
	            System.out.print(emp[i].getNPworkerName()+"\t");
	            if(emp[i].getNPworkerLank()==1) {
	            	System.out.print("����"+"\t");
	            }else if(emp[i].getNPworkerLank()==2) {
	            	System.out.print("����"+"\t");
	            }else if(emp[i].getNPworkerLank()==3) {
	            	System.out.print("�븮"+"\t");
	            }else if(emp[i].getNPworkerLank()==4) {
	            	System.out.print("���"+"\t");   
	            }   
				System.out.print("0"+emp[i].getNPworkerPNum()+">\n");
				System.out.print("��� : "+ String.format("%03d", emp[i].getNPworkerCode()) +"\t");
				System.out.println("�Ի��� :"+emp[i].getNPworkerFirstDate());
				System.out.println("���Ⱓ :"+emp[i].getNPworkerTerm());
				System.out.println("�ð� �� �޿� :"+emp[i].getNPworkerPay());
				System.out.println("�� �޿�: " + npwPay[i]);
				System.out.println("----------------------------------");
			}
		}
		
	}
	
	// �����ڸ��.�˻�.����˻� �޼���
	// (����ڸ��.�纯��ȸ�� ���� ����� �Ѵ�.)
	
	// �����ڸ��.�˻�.������� �޼���
	public void printLank(Scanner scanner) {
		System.out.print("������ �Է��ϼ���: ");
		System.out.println("1.����  2.����  3.�븮  4.���");
		int lank = scanner.nextInt();
		
		double[] pwPay = new double[emp.length];
		double[] npwPay = new double[emp.length];
		
		
		for(int i=0; i<maxPeople; i++) {
			if(lank == emp[i].getPworkerLank() && emp[i].getPworkerDiv()==0) {
				// �� �޿� ���
				pwPay[i] = (emp[i].getPworkerPay() + emp[i].getPworkerBonus() + emp[i].getPworkerOBonus()) * 0.91;
				
	            if(emp[i].getPworkerDiv()==0) {   System.out.print("<"+"������"+"\t");}
	            System.out.print(emp[i].getPworkerName()+"\t");
	            if(emp[i].getPworkerLank()==1) {
	            System.out.print("����"+"\t");
	            }else if(emp[i].getPworkerLank()==2) {
	            System.out.print("����"+"\t");
	            }else if(emp[i].getPworkerLank()==3) {
	            System.out.print("�븮"+"\t");
	            }else if(emp[i].getPworkerLank()==4) {
	            System.out.print("���"+"\t");   
	            }
	            
				System.out.print("0"+emp[i].getPworkerPNum()+">\n");
				System.out.print("��� : "+ String.format("%03d", emp[i].getPworkerCode()) +"\t");
				System.out.print("�ٹ��ð� : "+emp[i].getPworkerWTime()+"�ð�\t");
				System.out.print("�ʰ� �ٹ� : "+emp[i].getPworkerOTime()+"�ð�\n");
				System.out.print("������ :"+emp[i].getPworkerBonus());
				System.out.print("\n�߰��� :"+emp[i].getPworkerOBonus());
				System.out.printf("\n�� �޿�: %.2f\n", pwPay[i]);
				System.out.println("----------------------------------");
			}else if(lank == emp[i].getNPworkerLank() && emp[i].getNPworkerDiv()==1) {
				// �� �޿� ���
	            npwPay[i] = (emp[i].getNPworkerPay() * emp[i].getNPworkerWTime() * 5 * 4) * 0.91;
	            
	            if(emp[i].getNPworkerDiv()==1) {System.out.print("<"+ "��������"+"\t");}
	            System.out.print(emp[i].getNPworkerName()+"\t");
	            if(emp[i].getNPworkerLank()==1) {
	            	System.out.print("����"+"\t");
	            }else if(emp[i].getNPworkerLank()==2) {
	            	System.out.print("����"+"\t");
	            }else if(emp[i].getNPworkerLank()==3) {
	            	System.out.print("�븮"+"\t");
	            }else if(emp[i].getNPworkerLank()==4) {
	            	System.out.print("���"+"\t");   
	            }   
				System.out.print("0"+emp[i].getNPworkerPNum()+">\n");
				System.out.print("��� : "+ String.format("%03d", emp[i].getNPworkerCode()) +"\t");
				System.out.println("�Ի��� :"+emp[i].getNPworkerFirstDate());
				System.out.println("���Ⱓ :"+emp[i].getNPworkerTerm());
				System.out.println("�ð� �� �޿� :"+emp[i].getNPworkerPay());
				System.out.printf("�� �޿�: %.2f\n", npwPay[i]);
				System.out.println("----------------------------------");
			}
		}
	}
	
	
	// �����ڸ��.�˻�.����˻� �޼���
	public int mSearchCode(Scanner scanner, PayrollM pay) {

		double[] pwPay = new double[emp.length];
		double[] npwPay = new double[emp.length];

		do {
			int sel3;
			int checkCode = 0;
			int checkPw;
			
			System.out.println("GEUB YEO �� ������ ��� �� �˻� �� <��� �˻�>");
			System.out.println("1.����˻� 0. �ڷΰ���");
			sel3 = scanner.nextInt();

			switch (sel3) {
			case 0:
				return 0;

			case 1:
				System.out.print("����� �Է��ϼ��� : ");
				checkCode = scanner.nextInt();

				for (int i = 0; i < maxPeople; i++) {
					// ������
					// ����� ��ġ�ϴ��� üũ
					if(emp[i].getPworkerCode() == checkCode && emp[i].getPworkerDiv()==0) {
						
						// �� �޿� ���
						pwPay[i] = (emp[i].getPworkerPay() + emp[i].getPworkerBonus() + emp[i].getPworkerOBonus())
								* 0.91;

			            if(emp[i].getPworkerDiv()==0) {   System.out.print("<"+"������"+"\t");}
			            System.out.print(emp[i].getPworkerName()+"\t");
			            if(emp[i].getPworkerLank()==1) {
			            System.out.print("����"+"\t");
			            }else if(emp[i].getPworkerLank()==2) {
			            System.out.print("����"+"\t");
			            }else if(emp[i].getPworkerLank()==3) {
			            System.out.print("�븮"+"\t");
			            }else if(emp[i].getPworkerLank()==4) {
			            System.out.print("���"+"\t");   
			            }
						System.out.print("0" + emp[i].getPworkerPNum() + ">\n");
						System.out.print("��� : " + String.format("%03d", emp[i].getPworkerCode()) + "\t");
						System.out.print("�ٹ��ð� : " + emp[i].getPworkerWTime() + "�ð�\t");
						System.out.print("�ʰ� �ٹ� : " + emp[i].getPworkerOTime() + "�ð�\n");
						System.out.print("������ :" + emp[i].getPworkerBonus());
						System.out.print("\n�߰��� :" + emp[i].getPworkerOBonus());
						System.out.printf("\n�� �޿�: %.2f\n", pwPay[i]);
						
					// ��������
					// ����� ��ġ�ϴ��� üũ
					} else if(emp[i].getNPworkerCode() == checkCode && emp[i].getNPworkerDiv()==1) {
						
						// �� �޿� ���
						npwPay[i] = (emp[i].getNPworkerPay() * emp[i].getNPworkerWTime() * 5 * 4) * 0.91;

			            if(emp[i].getNPworkerDiv()==1) {System.out.print("<"+ "��������"+"\t");}
			            System.out.print(emp[i].getNPworkerName()+"\t");
			            if(emp[i].getNPworkerLank()==1) {
			            	System.out.print("����"+"\t");
			            }else if(emp[i].getNPworkerLank()==2) {
			            	System.out.print("����"+"\t");
			            }else if(emp[i].getNPworkerLank()==3) {
			            	System.out.print("�븮"+"\t");
			            }else if(emp[i].getNPworkerLank()==4) {
			            	System.out.print("���"+"\t");   
			            }   
						System.out.print("0" + emp[i].getNPworkerPNum() + ">\n");
						System.out.print("��� : " + String.format("%03d", emp[i].getNPworkerCode()) + "\t");

						System.out.println("�Ի��� :" + emp[i].getNPworkerFirstDate());
						System.out.println("���Ⱓ :" + emp[i].getNPworkerTerm());
						System.out.println("�ð� �� �޿� :" + emp[i].getNPworkerPay());
						System.out.printf("�� �޿�: %.2f\n", npwPay[i]);
						System.out.println("=======================================");

					}
				}

			}
		} while (true);

	}

	
	
	// �����ڸ��.���� �޼���
	public void deleteData(Scanner scanner, PayrollM _pay) {
		int deleteCode;
		_pay.allPrint(scanner, _pay);
		System.out.print("������ ��� �Է�: ");
		deleteCode = scanner.nextInt();
		
		for(int i=0; i<maxPeople; i++) {
			if(emp[i].getPworkerCode() == deleteCode || emp[i].getNPworkerCode() == deleteCode) {
				emp[i] = new Db();
				System.out.println("���: " + deleteCode + "�� ���������� �����Ǿ����ϴ�.");
			}
		}
	}
	
	
	//--------------------------------------------------------------------

	// ����� ��� �޼ҵ�
	public int userMode(Scanner scanner, PayrollM pay) {
			do {
				System.out.println("GEUB YEO �� <����� ���>");
				System.out.println("1.��ȭ��ȣ ����   2.�̸� ����   3.��� ��ȸ   0.�ڷΰ���");
				int sel2;
				sel2 = scanner.nextInt();
				switch (sel2) {
				case 0:
					return 0; // �ڷΰ���
				case 1:
					// ��ȭ��ȣ ����
					pay.rePNum(scanner);
					break;
				case 2:
					// �̸� ����
					pay.reName(scanner);
					break;
				case 3:
					// ��ȸ ����ް� �������
					uSearchCode(scanner, pay);
					break;
				}

			} while (true);
		}

	
	// ����ڸ��.�����ȸ
	public int uSearchCode(Scanner scanner, PayrollM pay) {

		double[] pwPay = new double[emp.length];
		double[] npwPay = new double[emp.length];

		do {
			int sel3;
			int checkCode = 0;
			int checkPw;
			
			System.out.println("GEUB YEO �� ����� ��� �� <��� ��ȸ>");
			System.out.println("1.�����ȸ 0. �ڷΰ���");
			sel3 = scanner.nextInt();

			switch (sel3) {
			case 0:
				return 0;

			case 1:
				System.out.print("����� �Է��ϼ��� : ");
				checkCode = scanner.nextInt();
				System.out.print("��й�ȣ�� �Է��ϼ��� : ");
				checkPw = scanner.nextInt();

				for (int i = 0; i < maxPeople; i++) {
					// ������
					// ����� ��ġ�ϴ� pw���� üũ
					if(emp[i].getPworkerCode() == checkCode && emp[i].getPworkerPw() == checkPw && emp[i].getPworkerDiv()==0) {
						
						// �� �޿� ���
						pwPay[i] = (emp[i].getPworkerPay() + emp[i].getPworkerBonus() + emp[i].getPworkerOBonus())
								* 0.91;

			            if(emp[i].getPworkerDiv()==0) {   System.out.print("<"+"������"+"\t");}
			            System.out.print(emp[i].getPworkerName()+"\t");
			            if(emp[i].getPworkerLank()==1) {
			            System.out.print("����"+"\t");
			            }else if(emp[i].getPworkerLank()==2) {
			            System.out.print("����"+"\t");
			            }else if(emp[i].getPworkerLank()==3) {
			            System.out.print("�븮"+"\t");
			            }else if(emp[i].getPworkerLank()==4) {
			            System.out.print("���"+"\t");   
			            }
						System.out.print("0" + emp[i].getPworkerPNum() + ">\n");
						System.out.print("��� : " + String.format("%03d", emp[i].getPworkerCode()) + "\t");
						System.out.print("�ٹ��ð� : " + emp[i].getPworkerWTime() + "�ð�\t");
						System.out.print("�ʰ� �ٹ� : " + emp[i].getPworkerOTime() + "�ð�\n");
						System.out.print("������ :" + emp[i].getPworkerBonus());
						System.out.print("\n�߰��� :" + emp[i].getPworkerOBonus());
						System.out.printf("\n�� �޿�: %.2f\n", pwPay[i]);
						
					// ��������
					// ����� ��ġ�ϴ� pw���� üũ
					} else if(emp[i].getNPworkerCode() == checkCode && emp[i].getNPworkerPw() == checkPw&& emp[i].getNPworkerDiv()==1) {
						
						// �� �޿� ���
						npwPay[i] = (emp[i].getNPworkerPay() * emp[i].getNPworkerWTime() * 5 * 4) * 0.91;

			            if(emp[i].getNPworkerDiv()==1) {System.out.print("<"+ "��������"+"\t");}
			            System.out.print(emp[i].getNPworkerName()+"\t");
			            if(emp[i].getNPworkerLank()==1) {
			            	System.out.print("����"+"\t");
			            }else if(emp[i].getNPworkerLank()==2) {
			            	System.out.print("����"+"\t");
			            }else if(emp[i].getNPworkerLank()==3) {
			            	System.out.print("�븮"+"\t");
			            }else if(emp[i].getNPworkerLank()==4) {
			            	System.out.print("���"+"\t");   
			            }   
						System.out.print("0" + emp[i].getNPworkerPNum() + ">\n");
						System.out.print("��� : " + String.format("%03d", emp[i].getNPworkerCode()) + "\t");

						System.out.println("�Ի��� :" + emp[i].getNPworkerFirstDate());
						System.out.println("���Ⱓ :" + emp[i].getNPworkerTerm());
						System.out.println("�ð� �� �޿� :" + emp[i].getNPworkerPay());
						System.out.printf("�� �޿�: %.2f\n", npwPay[i]);
						System.out.println("=======================================");

					}
				}

			}
		} while (true);

	}

	
	// ����ڸ��.��ȭ��ȣ ����
	public void rePNum(Scanner scanner) {
		int checkCode;
		int checkPw;
		System.out.print("��� �Է�: ");
		checkCode = scanner.nextInt();
		System.out.print("��й�ȣ �Է�: ");
		checkPw = scanner.nextInt();
		
		for(int i=0; i<maxPeople; i++) {
			// ������
			// ����� ��ġ�ϴ� pw���� üũ
			if(emp[i].getPworkerCode() == checkCode && emp[i].getPworkerPw() == checkPw && emp[i].getPworkerDiv()==0) {
				System.out.print("������ ��ȭ��ȣ�� �Է��ϼ���: ");
				emp[i].setPworkerPNum(scanner.nextInt());
				break;
				
			// ��������
			// ����� ��ġ�ϴ� pw���� üũ
			}else if(emp[i].getNPworkerCode() == checkCode && emp[i].getNPworkerPw() == checkPw&& emp[i].getNPworkerDiv()==1) {
				System.out.print("������ ��ȭ��ȣ�� �Է��ϼ���: ");
				emp[i].setNPworkerPNum(scanner.nextInt());
				break;
			}
		}
	}
	
	
	// ����ڸ��.�̸� ����
	public void reName(Scanner scanner) {
		int checkCode;
		int checkPw;
		System.out.print("��� �Է�: ");
		checkCode = scanner.nextInt();
		System.out.print("��й�ȣ �Է�: ");
		checkPw = scanner.nextInt();
		
		for(int i=0; i<maxPeople; i++) {
			if(checkCode == emp[i].getPworkerCode() && checkPw == emp[i].getPworkerPw() && emp[i].getPworkerDiv()==0) {
				System.out.print("������ �̸��� �Է��ϼ���: ");
				emp[i].setPworkerName(scanner.next());
			}else if(checkCode == emp[i].getNPworkerCode() && checkPw == emp[i].getNPworkerPw() && emp[i].getNPworkerDiv()==1) {
				System.out.print("������ �̸��� �Է��ϼ���: ");
				emp[i].setNPworkerName(scanner.next());
			}
		}
	}
	
}