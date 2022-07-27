package du.common;

public class Pagination {
	//한 페이지 당 보여질 목록 갯수
	private int listSize=10;
	
	//한 페이지 범위에 보여질 페이지 갯수
	private int rangeSize=2;
	
	//현재 페이지
	private int page;
	
	//현재 페이지 범위
	private int range;
	
	//총 게시물 수
	private int listCnt;
	//총 페이지 범위의 갯수
	private int pageCnt;
	
	//각 페이지 범위의 시작 번호

	

	

	private int startPage;
	//각 페이지 범위의 끝 번호
	private int endPage;
	
	
	private int StartList;
	//이전 페이지
	private boolean prev;
	
	//다음 페이지
	private boolean next;

	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	public int getRangeSize() {
		return rangeSize;
	}

	public void setRangeSize(int rangeSize) {
		this.rangeSize = rangeSize;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getListCnt() {
		return listCnt;
	}

	public void setListCnt(int listCnt) {
		this.listCnt = listCnt;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getStartList() {
		return StartList;
	}

	public void setStartList(int startList) {
		this.StartList = startList;
	}

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
	
	public int getPageCnt() {
		return pageCnt;
	}

	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}
	



	public void pageInfo(int page,int range,int listCnt) {
		this.page=page;
		this.range=range;
		this.listCnt=listCnt;
		//총 페이지 범위의 갯수
		this.pageCnt=(int)Math.ceil((float)listCnt/listSize);
		
		//시작 번호
		this.startPage=(range-1)*rangeSize+1;
		
		//끝 번호
		this.endPage=range*rangeSize;
		
		//Mapper에 사용할 Limit 시작번호
		this.StartList=(page-1)*listSize;
		
		//이전버튼
		this.prev=range==1 ? false:true;
		
		//다음버튼
		this.next=endPage>pageCnt ? false:true;
		if(endPage>=pageCnt) {
			this.endPage=this.pageCnt;
			this.next=false;
			
		}
		
		
		
	}
}
