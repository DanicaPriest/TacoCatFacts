package mybatis.model.nyt.challenges;

public class ResponseComparison {
    String searchTermOne;
    String searchTermTwo;
    int searchTermOneResultCount;
    int SearchTermTwoResultCount;

    public String getSearchTermOne() {
        return searchTermOne;
    }

    public void setSearchTermOne(String searchTermOne) {
        this.searchTermOne = searchTermOne;
    }

    public String getSearchTermTwo() {
        return searchTermTwo;
    }

    public void setSearchTermTwo(String searchTermTwo) {
        this.searchTermTwo = searchTermTwo;
    }

    public int getSearchTermOneResultCount() {
        return searchTermOneResultCount;
    }

    public void setSearchTermOneResultCount(int searchTermOneResultCount) {
        this.searchTermOneResultCount = searchTermOneResultCount;
    }

    public int getSearchTermTwoResultCount() {
        return SearchTermTwoResultCount;
    }

    public void setSearchTermTwoResultCount(int searchTermTwoResultCount) {
        SearchTermTwoResultCount = searchTermTwoResultCount;
    }
}
