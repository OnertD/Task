package ru.task.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Task {


    public static void main(String args[]){
        System.out.println("Laba 9. Initialization");
        System.out.println("Please write the string");
        InputStream in;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        try {
            input = reader.readLine();
            String substring = "";
            String countsubstring = "";
            String temp = "";
            int startDigitPos = -1;
            while (input.indexOf(']') != -1 && input.lastIndexOf('[') != -1){
                int start = input.lastIndexOf('[');
                int end = input.substring(start).indexOf(']')+start;
                substring = input.substring(start+1, end);
                for(int i = 0; Character.isDigit(input.charAt(start-1-i)); i++){
                    startDigitPos = start-1-i;
                    if (startDigitPos == 0) break;
                }
                countsubstring = startDigitPos-start == 0 ?  "" + input.charAt(startDigitPos) : input.substring(startDigitPos, start);
                for(int i = 0; i<Integer.parseInt(countsubstring); i++){
                    temp += substring;
                }
                StringBuilder sb = new StringBuilder(input);
                sb.delete(startDigitPos, end+1);
                sb.insert(startDigitPos, temp);
                input = sb.toString();
                temp = "";
                substring = "";
                countsubstring = "";
                startDigitPos = -1;

            }
            System.out.println(input);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}