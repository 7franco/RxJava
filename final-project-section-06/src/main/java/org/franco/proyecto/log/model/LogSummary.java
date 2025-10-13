package org.franco.proyecto.log.model;

import java.util.Map;
import java.util.Set;

public class LogSummary {

    private int total;
    private int errorCount;
    private Set<String> uniqueUsers;
    private double averageResponseTime;
    private Map<Integer, Long> errorCountsByCode;

    public LogSummary(int total, int errorCount, Set<String> uniqueUsers, double averageResponseTime, Map<Integer, Long> errorCountsByCode) {
        this.total = total;
        this.errorCount = errorCount;
        this.uniqueUsers = uniqueUsers;
        this.averageResponseTime = averageResponseTime;
        this.errorCountsByCode = errorCountsByCode;
    }

    @Override
    public String toString() {
        return "LogSummary{" +
                "total=" + total +
                ", errorCount=" + errorCount +
                ", uniqueUsers=" + uniqueUsers +
                ", averageResponseTime=" + averageResponseTime +
                ", errorCountsByCode=" + errorCountsByCode +
                '}';
    }
}
