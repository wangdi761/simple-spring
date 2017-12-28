package com.isle.common.utils.datagrid;

import java.util.List;

/**
 * Created by 61066 on 2017/12/28.
 */
public class EUDataGridResult<T> {

    private long total;
    private List<T> rows;

    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }
    public List<T> getRows() {
        return rows;
    }
    public void setRows(List<T> rows) {
        this.rows = rows;
    }

}
