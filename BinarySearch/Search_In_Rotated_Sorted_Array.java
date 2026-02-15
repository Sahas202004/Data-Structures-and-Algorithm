//There is an integer array sorted in ascending order and then rotated at some pivot.
//Example:
//[0,1,2,4,5,6,7] → rotated → [4,5,6,7,0,1,2]
//Given nums and target, return index if found, else -1.

//Test Case 1
//Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4

//Test Case 2
//Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1

//Test Case 3
//Input: nums = [1], target = 0
//Output: -1

public class Search_In_Rotated_Sorted_Array {
    public static void main(String[] args) {
        int[] arr={4,5,6,7,0,1,2};
        int target=5;
        int pivot=findPivot(arr);
        int res;
        if(arr[0]>target){
            res=binarySearch(arr,target,pivot+1,arr.length-1);
        }else{
            res=binarySearch(arr,target,0,pivot);
        }
        System.out.println(res);

    }
    static int findPivot(int[] nums){
//        Declare and Initialize start=0;
        int start=0;
//        Declare and Initialize end with the last index of the nums[];
        int end=nums.length-1;
//        Inside the while loop, we will be increasing the value of start
//        and decreasing the value of end based on some conditions.
//        This loop will run until the start is less than or equal to end
        while(start<end){
//            Declare and initialize the mid with the middle index's value
//            of the array.
//            It will keep changing after each iteration
            int mid=start+(end-start)/2;

//            we check if middle is greater than start, to avoid array out of bounds
//            exception. if true we will also check if the number at middle is greater that
//            number at middle+1 index, if yse then we have our pivot, return mid.
            if(mid>start && nums[mid]>nums[mid+1]){
                return mid;
            }
//            we check if middle is less than end, to avoid array out of bounds
//            exception. if true we will also check if the number at middle-1 is greater that
//            number at middle index, if yse then we have our pivot, return mid-1.
            if(mid<end && nums[mid-1]>nums[mid]){
                return mid-1;
            }
//            here we will update the value of start and end according to conditions
//            if number at start index is less than the middle number, that means we will move our start
//            pointer to mid+1 position, because by definition a rotated array is a type of array where after
//            pivot all the numbers will be smaller than the start number because it was sorted.
//            ex: original 0,1,2,4,5,6,7 if rotated 2 times it will be
//            rotated array; 6,7,0,1,2,3,4,5. the first element is greater than last.
            if(nums[start]<nums[mid]){
                start=mid+1;
            }
//            else we know start > mid therefore we will bring end pointer pointing to middle
//            because we have to find the break point since there is only one.
//            (a break point is a point where a number is greater than its next number or it smaller than the previous
//            one)
            else{
                end=mid;
            }
        }
//        we return start here in case if the give array has only one element.
        return start;
    }
    static int binarySearch(int[] nums,int target,int start,int end){
//        int start=0;
//        Declare and Initialize end with the last index of the nums[];
//        int end=nums.length-1;

//        Inside the while loop, we will be increasing the value of start
//        and decreasing the value of end based on some conditions.
//        This loop will run until the start is less than or equal to end
        while(start<=end){
//            Declare and initialize the mid with the middle index's value
//            of the array.
//            It will keep changing after each iteration
            int mid=start+(end-start)/2;

//            Conditions:-
//            The first condition checks if the middle value is greater than target.
//            If yes,then the end pointer will be re-initialized with value of middle-1
//            index
            if(nums[mid]>target){
                end=mid-1;
            }
//            if first condition is false, then this condition is checked.
//            it checks if the middle value is less than the target.
//            if yes then the start pointer is re-initialized with value of middle+1
//            index
            else if(nums[mid]<target){
                start=mid+1;
            }
//            if both the above conditions are false, that means our value is found
//            at middle index; So return Middle;
            else{
                return mid;
            }
        }
//        The target is not in the given nums[] array.
//        So return -1;
        return -1;
    }
}
