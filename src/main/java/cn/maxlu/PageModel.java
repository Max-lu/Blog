package cn.maxlu;

import java.util.List;

/**
 * Created by max.lu on 2016/2/24.
 */
public class PageModel<T> {
    private int pageNo;
    private int pageSize;
    private long totalRecords;
    private List<T> records;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public static <T> PageModel<T> createPageModel(int pageNo, int pageSize, long totalRecords, List<T> records) {
        PageModel<T> pageModel = new PageModel<T>();
        pageModel.setPageNo(pageNo);
        pageModel.setPageSize(pageSize);
        pageModel.setTotalRecords(totalRecords);
        pageModel.setRecords(records);
        return pageModel;
    }
}
