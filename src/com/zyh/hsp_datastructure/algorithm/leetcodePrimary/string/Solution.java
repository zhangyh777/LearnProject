package com.zyh.hsp_datastructure.algorithm.leetcodePrimary.string;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] arr = {"ab","a"};
        System.out.println(longestCommonPrefix(arr));


    }


    /**
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题
     *
     * @param str 字符数组
     */
    public static void reverse(char[] str) {
        int left = 0;
        int right = str.length - 1;
        while (left < right) {
            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            right--;
            left++;
        }
    }


    /**
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分 反转后的结果。
     * 如果反转后整数超过 32 位的有符号整数的范围[−2^31, 2^31− 1] ，就返回 0。
     * 假设环境不允许存储 64 位整数（有符号或无符号）。
     * res=0; t=x%10; res=res*10+t;
     * x=1234     res = res*10+x%10=4
     * x=123      res = res*10+x%10=43
     * x=12       res = res*10+x%10=432
     * x=1        res = res*10+x%10=4321
     *
     * @param x
     */
    public static int reverseNumber(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return (int) res == res ? (int) res : 0;
    }

    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        List list = new LinkedList();
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            map.put(ch[i], map.getOrDefault(ch[i], 0) + 1);
        }
        for (int i = 0; i < ch.length; i++) {
            if (map.get(ch[i]) == 1) {
                return i;
            }
        }

        return -1;
    }


    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * <p>
     * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        //字符串不一样长的话直接返回
        if (s.length() != t.length()) {
            return false;
        }

        //存放26个字符每个字符出现的次数
        //count[0]就是'a'出现的次数,count[1]是'b'出现的次数
        int[] counts = new int[26];
        //遍历字符串s,统计每个字符出现的次数
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }

        //遍历字符串t,每遍历到一个字符,s中该字符个数就--,
        //某个字符个数<0的时候就说明字符串t中该字符比字符串中s中的该字符多,s和t不是字母异位词
        for (int i = 0; i < t.length(); i++) {
            counts[t.charAt(i) - 'a']--;
            if (counts[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * <p>
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            //不是数字或者字母的话忽略不计
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            //字母的话读取之后转小写（不要先转小写再去读）
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    /**
     * 字符串needle在字符串haystack中第一次出现的索引
     * 暴力匹配可解
     * 优化思路：KMP
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        int up = 0;
        int down = 0;
        while (up < haystack.length()) {
            char ch = haystack.charAt(up);
            char chX = needle.charAt(down);
            if (ch == chX) {
                up++;
                down++;
            } else {
                up = up - down + 1;
                down = 0;
            }
            if (down == needle.length()) {
                return up - down;
            }
        }
        return -1;
    }

//     public static String longestCommonPrefix(String[] strs) {
//     //边界条件判断
//     if (strs == null || strs.length == 0)
//     return "";
//     //默认第一个字符串是他们的公共前缀
//     String pre = strs[0];
//     int i = 1;
//     while (i < strs.length) {
//     //不断的截取
//     //在数组里的某个字符串里找不到pre才进行截取
//     while (strs[i].indexOf(pre) != 0){//没有在strs[i]这个字符串里找到pre字符串
//     pre = pre.substring(0, pre.length() - 1);//pre字符串自截短一位,继续在strs[i]这个字符串里找
//     }
//     i++;
//     }
//     return pre;
//     }

    /**
     * 找出字符串的最长公共前缀
     * 纵向比较
     * leetc
     * leetcode
     * leetd
     * lee
     * <p>
     * l -> e -> e -> "lee"就是最长公共前缀
     * <p>
     * code
     * codeleet
     * leetcode
     * c!=l,没有公共前缀
     *
     * @param strs 字符串数组
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {

        //字符串数组中字符串的个数
        int arrLength = strs.length;

        for (int i = 0; i < strs[0].length(); i++) {//遍历数组里第一个字符串的每个字符和后面每个字符串里的字符比较
            char ch = strs[0].charAt(i);//第一个字符串的字符
            for (int j = 1; j < arrLength; j++) {//从第二个字符串开始,遍历每个字符串的字符
                //如果某个字符串长度比第一个字符串短
                //或者某个字符串中出现和第一个字符串中不一样的字符,
                //直接返回这之前得到的公共前缀,就是所有字符串的公共前缀
                if (i == strs[j].length() || strs[j].charAt(i) != ch) {
                    return strs[0].substring(0, i);
                }
            }
        }//如果没有中途退出for循环说明字符串数组中所有字符串都和第一个字符串相同,strs[0]==strs[1]==strs[2]==...
        return strs[0];

    }

    /**
     * 反转字符串中的每个单词,保持空格位置不变
     * leet code -> edoc teel
     *
     * @param s 母字符串,每个子串用空格分隔
     * @return
     */
    public static String reverseWords(String s) {
        char[] arr = s.toCharArray();//字符串转字符数组（包含空格）
        int left = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {//遇到空格（说明之前的所有字符组成一个字符串）,就把之前的所有字符翻转
                Reverse(arr, left, i - 1);
                left = i + 1;//从空格之后的字符重新开始
            }
            if (i == arr.length - 1) {//最后一个子串的最后一个字符（即母串的最后一个字符）
                Reverse(arr, left, i);//反转最后一个子串
            }
        }
        return new String(arr);
    }

    public static void Reverse(char[] chArr, int left, int right) {
        while (left < right) {//子字符串的字符交换位置
            char temp = chArr[left];
            chArr[left] = chArr[right];
            chArr[right] = temp;
            left++;
            right--;
        }
    }

    public static int findMin(int[] nums) {

        return -1;
    }

    /**
     * 删除排序数组中的重复元素，返回新数组的长度
     *
     * @param nums 排好序的数组，有重复元素
     * @return
     */
    public static int removeDuplicates(int[] nums) {

        int slow = 0;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        return ++slow;
    }

    /**
     * 把数组中的0都移到数组后边，同时保持非零数字的原有顺序
     *
     * @param nums 无序含0数组
     */
    public static void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;
        //快指针遍历数组,指向待处理数组的头部
        //慢指针指向处理好的数组的尾部
        while (fast < nums.length) {
            if (nums[fast] == 0) {
                fast++;
            } else {
                nums[slow++] = nums[fast++];
            }
        }
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = (digits[i] + 1) % 10;
            if (digits[i] != 0) {
                return digits;
            }

        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;

    }

    /**
     * 查找数组中的多数元素（出现次数大于n/2）
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums
        ) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }
        return majorityEntry.getKey();
    }

    /**
     * 判断数组中 num[i]==nums[j]并且abs(i-j)<=k的数是否存在
     *
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num) && i - map.get(num) <= k) {
                return true;
            }
            map.put(num, i);
        }
        return false;
    }

    /**
     * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
     *
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        for (int i = 0; i <= n; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 数组中第3大的数
     *
     * @param nums
     * @return
     */
    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int left = nums.length - 2;
        int right = nums.length - 1;
        int count = 1;
        while (left >= 0) {
            if (nums[left] != nums[right]) {
                right = left;
                count++;
            }
            if (count == 3) {
                return nums[left];
            }
            left--;
        }
        return nums[nums.length - 1];
    }


    /**
     * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
     *
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        for (int num : nums
        ) {
            set.add(num);
        }
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }
        return list;
    }


    /**
     * 矩阵reshape
     *
     * @param mat
     * @param r
     * @param c
     * @return
     */
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        if (r * c != mat.length * mat[0].length) {
            return mat;
        }
        int[][] M = new int[r][c];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                list.add(mat[i][j]);
            }
        }
        int index = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                M[i][j] = list.get(index);
                index++;
            }
        }
        return M;
    }


    /**
     * 数组置0
     * 二维数组matrix,如果matrix[i][j]==0的话,将i行和j列的数都置0
     *
     * @param matrix
     */
    public static void setZeroes1(int[][] matrix) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    set1.add(i);
                    set2.add(j);
                }
            }
        }
        for (int row : set1
        ) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[row][i] = 0;
            }
        }
        for (int col : set2
        ) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }

    }


    /**
     * 使用标记数组
     *
     * @param matrix
     */
    public static void setZeros(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        //标记数组，记录原始数组0所在的行和列
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        //遍历原始二维数组
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        //同样遍历原始数组,置0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
     *
     * @param s
     * @return
     */
    public static int firstUnique(String s) {
        char[] ch = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ch.length; i++) {
            map.put(ch[i], map.getOrDefault(map.get(i), 0) + 1);
        }

        for (int i = 0; i < ch.length; i++) {
            if (map.get(ch[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 给你两个字符串：str 和 Str ，判断 str 能不能由 Str 里面的字符构成。
     * <p>
     * 如果可以，返回 true ；否则返回 false 。
     * <p>
     * Str 中的每个字符只能在 str 中使用一次。
     *
     * @param str
     * @param Str
     * @return
     */
    public static boolean canConstruct(String str, String Str) {
        if (str.length() > Str.length()) {
            return false;
        }
        int[] count = new int[26];
        //统计大字符串中每个字符出现的次数
        for (int i = 0; i < Str.length(); i++) {
            char ch = Str.charAt(i);
            count[ch - 'a']++;
        }
        //小字符串中字符出现的次数,
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            //读取小字符串中的字符,将该字符出现的次数--
            count[ch - 'a']--;
            if (count[ch - 'a'] < 0) {//<0说明大字符串中的该字符个数少于小字符串中的个数,即大字符串中的字符不能构成小字符
                return false;
            }
        }
        return true;
    }


    /**
     * 给定两个字符串, s和goal。如果在若干次旋转操作之后，s能变成goal，那么返回true。
     * s的 旋转操作 就是将s 最左边的字符移动到最右边。
     *
     * @param s
     * @param goal
     * @return
     */
    public static boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }

    public static void moveZeros(int[] nums) {
        int slow = 0;

        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        while (slow < nums.length) {
            nums[slow++] = 0;
        }
    }

    /**
     * 找出数组的交集
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();
        for (int num : nums1
        ) {
            set1.add(num);
        }
        for (int num : nums2
        ) {
            set2.add(num);
        }
        return getIntersection(set1, set2);

    }

    public static int[] getIntersection(Set<Integer> set1, Set<Integer> set2) {
        if (set1.size() > set2.size()) {
            return getIntersection(set2, set1);
        }

        List<Integer> list = new ArrayList<>();
        for (int num : set1
        ) {
            if (set2.contains(num)) {
                list.add(num);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     * 有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合；
     * 左括号必须以正确的顺序闭合。
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }


        //成对的括号,右括号为键,左括号为值
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (pairs.containsKey(c)) {//遍历到右括号
                if (stack.isEmpty() || stack.peek() != pairs.get(c)) {//如果栈为空或者栈顶元素和该右括号不配套
                    return false;
                } else {//如果栈顶的括号（左括号）和该右括号配套,把配套的左括号（就是栈顶的括号）删掉
                    stack.pop();
                }
            } else {//左括号直接入栈
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    /**
     * nums1和nums2都是非递减顺序的有序数组,把nums2合并到nums1中
     * nums2的长度是n
     * nums1的长度是m+n,后面n个数为0,是给nums2中的元素占位的,nums1中的元素有m个
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        /*
            逆向双指针
            nums1和nums2都是有序数组,nums1后面n个数字都是0,给nums2中的数字占位
            nums1有效数字部分是[0,m-1]索引内,[m,m+n-1]索引内都是0
            从nums1有效数字部分的尾部和nums2的尾部开始遍历,比较大小,大的数字放到nums1尾部
         */
        //nums1数组有效数字部分尾部的索引
        int p1 = m - 1;
        //nums2数组的尾部索引
        int p2 = n - 1;
        //完整nums1数组尾部的索引
        int tail = m + n - 1;

        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {//nums1有效数字部分遍历完了
                cur = nums2[p2];
                p2--;
            } else if (p2 == -1) {//nums2遍历完了
                cur = nums1[p1];
                p1--;
            } else if (nums1[p1] > nums2[p2]) {//大的数字
                cur = nums1[p1];
                p1--;
            } else {
                cur = nums2[p2];
                p2--;
            }
            nums1[tail] = cur;
            tail--;//尾部索引--
        }
    }


    /**
     * 子序列
     * 字符串t删除某些字符后可以变成字符串s,则s是t的子序列
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence(String s, String t) {
        int p1 = 0;
        int p2 = 0;
        while (p1 < s.length() && p2 < t.length()) {
            if (s.charAt(p1) == t.charAt(p2)) {
                p1++;
            }
            p2++;
        }
        return p1 == s.length();

    }

    /**
     * 「快乐数」定义为：
     * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
     * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
     * 如果这个过程 结果为1，那么这个数就是快乐数。
     * 19
     * 1^2+9^2=82
     * 8^2+2^2=68
     * 6^2+8^2=100
     * 1^2+0^2+0^2=1
     *
     * @param num
     * @return
     */
//    public static boolean isHappy(int num) {
//
//    }


}
