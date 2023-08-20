package com.example.retrfitex.MVVMFetch;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponse {
    @SerializedName("count")
    private int count;
    @SerializedName("entries")
    private List<ApiEntry> entries;

    public ApiResponse(int count, List<ApiEntry> entries) {
        this.count = count;
        this.entries = entries;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ApiEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<ApiEntry> entries) {
        this.entries = entries;
    }

    // Getters and setters
}

