package day08.task3;

import day08.Game;

public class task3 {
    public static void main(String[] args) {

        DocumentConverter H = new HtmlConverter();
        DocumentConverter M = new MarkdownConverter();

        H.print(H.convert("Hello"));
        M.print(M.convert("Hello"));

    }
}

abstract class DocumentConverter {

    abstract String  convert(String content);

    void print(String content){
        System.out.println(content);
    }
}

class HtmlConverter extends DocumentConverter{
    @Override
    String convert(String content) {
        return "<p>" + content + "</p>";
    }
}

class MarkdownConverter extends DocumentConverter{
    @Override
    String convert(String content) {
        return "" + content+ "";
    }
}