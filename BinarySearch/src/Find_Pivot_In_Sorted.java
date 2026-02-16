package src;

public class Find_Pivot_In_Sorted {
    public static void main(String[] args) {
        int[] nums={5,6,7,8,9,0,1,2};
        int res=findPivotInRotatedArray(nums);
        System.out.println(res);
    }
    static int findPivotInRotatedArray(int[] nums){
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
            if(mid<end && nums[mid]>nums[mid+1]){
                return mid;
            }
//            we check if middle is less than end, to avoid array out of bounds
//            exception. if true we will also check if the number at middle-1 is greater that
//            number at middle index, if yse then we have our pivot, return mid-1.
            if(mid>start && nums[mid-1]>nums[mid]){
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
//            (a break point is a point where a number is greater than its next number, or it's smaller than the previous
//            one)
            else{
                end=mid;
            }
        }
//        we return start here in case if the give array has only one element.
        return start;
    }
}
