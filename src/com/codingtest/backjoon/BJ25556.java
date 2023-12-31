package com.codingtest.backjoon;
/*
문제
* 포닉스는 길이가 N인 순열 A와 네 개의 비어 있는 스택을 가지고 있다.

길이가
N인 순열이란, 1 이상 N이하의 서로 다른 정수 N개가 임의로 나열된 수열을 말한다.
스택이란 자료구조의 한 종류로 가장 나중에 삽입한 자료가 가장 먼저 나오는 후입선출 (Last In First Out, LIFO)의 특성을 가지고 있다.
포닉스는 PPC를 맞아 더러워진 순열을 청소하려 한다.

순열을 청소하는 것은 다음과 같은 과정을 통해 순열을 오름차순으로 정렬하는 것을 뜻한다. 즉 순열을 1, 2, 3, .., N으로 만들어야 한다.

순열 A의 원소들을 앞 원소부터 순서대로 네 개의 스택 중 하나에 삽입한다.
순열
A의 모든 원소를 스택에 삽입했다면, 네 개 중 원하는 스택에서 수를 꺼내는 것을 반복하여 네 개의 스택에서 모든 수를 꺼낸다.
꺼낸 수들을 꺼낸 순서대로 오른쪽에서 왼쪽으로 나열한다. 즉, 가장 처음에 꺼낸 수가 맨 뒤, 가장 나중에 꺼낸 수가 맨 앞에 위치하게 된다.
포닉스가 주어진 순열을 청소할 수 있는지 판별해 보자.
* */
import java.util.*;
public class BJ25556 {
    public static void main(String[] args){
        int sizenum = 0;
        boolean yesorno = true;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();
        Stack<Integer> stack4 = new Stack<>();
        Scanner sc = new Scanner(System.in);
        sizenum = sc.nextInt();
        sc.nextLine();
        int[] numArr = new int[sizenum];
        String [] stringArr = sc.nextLine().split(" ");
        numArr = Arrays.stream(stringArr).mapToInt(Integer::parseInt).toArray();
        for(int num:numArr){
            if(stack1.isEmpty() || stack1.peek() < num){
                stack1.push(num);
            }else if(stack2.isEmpty() || stack2.peek() < num){
                stack2.push(num);
            }else if(stack3.isEmpty() || stack3.peek() < num){
                stack3.push(num);
            }else if(stack4.isEmpty() || stack4.peek() < num){
                stack4.push(num);
            }else{
                yesorno = false;
            }
        }

        if(yesorno){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }
}
