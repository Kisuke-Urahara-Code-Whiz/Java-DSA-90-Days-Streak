package LeetCodeMedium;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode71 {

    public String simplifyPath(String path) {
        Deque<String> deque = new ArrayDeque<>();
        deque.add("/");
        for(String i: path.split("/")){
            if(!i.isEmpty()){
                if(i.equals(".")){
                    continue;
                }
                else if(i.equals("..")){
                    if(!(deque.size() ==1))
                        deque.removeLast();
                }
                else{
                    deque.addLast(i);
                }
            }
        }
        if(deque.size()==1) return "/";
        deque.removeFirst();
        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()){
            sb.append("/");
            sb.append(deque.removeFirst());
        }
        return new String(sb);
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode71().simplifyPath("/.../a/../b/c/../d/./"));
    }

}
