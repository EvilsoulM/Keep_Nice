package com.evilsoulm.keep_nice.model.dao.entity;

import java.util.List;

/**
 * Author by EvilsoulM
 * Data:2016-05-05 11:57
 * Project:Keep_Nice
 * Detail:
 */
public class BaseFeedResponse<DATA> {

    private boolean error;

    private List<DATA> results;

    public List<DATA> getResults() {
        return results;
    }

    public void setResults(List<DATA> results) {
        this.results = results;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
