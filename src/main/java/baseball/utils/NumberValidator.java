package baseball.utils;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberValidator {
    private static final String LENGTH_ERROR_MESSAGE = "숫자는 세 자리 수여야 합니다.";
    private static final String RANGE_ERROR_MESSAGE = "각 자리 수는 최소 1 이상, 최대 9 이하의 정수여야 합니다.";
    private static final String DUPLICATE_ERROR_MESSAGE = "숫자는 중복되어서는 안됩니다.";
    private static final String TYPE_ERROR_MESSAGE = "숫자만 입력 가능합니다.";

    public static boolean hasValidInput(List<Integer> userInput) {
        hasValidLength(userInput);
        hasValidRange(userInput);
        hasNonDuplicateNumbers(userInput);
        return true;
    }

    public static void hasValidType(String userInputStr){
        for(int i=0;i<userInputStr.length();i++){
            char c = userInputStr.charAt(i);
            if(!Character.isDigit(c)){
                throw new IllegalArgumentException(TYPE_ERROR_MESSAGE);
            }
        }
    }

    private static void hasValidLength(List<Integer> userInput) {
        if (!(userInput.size() == Constants.VALID_LENGTH)) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
    }

    private static void hasValidRange(List<Integer> userInput) {
        if (!(Collections.max(userInput) <= Constants.VALID_MAX_RANGE && Collections.min(userInput) >= Constants.VALID_MIN_RANGE)) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }

    private static void hasNonDuplicateNumbers(List<Integer> userInput) {
        Set<Integer> userInputSet = new HashSet<>(userInput);
        if (!(userInputSet.size() == userInput.size())) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }
}
