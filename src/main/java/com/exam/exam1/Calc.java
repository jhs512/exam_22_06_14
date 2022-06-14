package com.exam.exam1;

public class Calc {
    private String getOperatorCode(String s) {
        try {
            Integer.parseInt(s);

            return "number";
        } catch (NumberFormatException e) {

        }

        int nonNumberOperatorCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                nonNumberOperatorCount++;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
                if (s.charAt(i + 1) == ' ') {
                    nonNumberOperatorCount++;
                }
            }
        }

        if (nonNumberOperatorCount == 1) {
            // 단순연산 : -
            if (s.indexOf(" - ") != -1) return "-";
            // 단순연산 : +
            if (s.indexOf(" + ") != -1) return "+";
            // 단순연산 : *
            if (s.indexOf(" * ") != -1) return "*";
            // 단순연산 : /
            if (s.indexOf(" / ") != -1) return "/";
        }

        return "splitInTwo";
    }

    public int run(String s) {

        s = stripOuterBrackets(s);

        String operatorCode = getOperatorCode(s);

        if (operatorCode.equals("number")) {
            return Integer.parseInt(s);
        } else if (operatorCode.equals("-")) {
            return minus(s);
        } else if (operatorCode.equals("*")) {
            return multi(s);
        } else if (operatorCode.equals("/")) {
            return divide(s);
        } else if (operatorCode.equals("+")) {
            return plus(s);
        }

        // 더하기, 빼기로 나눌 수 있는지 체크
        int splitIndex = -1;
        int bracketCount = 0;
        boolean isPlus = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                bracketCount++;
            } else if (s.charAt(i) == ')') {
                bracketCount--;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (bracketCount > 0) {
                    continue;
                }

                if ( s.charAt(i + 1) != ' ' ) {
                    continue;
                }

                splitIndex = i;
                if (s.charAt(i) == '-') {
                    isPlus = false;
                }
                break;
            }
        }

        if (splitIndex != -1) {
            String head = s.substring(0, splitIndex).trim();
            String tail = s.substring(splitIndex + 1).trim();

            if (isPlus) {
                return run(head) + run(tail);
            }

            return run(head) - run(tail);
        }

        splitIndex = -1;
        bracketCount = 0;
        boolean isMulti = true;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                bracketCount++;
            } else if (s.charAt(i) == ')') {
                bracketCount--;
            } else if (s.charAt(i) == '*' || s.charAt(i) == '/') {
                if (bracketCount > 0) {
                    continue;
                }

                splitIndex = i;
                if (s.charAt(i) == '/') {
                    isMulti = false;
                }
                break;
            }
        }

        if (splitIndex != -1) {
            String head = s.substring(0, splitIndex).trim();
            String tail = s.substring(splitIndex + 1).trim();

            if (isMulti) {
                return run(head) * run(tail);
            }

            return run(head) / run(tail);
        }

        return 0;
    }

    private String stripOuterBrackets(String s) {
        s = s.trim();

        if (s.length() == 0) {
            return s;
        }

        while (s.charAt(0) == '(' && s.charAt(s.length() - 1) == ')') {
            s = s.substring(1, s.length() - 1);
        }

        return s;
    }

    private int divide(String s) {
        String[] sBits = s.split(" \\/ ");
        int a = Integer.parseInt(sBits[0]);
        int b = Integer.parseInt(sBits[1]);

        return a / b;
    }

    private int multi(String s) {
        String[] sBits = s.split(" \\* ");
        int a = Integer.parseInt(sBits[0]);
        int b = Integer.parseInt(sBits[1]);

        return a * b;
    }

    public int plus(String s) {
        String[] sBits = s.split(" \\+ ");
        int a = Integer.parseInt(sBits[0]);
        int b = Integer.parseInt(sBits[1]);

        return a + b;
    }

    public int minus(String s) {
        String[] sBits = s.split(" \\- ");
        int a = Integer.parseInt(sBits[0]);
        int b = Integer.parseInt(sBits[1]);

        return a - b;
    }
}