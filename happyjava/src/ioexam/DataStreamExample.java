package ioexam;

import java.io.*;

public class DataStreamExample {
    public static void main(String[] args) {
        String filename = "data.dat";

        // 데이터 쓰기
        try (DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(filename)))) {

            dos.writeInt(100);
            dos.writeDouble(3.14159);
            dos.writeBoolean(true);
            dos.writeUTF("안녕하세요, Java IO!");

            System.out.println("데이터 저장 완료");

        } catch (IOException e) {
            System.err.println("쓰기 오류: " + e.getMessage());
        }

        // 데이터 읽기
        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(filename)))) {

            int intValue = dis.readInt();
            double doubleValue = dis.readDouble();
            boolean boolValue = dis.readBoolean();
            String stringValue = dis.readUTF();

            System.out.println("\n=== 읽은 데이터 ===");
            System.out.println("정수: " + intValue);
            System.out.println("실수: " + doubleValue);
            System.out.println("불린: " + boolValue);
            System.out.println("문자열: " + stringValue);

        } catch (IOException e) {
            System.err.println("읽기 오류: " + e.getMessage());
        }
    }
}

