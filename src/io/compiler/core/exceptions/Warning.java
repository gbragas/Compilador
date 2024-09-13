package io.compiler.core.exceptions;

import java.util.ArrayList;
import java.util.List;

public class Warning {
    private List<String> warningList = new ArrayList<>();

    public void addWarning(String message) {
    	warningList.add(message);
    }

    public void printWarnings() {
    	System.out.println();
        for (String warning : warningList) {
            System.out.println("Warning: " + warning);
        }
        System.out.println();
    }

    public boolean hasWarnings() {
        return !warningList.isEmpty();
    }
}

