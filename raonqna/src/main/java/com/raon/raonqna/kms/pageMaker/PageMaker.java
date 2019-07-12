package com.raon.raonqna.kms.pageMaker;

public class PageMaker {

	private int totalCount;//전체 게시물 개수
	private int pageNum;//현재 페이지 번호
	private int contentNum = 10; //한 페이지에 몇 개 표시할지
	private int startPage=1;//현재 페이지 블록의 시작 페이지
	private int endPage=5;//현제 페이지 블록의 마지막 페이지
	private boolean prev=false;//이전 페이지로 가는 화살표
	private boolean next;//다음 페이지로 가는 화살표
	private int currentBlock=1; //현재 페이지 블록
	private int lastblock; //마지막페이지 블록
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
		//한 페이지에 5개씩 보여지므로
		//현재 페이지 블록의 번호 * 블록당 페이지의 개수(5) - 4를 하면 시작 페이지 번호를 정할 수 있다
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
		//기본 시작페이지 +4
		//조건 , 마지막 페이지 블록이면 마지막 페이지 번호
	}


	public int getCurrentBlock() {
		return currentBlock;
	}

	public void setCurrentBlock(int pageNum) {//현재 페이지 블록의 번호가 몇번인지 지정해주는 함수
		//	        페이지번호 / 페이지 그룹 안의 페이지 개수(5)
		//	        ->나머지 있으면 더하기 1한다. -> 이 결과를 현재 블록 번호라고 부른다. cblock

		this.currentBlock = pageNum/5;
		if (pageNum%5>0) {
			this.currentBlock++;
		}
	}

	public int getLastblock() {
		return lastblock;
	}

	public void setLastblock(int totalCount) {//마지막 페이지 블록의 번호가 뭔지 지정해주는 함수
		//전체 글 개수를 사용해서 지정한다
		this.lastblock = totalCount / (5*this.contentNum);
		if (totalCount%(5*this.contentNum)>0) {
			this.lastblock++;
		}
		//	        전체 글 개수(128) / 페이지 그룹 안의 페이지 개수(5) * 한페이지당 글 개수(10)
		//	        ->나머지 있으면 더하기 1한다. -> 이 결과를 마지막 블록 번호라고 부른다. last block
	}

	public void prevNext(int pageNum) {

		if (pageNum>0 && pageNum<6) {
			setPrev(false);
			setNext(true);
		}
		else if(getLastblock()==getCurrentBlock()) {//5개씩 페이지의 그룹번호를 지정한다.
			//그룹 번호가 3이라는 것은 해당 페이지 그룹이 마지막이라는 것이기에 이전 화살표만 활성화한다 
			//이 두개가 같다면 마지막 블록이므로 이전만 있고 이후가 없다.

			setPrev(true);
			setNext(false);        
		}
		else {
			setPrev(true);
			setNext(true);
		}
	}
	public int calcpage(int totalCount,int contentNum) {//전체 몇페이지까지 있을지 함수로 계산한다
		int totalpage = totalCount/contentNum;//전체 게시물 수를 한 페이지당 몇개 보이는지로 나눈다
		if (totalCount % contentNum>0) {//그리고 나머지가 있다면 1을 더해서 한 페이지 증가 시킨다
			totalpage++;
		}
		if (totalpage<this.pageNum) {
			this.pageNum=totalpage;
		}
		return totalpage;//페이지 개수를 리턴한다
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



