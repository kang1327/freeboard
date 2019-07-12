package com.raon.raonqna.kms.pageMaker;

public class PageMaker {

	private int totalCount;//��ü �Խù� ����
	private int pageNum;//���� ������ ��ȣ
	private int contentNum = 10; //�� �������� �� �� ǥ������
	private int startPage=1;//���� ������ ����� ���� ������
	private int endPage=5;//���� ������ ����� ������ ������
	private boolean prev=false;//���� �������� ���� ȭ��ǥ
	private boolean next;//���� �������� ���� ȭ��ǥ
	private int currentBlock=1; //���� ������ ���
	private int lastblock; //������������ ���
	private int countlist;

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int currentblock) {
		this.startPage = (currentblock*5)-4;
		//�� �������� 5���� �������Ƿ�
		//���� ������ ����� ��ȣ * ��ϴ� �������� ����(5) - 4�� �ϸ� ���� ������ ��ȣ�� ���� �� �ִ�
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int getlastblock,int getcurrentblock) {
		if (getlastblock==getcurrentblock) {
			this.endPage = calcpage(getTotalCount(),getContentNum());
		}
		else {
			this.endPage = getStartPage()+4;
		}
		//�⺻ ���������� +4
		//���� , ������ ������ ����̸� ������ ������ ��ȣ
	}


	public int getCurrentBlock() {
		return currentBlock;
	}

	public void setCurrentBlock(int pageNum) {//���� ������ ����� ��ȣ�� ������� �������ִ� �Լ�
		//	        ��������ȣ / ������ �׷� ���� ������ ����(5)
		//	        ->������ ������ ���ϱ� 1�Ѵ�. -> �� ����� ���� ��� ��ȣ��� �θ���. cblock

		this.currentBlock = pageNum/5;
		if (pageNum%5>0) {
			this.currentBlock++;
		}
	}

	public int getLastblock() {
		return lastblock;
	}

	public void setLastblock(int totalCount) {//������ ������ ����� ��ȣ�� ���� �������ִ� �Լ�
		//��ü �� ������ ����ؼ� �����Ѵ�
		this.lastblock = totalCount / (5*this.contentNum);
		if (totalCount%(5*this.contentNum)>0) {
			this.lastblock++;
		}
		//	        ��ü �� ����(128) / ������ �׷� ���� ������ ����(5) * ���������� �� ����(10)
		//	        ->������ ������ ���ϱ� 1�Ѵ�. -> �� ����� ������ ��� ��ȣ��� �θ���. last block
	}

	public void prevNext(int pageNum) {

		if (pageNum>0 && pageNum<6) {
			setPrev(false);
			setNext(true);
		}
		else if(getLastblock()==getCurrentBlock()) {//5���� �������� �׷��ȣ�� �����Ѵ�.
			//�׷� ��ȣ�� 3�̶�� ���� �ش� ������ �׷��� �������̶�� ���̱⿡ ���� ȭ��ǥ�� Ȱ��ȭ�Ѵ� 
			//�� �ΰ��� ���ٸ� ������ ����̹Ƿ� ������ �ְ� ���İ� ����.

			setPrev(true);
			setNext(false);        
		}
		else {
			setPrev(true);
			setNext(true);
		}
	}
	public int calcpage(int totalCount,int contentNum) {//��ü ������������ ������ �Լ��� ����Ѵ�
		int totalpage = totalCount/contentNum;//��ü �Խù� ���� �� �������� � ���̴����� ������
		if (totalCount % contentNum>0) {//�׸��� �������� �ִٸ� 1�� ���ؼ� �� ������ ���� ��Ų��
			totalpage++;
		}
		if (totalpage<this.pageNum) {
			this.pageNum=totalpage;
		}
		return totalpage;//������ ������ �����Ѵ�
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getCountlist() {
		return countlist;
	}

	public void setCountlist(int countlist) {
		this.countlist = countlist;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getContentNum() {
		return contentNum;
	}

	public void setContentNum(int contentNum) {
		this.contentNum = contentNum;
	}



}



