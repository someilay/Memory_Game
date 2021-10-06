package main.java.gui;

import main.java.Button;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputHandler {
    private List<Button> components;
    private final Scanner scanner;

    public InputHandler(List<Button> components) {
        this.components = components;
        scanner = new Scanner(System.in);
    }

    public Button findButton(){
        String nextClick = scanner.nextLine();
        try {
            String buttonName = extractName(nextClick);
            int[] coordinates = extractCoordinates(nextClick);

            if (!isInputValid(nextClick, buttonName, coordinates)){
                return null;
            }

            return findButtonByCoordinatesAndName(buttonName, coordinates);
        } catch (InputMismatchException | NullPointerException e) {
            return null;
        }
    }

    private String extractName(String nextClick){
        Pattern buttonNamePattern = Pattern.compile("\\w+");
        Matcher buttonNameMatcher = buttonNamePattern.matcher(nextClick);

        if (buttonNameMatcher.find()){
            return nextClick.substring(buttonNameMatcher.start(), buttonNameMatcher.end());
        }

        return null;
    }

    private int[] extractCoordinates(String nextClick) throws InputMismatchException {
        List<Integer> integers = extractInts(nextClick);

        if (integers.isEmpty()){
            return new int[0];
        }

        if (integers.size() != 2){
            throw new InputMismatchException();
        }

        int[] result = new int[2];
        result[0] = integers.get(0);
        result[1] = integers.get(1);
        return result;
    }

    private List<Integer> extractInts(String nextClick){
        List<Integer> integers = new ArrayList<>();
        Pattern digitPattern = Pattern.compile("\\d+");
        Matcher digitMatcher = digitPattern.matcher(nextClick);

        while (digitMatcher.find()){
            integers.add(Integer.parseInt(nextClick.substring(digitMatcher.start(), digitMatcher.end())));
        }

        return integers;
    }

    private Button findButtonByCoordinatesAndName(String buttonName, int[] coordinates){
        for (Button button: components){
            if (button.getName().toString().equals(buttonName)){
                if (coordinates.length != 0){
                    if (coordinates[0] == button.getPosition().x && coordinates[1] == button.getPosition().y){
                        return button;
                    }
                } else {
                    return button;
                }
            }
        }
        return null;
    }

    private boolean isInputValid(String nextCLick, String extractedName, int[] extractedCoordinates){
        if (extractedName == null){
            return false;
        }

        int extractedSize = extractedName.length();

        for (int coordinate: extractedCoordinates) {
            extractedSize += String.valueOf(coordinate).length();
        }

        return nextCLick.replace(" ", "").length() == extractedSize;
    }
}
