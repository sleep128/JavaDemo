package com.sleep.algorithm;

public class BinarySearch {
    public static void main(String[] args) {
        int[] ints = new int[] {1,2,3,5,6,7,8,9};
        int search = search(ints, 7);
        System.out.println("ints["+search+"]:"+ints[search]);
    }

    public static int search(int[] data, int target){
        int left = 0;
        int right = data.length -1;
        while(left<=right){
            int mid = (left+right)/2;
            if(data[mid]==target){
                return mid;
            }else if(data[mid]>target){
                right = mid -1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }

}
