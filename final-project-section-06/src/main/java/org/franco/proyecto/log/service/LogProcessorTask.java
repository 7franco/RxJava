package org.franco.proyecto.log.service;

import org.franco.proyecto.log.model.LogEntry;
import org.franco.proyecto.log.model.LogSummary;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class LogProcessorTask implements Callable<LogSummary> {
    private final List<LogEntry> logEntries;

    public LogProcessorTask(List<LogEntry> logEntries) {
        this.logEntries = logEntries;
    }

    @Override
    public LogSummary call() throws Exception {

        System.out.println("Tarea: Procesando "+ logEntries.size() +" entrada de log en hilo "+ Thread.currentThread().getName());
        int total = logEntries.size();
        //statusCode >=400
        List<LogEntry> errorsLogs = logEntries.stream().filter(log-> log.getStatusCode()>=400).toList();
        int errorCount =errorsLogs.size();
        //
        Set<String> uniqueUsers = logEntries.stream().map(LogEntry::getUser).collect(Collectors.toSet());

//        double averageResponseTime = logEntries.stream()
//                .map(LogEntry::getResponseTimeMs)
//                .collect(Collectors.averagingInt(Integer::intValue));

        double averageResponseTime = logEntries.stream()
                .mapToInt(LogEntry::getResponseTimeMs)
                .average()
                .orElse(0.0);

        Map<Integer, Long> errorCountsByCode = errorsLogs.stream().collect(Collectors.groupingBy(
                LogEntry::getStatusCode,
                Collectors.counting()
        ));
        System.out.println("Finalizando: Proceso "+ logEntries.size() +" "+
                "entradas de log en hilo "+ Thread.currentThread().getName());

        return new LogSummary(total,errorCount, uniqueUsers,averageResponseTime, errorCountsByCode);
    }
}
