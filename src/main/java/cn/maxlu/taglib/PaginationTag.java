package cn.maxlu.taglib;

import org.springframework.web.servlet.tags.RequestContextAwareTag;

import javax.servlet.jsp.JspException;
import java.io.IOException;

public class PaginationTag extends RequestContextAwareTag {
    private int pageNo;
    private int pageSize;
    private long totalRecords;
    private String url;

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getTotalPages() {
        return (int) totalRecords / pageSize + 1;
    }

    @Override
    protected int doStartTagInternal() throws JspException, IOException {
        StringBuilder stringBuilder = new StringBuilder(1000);
        stringBuilder.append("<span>共").append(totalRecords).append("篇</span>");

        int totalPages = getTotalPages();
        if (totalPages > 1) {
            for (int i = 1; i <= totalPages; i++) {
                if (i != pageNo) {
                    stringBuilder.append("<a href=\"").append(url).append(i).append("/").append(pageSize).append("\"/>").append(i).append("</a>");
                } else {
                    stringBuilder.append("<strong>").append(i).append("</strong>");
                }
            }
        }
        pageContext.getOut().write(stringBuilder.toString());
        return SKIP_BODY;
    }
}
