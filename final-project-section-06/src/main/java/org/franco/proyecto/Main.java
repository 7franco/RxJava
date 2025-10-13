package org.franco.proyecto;

import org.franco.proyecto.log.model.LogEntry;
import org.franco.proyecto.log.model.LogSummary;
import org.franco.proyecto.log.service.LogProcessorTask;
import org.franco.proyecto.log.service.LogService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static void main(String[] args) {
        System.out.println("🚀 Iniciando análisis de logs...");

        File logsFolder = new File("logs");
        File[] logFiles = logsFolder.listFiles((dir, name) -> name.endsWith(".log"));

        if (logFiles == null || logFiles.length == 0) {
            System.out.println("⚠️ No se encontraron archivos .log en la carpeta 'logs'. Asegúrate de crearla y poner archivos dentro.");
            return;
        }

        LogService service = new LogService();

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Future<LogSummary>> futures = new ArrayList<>();

        for (File logFile: logFiles){
            List<LogEntry> entries = service.readLogsFromFile(logFile.getAbsolutePath());
            LogProcessorTask task = new LogProcessorTask(entries);
            futures.add(executorService.submit(task));
        }

        for (Future<LogSummary> future: futures){
            try {
                LogSummary logSummary = future.get();
                System.out.println(logSummary);
            }catch (InterruptedException | ExecutionException e){
                System.out.println(e.getMessage());
            }
        }

        executorService.shutdown();

    }
}
