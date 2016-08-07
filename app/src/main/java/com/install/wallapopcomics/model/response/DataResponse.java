package com.install.wallapopcomics.model.response;

import java.util.List;

/**
 * Created by Peter on 07.08.2016.
 */
public class DataResponse {
    private int offset;
    private int limit;
    private int total;
    private int count;
    private List<ResultsResponse> results;

    public DataResponse() {
    }

    public DataResponse(int count, int limit, int offset, List<ResultsResponse> results, int total) {
        this.count = count;
        this.limit = limit;
        this.offset = offset;
        this.results = results;
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public List<ResultsResponse> getResults() {
        return results;
    }

    public void setResults(List<ResultsResponse> results) {
        this.results = results;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
