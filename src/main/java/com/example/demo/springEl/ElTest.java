package com.example.demo.springEl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author gino
 * 2021-04-29
 */
public class ElTest {
    @Value("#1>0?5:10")
    private  static  int  value ;
    public static void main(String[] args) {
        ExpressionParser parser=new SpelExpressionParser();

        Expression expression = parser.parseExpression("new String ('abc')");
        String expressionString = expression.getExpressionString();
        System.out.println("expression："+expressionString);
        String str= (String) expression.getValue();
        System.out.println(str);
        System.out.println(value);

    }
}
