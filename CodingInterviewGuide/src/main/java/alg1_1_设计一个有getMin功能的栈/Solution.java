package alg1_1_设计一个有getMin功能的栈;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author Wangkx
 * @Date 2021/9/3 17:27
 * @Version 1.0
 * @Description:
 */
public class Solution {
    public static void main(String[] args) {
        MyStack2 mystack = new Solution().new MyStack2();
//        mystack.push(3);
//        mystack.push(2);
//        mystack.push(1);
//        System.out.println(mystack.getMin());
//        mystack.pop();
//        int res = mystack.getMin();
//        System.out.println(res);
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String s;
        for (int i = 0; i < n; i++) {
            s = scanner.nextLine();
            if (s.equals("pop")) {
                mystack.pop();
            } else if (s.equals("getMin")) {
                System.out.println(mystack.getMin());
            } else {
                mystack.push(Integer.parseInt(s.split(" ")[1]));
            }
        }
    }

    class MyStack {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack() {
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }

        public void push(int newNum) {
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(newNum);
            } else if (newNum <= this.getmin()) {
                this.stackMin.push(newNum);
            }
            this.stackData.push(newNum);
        }

        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            int value = this.stackData.pop();
            if (value == this.getmin()) {
                this.stackMin.pop();
            }
            return value;
        }

        public int getmin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMin.peek();
        }
    }

    class MyStack2 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack2() {
            this.stackData = new Stack<>();
            this.stackMin = new Stack<>();
        }

        public int getMin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("空");
            } else {
                return this.stackMin.peek();
            }
        }

        public void push(int newNum) {
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(newNum);
            } else {//stackMin不为空
                int min = this.stackMin.peek();
                if (newNum <= min) {
                    this.stackMin.push(newNum);
                } else {
                    this.stackMin.push(min);
                }
            }
            this.stackData.push(newNum);
        }

        public int pop() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("空");
            }
            this.stackMin.pop();
            return this.stackData.pop();
        }
    }
}


