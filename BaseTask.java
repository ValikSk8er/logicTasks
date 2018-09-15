package com.academy.homeworks;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.BufferedReader;

public class BaseTask {
    protected static final String SPACE_TEXT = " ";

    public static String readLine() throws IOException {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        return bufferedReader
                .readLine()
                .trim();
    }
}
