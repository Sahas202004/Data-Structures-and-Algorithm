//Given a sorted array of integers nums (in ascending order) and an integer target, return the index of target if it exists in the array. Otherwise, return -1.
//You must write an algorithm with O(log n) runtime complexity.


public class BinarySearch {
    public static void main(String[] args) {
        int[] nums={1,3,5,7,8,9,10};
        int target=9;

        int res=binarySearch(nums,target);
        System.out.println(res);
    }
    //    The Function Returns the target's index if it is available in the nums[];
//    Else it returns -1;
//    Since it implements Binary Search, the Time Complexity is O(log n);
    static int binarySearch(int[] nums,int target){
//        Declare and Initialize start=0;
        int start=0;
//        Declare and Initialize end with the last index of the nums[];
        int end=nums.length-1;

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
//            if both the above conditions are false, that means our value si found
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