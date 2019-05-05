package com.yyn.phone.provider.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageBean<T> implements Serializable{

    private static final long serialVersionUID = 1L;

    // 当前页
    private Integer currentPage = 1;
    // 每页显示的总条数
    private Integer pageSize = 10;
    // 总条数
    private Integer totalNum;
    // 是否有下一页
    private Integer isMore;
    // 总页数
    private Integer totalPage;
    // 开始索引
    private Integer startIndex;
    // 分页结果
    private List<T> items;

    private List<String> pageView;

    public PageBean() {
        super();
    }

    public PageBean(Integer currentPage, Integer pageSize, Integer totalNum) {
        super();
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalNum = totalNum;
        this.totalPage = (this.totalNum+this.pageSize-1)/this.pageSize;
        this.startIndex = (this.currentPage-1)*this.pageSize;
        this.isMore = this.currentPage >= this.totalPage?0:1;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getIsMore() {
        return isMore;
    }

    public void setIsMore(Integer isMore) {
        this.isMore = isMore;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    /**
     * 获得分页样式
     *
     * @return
     */
    public List<String> getPageView() {
        return pageView;
    }
    /**
     * 设置分页样式
     *
     * @param list
     */
    public void setPageView(List<String> pageView) {
        this.pageView = pageView;
    }


    /**
     * 分页显示样示部分
     */
    public void pageView(String url){

        pageView = new ArrayList<String>();

        if(this.currentPage != 1){
            pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + this.pageSize + "&currentPage=1'\"><font size=2>首页</font></a>");
            pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + this.pageSize + "&currentPage="+(this.currentPage-1)+"'\"><font size=2>上一页</font></a>");
        }else{
            pageView.add("<font size=2>首页</font>");
            pageView.add("<font size=2>上一页</font>");
        }

        if(this.getTotalPage() <= 10){
            for (int i = 0; i < this.getTotalPage(); i++) {
                if((i+1)==this.currentPage){
                    pageView.add("<strong>"+this.currentPage+"</strong>");
                    i = i+1;
                    if(this.currentPage==this.getTotalPage())break;
                }
                pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + this.pageSize + "&currentPage="+(i+1)+"'\">"+(i+1)+"</a>");
            }
        }else if(this.getTotalPage() <= 20){
            //没有把...加上
            int l = 0;
            int r = 0;
            if(this.currentPage<5){
                l=this.currentPage-1;
                r=10-l-1;
            }else if(this.getTotalPage()-this.currentPage<5){
                r=this.getTotalPage()-this.currentPage;
                l=10-1-r;
            }else{
                l=4;
                r=5;
            }
            int tmp =  this.currentPage-l;
            for (int i = tmp; i < tmp+10; i++) {
                if(i==this.currentPage){
                    pageView.add("<strong>"+this.currentPage+"</strong>");
                    i = i+1;
                    if(this.currentPage==this.getTotalPage()) break;
                }
                pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + this.pageSize + "&currentPage="+(i)+"'\">"+(i)+"</a>");
            }

        }else if(this.currentPage<7){
            for (int i = 0; i < 8; i++) {
                if(i+1==this.currentPage){
                    pageView.add("<strong>"+this.currentPage+"</strong>");
                    i = i+1;
                }
                pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + this.pageSize + "&currentPage="+(i+1)+"'\">"+(i+1)+"</a>");
            }
            pageView.add("...");
            pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + this.pageSize + "&currentPage="+(this.getTotalPage()-1)+"'\">"+(this.getTotalPage()-1)+"</a>");
            pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + this.pageSize + "&currentPage="+(this.getTotalPage())+"'\">"+(this.getTotalPage())+"</a>");
        }else if(this.currentPage>this.getTotalPage()-6){
            pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + this.pageSize + "&currentPage="+(1)+"'\">"+(1)+"</a>");
            pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + this.pageSize + "&currentPage="+(2)+"'\">"+(2)+"</a>");
            pageView.add("...");
            for (int i = this.getTotalPage()-8; i <this.getTotalPage() ; i++) {
                if(i+1==this.currentPage){
                    pageView.add("<strong>"+this.currentPage+"</strong>");
                    i = i+1;
                    if(this.currentPage==this.getTotalPage()) break;
                }
                pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + this.pageSize + "&currentPage="+(i+1)+"'\">"+(i+1)+"</a>");
            }
        }else{
            pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + this.pageSize + "&currentPage="+(1)+"'\">"+(1)+"</a>");
            pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + this.pageSize + "&currentPage="+(2)+"'\">"+(2)+"</a>");
            pageView.add("...");

            pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + this.pageSize + "&currentPage="+(this.currentPage-2)+"'\">"+(this.currentPage-2)+"</a>");
            pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + this.pageSize + "&currentPage="+(this.currentPage-1)+"'\">"+(this.currentPage-1)+"</a>");
            pageView.add("<strong>"+this.currentPage+"</strong>");
            pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + this.pageSize + "&currentPage="+(this.currentPage+1)+"'\">"+(this.currentPage+1)+"</a>");
            pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + this.pageSize + "&currentPage="+(this.currentPage+2)+"'\">"+(this.currentPage+2)+"</a>");

            pageView.add("...");
            pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + this.pageSize + "&currentPage="+(this.getTotalPage()-1)+"'\">"+(this.getTotalPage()-1)+"</a>");
            pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + this.pageSize + "&currentPage="+(this.getTotalPage())+"'\">"+(this.getTotalPage())+"</a>");
        }
        if(this.currentPage != this.getTotalPage()){
            pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + this.pageSize + "&currentPage="+(this.currentPage+1)+"'\"><font size=2>下一页</font></a>");
            pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + this.pageSize + "&currentPage="+this.getTotalPage()+"'\"><font size=2>尾页</font></a>");
        } else{
            pageView.add("<font size=2>下一页</font>");
            pageView.add("<font size=2>尾页</font>");
        }
        pageView.add("共<var>" + getTotalPage() + "</var>页 到第<input type='text' id='currentPage'  size='3' style='width: 18px;height: 12px; margin: 0 3px;'/>页 <input type='button' id='skip' class='hand btn60x20' value='确定' onclick=\"javascript:window.location.href = '" + url + "?" + this.pageSize + "&currentPage=' + $('#currentPage').val() \"/>");
    }



}
