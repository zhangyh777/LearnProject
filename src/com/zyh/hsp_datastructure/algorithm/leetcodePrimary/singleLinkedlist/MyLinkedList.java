package com.zyh.hsp_datastructure.algorithm.leetcodePrimary.singleLinkedlist;


import java.util.*;

class Test {
    public static void main(String[] args) {

//        MyLinkedList mll = new MyLinkedList();
//        mll.addAtHead(1);
//        mll.addAtTail(2);
//        mll.addAtTail(3);
//        mll.addAtTail(4);
//        System.out.println(mll.reverse(mll.head));
        int[] arr = {2, 3, 1, 2, 4, 3};
        System.out.println(MinSubArrayLen(7, arr));
    }

    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 子数组 是数组中的一个连续部分。
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int ans = nums[0];
        for (int num : nums
        ) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public static int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];

        for (int i = 0, idx = -n; i < n; ++i) {
            if (s.charAt(i) == c) {
                idx = i;
            }
            ans[i] = i - idx;
        }

        for (int i = n - 1, idx = 2 * n; i >= 0; --i) {
            if (s.charAt(i) == c) {
                idx = i;
            }
            ans[i] = Math.min(ans[i], idx - i);
        }
        return ans;
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 返回target在nums数组中的索引位置,如果不存在的话返回target应该插入的位置
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = nums.length;
        while (left <= right) {
            int mid = left + (right - left) >> 1;
            if (target <= nums[mid]) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }

    public static int removeElement(int[] nums, int val) {
        /*

        //数组元素的相对顺序发生变化
        int left = 0;
        int right = nums.length;
        while (left<right){
            if (nums[left]==val){
                nums[left]=nums[right-1];
                right--;
            }else {
                left++;
            }
        }
        return left;
         */


        /*
            因为要从原始数组中删除重复元素,所以新数组的长度一定小于等于原始数组的长度
            fast指针遍历原始数组,slow指针存放新数组中的元素（和val不相同的数）
            如果nums[fast]!=val的话那它一定是新数组的元素,把它放到slow指针处,同时slow和fast后移
            如果nums[fast]==val的话,新数组中的元素不发生变化,只需要fast继续遍历原始数组即可（fast++）
         */
        //数组元素的相对顺序不发生变化
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    /**
     * 有序数组（可能有负数），返回平方之后新的有序数组
     *
     * @param nums
     * @return
     */
    public static int[] sortedSquares(int[] nums) {
        /*
            从两头分别遍历数组,比较平方数的大小，大的放到新数组尾部
        */
        //新数组
        int[] ans = new int[nums.length];
        //新数组的索引
        int index = ans.length - 1;
        //左右指针
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int n1 = nums[left] * nums[left];
            int n2 = nums[right] * nums[right];
            //平方数大的放到新数组尾部，指针移动
            if (n1 > n2) {
                ans[index--] = n1;
                left++;
            } else {
                ans[index--] = n2;
                right--;
            }
        }
        return ans;
    }

    /**
     * 给定一个含有n个正整数的数组和一个正整数 target 。
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组，并返回其长度。如果不存在符合条件的子数组，返回 0
     *
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        /*
            滑动窗口（双指针的一种）
         */
        int slow = 0;
        int fast = 0;
        //窗口大小
        int ans = Integer.MAX_VALUE;
        //窗口内元素之和
        int sum = 0;
        //遍历数组
        while (fast < nums.length) {

            sum += nums[fast];
            //如果窗口内的元素和大于等于target
            while (sum >= target) {
                //窗口大小变化
                ans = Math.max(ans, fast - slow + 1);
                //删掉窗口起点的元素
                sum -= nums[slow];
                //窗口起点指针后移
                slow++;
            }
            fast++;
        }


        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


    /**
     * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
     * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
     *
     * @param nums
     * @param k
     * @return
     */
    public static double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        //假设第一个窗口和是最大的
        int maxSum = sum;

        //i是后面各个窗口的尾
        for (int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(sum, maxSum);
        }
        /*
        //i是后面各个窗口的头
        for (int i = 1; i < n-k+1; i++) {
            sum=sum-nums[i-1]+nums[i+k-1];
            maxSum=Math.max(sum,maxSum);
        }
        */
        return 1.0 * maxSum / k;
    }

    public static int countGoodSubstrings(String s) {
        int k = 3;
        int p = 0;
        String ans = "";
        Map<String, Integer> map = new HashMap<>();
        while (p < s.length() - k + 1) {
            for (int i = p; i <= p + k - 1; i++) {
                char c = s.charAt(i);
                if (!ans.contains(c + "")) {
                    ans += c;
                } else {
                    ans = "";
                    break;
                }
            }
            map.put(ans, map.getOrDefault(ans, 0) + 1);
            ans = "";
            p++;
        }
        int sum = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()
        ) {
            if (entry.getKey() != "") {
                sum += map.get(entry.getKey());
            }
        }
        return sum;
    }

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        char[] charArr = s.toCharArray();
        int n = charArr.length;
        Set<Character> set = new HashSet<>();
        int slow = 0;
        int fast = 0;
        int ans = 0;
        while (fast < n) {
            char c = charArr[fast];
            if (!set.add(c)) {
                ans = Math.max(ans, set.size());
                set.clear();
                slow++;
                fast = slow;
            } else {
                fast++;
            }
        }
        return Math.max(ans, set.size());
    }

    public static int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < accounts.length; i++) {
            for (int j = 0; j < accounts[0].length; j++) {
                sum += accounts[i][j];
            }
            max = Math.max(max, sum);
            sum = 0;
        }
        return max;
    }

    public static List<String> findRepeatedDnaSequences(String s, int k) {
        if (s.length() < 10) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        int right = 0;

        while (right < s.length() + 1 - k) {
            String sub = s.substring(right, right + k);
            map.put(sub, map.getOrDefault(sub, 0) + 1);

            if (map.get(sub) == 2) {
                res.add(sub);
            }
            right++;
        }
        return res;
    }

    /**
     * 给你一个整数数组 nums 和两个整数k 和 t 。
     * 请你判断是否存在 两个不同下标 i 和 j，
     * 使得abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
       /*
            abs(arr[i]-arr[j])<=t
            abs(i-j)<=k

            k就是窗口长度
        */

        return false;

    }

    public static String longestCommonPrefix(String[] strs) {
        //字符串长度
        int n = strs.length;
        //第一个字符串
        String first = strs[0];
        //遍历第一个字符串的各个字符
        for (int i = 0; i < first.length(); i++) {
            char c = first.charAt(i);
            //遍历别的字符串
            for (int j = 1; j < n; j++) {
                //如果第一个字符串遍历完了或者遇到不一样的字符,说明最大公共前缀已经查找结束
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return first.substring(0, i);
                }
            }
        }
        //第一个字符串遍历完了还没在别的字符串里遇到不一样的字符，说明第一个字符串就是最长公共前缀
        return first;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        /*
            nums1和nums2都是非递减排序，合并nums2到nums1
            数组nums实际长度为m+n，有效数字长度为m,后面n个空间是给nums2数组中的数占位
         */
        //从两个数组尾部开始遍历
        int p1 = m - 1;
        int p2 = n - 1;
        int index = m + n - 1;
        while (p2 >= 0 || p1 >= 0) {
            if (p1 == -1) {
                nums1[index--] = nums2[p2--];
            } else if (p2 == -1) {
                nums1[index--] = nums1[p1--];
            } else if (nums1[p1] < nums2[p2]) {
                nums1[index--] = nums2[p2--];
            } else {
                nums1[index--] = nums1[p1--];
            }
        }

    }

    /**
     * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
     * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
     *
     * @param nums
     * @return
     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        return new TreeNode();
    }

    /**
     * 删除升序排列的数组中重复的元素，返回新数组的长度，剩下的元素相对顺序保持不变
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        //慢指针指向新数组的尾部（没有重复元素的数组）
        //快指针遍历原始数组
        int slow = 1;
        int fast = 1;
        /*
            因为数组是升序排列,所以如果有重复的元素那么一定是挨着的,遍历元素,和它挨着的元素比较即可
         */
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        return slow;
    }

    /**
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
     *
     * @param nums
     * @return
     */
    public static int removeDuplicatesB(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        //慢指针指向新数组的尾部（没有重复元素的数组）
        //快指针遍历原始数组
        int slow = 2;
        int fast = 2;
        /*
            数组中每个数字最多出现两次而不是一次,所以拿当前遍历到的数字和上上个被保留的数字作比较
         */
        while (fast < n) {
            if (nums[fast] != nums[slow - 2]) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }

        return slow;
    }

    /**
     * 给定一个包含红色、白色和蓝色、共n 个元素的数组nums，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * 我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
     *
     * @param nums
     */
    public static void sortColors(int[] nums) {
        int n = nums.length;
        int head = 0;
        //第一次遍历数组把所有的0放到前面,不是0的放到遍历到的0的位置上
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                int temp = nums[head];
                nums[head] = 0;
                nums[i] = temp;
                head++;
            }
        }
        //第二次遍历数组把所有的1放到0的后面,不是1的放到遍历到的1的位置上
        for (int i = head; i < n; i++) {
            if (nums[i] == 1) {
                int temp = nums[head];
                nums[head] = 1;
                nums[i] = temp;
                head++;
            }
        }
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;

        }
        return true;
    }


    public static int MinSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int slow = 0;
        int fast = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while (fast < n) {
            sum += nums[fast];
            if (sum >= target) {
                res = Math.min(res, fast - slow + 1);
                sum -= nums[slow];
                ++slow;

            } else {
                ++fast;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;

    }

    /**
     * 求x的平方根,如果是小数的话返回整数部分
     *
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        /*
            设x的平方根为k,k是满足k^2<=x的最大整数
            在0~x区间内进行二分查找
         */
        int left = 0;
        int right = x;
        int ans = -1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static int Search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //mid落在旋转后的数组的前半部分（该部分元素相比后半部分都要大）
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {//mid落在旋转后的数组的后半部分（该部分元素相比前半部分都要小）
                if (nums[mid] < target && target < nums[n - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找波峰
     *
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        /*
            爬坡
            当前位置k,nums[k]和nums[k+1]
            nums[k]>nums[k+1]:k右边是下坡,可能会遇到新的波峰,但不一定
            nums[k]<=nums[k+1]:k右边是上坡,一定会遇到波峰（起码是nums[k+1]）
         */
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            //爬坡,往大于nums[mid]的方向找
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int findRotateMin(int[] nums) {
        /*
            旋转之后数组可能的形状

           （1）旋转次数不是n的整数倍
                    *(y)
                *
            *
                                    *
                                *
                            *
                        *(x)
            （2）旋转次数是n的整数倍,实际上没有发生旋转

                            *(y)
                        *
                    *
                *
             *(x)
            关注原来数组的第一个元素x以及最后一个元素y,x右边的都是比y小的,x左边的都是比y大的

         */
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {//nums[mid]是最小值右侧的元素,要找最小值,忽略右侧区间
                right = mid;
            } else {//nums[mid]是最小值左侧的元素,要找最小值,忽略左侧区间
                left = mid + 1;
            }
        }
        return nums[left];
    }


}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


/**
 * 节点类
 */
class ListNode {
    public int val;
    public ListNode next;//节点的next指针,指向节点的下一个节点
    public ListNode rand;//节点的随即指针,可能指向任意节点,完全随机

    ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode[" + "val=" + val + "]";
    }
}

/**
 * 链表类
 */
public class MyLinkedList {

    //链表容量
    public int size;
    //头节点
    public ListNode head;


    public MyLinkedList() {
        this.size = 0;
        this.head = null;
    }

    public void show() {
        ListNode cur = head;
        while (cur != null) {
            System.out.println(cur);
            cur = cur.next;
        }
        System.out.println();
    }

    /**
     * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1
     *
     * @param index
     * @return
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }


    /**
     * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
     *
     * @param val
     */
    public void addAtHead(int val) {
        ListNode toAdd = new ListNode(val);
        if (head == null) {
            head = toAdd;
            size++;
            return;
        }
        //新节点指向原来的头节点
        toAdd.next = head;
        //把新节点设置为头节点
        head = toAdd;
        size++;
    }

    public void addAtTail(int val) {
        ListNode toAdd = new ListNode(val);
        //链表为空
        if (head == null) {
            head = toAdd;
            size++;
            return;
        }

        //链表不为空,循环遍历找到最后一个节点
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = toAdd;
        size++;
    }


    /**
     * addAtIndex(index,val)：
     * 在链表中的第index个节点之前添加值为val 的节点。
     * 如果index等于链表的长度，则该节点将附加到链表的末尾。
     * 如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
     *
     * @param index
     * @param val
     */
    public void addAtIndex(int index, int val) {
        if (index == size) {
            addAtTail(val);
            return;
        }
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        if (index > size) {
            return;
        }

        ListNode toAdd = new ListNode(val);
        ListNode cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        toAdd.next = cur.next;
        cur.next = toAdd;
        size++;


    }

    /**
     * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
     *
     * @param index
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }

        ListNode cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        size--;
    }


    /**
     * 判断链表是否有环
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        /*
            快慢指针
            快指针每次走两步,慢指针每次走一步
            如果有环,快慢指针一定会相遇
         */
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 定位链表环的起点（如果有）
     * 哈希表
     *
     * @param head
     * @return
     */
    public ListNode detectCycleByHash(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode cur = head;
        if (head == null) {
            return null;
        }
        while (cur.next != null) {
            if (!set.add(cur)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    /**
     * 定位链表环的起点（如果有）
     * 双指针
     *
     * @param head
     * @return
     */
    public ListNode detectCycleByDoublePoint(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            //如果快指针能走到null,说明链表没有环
            if (fast == null || fast.next == null) {
                return null;
            }else {
                //链表有环的话,快指针步长为2,慢指针步长为1,二者肯定会相遇
                fast = fast.next.next;
                slow = slow.next;
            }
            //快慢指针相遇,说明有环,跳出循环
            if (fast == slow) {
                break;
            }
        }
        //快指针回到开头,慢指针不动
        //快慢指针同时出发,步长也都为1,最后快慢指针肯定会在环的起点相遇
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }


    /**
     * 相交链表,给出两个无环链表的头节点,返回两个链表的交点
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNodeByHash(ListNode headA, ListNode headB) {

        /*
           HashSet去重法
         */
        Set<ListNode> set = new HashSet<>();
        //把链表A的节点放到HashSet中
        ListNode cur = headA;
        while (cur != null) {
            set.add(cur);
            cur = cur.next;
        }
        //遍历链表B,看HashSet中是否有链表B的节点
        cur = headB;
        while (cur != null) {
            if (set.contains(cur)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    public ListNode getIntersectionNodeByDoublePoint(ListNode headA, ListNode headB) {
        //双指针
        /*
                  x
                      y     z     q     w    e
                  c
             b
        a

        链表A:xy(2)zqwe(4)
        链表B:abcy(4)zqwe(4)


        指针pA指向A的头节点,
        指针pB指向B的头节点,
        pA!=pB时：pA和pB指针同时后移（pA=pA.next,pB=pB.next）
        如果A链表遍历完了（即pA==null）,让pA指向B链表的头节点开始遍历
        如果B链表遍历完了（即pB==null）,让pB指向A链表的头节点开始遍历
        pA=pB时就是到交点了
        pA走过的长度 2+4+4
        pB走过的长度 4+4+2

         */

        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }


    /**
     * 删除倒数第n个节点
     * （两次遍历）倒数第k个节点也就是正数第n+1-k个节点,可以先计算链表长度然后正向遍历链表找到第n+1-k个节点
     * （一次遍历）双指针
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int k) {
        //1.伪头
        ListNode dummy = new ListNode(0, head);
        //2.快慢指针
        ListNode fast = dummy;
        ListNode slow = dummy;
        //3.快指针先走k步
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        //4.快慢指针同时走,直到链表最后（fast.next==null）
        //slow就到了倒数第k个节点的前驱节点处
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //跳跃,删除倒数第k个节点
        slow.next = slow.next.next;
        return dummy.next;
    }


    /**
     * 反转链表,返回新链表的头节点
     *
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        //新链表的头节点
        ListNode tempHead = null;
        //临时节点用来遍历旧链表
        ListNode cur = head;
        //预备节点,保存当前节点的下一个节点
        ListNode next = null;
        while (cur != null) {
            //提前保存当前节点的下一个节点
            next = cur.next;
            //当前节点的next指向新的头节点
            cur.next = tempHead;
            //新的头节点前移
            tempHead = cur;
            //当前节点后移
            cur = next;
        }

        return tempHead;

    }

    public ListNode swapPairs(ListNode head) {
        //伪头
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        //遍历链表
        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.next != null) {
            ListNode node1 = cur.next;
            ListNode node2 = cur.next.next;
            //两两交换
            cur.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            //后移
            cur = node1;
        }
        return dummyHead.next;
    }

    /**
     * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }

        int n = 1;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            n++;
        }
        int add = n - (k % n);
        //反转次数是链表长度的整数倍,链表实际不发生变化
        if (add == 0) {
            return head;
        }
        //组成环
        cur.next = head;

        //新链表的最后一个节点:原链表的第 n-1-(k%n) 个节点,即add--=0时的节点
        while (add-- > 0) {
            cur = cur.next;
        }//cur就是新链表的尾节点,cur.next是新链表的头节点
        //在新链表的尾部断开链表
        //记录新链表的头节点
        ListNode res = cur.next;
        //新链表的尾节点后边置空
        cur.next = null;
        return res;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;

        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;

    }

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        //伪头节点,要存起来
        ListNode tempHead = new ListNode(-1);
        //伪头节点的替代,存放新的链表
        ListNode cur = tempHead;
        //遍历两个链表
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        //其中一个链表遍历完了,直接把另一个没有遍历完的链表放过去
        cur.next = list1 == null ? list2 : list1;
        return tempHead.next;

    }

    /**
     * 删除链表中指定属性的节点,返回新的头节点
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode cur = dummy;

        while (cur != null && cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    /**
     * 奇偶链表
     * 链表索引设定从1开始
     * 把链表中奇数索引的放到前面,偶数索引的放到后面（保证相对顺序不变）
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        //奇偶链表各自的头节点
        //第一次定位到了之后就不动了
        ListNode oddHead = head;//原始链表的头节点是奇数节点,也是新链表的头节点,可以直接用head代替不用另外创建变量
        ListNode evenHead = head.next;
        //奇偶指针
        ListNode odd = oddHead;
        ListNode even = evenHead;

        while (even != null && even.next != null) {
            //偶数节点后面是奇数节点,把它放到当前奇数节点后面,奇数节点指针后移
            odd.next = even.next;
            odd = odd.next;
            //奇数节点后面是偶数节点,把它放到当前偶数节点后面,偶数节点指针后移
            even.next = odd.next;
            even = even.next;
        }
        //把偶数节点头挂到奇数链表尾部
        odd.next = evenHead;
        //返回新链表的头节点
        return oddHead;
    }

    /**
     * 回文链表
     * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        cur = head;

        while (!stack.isEmpty()) {
            ListNode temp = stack.pop();
            if (temp.val == cur.val) {
                cur = cur.next;
            } else {
                return false;
            }
        }
        return true;
    }


    /**
     * 双指针
     * 把链表后半部分反转,和前半部分比较
     * 链表分半：快慢指针,快指针步长为2慢指针步长为1
     *
     * @param head
     * @return
     */
    public boolean isPalindromeByTwoPoint(ListNode head) {

        //原始链表前半部分的尾节点
        ListNode firstHalfEnd = getFirstHalfEnd(head);
        //后半部链表反转,并记录反转后的头节点
        ListNode secondHalfStart = reverse(firstHalfEnd.next);

        //双指针遍历两部分链表
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;

        while (p2 != null) {
            if (p1.val == p2.val) {
                p1 = p1.next;
                p2 = p2.next;
            } else {
                return false;
            }
        }
        //恢复反转后的链表
        reverse(secondHalfStart);
        return true;
    }

    public ListNode getFirstHalfEnd(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        return l1;
    }

    /**
     * 复制一个含有rand指针的单链表,返回复制得到的新链表
     *
     * @param head
     * @return
     */
    public static ListNode copyLinkedlistWithRand(ListNode head) {
        /*
            rand指针指向完全随机
            1->2->3->null
         */
        ListNode cur = head;
        ListNode next = null;
        ListNode copyNode = null;
        //1.在原始链表中每个节点后便直接新增复制的节点
        /*
            1->1'->2->2'->3->3'
         */
        while (cur != null) {
            //记录当前节点的下一个节点
            next = cur.next;
            //复制当前节点并挂到当前节点后边
            copyNode = new ListNode(cur.val);
            cur.next = copyNode;
            //原来的next节点放到
            copyNode.next = next;
            //cur后移遍历原始链表的下一个节点
            cur = next;
        }//rand指针并没有发生变化

        //2.根据原始节点的rand指针确定新复制的节点的rand指针指向
        cur = head;
        copyNode = null;
        while (cur != null) {
            next = cur.next.next;
            copyNode = cur.next;
            copyNode.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }

        //3.断开新旧节点
        ListNode res = head.next;
        cur = head;
        while (cur != null) {
            next = cur.next.next;
            copyNode = cur.next;
            cur.next = next;
            copyNode.next = next != null ? next.next : null;
            cur = next;
        }

        return res;


    }


}