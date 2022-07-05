package com.zyh.hsp_datastructure.algorithm.leetcodePrimary.array.easy;


import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {99, 99};
        System.out.println(containsNearbyDuplicate(arr, 2));

    }

    /**
     * 1.两数之和
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        //key存放数字,value存放索引
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(target - num)) {
                return new int[]{map.get(target - num), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    /**
     * 26.删除有序数组中的重复项
     * <p>
     * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
     * </>
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        /*
            快慢指针
            快指针遍历数组,指向当前要判定的元素,慢指针指向处理过后的数组的尾部
         */
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            //快指针遍历数组,直到遇到和慢指针不相同的数字,慢指针先后移,快指针指向的数字放到移动后的慢指针上,这样慢指针上的数字都是不重复的数子
            if (nums[fast] != nums[slow]) {
                nums[++slow] = nums[fast];
            }
            ++fast;
        }
        return ++slow;
    }

    /**
     * 27.移除元素
     * <p>给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度</p>
     * <p>不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。</p>
     * <p>1.元素的顺序可以改变</p>
     * <p>2.元素的顺序不能改变</p>
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        /*
            元素相对顺序不能发生改变的情况
         */

        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;

        /*
        元素相对顺序可以发生改变的情况
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            if (nums[left]==val){
                nums[left--]=nums[right--];
            }
            left++;
        }
        return left;
        */
    }

    /**
     * 35.搜索插入位置
     * <p>给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。</p>
     * <p>请必须使用时间复杂度为 O(log n) 的算法。</p>
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        /*
            nums是排序数组,O(logN)复杂度的话,二分
         */
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) >> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }


    /**
     * 53.最大子数组和
     * <p>给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。</p>
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int temp = 0;
        int ans = nums[0];
        for (int num : nums
        ) {
            temp = Math.max(temp + num, num);
            ans = Math.max(temp, ans);
        }
        return ans;
    }

    /**
     * 66.加一
     * <p>给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。</p>
     * <p>最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。</p>
     * <p>你可以假设除了整数 0 之外，这个整数不会以零开头。</p>
     *
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            //（（digits[i]+1）% 10）结果只能是0~9
            //,如果结果是0的话说明digits[i]是9,+1之后会发生进位,但只要不是所有的位置都是9那么数组长度就不会变长
            //,结果不是0的话,说明digits[i]不是9,+1之和肯定不会发生进位,即数组长度不会变长,直接返回更新后的digits
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
     * 88.合并两个有序数组,两个非逆序数组nums1和nums2,合并nums2到nums1中
     * <p>数组1有效数字长度为m,实际长度为m+n,数组2的长度为n。数组1的后面n个位置上都是0,是给数组2的元素占位的</p>
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int index = m + n - 1;

        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                nums1[index--] = nums2[p2--];
            } else if (p2 == -1) {
                nums1[index--] = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                nums1[index--] = nums1[p1--];
            } else {
                nums1[index--] = nums2[p2--];
            }
        }
    }

    /**
     * 108.有序数组转换成二叉搜索树
     * <p>给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。</p>
     * <p>高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。</p>
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return help(nums, 0, nums.length - 1);
    }

    public TreeNode help(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        /*
            升序数组转换成高度平衡的二叉搜索树
            二叉搜索树的中序遍历正好是升序数组，如果是单纯的由升序数组恢复二叉搜索树,那么选择数组中任意以一个元素作为根节点
            ,该节点左边的升序序列构建左子树,该节点右边的升序序列构建右子树,就可以得到一棵二叉搜索树
            但如果要求高度平衡的话,就不能任意选择数组中的元素做根节点了,要选择中间的元素
         */
        //数组中间的元素为根节点
        int mid = (left + right) / 2;
        TreeNode head = new TreeNode(nums[mid]);
        //递归构建左右子树
        head.left = help(nums, left, mid - 1);
        head.right = help(nums, mid + 1, right);
        return head;
    }

    /**
     * 118.杨辉三角I
     * <p>给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。</p>
     * <p>在「杨辉三角」中，每个数是它左上方和右上方的数的和。</p>
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> YangHui(int numRows) {
        /*
            1
            1   1
            1   2   1
            1   3   3   1
            1   4   6   4   1
            1   5   10  10  5   1
            ...
            1.第n行有n个数
            2.每行的首和尾都是1
            3.除了首尾元素之外,每个数字=上一行的前一列的数字+上一行的同一列的数字
                            [i][j]=[i-1][j-1]+[i-1][j]
         */
        //完整的杨辉三角
        List<List<Integer>> yangHui = new ArrayList<>();
        //杨辉三角的每一行
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            //给每一行的每个元素赋值
            for (int j = 0; j < i + 1; j++) {
                //头尾都是1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(yangHui.get(i - 1).get(j - 1) + yangHui.get(i - 1).get(j));
                }
            }
            yangHui.add(row);
        }
        return yangHui;
    }

    /**
     * 119.杨辉三角II
     * <p>给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。</p>
     * <p>在「杨辉三角」中，每个数是它左上方和右上方的数的和。</p>
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        return new ArrayList<>();
    }

    /**
     * 136.只出现一次的数字
     * <p>给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素</p>
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        /*
            位运算 异或^
            1.任何数字和0异或结果不变
            2.两个数字进行异或操作,两数相同为0,两数不同为1
            3.a^b^b=a（因为b^b=0,a^0=a）
         */
        int res = 0;
        //数组中的数字挨个和0进行异或操作,出现两次的数字异或之后变为0,最后只剩下出现一次的数字和0异或,结果就是那个只出现一次的数字
        for (int num : nums
        ) {
            res = res ^ num;
        }
        return res;
    }

    /**
     * 169.多数元素
     * <p>给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。</p>
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums
        ) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()
        ) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }
        return -1;
    }

    /**
     * 217.存在重复元素I
     * <p>给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。</p>
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums
        ) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 219.存在重复元素II
     * <p>给你一个整数数组nums 和一个整数k ，判断数组中是否存在两个 不同的索引i和j</p>
     * <p>满足 nums[i] == nums[j] 且 abs(i - j) <= k</p>
     * <p>如果存在，返回 true ；否则，返回 false 。</p>
     *
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        /*
            滑动窗口
            维护一个size最大为k的哈希表set
            每次遍历到数组中的一个数字时,判断set中是否已存在该数字,存在的话就是true,不存在的话就把该数字放进set中,
            如果set的size大于k的话,就移出set里最前面的数
         */
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    /**
     * 228.汇总区间
     * <p>给定一个 无重复元素 的有序 整数数组 nums 。</p>
     * <p>返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。</p>
     * <p>也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。</p>
     *
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            //每次遇到相邻元素之间的差值大于 1 时，我们就找到了一个区间
            //如果相邻两个数字的差值==1的话,这两个数字是连续的,继续往后找
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            //low->high
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if (low < high) {
                temp.append("->");
                temp.append(Integer.toString(nums[high]));
            }
            res.add(temp.toString());
        }
        return res;
    }


    /**
     * 453.最小操作次数使数组元素相等
     *
     * @param nums
     * @return
     */
    public static int minMoves(int[] nums) {
        /*
            n-1个数进行+1操作,等价于一个数进行-1操作（差值是等价的）
            n-1个数进行+1操作之后新的n个数字变成一样大小
                            <=>
            一个数字进行-1操作变成和最小数字一样大小,数组中所有数字都要变成和原始数组最小数字一样大小,就要累加每个数字的-1操作次数
         */
        //数组中的最小数字
        int minNum = Arrays.stream(nums).min().getAsInt();
        int res = 0;
        for (int num : nums
        ) {
            //累加每个数字的-1操作次数
            res += num - minNum;
        }
        return res;
    }

    /**
     * 496.下一个更大元素I
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        return null;

    }


}

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

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
