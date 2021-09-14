package alg1_2_由两个栈组成的队列;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author Wangkx
 * @Date 2021/9/14 17:14
 * @Version 1.0
 * @Description:
 */
public class Solution {
    public static void main(String[] args) {
        TwoStackQueue twoStackQueue = new Solution().new TwoStackQueue();
//        twoStackQueue.add(1);
//        twoStackQueue.add(2);
//        twoStackQueue.add(3);
//        System.out.println(twoStackQueue.peek());
//        System.out.println(twoStackQueue.poll());
//        System.out.println(twoStackQueue.peek());


        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        String string;
        for (int i = 0; i < n; i++) {
            string = scanner.nextLine();
            if (string.equals("poll")) {
                twoStackQueue.poll();
            } else if (string.equals("peek")) {
                System.out.println(twoStackQueue.peek());
            } else {
                twoStackQueue.add(Integer.valueOf(string.split(" ")[1]));
            }
        }
    }

    class TwoStackQueue {
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public TwoStackQueue() {
            this.stackPush = new Stack<>();
            this.stackPop = new Stack<>();
        }

        /**
         * push栈往pop栈导入数据
         * 注意两点：
         * 1.push向pop栈导入时，必须一次性将push栈里的所有数据全都导入
         * 2.push向pop栈导入时，pop栈必须为空
         */
        private void pushToPop() {
            if (stackPop.isEmpty()) {
                while (!stackPush.isEmpty()) {
                    int value = stackPush.pop();
                    stackPop.push(value);
                }
            }
            //todo 不为空就没有任何操作？
        }

        public void add(int num) {
            stackPush.push(num);
            pushToPop();
        }

        public int poll() {
            if (stackPop.isEmpty() && stackPush.isEmpty()) {
                throw new RuntimeException("Queue is empty!");
            }
            pushToPop();
            return stackPop.pop();
        }

        public int peek() {
            if (stackPop.isEmpty() && stackPush.isEmpty()) {
                throw new RuntimeException("Queue is empty!");
            }
            pushToPop();
            return stackPop.peek();
        }

    }
}
