package com.company.exercise;

import java.util.*;

public class _22GenerateParenthesis {


    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        doGenerate(result, "", n, n);
        return result;
    }

    private void doGenerate(List<String> result, String str, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(str);
            return;
        }

        if (left == right) {
            doGenerate(result, str + "(", left - 1, right);
        } else if (left < right) {
            if (left != 0) {
                doGenerate(result, str + "(", left - 1, right);
            }
            doGenerate(result, str + ")", left, right - 1);
        } else {
            // not possible
        }
    }

    public static void main(String[] args) {
        _22GenerateParenthesis procedure = new _22GenerateParenthesis();
        procedure.generateParenthesis(2);
    }

}
