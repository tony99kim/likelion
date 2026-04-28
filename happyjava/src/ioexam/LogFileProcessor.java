package ioexam;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogFileProcessor {
    public static void main(String[] args) {
        String inputFile = "access.log";
        String outputFile = "errors.log";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             PrintWriter writer = new PrintWriter(new BufferedWriter(
                     new FileWriter(outputFile)))) {

            String line;
            int totalLines = 0;
            int errorLines = 0;

            while ((line = reader.readLine()) != null) {
                totalLines++;

                // ERROR를 포함한 라인만 추출
                if (line.contains("ERROR")) {
                    writer.println("[" + totalLines + "] " + line);
                    errorLines++;
                }
            }

            // 통계 정보 추가
            writer.println("\n=== 로그 분석 결과 ===");
            writer.println("전체 라인: " + totalLines);
            writer.println("오류 라인: " + errorLines);
            writer.printf("오류율: %.2f%%\n", (errorLines * 100.0 / totalLines));

            System.out.println("로그 파일 처리 완료!");
            System.out.println("오류 로그가 " + outputFile + "에 저장되었습니다.");

        } catch (IOException e) {
            System.err.println("파일 처리 오류: " + e.getMessage());
        }
    }
}
