package src;//Given a sorted array of distinct integers and a target value, return the index if the target is found.
//If not, return the index where it would be inserted in order.

//Must run in O(log n).

//Test Case 1
//Input: nums = [1,3,5,6], target = 5
//Output: 2

//Test Case 2
//Input: nums = [1,3,5,6], target = 2
//Output: 1

//Test Case 3
//Input: nums = [1,3,5,6], target = 7
//Output: 4

public class Search_Insert_Position {
    public static void main(String[] args) {
        int[] nums={1,3,5,6};
        int number=7;

        int res=findInsertPosition(nums,number);
        System.out.println(res);
    }
    static int findInsertPosition(int[] nums,int number){
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
            if(nums[mid]>number){
                end=mid-1;
            }
//            if first condition is false, then this condition is checked.
//            it checks if the middle value is less than the target.
//            if yes then the start pointer is re-initialized with value of middle+1
//            index
            else if(nums[mid]<number){
                start=mid+1;
            }
//            if both the above conditions are false, that means our value si found
//            at middle index; So return Middle;
            else{
                return mid;
            }
        }
//        The target is not in the given nums[] array.
//        therefore we return start here because we know that
//        the condition of while loop tha if the start is > end then we have to
//        exit the loop.
//        ex:{1,3,5,6}; target=7
//        First iteration:
//        start=0th index end=3rd index mid=start+(end-start)/2 i.e. 1st index;
//        it will check if middle element is greater than target (3>7)//false
//        it will check if middle element is greater than target (3<7)//true;
//        so start will be mid+1=2;
//        Second iteration:
//        start=2nd index end=3rd index mid=start+(end-start)/2 i.e. 2nd index;
//        it will check if middle element is greater than target (5>7)//false
//        it will check if middle element is greater than target (5<7)//true;
//        so start will be mid+1=3;
//        Here the start end and mid will pe pointing at same element.
//        we have not found our target.
//        therefore start=3 end=3 and mid=3
//        it will check if middle element is greater than target (6>7)//false
//        it will check if middle element is greater than target (6<7)//true;
//        so start will be mid+1 which will be 4 and end will be 3.
//        at this point we are at the situation where start is greater than end
//        start is mid+1(in this case 4);
//        we did not find our target, so the perfect index to insert our number will be start
        return start;
    }
}
