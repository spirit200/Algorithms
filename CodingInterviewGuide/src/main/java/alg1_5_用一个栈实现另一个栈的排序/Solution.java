package alg1_5_用一个栈实现另一个栈的排序;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author Wangkx
 * @Date 2021/9/16 21:02
 * @Version 1.0
 * @Description:
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] str = scanner.nextLine().split(" ");
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            stack.push(Integer.parseInt(str[i]));
        }
        sortStackByStack(stack);
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }

    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
//            if (!help.isEmpty() && cur > help.peek()) {
//                stack.push(help.pop());//todo 如果 cur 大于 help 的栈顶元素，则将 help 的元素逐一弹出，逐一压入 stack，直到 cur小于或等于 help 的栈顶元素，再将 cur 压入 help。
//            } else {
//                help.push(cur);
//            }
            while (!help.isEmpty() && cur > help.peek()) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }
}
