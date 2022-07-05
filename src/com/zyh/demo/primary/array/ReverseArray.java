package com.zyh.demo.primary.array;

public class ReverseArray{
	public static void main(String[] args){
		int[] array = {1,3,5,7,9};
		reverse2(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	public static int[] reverse1(int[] arr){
		for (int i = 0; i < arr.length/2; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = temp;
		}
		return arr;
	}
	public static int[] reverse2(int[] arr){
		for (int start=0,end=arr.length-1;start<=end;start++,end--) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
		}
		return arr;
	}
}