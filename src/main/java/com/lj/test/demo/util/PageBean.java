package com.lj.test.demo.util;

import java.util.List;

public class PageBean<T> {
    private List<T> list;       //结果集
    private int firstPage;      //首页
    private int prePage;        // 上一页
    private int nextPage;       // 下一页
    private int currentPage ;   // 当前页
    private int pageSize = 10;  // 每页显示的条数
    private int totalPage;      // 总页数
    private int totalCount ;    // 总条数

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getFirstPage() {
        return 1;
    }

    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }

    //上一页： 算法：如果当前页是首页，则为1，否则为当前页-1
    public int getPrePage() {
        return this.getCurrentPage()==this.getFirstPage() ? 1 : this.getCurrentPage()-1;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    //下一页：算法：如果当前页是末页，则为末页，否则当前页+1
    public int getNextPage() {
        return this.getCurrentPage()==this.getTotalPage() ?this.getTotalPage() : this.getCurrentPage()+1;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return (totalCount + pageSize - 1) / pageSize ;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
