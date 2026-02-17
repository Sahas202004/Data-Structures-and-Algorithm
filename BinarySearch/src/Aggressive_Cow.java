package src;

//You are given an array stalls[] representing positions of stalls on a number line and an integer k representing
//the number of cows.

//You need to place k cows in the stalls such that:

//Each stall can have at most one cow.

//The minimum distance between any two cows is maximized.

//Return the maximum possible minimum distance.

//Input:
//stalls = [1, 2, 4, 8, 9]
//k = 3

//Input:
//stalls = [1, 2, 3, 4, 5]
//k = 2
//
//Output:
//4

//Input:
//stalls = [1, 5, 9, 12]
//k = 4
//
//Output:
//3

public class Aggressive_Cow {
    public static void main(String[] args) {
        int[] stalls={1, 2, 4, 8, 9};
        int cows=3;
        int res=aggressiveCow(stalls,cows);
        System.out.println(res);
    }

//    in this question we are given an array of stalls representing the position on a number line
//    we are given the number of cows as k. we have to place the cows in the stalls such that, the
//    minimum distance between 2 cows that is maximum.

//    This is another pattern shift in Binary search. We have to find the between 2 cows that is max
//    eg: 1,2,3,4,8,9
//    we know that we have to find the minimum maximum distance(yeah that's tricky).
//    so we can consider the range from 1(the distance should be atleast 1). to the subtracted value of first
//    and last element.
//    in this case the range will be 1 to (9-1=8)

//    in simple words ill tell you, if there are 1,3,4,5 choices of minimum distance,
//    then we have to find the maximum out of those, i.e. 5 in this case

    static int aggressiveCow(int[] nums,int cows){
//        starting of the range is 1
        int start = 1;
//        ending of the range is 8
        int end = nums[nums.length-1] - nums[0];
//        int end=nums[nums.length-1]-nums[0];



//        The Loop will run until the start <= end
        while(start<=end){
//            we take the count=1
            int count=1;
//            we take middle element for comparison
            int mid=start+(end-start)/2;

//            we take a temporary variable and assign value as 0
            int temp=0;

//            we will run the loop to check some conditions
            for(int i=1;i<nums.length;i++){
//                we check if nums[i] i.e. ith element of num minus nums[temp] >= mid
//                we will do count++;
//                here, the nums[i] for the first iteration is 2 and nums[temp] is 1 mid=4;
//                therefore 2-1=1 and 1>=4 this is false
//                this will continue till i<length of nums.

//                this condition is used to check if the cow fits in the stall.
                if(nums[i]-nums[temp]>=mid){
//                    this will only execute when cow fits on the stall.
                    count++;
//                    if the cow fits on the ith index, then we will assign temp=i;
                    temp=i;
                }
            }

//            if the count that we calculated is >= the cows count
//            then there could be a better answer in the right half of the range,
//            because we have to find the minimum distance that is maximum
            if(count>=cows){
                start=mid+1;
            }
//            else the distance between cows is irregular, and the cows do not fits in the
//            sequence, therefore bring the end to mid-1
            else{
                end=mid-1;
            }

        }
//        at last, we know the start will cross the end,mid and end will be pointing at the
//        minimum distance that is maximum. so we return end.
        return end;

    }

}
