//LeetCode Problem no:1539

//Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
//Return the kth positive integer that is missing from this array.

//Example 1:
//Input: arr = [2,3,4,7,11], k = 5
//Output: 9
//Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.

//Example 2:
//Input: arr = [1,2,3,4], k = 2
//Output: 6
//Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.

public class Kth_Missing_Positive_Integer {
    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        int k=2;
//        here missing positives are {5,6,7,....}
//        k is 2, therefore 2nd missing positive integer is 6.
        int kthMissingInteger=findKthMissingPositiveInteger(nums,k);
        System.out.println(kthMissingInteger);
    }

//    <--If You are doing simple Binary Search Problems and encountered this first time and are not able to
//    solve, don't feel demotivated because it's just a different pattern. it's a pattern shift, try to understand
//    it rather than just copying the whole stuff. At last, you will find that it's slightly different from the normal
//    BS, but it is way easier problem. iam telling you by my experience,keep your head up and dive into this new pattern-->

    static int findKthMissingPositiveInteger(int[] nums,int k){
//        Initialize start variable with 0th index of nums;
        int start=0;
//        Initialize end variable with the last index of nums;
        int end=nums.length-1;
//        Declare the result to store the final result
        int result;

//        the while loop will run until the start is less than or equal to end;
        while(start<=end){
//            Declare and initialize the mid with the middle index's value
//            of the array.
//            It will keep changing after each iteration
            int mid=start+(end-start)/2;

//            Here the logic to find the missing kth +ve number.
//            first check if subtracting 1 by mid-index, subtracted by the number at mid-index
//            is smaller than the k. if yes, then bring the start pointer to mid+1 index.
//            ex:2,3,4,7,11
//            here the start=0 end=4 mid=2. if 4(middle number)-2(mid-index)-1<5(k); which is true
//            so start will be 2+1 i.e.mid+1; so mid=3;
//
            if(nums[mid]-mid-1<k){
                start=mid+1;
            }
//            else, nums[mid]-mid-1 > k , therefore we bring end pointer to mid-1;
//            continue this till start<=end;
            else{
                end=mid-1;
            }
        }
//        at last, we have end pointing to the index where if we add that index with k+1 then we will have our
//        kth missing positive integer. we evaluate end+k+1 and store the output in result for better debugging.
        result=end+k+1;

//        at last, we return result
        return result;
    }
}
