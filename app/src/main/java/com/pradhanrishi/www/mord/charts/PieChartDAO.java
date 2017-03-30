package com.pradhanrishi.www.mord.charts;

/**
 * Created by yash on 28/3/17.
 */

public class PieChartDAO {

    String id;
    String label;
    String type;
    String[] data;

    PieChartDAO(String mid, String mlabel, String mtype, String[] mdata) {
        id = mid;
        label = mlabel;
        type = mtype;
        data = mdata;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }
}
