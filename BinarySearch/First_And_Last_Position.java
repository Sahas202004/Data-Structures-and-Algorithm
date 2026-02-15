public class First_And_Last_Position {
    public static void main(String[] args) {
        int[] nums={1,2,3,3,4,4,4,4,6};
        int target=4;
//        created and array of size 2 to store the first and the last index.
        int[] arr=new int[2];
//        in the first position of the array we will store the first index by calling the method
//        fundFirstAndLastIndex(we will pass nums array,target,and true as an switch to find first/last occurrence)
        arr[0]=findFirstAndLastIndex(nums,target,true);
//        we will check if the result of the first method call is -1. if it is -1 then there is no target element in the
//        given array. so the first and second index of arr will be -1,-1.
        if(arr[0]==-1){
            arr[1]=-1;
        }
//        if the first index has some non-negative value, then find the last index.
        else{
            arr[1]=findFirstAndLastIndex(nums,target,false);
        }
        for(int i:arr){
            System.out.print(i+" ");
        }
    }

    static int findFirstAndLastIndex(int[] nums,int target,boolean left){
        int index=-1;
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
//            If num[mid]==target then we have to check for the first and last index respectively.
            else{
//                we will assign the middle element to the index variable.
                index=mid;
//                if we have to find the first occurrence of a number, that means from the current position
//                we have to traverse to the left side. so we will bring end to mid-1 index
                if(left){
                    end=mid-1;
                }
//                if we have to find the last occurrence of a number, that means from the current position
//                we have to traverse to the right side. so we will bring start to mid+1 index
                else{
                    start=mid+1;
                }
            }
        }
//        at last, we have the first/last index inside the index variable,so return that.
        return index;
    }
}
